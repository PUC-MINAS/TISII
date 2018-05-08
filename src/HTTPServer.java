import java.awt.Desktop;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;

import org.simpleframework.http.Query;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

public class HTTPServer implements Container{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int porta = 781;

		// Configura uma conexão soquete para o servidor HTTP.
		Container container = new HTTPServer();
		ContainerSocketProcessor servidor = new ContainerSocketProcessor(container);
		Connection conexao = new SocketConnection(servidor);
		SocketAddress endereco = new InetSocketAddress(porta);
		conexao.connect(endereco);
		
		//Testa a conexão abrindo o navegador padrão.
		Desktop.getDesktop().browse(new URI("http://127.0.0.1:" + porta));

		System.out.println("Tecle ENTER para interromper o servidor...");
		System.in.read();

		conexao.close();
		servidor.stop();
	}

	@Override
	public void handle(Request request, Response response) {
		// TODO Auto-generated method stub
		try {
			String path = request.getPath().getPath();
			String method = request.getMethod();
			String mensagem;
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
