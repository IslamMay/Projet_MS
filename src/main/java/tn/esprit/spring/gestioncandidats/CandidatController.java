package tn.esprit.spring.gestioncandidats;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidats")
public class CandidatController {
@RequestMapping("/hello")
    public String sayHello(){
        return "Hello from MicroService Candidat ";
    }
}
