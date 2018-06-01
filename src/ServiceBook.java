import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

//w W 
public class ServiceBook {

    private static Archive<Book> books = new Archive<Book>("Archives/books.json");

    //Checks if the book exists, if not creates and return true, if does return false
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

	//if book doesn't exists, creates a book
	if(list.contains(b)) {
	    books.write(b);
	    return true;
	}
	return false;
    }

    //returns a list of Books
    public static List<Book> read(Request resquest) {
	List<Book> list = books.read();
	return list;
    }

    //Updates a Book
    public static boolean update(Request request) {
	//Receives isbn from request and searches for it in the list
	int index = getIndex(Long.parseLong(request.getParameter("isbnToUpdate")));		
	if(index>-1) {
	    List<Book> list = books.read();
	    list.get(index).setName(request.getParameter("name"))
	    .setPublishingCompany(request.getParameter("publishingCompany"))
	    .setLanguage(request.getParameter("language"))
	    .setIsbn(Long.parseLong(request.getParameter("isbn")))
	    .setGenre(Integer.parseInt(request.getParameter("genre")))
	    .setSynopsis(request.getParameter("synopsis"))
	    .setAuthor(request.getParameter("Author"))
	    .setSynopsis(request.getParameter("synopsis"));
	    return true;
	}
	return false;
    }

    //Cheks if a book exist, if not returns false, if does deletes and return true 
    public static boolean delete(Request request){
	//Receives isbn from request and searches for it in the list
	int index = getIndex(Long.parseLong(request.getParameter("isbn")));
	List<Book>list = books.read();

	//deletes the book
	boolean deleted=false;
	if(index>=0) {
	    list.remove(index);
	    deleted=true;
	}
	return deleted;
    }

    //Returns index of a book. -1 if doesn't exists
    private static int getIndex(long isbn) {
	List<Book> list = books.read();
	int index = -1;
	boolean found = false;
	for(int i=0;i<list.size() && !found;i++)
	    if(list.get(i).getIsbn()==isbn) {
		found = true;
		index = i;
	    }
	return index;
    }


    public static Book search(String nameBook) {
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
