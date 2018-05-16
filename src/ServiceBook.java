import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

public class ServiceBook {
	
	private static Archive<Book> books = new Archive<Book>("Archives/books.json");

	public static boolean create(Request request) {
		// TODO Auto-generated method stub
		Query query = request.getQuery();
		String name = query.get("name");
		
		return true;
	}

	public static List<Book> read(Request request) {
		// TODO Auto-generated method stub
		Query query = request.getQuery();
		List<Book> list = books.read();
		
		if (query.containsKey("search")) {
			String s = query.get("search");
			list.stream().filter( (a) -> a.getAuthor().contains(s));
		}
		
		return books.read();
	}

}
