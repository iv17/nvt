package nvt.web.dto;

import java.util.ArrayList;

public class SearchDTO {

	
	private ArrayList<ZipCodeDTO> selectedZipCodes;
	private ArrayList<CityDTO> selectedCities;
	private ArrayList<BlockDTO> selectedBlocks;
	private ArrayList<SelectedAdvertisementTypeDTO> selectedAdvertisementTypes;
	private ArrayList<SelectedRealEstateTypeDTO> selectedRealEstateTypes;
	
	private double minPrice;
	private double maxPrice;
	private double minSurface;
	private double maxSurface;
	
	
	public SearchDTO() {
	
	}
	
	
	public SearchDTO(ArrayList<ZipCodeDTO> selectedZipCodes, ArrayList<CityDTO> selectedCities,
			ArrayList<BlockDTO> selectedBlocks, ArrayList<SelectedAdvertisementTypeDTO> selectedAdvertisementTypes,
			ArrayList<SelectedRealEstateTypeDTO> selectedRealEstateTypes, double minPrice, double maxPrice, double minSurface,
			double maxSurface) {
		super();
		this.selectedZipCodes = selectedZipCodes;
		this.selectedCities = selectedCities;
		this.selectedBlocks = selectedBlocks;
		this.selectedAdvertisementTypes = selectedAdvertisementTypes;
		this.selectedRealEstateTypes = selectedRealEstateTypes;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.minSurface = minSurface;
		this.maxSurface = maxSurface;
	}
	
	
	public ArrayList<ZipCodeDTO> getSelectedZipCodes() {
		return selectedZipCodes;
	}
	public void setSelectedZipCodes(ArrayList<ZipCodeDTO> selectedZipCodes) {
		this.selectedZipCodes = selectedZipCodes;
	}
	public ArrayList<CityDTO> getSelectedCities() {
		return selectedCities;
	}
	public void setSelectedCities(ArrayList<CityDTO> selectedCities) {
		this.selectedCities = selectedCities;
	}
	public ArrayList<BlockDTO> getSelectedBlocks() {
		return selectedBlocks;
	}
	public void setSelectedBlocks(ArrayList<BlockDTO> selectedBlocks) {
		this.selectedBlocks = selectedBlocks;
	}
	public ArrayList<SelectedAdvertisementTypeDTO> getSelectedAdvertisementTypes() {
		return selectedAdvertisementTypes;
	}
	public void setSelectedAdvertisementTypes(ArrayList<SelectedAdvertisementTypeDTO> selectedAdvertisementTypes) {
		this.selectedAdvertisementTypes = selectedAdvertisementTypes;
	}
	public ArrayList<SelectedRealEstateTypeDTO> getSelectedRealEstateTypes() {
		return selectedRealEstateTypes;
	}
	public void setSelectedRealEstateTypes(ArrayList<SelectedRealEstateTypeDTO> selectedRealEstateTypes) {
		this.selectedRealEstateTypes = selectedRealEstateTypes;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public double getMinSurface() {
		return minSurface;
	}
	public void setMinSurface(double minSurface) {
		this.minSurface = minSurface;
	}
	public double getMaxSurface() {
		return maxSurface;
	}
	public void setMaxSurface(double maxSurface) {
		this.maxSurface = maxSurface;
	}


	@Override
	public String toString() {
		return "SearchDTO [selectedZipCodes=" + selectedZipCodes.get(0).toString() + ", selectedCities=" + selectedCities.get(0).toString()
				+ ", selectedBlocks=" + selectedBlocks.get(0).toString() + ", selectedAdvertisementTypes=" + selectedAdvertisementTypes.get(0).toString()
				+ ", selectedRealEstateTypes=" + selectedRealEstateTypes.get(0).toString() + ", minPrice=" + minPrice + ", maxPrice="
				+ maxPrice + ", minSurface=" + minSurface + ", maxSurface=" + maxSurface + "]";
	}
	
	
	
	
	
	
}
