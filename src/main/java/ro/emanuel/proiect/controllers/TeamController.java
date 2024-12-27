package ro.emanuel.proiect.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.emanuel.proiect.dao.TeamDAO;
import ro.emanuel.proiect.pojo.Team;

@Controller
public class TeamController {

	@GetMapping("/team")
	public String singleTeam(@RequestParam(name = "id", required = true, defaultValue = "1") int id, Model model)
			throws SQLException, ClassNotFoundException {
		// Iau obiectul din baza de date
		Team team = TeamDAO.getById(id);

		// Adaug obiectul in pagina jsp
		model.addAttribute("team", team);

		return "team.jsp";
	}

	@GetMapping("/teams")
	public String allTeams(Model model) throws SQLException, ClassNotFoundException {
		// Iau obiectele din baza de date
		List<Team> teams = TeamDAO.getAll();

		// Adaug obiectul in pagina jsp
		model.addAttribute("teams", teams);

		return "teams.jsp";
	}

	@GetMapping("teams/edit/{id}")
	public String editTeam(Model model, @PathVariable int id) throws ClassNotFoundException, SQLException {
		// Iau obiectul din baza de date
		Team team = TeamDAO.getById(id);

		// Adaug obiectul in pagina jsp
		model.addAttribute("team", team);

		return "/teamEdit.jsp";
	}

	@PostMapping("teams/edit")
	public String saveSong(@ModelAttribute("team") Team team, Model model, BindingResult result)
			throws ClassNotFoundException, SQLException {
		TeamDAO.update(team);

		return "redirect:/teams";
	}

	@GetMapping("/teams/createTeam")
	public String createTeam(Model model) {
		Team team = new Team();
		model.addAttribute("newTeam", team);
		return "/createTeam.jsp";
	}

	@PostMapping("/teams/saveNewTeam")
	public String saveNewTeam(@ModelAttribute("newTeam") Team team) throws ClassNotFoundException, SQLException {
		TeamDAO.create(team);
		return "redirect:/teams";
	}

	@GetMapping("/teams/delete/{id}")
	public String deleteTeam(@PathVariable int id) throws ClassNotFoundException, SQLException {
		TeamDAO.delete(id);
		return "redirect:/teams";
	}

}
