package tn.esprit.spring.gestioncandidats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatService implements ICandidatService {

    @Autowired
    private CandidatRepository candidateRepository;
    @Autowired
    private JobClient jobServiceClient;

    @Override
    public List<Candidat> getAll() {
        return candidateRepository.findAll();
    }
    public List<JobDTO> getJobs() {
        return jobServiceClient.getAllJobs();
    }

    public JobDTO getJobById(int id) {
        return jobServiceClient.getJobById(id);
    }
    public List<JobDTO> getFavoriteJobs(int candidateId) {
        Candidat candidate = candidateRepository.findById(candidateId).get();
        return candidate.getFavoriteJobs().stream()
                .map(jobServiceClient::getJobById)
                .collect(Collectors.toList());
    }
    public void saveFavoriteJob(int candidateId, int jobId) {
        Candidat candidate = candidateRepository.findById(candidateId).get();
        candidate.getFavoriteJobs().add(jobId);
        candidateRepository.save(candidate);

    }



}
