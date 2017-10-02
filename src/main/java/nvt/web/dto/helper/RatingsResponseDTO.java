package nvt.web.dto.helper;

public class RatingsResponseDTO {

	int ratings1;
	int ratings2;
	int ratings3;
	int ratings4;
	int ratings5;
	int ukupno;
	double srednjaVrednost;

	
	public RatingsResponseDTO() {
		
	}

	public RatingsResponseDTO(int ratings1, int ratings2, int ratings3, int ratings4, int ratings5, int ukupno,
			double srednjaVrednost) {
		this.ratings1 = ratings1;
		this.ratings2 = ratings2;
		this.ratings3 = ratings3;
		this.ratings4 = ratings4;
		this.ratings5 = ratings5;
		this.ukupno = ukupno;
		this.srednjaVrednost = srednjaVrednost;
	}


	public int getRatings1() {
		return ratings1;
	}

	public void setRatings1(int ratings1) {
		this.ratings1 = ratings1;
	}

	public int getRatings2() {
		return ratings2;
	}

	public void setRatings2(int ratings2) {
		this.ratings2 = ratings2;
	}

	public int getRatings3() {
		return ratings3;
	}

	public void setRatings3(int ratings3) {
		this.ratings3 = ratings3;
	}

	public int getRatings4() {
		return ratings4;
	}

	public void setRatings4(int ratings4) {
		this.ratings4 = ratings4;
	}

	public int getRatings5() {
		return ratings5;
	}

	public void setRatings5(int ratings5) {
		this.ratings5 = ratings5;
	}

	public int getUkupno() {
		return ukupno;
	}

	public void setUkupno(int ukupno) {
		this.ukupno = ukupno;
	}

	public double getSrednjaVrednost() {
		return srednjaVrednost;
	}

	public void setSrednjaVrednost(double srednjaVrednost) {
		this.srednjaVrednost = srednjaVrednost;
	}
	
}
