package ro.emanuel.proiect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.proiect.helper.Helper;
import ro.emanuel.proiect.pojo.Team;

public class TeamDAO {

	public static Team getById(Integer id) throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "select * from worship_teams where id=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);

		ResultSet set = statement.executeQuery();
		Team team = null;
		if (set.next()) {
			team = new Team(set.getInt("id"), set.getString("team_name"));
		}
		Helper.closeConnection();
		return team;
	}

	public static List<Team> getAll() throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "select * from worship_teams";
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery(query);

		List<Team> teams = new ArrayList<>();
		while (set.next()) {
			Integer id = set.getInt("id");
			String teamName = set.getString("team_name");
			Team team = new Team(id, teamName);
			teams.add(team);
		}

		Helper.closeConnection();
		return teams;
	}

	public static void update(Team team) throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "update worship_teams set team_name=? where id=?";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, team.getTeamName());
		statement.setInt(2, team.getId());

		statement.executeUpdate();
		Helper.closeConnection();
	}

	public static void create(Team team) throws ClassNotFoundException, SQLException {
		Connection connection = Helper.getConnection();
		String query = "insert into worship_teams(team_name) values(?)";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, team.getTeamName());

		statement.executeUpdate();
		Helper.closeConnection();
	}

	public static void delete(int id) throws ClassNotFoundException, SQLException {
		String query = "delete from worship_teams where id=" + id;
		Connection connection = Helper.getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		Helper.closeConnection();
	}

}
