package esprit.tn.project2msa.Services;

import esprit.tn.project2msa.entites.appointement;

import java.util.List;

public interface appointementService {
    public void AjouterAppointement(appointement appointment);
    public appointement UpdateAppointement( appointement appointment, Integer id);
    public boolean removeAppointement(Integer idApp);
    public List<appointement> retrieveAllAppointement();
    public appointement retrieveAppointementbyId(Integer idApp);
    List<appointement> findAllAppointementsByAnnonce(Integer IdAnnonce);
}
