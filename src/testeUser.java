import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class testeUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Archive<User> users = new Archive<User>("Archives/users.json");
		List<JSONObject> listO;
		List<User> list = new ArrayList<User>();
		List<Loan> loans = new ArrayList<Loan>();
		List<Reserve> reserves = new ArrayList<Reserve>();
		List<Exemplary> exemplaries = ServiceExemplary.read(null);
		Exemplary ex1 = exemplaries.get(0);
		Exemplary ex2 = exemplaries.get(1);
		loans.add(new Loan(ex1));
		reserves.add(new Reserve(ex2));
		/*User nUser = new User(
								"usernameTeste2",
								"teste2@teste.com",
								"senha2",
								1,
								1,
								new DataRegister(
													"testeFirstName2",
													"testeLastName2",
													"111111112",
													"111111111112",
													"333333332",
													"999999992",
													LocalDate.of(1994, 03, 11),
													LocalDate.now(),
													new Adress( "rua X","65","","31650310","Belo Horizonte","MG")
												)
							);
		
		nUser.setLoans(loans);
		nUser.setReserves(reserves);
		users.write(nUser);*/
		
		listO = users.read();
		
		for (JSONObject o: listO) {
			User u = new User();
			u.fromJSONObject(o);
			list.add(u);
		}
		
		
		
	}

}
