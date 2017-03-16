package nvt.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "working_time")
public class WorkingTime implements Serializable {


	private static final long serialVersionUID = 2614433274449352907L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	protected int id;
	
	@Column(name = "radni_dan_od", unique = true, nullable = false)
	protected String radniDanOd;
	
	@Column(name = "radni_dan_do", unique = true, nullable = false)
	protected String radniDanDo;
	
	@Column(name = "vikend_od", unique = false, nullable = true)
	protected String vikendOd;
	
	@Column(name = "vikend_do", unique = false, nullable = true)
	protected String vikendDo;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "workingTime")
	protected Set<Company> companies;

	
	
	public WorkingTime() {
	
	}

	public WorkingTime(String radniDanOd, String radniDanDo, String vikendOd, String vikendDo) {
		this.radniDanOd = radniDanOd;
		this.radniDanDo = radniDanDo;
		this.vikendOd = vikendOd;
		this.vikendDo = vikendDo;
	}

	
	public WorkingTime(int id, String radniDanOd, String radniDanDo, String vikendOd, String vikendDo,
			Set<Company> companies) {
		this.id = id;
		this.radniDanOd = radniDanOd;
		this.radniDanDo = radniDanDo;
		this.vikendOd = vikendOd;
		this.vikendDo = vikendDo;
		this.companies = companies;
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
	
	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}
	
}
