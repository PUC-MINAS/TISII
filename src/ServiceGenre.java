import java.util.List;

import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

public class ServiceGenre {
	private static Archive<Genre> genres = new Archive<Genre>("Archives/genres.json");
	
	public static List<Genre> readAll() {
		// TODO Auto-generated method stub
		List<Genre> list = genres.read();		
		
		return list;
	}
	
	public static Genre search(int id) {
		List<Genre> list = genres.read();
		
		for(Genre e : list) {
			if (e.id == id) return e;
		}	
		
		return null;
	}
	
}
