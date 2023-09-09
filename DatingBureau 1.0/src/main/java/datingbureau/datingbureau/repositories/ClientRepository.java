package datingbureau.datingbureau.repositories;

import datingbureau.datingbureau.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findByCharacteristicsContainsAndStatusLike(String characteristics, String status);

    List<Client> findByStatusLike(String status);

}