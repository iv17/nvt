package nvt.web.dto;

import nvt.beans.AdvertisementType;

public class AdvertisementTypeDTO {

	protected int id;
	protected String name;
	
	
	
	public AdvertisementTypeDTO(AdvertisementType advertisementType) {
		this(advertisementType.getId(),
				advertisementType.getName());
	}
	
	
	public AdvertisementTypeDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
