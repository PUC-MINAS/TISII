import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

public class ServiceBook {
	
	private static Archive<Book> books = new Archive<Book>("Archives/books.json");

	public static boolean create(Request request) {
		Query query = request.getQuery();
		
		//Creates a book
		Book b = new Book();
		try {
			b.setName(request.getParameter("name"));
			b.setPublishingCompany(request.getParameter("publishingCompany"));
			b.setLanguage(request.getParameter("language"));
			b.setIsbn(Long.parseLong(request.getParameter("isbn")));
			b.setGenre(Integer.parseInt(request.getParameter("genre")));
			b.setSynopsis(request.getParameter("synopsis"));
			b.setAuthor(request.getParameter("Author"));
			b.setSynopsis(request.getParameter("synopsis"));
		}catch(NumberFormatException e) {
			return false;
		}
		
		
		//Checks if the book already exists
		List<Book> list = books.read();
		boolean found = false;
		for(int i=0;i<list.size() && !found;i++)
			if(b.equals(i))
				found=true;
		
		//if book doesn't exists, creates a book
		boolean created=false;
		if(!found) {
			books.write(b);
			created=true;
		}
			
		return created;
	}

	public static List<Book> read(Request request) {
		Query query = request.getQuery();
		List<Book> list = books.read();

		return list;
	}

}
