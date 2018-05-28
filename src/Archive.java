import java.io.BufferedReader;
import java.io.File;
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

/* Author: Ravi Assis
 * Date: 20/05/2018
 * Description: This class can read or write any collection of data of the type List<T>
 * */

public class Archive<T> {
	private String path; //directory name
	
	/*Constructer*/
	public Archive(String path){
		this.path = path;
		File file = new File(path);
		if( !file.exists() ) {
			FileOutputStream arq;
			try {
				arq = new FileOutputStream(this.getPath());
				arq.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//read()
	// this method read a json file and return the data as a List<T>
	public List<T> read() {
		JSONArray array = null;
		try {
			FileInputStream arq = new FileInputStream(this.getPath());
			InputStreamReader input = new InputStreamReader(arq);
			BufferedReader br = new BufferedReader(input);
			array = new JSONArray(br.readLine());				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			array = new JSONArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			array = new JSONArray();
		}		
		catch (Exception e) {
			
			array = new JSONArray();
		}
		return (List<T>) array.toList();
	}

	//getPath()
	//return the directory path of the object
	public String getPath() {
		// TODO Auto-generated method stub
		return this.path;
	}

	//write(T obj)
	// this method receive as parameter a T Object and put him in the json file.
	public boolean write(T obj) {
		// TODO Auto-generated method stub
		List<T> list = this.read();
		list.add(obj);
		JSONArray array = new JSONArray(list);
		
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
