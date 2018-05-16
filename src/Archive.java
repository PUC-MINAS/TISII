import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Archive<T> {
	private String path;
	
	public Archive(String path){
		this.path = path;
	}
	
	public List<T> read() {
		// TODO Auto-generated method stub
		JSONArray array = null;
		List<T> books = new ArrayList<T>();
		try {
			FileInputStream arq = new FileInputStream(this.getPath());
			InputStreamReader input = new InputStreamReader(arq);
			BufferedReader br = new BufferedReader(input);
			array = new JSONArray(br.readLine());				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < array.length(); i++) {
			JSONObject obj = array.getJSONObject(i);
			Book b = new Book(obj.getString("name"),
							  obj.getString("publishingCompany"),
							  obj.getString("language"),
							  obj.getLong("isbn"),
							  obj.getInt("genre"),
							  obj.getString("synopsis"),
							  obj.getString("author"));
			books.add((T) b);
		}
		return books;
	}

	public String getPath() {
		// TODO Auto-generated method stub
		return this.path;
	}
	
}
