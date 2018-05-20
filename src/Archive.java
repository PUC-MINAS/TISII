import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
		return (List<T>) array.toList();
	}

	public String getPath() {
		// TODO Auto-generated method stub
		return this.path;
	}

	public boolean write(T obj) {
		// TODO Auto-generated method stub
		JSONArray array = new JSONArray();
		List<T> list = this.read();
		list.add(obj);
		array.put(list);
		try {
			FileOutputStream arq = new FileOutputStream(this.getPath());
			PrintWriter pr = new PrintWriter(arq);
			array.write(pr);						
			pr.close();
			arq.close();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
