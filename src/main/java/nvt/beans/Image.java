package nvt.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image implements Serializable {

	private static final long serialVersionUID = -6591309909176755838L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "name", unique = false, nullable = true)
	private String name;
	
	@Column(name = "file", unique = false, nullable = true)
	private String file;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "realestate_id", referencedColumnName = "id", nullable = true)
	private RealEstate realEstate;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
	private User user;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", referencedColumnName = "id", nullable = true)
	private Company company;
	
	
	public Image() { }

	public Image(String name, String file) {
		this.name = name;
		this.file = file;
	}

	
	public Image(String name, String file, RealEstate realEstate) {
		this.name = name;
		this.file = file;
		this.realEstate = realEstate;
	}
	

	public Image(String name, String file, User user) {
		this.name = name;
		this.file = file;
		this.user = user;
	}


	public Image(String name, String file, Company company) {
		this.name = name;
		this.file = file;
		this.company = company;
	}
	
	
	public Image(int id, String name, String file, RealEstate realEstate) {
		this.id = id;
		this.name = name;
		this.file = file;
		this.realEstate = realEstate;
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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public RealEstate getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealEstate realEstate) {
		this.realEstate = realEstate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	
}
