import java.time.LocalDate;
import java.time.LocalDateTime;

public class Loan {
	private Exemplary exemplary;
	private LocalDate loanDate;
	private LocalDate returnDate;
	private int renewals;
	private static final int MAX_RENEWALS = 3;
	
	public Loan(Exemplary ex) {
		this.exemplary = ex;
		this.loanDate = LocalDate.now();
		this.returnDate = loanDate.plusDays(10);
		this.renewals = 0;
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
	
	public boolean renew() {
		if (this.renewals < this.MAX_RENEWALS) {
			this.renewals++;
			this.returnDate = this.returnDate.plusDays(10);
			return true;
		}
		else return false;
	}
}
