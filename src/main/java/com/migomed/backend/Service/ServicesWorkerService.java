package com.migomed.backend.Service;

import com.migomed.backend.Entity.ServicesWorker;
import com.migomed.backend.Entity.Users;
import com.migomed.backend.Repository.ServicesWorkerRepository;
import com.migomed.backend.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesWorkerService {
    private final ServicesWorkerRepository servicesWorkerRepository;

    public List<ServicesWorker> getAllUServicesWorker(){
        return servicesWorkerRepository.findAll();
    }

    public ServicesWorker getServicesWorkerById(Long id){
        return servicesWorkerRepository.findById(id).orElse(null);
    }

    public ServicesWorker saveServicesWorker(ServicesWorker servicesWorker){
        return servicesWorkerRepository.save(servicesWorker);
    }

    public void deleteServicesWorker(Long id){
        servicesWorkerRepository.deleteById(id);
    }
}
