package datingbureau.datingbureau.services;

import datingbureau.datingbureau.data.Client;
import datingbureau.datingbureau.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }


    public void addClient(String firstName, String lastName, String sex, String charact, String requir) {
        clientRepository.save(new Client(firstName, lastName, sex, charact, requir));
    }

    public List<Client> getActiveClients() {
        return clientRepository.findByStatusLike("active");
    }

    public List<Client> getCandidates(String requir) {
        return clientRepository.findByCharacteristicsContainsAndStatusLike(requir, "active");
    }

    public void updateClient(int id, String firstName, String lastName, String sex, String charact, String requir, String status) {
        Optional<Client> client = clientRepository.findById(id);
        client.ifPresent(a -> {
            a.setFirstName(firstName);
            a.setLastName(lastName);
            a.setSex(sex);
            a.setCharacteristics(charact);
            a.setRequirements(requir);
            a.setStatus(status);
            clientRepository.save(a);
        });
    }

    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }

    public void setStatusHappy(int id) {
        Optional<Client> client = clientRepository.findById(id);
        client.ifPresent(a -> a.setStatus("found a partner"));
    }
}
