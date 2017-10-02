package nvt.util;

import java.util.ArrayList;
import java.util.List;

import nvt.beans.RealEstate;
import nvt.beans.RealEstateRating;
import nvt.web.dto.RealEstateRatingDTO;
import nvt.web.dto.helper.RatingsResponseDTO;

public class Util {

	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public static RatingsResponseDTO ratings(RealEstate realEstate) {

		List<RealEstateRatingDTO> ratings1 = new ArrayList<RealEstateRatingDTO>();
		List<RealEstateRatingDTO> ratings2 = new ArrayList<RealEstateRatingDTO>();
		List<RealEstateRatingDTO> ratings3 = new ArrayList<RealEstateRatingDTO>();
		List<RealEstateRatingDTO> ratings4 = new ArrayList<RealEstateRatingDTO>();
		List<RealEstateRatingDTO> ratings5 = new ArrayList<RealEstateRatingDTO>();
		double sum = 0;
		for (RealEstateRating r : realEstate.getRatings()) {
			sum += r.getRate();
			RealEstateRatingDTO rr = new RealEstateRatingDTO(r);
			if(rr.getRate() == 1) {ratings1.add(rr);}
			if(rr.getRate() == 2) {ratings2.add(rr);}
			if(rr.getRate() == 3) {ratings3.add(rr);}
			if(rr.getRate() == 4) {ratings4.add(rr);}
			if(rr.getRate() == 5) {ratings5.add(rr);}

		}
		int r1 = ratings1.size();
		int r2 = ratings2.size();
		int r3 = ratings3.size();
		int r4 = ratings4.size();
		int r5 = ratings5.size();
		int ukupno = realEstate.getRatings().size();
		int srednjaVrednost = 0;
		if(ukupno > 0) {
			srednjaVrednost = (int) (sum/realEstate.getRatings().size());
			//srednjaVrednost = Util.round(srednjaVrednost, 1);
			System.out.println(srednjaVrednost);
		}

		RatingsResponseDTO ratings = new RatingsResponseDTO(r1, r2, r3, r4, r5, ukupno, srednjaVrednost);
		return ratings;
	}
}
