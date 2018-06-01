import java.util.List;

import org.simpleframework.http.Request;

public class ServiceExemplary {

	private static Archive<Exemplary> exemplaries = new Archive<Exemplary>("Archives/exemplaries.json");
	
	/*Not implemented yet*/
	public static boolean create(Request request) {
		// TODO Auto-generated method stub
		long isbnBook = Long.parseLong( request.getParameter("isbnBook") );
		int exemplaryCode = Integer.parseInt(request.getParameter("exemplaryCode"));
		String loc = request.getParameter("localization");
		boolean braile = Boolean.parseBoolean(request.getParameter("braile"));
		Book book = ServiceBook.search(isbnBook);
		List<Exemplary> list = exemplaries.read();
		
		if(book != null) {
			Exemplary ex = new Exemplary(exemplaryCode, braile, book, loc );
			
			if( !list.contains(ex) ) {
				exemplaries.write(ex);
				return true;
			}			
			else {
				return false;
			}
		}		
		
		return false;
	}

}
