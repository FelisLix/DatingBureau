package datingbureau.datingbureau.services;


import datingbureau.datingbureau.data.Meeting;
import datingbureau.datingbureau.repositories.MeetingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor

public class MeetingService {

    private MeetingRepository meetingRepository;
    private ClientService clientService;

    public List<Meeting> getAll() {
        return meetingRepository.findAll();
    }

    public void addMeeting(int id1, int id2, LocalDate date) {
        if (clientService.findById(id1).isPresent() && clientService.findById(id2).isPresent()) {
            meetingRepository.save(new Meeting(clientService.findById(id1).get(), clientService.findById(id2).get(), date));
        }
    }

    public void deleteMeeting(int id) {
        meetingRepository.deleteById(id);
    }
}
