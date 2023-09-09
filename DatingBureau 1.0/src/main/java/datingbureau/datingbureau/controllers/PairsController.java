package datingbureau.datingbureau.controllers;

import datingbureau.datingbureau.services.ArchiveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor

public class PairsController {

    private ArchiveService archiveService;

    @GetMapping("add_pair")
    public String planDate(Model model, @RequestParam int id1, int id2) {
        archiveService.addPair(id1, id2);
        model.addAttribute("pairs", archiveService.getAll());
        return "show_pairs";
    }

    @GetMapping("delete_pair")
    public String deleteMeeting(@RequestParam int id) {
        try {
            archiveService.deletePair(id);
        } catch (Exception ignored) {
        }
        return "redirect:/show_pairs";
    }
}
