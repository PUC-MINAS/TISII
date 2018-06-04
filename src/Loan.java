import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONObject;

public class Loan implements JSONInterface{
	private int exemplaryCode;
	private Exemplary exemplary;
	private LocalDate loanDate;
	private LocalDate returnDate;
	private int renewals;
	private static final int MAX_RENEWALS = 3;
	
	public Loan(Exemplary ex) {
		this.exemplary = ex;
		this.exemplaryCode = ex.getExemplaryCode();
		this.loanDate = LocalDate.now();
		this.returnDate = loanDate.plusDays(10);
		this.renewals = 0;
	}
	
	public Loan() {
		this.setExemplaryCode(0);
		this.setExemplary(null);
		this.setLoanDate(null);
		this.setReturnDate(null);
		this.setRenewals(0);
	}

	public Exemplary getExemplary() {
		return exemplary;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}
	
	public int getExemplaryCode() {
		return exemplaryCode;
	}

	public int getRenewals() {
		return renewals;
	}

	public void setExemplaryCode(int exemplaryCode) {
		this.exemplaryCode = exemplaryCode;
	}

	public void setExemplary(Exemplary exemplary) {
		this.exemplary = exemplary;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public void setRenewals(int renewals) {
		this.renewals = renewals;
	}

	public boolean renew() {
		if (this.renewals < this.MAX_RENEWALS) {
			this.renewals++;
			this.returnDate = this.returnDate.plusDays(10);
			return true;
		}
		else return false;
	}

	@Override
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		JSONObject o = new JSONObject();
		o.put("exemplaryCode", this.getExemplaryCode());
		o.put("loanDate", this.getLoanDate());
		o.put("returnDate", this.getReturnDate());
		o.put("renewals", this.getRenewals());		
		return o;
	}

	@Override
	public void fromJSONObject(JSONObject o) {
		// TODO Auto-generated method stub
		this.setExemplaryCode(o.getInt("exemplaryCode"));
		LocalDate d = LocalDate.parse(o.getString("loanDate"));
		this.setLoanDate(d);
		d = LocalDate.parse(o.getString("returnDate"));
		this.setReturnDate(d);
		this.setRenewals(o.getInt("renewals"));
		
		this.setExemplary(ServiceExemplary.search(this.getExemplaryCode()));
	}
}
