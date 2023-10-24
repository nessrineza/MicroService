package esprit.tn.project2msa.Services;

import esprit.tn.project2msa.entites.Appointement;

import java.util.List;

public interface appointementService {
    public void AjouterAppointement(Appointement appointment);
    public Appointement UpdateAppointement(Appointement appointment, Integer id);
    public boolean removeAppointement(Integer idApp);
    public List<Appointement> retrieveAllAppointement();
    public Appointement retrieveAppointementbyId(Integer idApp);
    //List<Appointement> findAllByAnnonce(Integer IdAnnonce);
    public List<Appointement> findAllAppointementsByAnnonce(Integer id );
}
