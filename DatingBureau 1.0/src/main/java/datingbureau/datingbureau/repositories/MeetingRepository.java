package datingbureau.datingbureau.repositories;

import datingbureau.datingbureau.data.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

}