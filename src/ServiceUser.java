import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.simpleframework.http.Request;



public class ServiceUser {

	

	private static Archive<User> users = new Archive<User>("Archives/users.json");

	

	// Not implemented yet

	public static boolean create(Request request) {

		// TODO Auto-generated method stub


		User user = new User();

		List<User> list = readAll();

		try {

			user.setUsername(request.getParameter("username"));

			user.setType(Integer.parseInt(request.getParameter("type")));

			user.setEmail(request.getParameter("email"));

			user.setPassword(request.getParameter("password"));

			user.setStatus(StatusUser.WAITING_CONFIRMATION);

			user.setData( 

				new DataRegister(

					request.getParameter("firstName"),

					request.getParameter("lastName"),

					request.getParameter("docIdentity"),

					request.getParameter("docCpf"),

					request.getParameter("phone"),

					request.getParameter("cel"),

					LocalDate.parse(request.getParameter("birth")),

					LocalDate.now(),

					new Adress(

						request.getParameter("adress"),

						request.getParameter("number"),

						request.getParameter("complement"),

						request.getParameter("cep"),

						request.getParameter("city"),

						request.getParameter("state")

						

					)						

				)

			);

			

			

		}

		catch(Exception e){

			return false;

		}

		

		if ( !list.contains(user)) {

			users.write(user);

			return true;

		}

		else {

			return false;

		}

	}

	

	
	
	public static boolean loginWithEmailAndName(String email, String password){
		List<User> list = readAll();
		for (User u : list) {

		    if( u.getEmail() == email&& u.getPassword()== password)
		    	return true;

		}
		
		return false;
		
	}
	
	
	public static List<User> read (){
		return readAll();
	}
	
	
	

	



	
	private static List<User> readAll(){
		List<JSONObject> listJSON = users.read();
		List<User> list = new ArrayList<User>();
		
		for (JSONObject j : listJSON) {
			User u = new User();
			u.fromJSONObject(j);
			list.add(u);
		}		
		
		return list;
	}
	

}