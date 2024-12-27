package ro.emanuel.proiect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.proiect.helper.Helper;
import ro.emanuel.proiect.pojo.User;

public class UserDAO {

	public static User getById(Integer id) throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "select * from worship_users where id=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();
		User user = null;
		if (resultSet.next()) {
			user = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getInt("domain_id"));
		}
		Helper.closeConnection();
		return user;
	}

	public static List<User> getAll() throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "select * from worship_users";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		List<User> users = new ArrayList<>();
		while (resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String username = resultSet.getString("username");
			Integer domainId = resultSet.getInt("domain_id");
			User user = new User(id, username, domainId);
			users.add(user);
		}

		Helper.closeConnection();
		return users;
	}

	public static void update(User user) throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "update worship_users set username=?, domain_id=? where id=?";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, user.getUsername());
		statement.setInt(2, user.getDomainId());
		statement.setInt(3, user.getId());

		statement.executeUpdate();
		Helper.closeConnection();
	}

	public static void create(User user) throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "insert into worship_users(username,domain_id) values(?,?)";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, user.getUsername());
		statement.setInt(2, user.getDomainId());

		statement.executeUpdate();
		Helper.closeConnection();
	}

	public static void delete(int id) throws ClassNotFoundException, SQLException {
		String query = "delete from worship_users where id=" + id;
		Connection connection = Helper.getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		Helper.closeConnection();
	}

}
