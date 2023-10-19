package esprit.tn.project2msa.Controller;

import esprit.tn.project2msa.Services.appointementServiceImp;
import esprit.tn.project2msa.entites.appointement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Appointement")
public class AppointementController {
    @Autowired
    esprit.tn.project2msa.Services.appointementServiceImp appointementServiceImp;
    @PostMapping("/Add")
    public void addAppointement(@RequestBody appointement appointment)  {

        this.appointementServiceImp.AjouterAppointement(appointment);


    }
    @PutMapping("/update/{id}")
    public appointement updateAppointement(@RequestBody appointement A,@PathVariable("id") Integer id)
    {
        return appointementServiceImp.UpdateAppointement(A,id);

    }
    @DeleteMapping("/delete/{id}")
    void deleteAppointement(@PathVariable("id") Integer id){
        appointementServiceImp.removeAppointement(id);
    }


    @GetMapping("/all")
    List<appointement> retrieveAllAnnouncementsAll()
    {
        return appointementServiceImp.retrieveAllAppointement();
    }
    @GetMapping("/get/{id}")
    appointement getAppointement(@PathVariable("id") Integer idApp) {
        return appointementServiceImp.retrieveAppointementbyId(idApp);
    }
}
