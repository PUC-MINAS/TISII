import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

public class ServiceGenre {
	private static Archive<Genre> genres = new Archive<Genre>("Archives/genres.json");
	
	public static List<Genre> readAll() {
		// TODO Auto-generated method stub
		
		List<JSONObject> listJSON = genres.read();
		List<Genre> list = new ArrayList<Genre>();
		
		for (JSONObject j : listJSON) {
			Genre b = new Genre();
			b.fromJSONObject(j);
			list.add(b);
		}
		
		
		return list;
	}
	
	public static Genre search(int id) {
		List<Genre> list = readAll();
		
		for(Genre e : list) {
			if (e.id == id) return e;
		}	
		
		return null;
	}

	// Not implemented yet
	public static boolean create(Request request) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
