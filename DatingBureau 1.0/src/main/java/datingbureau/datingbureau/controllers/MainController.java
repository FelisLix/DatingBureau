package datingbureau.datingbureau.controllers;


import datingbureau.datingbureau.services.ArchiveService;
import datingbureau.datingbureau.services.ClientService;
import datingbureau.datingbureau.services.MeetingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor

public class MainController {

    private ClientService clientService;
    private ArchiveService archiveService;
    private MeetingService meetingService;

    @GetMapping("show_clients")
    public String showClients(Model model) {
        model.addAttribute("clients", clientService.getAll());
        return "show_clients";
    }

    @GetMapping("show_meetings")
    public String showMeetings(Model model) {
        model.addAttribute("meetings", meetingService.getAll());
        return "show_meetings";
    }

    @GetMapping("show_pairs")
    public String showPairs(Model model) {
        model.addAttribute("pairs", archiveService.getAll());
        return "show_pairs";
    }

    @GetMapping("main_menu")
    public String mainMenu() {
        return "index";
    }

}
