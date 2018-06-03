import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONObject;
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
		List<Exemplary> list = readAll();
		
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
	
	//returns a list of Exemplaries contends all Exemplaries
    private static List<Exemplary> readAll() {
    	List<JSONObject> listJSON = exemplaries.read();
		List<Exemplary> list = new ArrayList<Exemplary>();
		
		for (JSONObject j : listJSON) {
			Exemplary b = new Exemplary();
			b.fromJSONObject(j);
			list.add(b);
		}
		
		
		return list;
    }

	public static List<Exemplary> read(Request request) {
		// TODO Auto-generated method stub
		return readAll();
	}

	/*not implemented yet*/
	public static Exemplary search(int exemplaryCode) {
		// TODO Auto-generated method stub
		List<Exemplary> list = readAll();
		
		for (Exemplary e: list) {
			if(e.getExemplaryCode() == exemplaryCode) return e;
		}
		
		return null;
	} 

}
