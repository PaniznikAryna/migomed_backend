package com.migomed.backend.Service;

import com.migomed.backend.Entity.Schedule;
import com.migomed.backend.Repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedule(){
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Long id){
        return scheduleRepository.findById(id).orElse(null);
    }

    public Schedule saveSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id){
        scheduleRepository.deleteById(id);
    }
}
