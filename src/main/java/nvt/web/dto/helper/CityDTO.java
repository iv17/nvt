package nvt.web.dto.helper;

public class CityDTO {

	protected int id;
	protected String label;
	
	
	public CityDTO() {
	
	}
	
	public CityDTO(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
}
