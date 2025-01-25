package ro.emanuel.proiect.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.proiect.helper.Helper;
import ro.emanuel.proiect.pojo.Service;

public class ServiceDAO {

	public static Service getById(Integer id) throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "select * from worship_services where id=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);

		ResultSet set = statement.executeQuery();
		Service service = null;
		if (set.next()) {
			service = new Service(set.getInt("id"), set.getString("service_name"), set.getDate("service_date"));
		}
		Helper.closeConnection();
		return service;
	}

	public static List<Service> getAll() throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "select * from worship_services";
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery(query);

		List<Service> services = new ArrayList<>();
		while (set.next()) {
			Integer id = set.getInt("id");
			String serviceName = set.getString("service_name");
			Date serviceDate = set.getDate("service_date");
			Service service = new Service(id, serviceName, serviceDate);
			services.add(service);
		}

		Helper.closeConnection();
		return services;
	}

	public static void update(Service service) throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "update worship_services set service_name=?, service_date=? where id=?";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, service.getServiceName());
		statement.setDate(2, service.getServiceDate());
		statement.setInt(3, service.getId());

		statement.executeUpdate();
		Helper.closeConnection();
	}

	public static void create(Service service) throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "insert into worship_services(service_name,service_date) values(?,?)";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, service.getServiceName());
		statement.setDate(2, service.getServiceDate());

		statement.executeUpdate();
		Helper.closeConnection();
	}

	public static void delete(int id) throws ClassNotFoundException, SQLException {
		String query = "delete from worship_services where id=" + id;
		Connection connection = Helper.getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		Helper.closeConnection();
	}

}
