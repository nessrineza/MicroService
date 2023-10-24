package esprit.tn.project2msa.Repositories;

import esprit.tn.project2msa.entites.Appointement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointementRepo extends JpaRepository<Appointement, Integer> {

    List<Appointement> findAllByAnnonceId(Integer id);








}
