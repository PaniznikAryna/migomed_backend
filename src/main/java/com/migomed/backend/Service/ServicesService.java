package com.migomed.backend.Service;

import com.migomed.backend.Entity.Services;
import com.migomed.backend.Repository.ServicesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ServicesService {
    private final ServicesRepository servicesRepository;

    public List<Services> getAllServices(){
        return servicesRepository.findAll();
    }

    public Services getServicesById(Long id){
        return servicesRepository.findById(id).orElse(null);
    }

    public Services saveServices(Services services){
        return servicesRepository.save(services);
    }

    public void deleteServices(Long id){
        servicesRepository.deleteById(id);
    }
}
