package nvt.web.dto;

import nvt.beans.WorkingTime;

public class WorkingTimeDTO {

	protected int id;
	protected String radniDanOd;
	protected String radniDanDo;
	protected String vikendOd;
	protected String vikendDo;
	
	
	public WorkingTimeDTO(WorkingTime workingTime) {
		this(workingTime.getId(), workingTime.getRadniDanOd(), workingTime.getRadniDanDo(),
				workingTime.getRadniDanOd(), workingTime.getRadniDanDo());
	}
	
	
	public WorkingTimeDTO(int id, String radniDanOd, String radniDanDo, String vikendOd, String vikendDo) {
		this.id = id;
		this.radniDanOd = radniDanOd;
		this.radniDanDo = radniDanDo;
		this.vikendOd = vikendOd;
		this.vikendDo = vikendDo;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRadniDanOd() {
		return radniDanOd;
	}
	public void setRadniDanOd(String radniDanOd) {
		this.radniDanOd = radniDanOd;
	}
	public String getRadniDanDo() {
		return radniDanDo;
	}
	public void setRadniDanDo(String radniDanDo) {
		this.radniDanDo = radniDanDo;
	}
	public String getVikendOd() {
		return vikendOd;
	}
	public void setVikendOd(String vikendOd) {
		this.vikendOd = vikendOd;
	}
	public String getVikendDo() {
		return vikendDo;
	}
	public void setVikendDo(String vikendDo) {
		this.vikendDo = vikendDo;
	}

	
}
