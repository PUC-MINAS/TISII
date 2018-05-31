import org.simpleframework.http.Request;

public class ServiceExemplary {

	private static Archive<Exemplary> exemplaries = new Archive<Exemplary>("Archives/exemplaries.json");
	
	public static boolean create(Request request) {
		// TODO Auto-generated method stub
		String nameBook = request.getParameter("nameBook");
		int exemplaryCode = Integer.parseInt(request.getParameter("exemplaryCode"));
		String loc = request.getParameter("localization");
		boolean b = Boolean.parseBoolean(request.getParameter("braile"));
		Book book = ServiceBook.search(nameBook);
		
		Exemplary ex = new Exemplary();
		
		return true;
	}

}
