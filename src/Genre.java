import org.json.JSONObject;

public class Genre implements JSONInterface {
	public int id;
	public String title;
	
	@Override
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		return new JSONObject(this);
	}
	@Override
	public void fromJSONObject(JSONObject o) {
		// TODO Auto-generated method stub
		this.id = o.getInt("id");
		this.title = o.getString("title");
	}
}
