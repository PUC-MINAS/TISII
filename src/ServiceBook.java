import org.json.JSONObject;
import org.simpleframework.http.Query;
import org.simpleframework.http.Request;

public class ServiceBook {

	public static String create(Request request) {
		// TODO Auto-generated method stub
		Query query = request.getQuery();
		String name = query.get("name");
		
		JSONObject msg = new JSONObject();
		msg.put("status", "create successful");
		return msg.toString();
	}

}
