package esprit.tn.project2msa.Repositories;

import esprit.tn.project2msa.entites.appointement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointementRepo extends JpaRepository<appointement, Integer> {

}
