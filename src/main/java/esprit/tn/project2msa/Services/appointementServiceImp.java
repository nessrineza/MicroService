package esprit.tn.project2msa.Services;

import esprit.tn.project2msa.Repositories.AppointementRepo;
import esprit.tn.project2msa.entites.Appointement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class appointementServiceImp  implements appointementService {
    @Autowired
    AppointementRepo appointementRepository;

    @Override
    public void AjouterAppointement(Appointement appointment) {
        // this.appointementRepository = appointementRepository;
        appointementRepository.save(appointment);
    }

    @Override
    public Appointement UpdateAppointement(Appointement appointment, Integer id) {
        appointment.setId(id);
        return appointementRepository.save(appointment);
    }

    @Override
    public boolean removeAppointement(Integer idApp) {
        appointementRepository.deleteById(idApp);
        return false;
    }

    @Override
    public List<Appointement> retrieveAllAppointement() {
        List<Appointement> appointments = new ArrayList<>();
        appointementRepository.findAll().forEach(appointments::add);
        return appointments;
    }

    @Override
    public Appointement retrieveAppointementbyId(Integer idApp) {
        return appointementRepository.findById(idApp).orElse(null);
    }


    @Override

    public List<Appointement> findAllAppointementsByAnnonce(Integer id) {

        return appointementRepository.findAllByAnnonceId(id);
    }
}