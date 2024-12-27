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

import ro.emanuel.proiect.dao.DomainDAO;
import ro.emanuel.proiect.pojo.Domain;

@Controller
public class DomainController {

	@GetMapping("/domain")
	public String singleDomain(@RequestParam(name = "id", required = true, defaultValue = "1") int id, Model model)
			throws SQLException, ClassNotFoundException {
		// Iau obiectul din baza de date
		Domain domain = DomainDAO.getById(id);

		// Adaug obiectul in pagina jsp
		model.addAttribute("domain", domain);

		return "domain.jsp";
	}

	@GetMapping("/domains")
	public String allDomains(Model model) throws SQLException, ClassNotFoundException {
		// Iau obiectele din baza de date
		List<Domain> domains = DomainDAO.getAll();

		// Adaug obiectul in pagina jsp
		model.addAttribute("domains", domains);

		return "domains.jsp";
	}

	@GetMapping("domains/edit/{id}")
	public String editDomain(Model model, @PathVariable int id) throws ClassNotFoundException, SQLException {
		// Iau obiectul din baza de date
		Domain domain = DomainDAO.getById(id);

		// Adaug obiectul in pagina jsp
		model.addAttribute("domain", domain);

		return "/domainEdit.jsp";
	}

	@PostMapping("domains/edit")
	public String saveSong(@ModelAttribute("domain") Domain domain, Model model, BindingResult result)
			throws ClassNotFoundException, SQLException {
		DomainDAO.update(domain);

		return "redirect:/domains";
	}

	@GetMapping("/domains/createDomain")
	public String createDomain(Model model) {
		Domain domain = new Domain();
		model.addAttribute("newDomain", domain);
		return "/createDomain.jsp";
	}

	@PostMapping("/domains/saveNewDomain")
	public String saveNewDomain(@ModelAttribute("newDomain") Domain domain) throws ClassNotFoundException, SQLException {
		DomainDAO.create(domain);
		return "redirect:/domains";
	}

	@GetMapping("/domains/delete/{id}")
	public String deleteDomain(@PathVariable int id) throws ClassNotFoundException, SQLException {
		DomainDAO.delete(id);
		return "redirect:/domains";
	}

}
