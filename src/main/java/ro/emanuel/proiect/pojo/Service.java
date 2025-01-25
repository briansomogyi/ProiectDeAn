package ro.emanuel.proiect.pojo;

import java.sql.Date;

public class Service {

	private Integer id;
	private String serviceName;
	private Date serviceDate;

	public Service() {
	}

	public Service(Integer id, String serviceName, Date serviceDate) {
		this.id = id;
		this.serviceName = serviceName;
		this.serviceDate = serviceDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

}
