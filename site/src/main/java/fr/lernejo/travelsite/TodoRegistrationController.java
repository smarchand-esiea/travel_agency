package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TodoRegistrationController {

    final ArrayList listeRegistration;

    public TodoRegistrationController() { this.listeRegistration = new ArrayList(); }

    @PostMapping(value = "/api/inscription")
    public void AjoutTodo(@RequestBody User userRegistration) {
        listeRegistration.add(userRegistration);
    }

    @GetMapping(value = "/api/travels")
    public ArrayList<Destination> GetTodo(@RequestParam String userName) {
        ArrayList<Destination> listeDestination = new ArrayList<Destination>();
        listeDestination.add(new Destination("France", 23));
        listeDestination.add(new Destination("Allemagne", 19));
       return listeDestination;
    }
}
