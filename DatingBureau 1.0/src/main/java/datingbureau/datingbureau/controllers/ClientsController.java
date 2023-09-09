package datingbureau.datingbureau.controllers;

import datingbureau.datingbureau.data.Client;
import datingbureau.datingbureau.services.ArchiveService;
import datingbureau.datingbureau.services.ClientService;
import datingbureau.datingbureau.services.MeetingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor

public class ClientsController {

    private ClientService clientService;
    private ArchiveService archiveService;
    private MeetingService meetingService;

    @GetMapping("edit_client")
    public String editClient(@RequestParam int id, Model model) {
        Optional<Client> a = clientService.findById(id);
        if (a.isPresent()) {
            model.addAttribute("client", a.get());
            return "edit_client";
        }
        return "redirect:/show_clients";
    }

    @PostMapping("edit_client")
    public String updateClient(@RequestParam int id, @RequestParam String firstName,
                               @RequestParam String lastName, @RequestParam String sex,
                               @RequestParam String characteristics, @RequestParam String requirements,
                               @RequestParam String status) {
        clientService.updateClient(id, firstName, lastName, sex, characteristics, requirements, status);
        return "redirect:/show_clients";
    }

    @GetMapping("delete_client")
    public String deleteClient(@RequestParam int id) {
        try {
            clientService.deleteClient(id);
        } catch (Exception ignored) {
        }
        return "redirect:/show_clients";
    }

    @GetMapping("add_client")
    public String addClient() {
        return "add_new_client";
    }

    @PostMapping("add_client")
    public String addClient(@RequestParam String firstName,
                            @RequestParam String lastName, @RequestParam String sex,
                            @RequestParam String characteristics, @RequestParam String requirements) {
        clientService.addClient(firstName, lastName, sex, characteristics, requirements);
        return "redirect:/show_clients";
    }

    @GetMapping("show_active_clients")
    public String showClients(Model model) {
        model.addAttribute("clients", clientService.getActiveClients());
        return "clients_filtered";
    }

    @GetMapping("search_candidates")
    public String showClients(Model model, @RequestParam String requirement, @RequestParam int id) {
        model.addAttribute("candidates", clientService.getCandidates(requirement));
        model.addAttribute("id", id);
        return "show_candidates";
    }
}
