package tn.esprit.spring.gestioncandidats;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatController {
    private CandidatService candidatService;

    public CandidatController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello from MicroService Candidat ";
    }
    @GetMapping
    public ResponseEntity<List<Candidat>> getAll() {
        List<Candidat> candidats = candidatService.getAll();
        if (candidats.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(candidats);
    }
    @RequestMapping("/jobs")
    public List<JobDTO> getAllJobs() {
        return candidatService.getJobs();
    }

    @RequestMapping("jobs/{id}")
    public JobDTO getJobByID(@PathVariable int id) {
        return candidatService.getJobById(id);
    }
    @GetMapping("/{id}/favorite-jobs")
    public List<JobDTO> getFavoriteJobs(@PathVariable int id) {
        return candidatService.getFavoriteJobs(id);
    }
    @PostMapping("/{id}/favorite-jobs/{jobId}")
    public ResponseEntity<String> saveFavoriteJob(@PathVariable int id, @PathVariable
    int jobId) {
        JobDTO job = candidatService.getJobById(jobId);
        if (job != null) {
            candidatService.saveFavoriteJob(id, jobId);
            return ResponseEntity.status(HttpStatus.OK).body("Job saved as favorite successfully.");
        } else {
// Gérer le cas où le job n'existe pas
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Job not found with ID: " + jobId);
        }
    }
}
