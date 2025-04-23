package com.migomed.backend.Service;

import com.migomed.backend.Entity.Visits;
import com.migomed.backend.Repository.VisitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitsRepositoryService {
    private final VisitsRepository visitsRepository;

    public List<Visits> getAllVisits(){
        return visitsRepository.findAll();
    }

    public Visits getVisitsById(Long id){
        return visitsRepository.findById(id).orElse(null);
    }

    public Visits saveVisits(Visits visits){
        return visitsRepository.save(visits);
    }

    public void deleteVisits(Long id){
        visitsRepository.deleteById(id);
    }
}
