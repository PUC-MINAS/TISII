import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

public class ServiceBook {

	public static boolean create(Request request) {
		// TODO Auto-generated method stub
		Query query = request.getQuery();
		String name = query.get("name");
		
		return true;
	}

	public static List<Book> toList() {
		// TODO Auto-generated method stub
		Book book = new Book();
		List<Book> books = new ArrayList<Book>();
		book.setName("GOT");
		book.setAuthor("George R. R. Martin");
		book.setLanguage("Português");
		book.setPublishingCompany("Leya");
		book.setSynopsis("The night is dark and full of terros.");
		books.add(book);
		book = new Book();
		book.setName("Senhor dos Anéis");
		book.setAuthor("J. R. R. Tolkien");
		book.setLanguage("Português");
		book.setPublishingCompany("Não sei");
		book.setSynopsis("Teste");
		books.add(book);
		return books;
	}

}
