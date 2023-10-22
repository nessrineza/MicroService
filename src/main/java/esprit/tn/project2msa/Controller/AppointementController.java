package esprit.tn.project2msa.Controller;

import esprit.tn.project2msa.Services.appointementServiceImp;
import esprit.tn.project2msa.entites.appointement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Appointement")
public class AppointementController {
    @Autowired
    esprit.tn.project2msa.Services.appointementServiceImp appointementServiceImp;
    @PostMapping("/Add")
    public ResponseEntity<Void> addAppointment(@RequestBody appointement appointment) {
        // Appel de votre service pour ajouter un rendez-vous
        this.appointementServiceImp.AjouterAppointement(appointment);

        // Vous pouvez personnaliser la réponse HTTP ici
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Valeur personnalisée");

        return new ResponseEntity<>(headers, HttpStatus.CREATED); // Exemple de code de statut 201 (Created)
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<appointement> updateAppointment(@RequestBody appointement appointment, @PathVariable("id") Integer id) {
        // Appel de votre service pour mettre à jour un rendez-vous
        appointement updatedAppointment = this.appointementServiceImp.UpdateAppointement(appointment, id);

        if (updatedAppointment != null) {
            // Si la mise à jour a réussi, retournez un ResponseEntity avec le rendez-vous mis à jour et le code 200 (OK).
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
        } else {
            // Si la mise à jour a échoué, retournez un ResponseEntity avec le code 404 (Not Found).
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id") Integer id){

        boolean removed = this.appointementServiceImp.removeAppointement(id);
        if (removed) {
            // Si la suppression a réussi, retournez un ResponseEntity avec le code 204 (No Content).
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // Si la suppression a échoué (par exemple, si l'ID n'a pas été trouvé), retournez un ResponseEntity avec le code 404 (Not Found).
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<appointement>> retrieveAllAppointments() {
        List<appointement> appointments = appointementServiceImp.retrieveAllAppointement();

        if (!appointments.isEmpty()) {
            // Si la liste d'annonces n'est pas vide, renvoyez un ResponseEntity avec les annonces et le code 200 (OK).
            return new ResponseEntity<>(appointments, HttpStatus.OK);
        } else {
            // Si la liste d'annonces est vide, renvoyez un ResponseEntity avec le code 204 (No Content) pour indiquer qu'il n'y a aucune annonce.
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/Annonce/{annonce-id}")
    public ResponseEntity<List<appointement>> retrieveAllAppointments(@PathVariable("annonce-id") Integer IdAnnonce) {
        return  ResponseEntity.ok(appointementServiceImp.findAllAppointementsByAnnonce(IdAnnonce));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<appointement> getAppointment(@PathVariable("id") Integer idApp) {
        appointement appointment = appointementServiceImp.retrieveAppointementbyId(idApp);

        if (appointment != null) {
            // Si l'annonce a été trouvée, renvoyez un ResponseEntity avec l'annonce et le code 200 (OK).
            return new ResponseEntity<>(appointment, HttpStatus.OK);
        } else {
            // Si l'annonce n'a pas été trouvée, renvoyez un ResponseEntity avec le code 404 (Not Found).
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
