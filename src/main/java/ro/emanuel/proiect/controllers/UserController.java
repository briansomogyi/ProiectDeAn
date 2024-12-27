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

import ro.emanuel.proiect.dao.UserDAO;
import ro.emanuel.proiect.pojo.User;

@Controller
public class UserController {

	@GetMapping("/user")
	public String singleUser(@RequestParam(name = "id", required = true, defaultValue = "1") int id, Model model)
			throws SQLException, ClassNotFoundException {
		// Iau obiectul din baza de date
		User user = UserDAO.getById(id);

		// Adaug obiectul in pagina jsp
		model.addAttribute("user", user);

		return "user.jsp";
	}

	@GetMapping("/users")
	public String allUsers(Model model) throws SQLException, ClassNotFoundException {
		// Iau obiectele din baza de date
		List<User> users = UserDAO.getAll();

		// Adaug obiectul in pagina jsp
		model.addAttribute("users", users);

		return "users.jsp";
	}

	@GetMapping("users/edit/{id}")
	public String editUser(Model model, @PathVariable int id) throws ClassNotFoundException, SQLException {
		// Iau obiectul din baza de date
		User user = UserDAO.getById(id);

		// Adaug obiectul in pagina jsp
		model.addAttribute("user", user);

		return "/userEdit.jsp";
	}

	@PostMapping("users/edit")
	public String saveUser(@ModelAttribute("user") User user, Model model, BindingResult result)
			throws ClassNotFoundException, SQLException {
		UserDAO.update(user);

		return "redirect:/users";
	}

	@GetMapping("/users/createUser")
	public String createUser(Model model) {
		User user = new User();
		model.addAttribute("newUser", user);
		return "/createUser.jsp";
	}

	@PostMapping("/users/saveNewUser")
	public String saveNewUser(@ModelAttribute("newUser") User user) throws ClassNotFoundException, SQLException {
		UserDAO.create(user);
		return "redirect:/users";
	}

	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable int id) throws ClassNotFoundException, SQLException {
		UserDAO.delete(id);
		return "redirect:/users";
	}

}
