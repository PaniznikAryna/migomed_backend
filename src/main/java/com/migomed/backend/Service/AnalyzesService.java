package com.migomed.backend.Service;

import com.migomed.backend.Entity.Analyzes;
import com.migomed.backend.Repository.AnalyzesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyzesService {
    private final AnalyzesRepository analyzesRepository;

    public List<Analyzes> getAllAnalyzes(){
        return analyzesRepository.findAll();
    }

    public Analyzes getAnalyzesById(Long id){
        return analyzesRepository.findById(id).orElse(null);
    }

    public Analyzes saveAnalyzes(Analyzes analyzes){
        return analyzesRepository.save(analyzes);
    }

    public void deleteAnalyzes(Long id){
        analyzesRepository.deleteById(id);
    }
}
