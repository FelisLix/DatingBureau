package datingbureau.datingbureau.services;

import datingbureau.datingbureau.data.Archive;
import datingbureau.datingbureau.repositories.ArchiveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ArchiveService {

    private ArchiveRepository archiveRepository;
    private ClientService clientService;

    public List<Archive> getAll() {
        return archiveRepository.findAll();
    }

    public void addPair(int id1, int id2) {
        if (clientService.findById(id1).isPresent() && clientService.findById(id2).isPresent()) {
            clientService.setStatusHappy(id1);
            clientService.setStatusHappy(id2);
            archiveRepository.save(new Archive(clientService.findById(id1).get(), clientService.findById(id2).get()));
        }
    }

    public void deletePair(int id) {
        archiveRepository.deleteById(id);
    }
}
