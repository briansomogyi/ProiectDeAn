package ro.emanuel.proiect.pojo;

public class Domain {

	private Integer id;
	private String domainName;

	public Domain() {
	}

	public Domain(Integer id, String domainName) {
		this.id = id;
		this.domainName = domainName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

}
