package nvt.web.dto;

public class SelectedRealEstateTypeDTO {

	private int id;
	private String label;
	
	
	public SelectedRealEstateTypeDTO() {
	
	}
	
	public SelectedRealEstateTypeDTO(int id, String label) {
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

	@Override
	public String toString() {
		return "SelectedRealEstateTypeDTO [id=" + id + ", label=" + label + "]";
	}
	
	
}
