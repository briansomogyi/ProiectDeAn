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

import ro.emanuel.proiect.dao.ServiceDAO;
import ro.emanuel.proiect.pojo.Service;

@Controller
public class ServiceController {

	@GetMapping("/service")
	public String singleService(@RequestParam(name = "id", required = true, defaultValue = "1") int id, Model model)
			throws SQLException, ClassNotFoundException {
		// Iau obiectul din baza de date
		Service service = ServiceDAO.getById(id);

		// Adaug obiectul in pagina jsp
		model.addAttribute("service", service);

		return "service.jsp";
	}

	@GetMapping("/services")
	public String allServices(Model model) throws SQLException, ClassNotFoundException {
		// Iau obiectele din baza de date
		List<Service> services = ServiceDAO.getAll();

		// Adaug obiectul in pagina jsp
		model.addAttribute("services", services);

		return "services.jsp";
	}

	@GetMapping("services/edit/{id}")
	public String editService(Model model, @PathVariable int id) throws ClassNotFoundException, SQLException {
		// Iau obiectul din baza de date
		Service service = ServiceDAO.getById(id);

		// Adaug obiectul in pagina jsp
		model.addAttribute("service", service);

		return "/serviceEdit.jsp";
	}

	@PostMapping("services/edit")
	public String saveSong(@ModelAttribute("service") Service service, Model model, BindingResult result)
			throws ClassNotFoundException, SQLException {
		ServiceDAO.update(service);

		return "redirect:/services";
	}

	@GetMapping("/services/createService")
	public String createService(Model model) {
		Service service = new Service();
		model.addAttribute("newService", service);
		return "/createService.jsp";
	}

	@PostMapping("/services/saveNewService")
	public String saveNewService(@ModelAttribute("newService") Service service) throws ClassNotFoundException, SQLException {
		ServiceDAO.create(service);
		return "redirect:/services";
	}

	@GetMapping("/services/delete/{id}")
	public String deleteService(@PathVariable int id) throws ClassNotFoundException, SQLException {
		ServiceDAO.delete(id);
		return "redirect:/services";
	}

}
