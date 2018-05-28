import java.awt.Desktop;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.Status;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;


public class HTTPServer implements Container{

	public static void main(String[] args) throws Exception {
		int porta = 781;

		// Configura uma conexão soquete para o servidor HTTP.
		Container container = new HTTPServer();
		ContainerSocketProcessor servidor = new ContainerSocketProcessor(container);
		Connection conexao = new SocketConnection(servidor);
		SocketAddress endereco = new InetSocketAddress(porta);
		conexao.connect(endereco);
		
		//Testa a conexão abrindo o navegador padrão.
//		Desktop.getDesktop().browse(new URI("http://127.0.0.1:" + porta));

		System.out.println("Tecle ENTER para interromper o servidor...");
		System.in.read();

		conexao.close();
		servidor.stop();
	}

	@Override
	public void handle(Request request, Response response) {
		try {
			String path = request.getPath().getPath();
			String method = request.getMethod();
			JSONObject msg = new JSONObject();
			
			if(path.startsWith("/services/book/create")&&method.compareToIgnoreCase("POST")==0){
				// http://127.0.0.1:781/services/book/create
				if(ServiceBook.create(request)) {
					request.toString();
					msg.put("status", Status.CREATED);
					sendResponse(Status.CREATED, response, msg.toString());
				}
				else {
					msg.put("status", Status.NOT_MODIFIED);
					sendResponse(Status.NOT_MODIFIED, response, msg.toString());
				}	
			}
			else if(path.startsWith("/services/exemplary/create")) {
				if(ServiceExemplary.create(request)) {
					msg.put("status", Status.CREATED);
					sendResponse(Status.CREATED, response, msg.toString());
				}
				else {
					msg.put("status", Status.NOT_MODIFIED);
					sendResponse(Status.NOT_MODIFIED, response, msg.toString());
				}	
			}
			else if(path.startsWith("/services/book/read")) {
				msg.put("books", ServiceBook.read(request));
				msg.put("status", Status.OK);
				sendResponse(Status.OK, response, msg.toString());
			}
			else if(path.startsWith("/services/genre/create")) {
				if(ServiceGenre.create(request)) {
					msg.put("status", Status.CREATED);
					sendResponse(Status.OK, response, msg.toString());
				}
				else {
					msg.put("status", Status.NOT_MODIFIED);
					sendResponse(Status.NOT_MODIFIED, response, msg.toString());
				}
			}
			else {
				this.notFind(response, path);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void notFind(Response response, String path) throws Exception {
		JSONObject error = new JSONObject();
		error.put("error", Status.NOT_FOUND);
		error.put("path", path);
		sendResponse(Status.NOT_FOUND, response, error.toString());
	}
	
	private void sendResponse(Status status, Response response, String str) throws Exception {

		PrintStream body = response.getPrintStream();
		long time = System.currentTimeMillis();

		response.setValue("Content-Type", "application/json");
		response.setValue("Server", "WebService System Ninive (1.0)");
		response.setValue("Access-Control-Allow-Origin", "null");
		response.setDate("Date", time);
		response.setDate("Last-Modified", time);
		response.setStatus(status);

		if (str != null)
			body.println(str);
		body.close();
	}

}
