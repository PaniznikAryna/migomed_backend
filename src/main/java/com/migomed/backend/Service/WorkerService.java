package com.migomed.backend.Service;

import com.migomed.backend.Entity.Worker;
import com.migomed.backend.Repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepository;

    public List<Worker> getAllWorker(){
        return workerRepository.findAll();
    }

    public Worker getWorkerById(Long id){
        return workerRepository.findById(id).orElse(null);
    }

    public Worker saveWorker(Worker worker){
        return workerRepository.save(worker);
    }

    public void deleteWorker(Long id){
        workerRepository.deleteById(id);
    }
}
