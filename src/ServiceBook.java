import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

public class ServiceBook {
	
	private static Archive<Book> books = new Archive<Book>("Archives/books.json");

	//Cheks if the book exists, if not creates and return true, if does return false
	public static boolean create(Request request) {		
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
		boolean found = list.contains(b);
		
		//if book doesn't exists, creates a book
		boolean created=false;
		if(!found) {
			books.write(b);
			created=true;
		}
			
		return created;
	}

	//returns a list of Books
	public static List<Book> read(Request resquest) {
		List<Book> list = books.read();
		return list;
	}
	
	//Cheks if a book exist, if not returns false, if does deletes and return true 
	public static boolean delete(Request request){
		//Creates a book
		Book b = new Book();
		b.setName(request.getParameter("name"));
		b.setPublishingCompany(request.getParameter("publishingCompany"));
		b.setLanguage(request.getParameter("language"));
		b.setIsbn(Long.parseLong(request.getParameter("isbn")));
		b.setGenre(Integer.parseInt(request.getParameter("genre")));
		b.setSynopsis(request.getParameter("synopsis"));
		b.setAuthor(request.getParameter("Author"));
		b.setSynopsis(request.getParameter("synopsis"));
		
		//Checks if the book exists 
		List<Book> list = books.read();
		int index = list.indexOf(b); 
				
		//deletes the book
		boolean deleted=false;
		if(index>=0) {
			list.remove(index);
			deleted=true;
		}
			
		return deleted;
	}

	public static Book search(String nameBook) {
		// TODO Auto-generated method stub
		List<Book> list = readAll();
		
		for (Object e : list) {
			if( ((Book) e).getName().compareToIgnoreCase(nameBook) == 0) return (Book)e;
		}
		
		return null;
	}

	private static List<Book> readAll() {
		return books.read();
	}
}
