package ro.emanuel.proiect.pojo;

public class User {

	private Integer id;
	private String username;
	private Integer domainId;

	public User() {
	}

	public User(Integer id, String username, Integer domainId) {
		this.id = id;
		this.username = username;
		this.domainId = domainId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getDomainId() {
		return domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

}
