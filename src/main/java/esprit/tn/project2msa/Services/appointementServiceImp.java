package esprit.tn.project2msa.Services;

import esprit.tn.project2msa.Repositories.AppointementRepo;
import esprit.tn.project2msa.entites.AppointmentStatus;
import esprit.tn.project2msa.entites.appointement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class appointementServiceImp  implements appointementService{
    @Autowired
    AppointementRepo appointementRepository;
    @Override
    public void AjouterAppointement(appointement appointment) {
       // this.appointementRepository = appointementRepository;
       appointementRepository.save(appointment);
    }

    @Override
    public appointement UpdateAppointement(appointement appointment, Integer id) {
        appointment.setId(id);
        return appointementRepository.save(appointment);
    }

    @Override
    public void removeAppointement(Integer idApp) {
        appointementRepository.deleteById(idApp);
    }

    @Override
    public List<appointement> retrieveAllAppointement() {
        List<appointement> appointments = new ArrayList<>();
        appointementRepository.findAll().forEach(appointments::add);
        return appointments;
    }

    @Override
    public appointement retrieveAppointementbyId(Integer idApp) {
        return  appointementRepository.findById(idApp).orElse(null);
    }
}
