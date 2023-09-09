package datingbureau.datingbureau.controllers;


import datingbureau.datingbureau.data.Client;
import datingbureau.datingbureau.services.ClientService;
import datingbureau.datingbureau.services.MeetingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@AllArgsConstructor

public class MeetingsController {
    private ClientService clientService;
    private MeetingService meetingService;

    @GetMapping("plan_meeting")
    public String planMeeting(Model model, @RequestParam int id1, @RequestParam int id2) {
        Optional<Client> a1 = clientService.findById(id1);
        Optional<Client> a2 = clientService.findById(id2);
        if (a1.isPresent() && a2.isPresent()) {
            model.addAttribute("client1", a1.get());
            model.addAttribute("client2", a2.get());
            return "add_new_meeting";
        }
        return "show_clients";
    }

    @PostMapping("add_meeting")
    public String addMeeting(Model model, @RequestParam int id1, int id2, @RequestParam LocalDate date) {
        meetingService.addMeeting(id1, id2, date);
        model.addAttribute("meetings", meetingService.getAll());
        return "show_meetings";
    }

    @GetMapping("delete_meeting")
    public String deleteMeeting(@RequestParam int id) {
        try {
            meetingService.deleteMeeting(id);
        } catch (Exception ignored) {
        }
        return "redirect:/show_meetings";
    }

}
