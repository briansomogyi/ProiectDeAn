package ro.emanuel.proiect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.proiect.helper.Helper;
import ro.emanuel.proiect.pojo.Domain;

public class DomainDAO {

	public static Domain getById(Integer id) throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "select * from worship_domains where id=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);

		ResultSet set = statement.executeQuery();
		Domain domain = null;
		if (set.next()) {
			domain = new Domain(set.getInt("id"), set.getString("domain_name"));
		}
		Helper.closeConnection();
		return domain;
	}

	public static List<Domain> getAll() throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "select * from worship_domains";
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery(query);

		List<Domain> domains = new ArrayList<>();
		while (set.next()) {
			Integer id = set.getInt("id");
			String username = set.getString("domain_name");
			Domain domain = new Domain(id, username);
			domains.add(domain);
		}

		Helper.closeConnection();
		return domains;
	}

	public static void update(Domain domain) throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "update worship_domains set domain_name=? where id=?";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, domain.getDomainName());
		statement.setInt(2, domain.getId());

		statement.executeUpdate();
		Helper.closeConnection();
	}

	public static void create(Domain domain) throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "insert into worship_domains(domain_name) values(?)";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, domain.getDomainName());

		statement.executeUpdate();
		Helper.closeConnection();
	}

	public static void delete(int id) throws ClassNotFoundException, SQLException {
		String query = "delete from worship_domains where id=" + id;
		Connection connection = Helper.getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		Helper.closeConnection();
	}

}
