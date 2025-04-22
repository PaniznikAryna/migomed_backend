package com.migomed.backend.Controller;

import com.migomed.backend.Entity.Services;
import com.migomed.backend.Service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServicesController {

    private final ServicesService servicesService;

    @GetMapping
    public ResponseEntity<List<Services>> getAllServices() {
        List<Services> servicesList = servicesService.getAllServices();
        return ResponseEntity.ok(servicesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Services> getServicesById(@PathVariable Long id) {
        Services services = servicesService.getServicesById(id);
        if (services == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(services);
    }

    @PostMapping
    public ResponseEntity<Services> createServices(@RequestBody Services services) {
        Services savedServices = servicesService.saveServices(services);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedServices);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Services> updateServices(@PathVariable Long id, @RequestBody Services updatedServicesData) {
        Services existingServices = servicesService.getServicesById(id);
        if (existingServices == null) {
            return ResponseEntity.notFound().build();
        }
        existingServices.setTitle(updatedServicesData.getTitle());
        existingServices.setCost(updatedServicesData.getCost());
        Services updatedServices = servicesService.saveServices(existingServices);
        return ResponseEntity.ok(updatedServices);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServices(@PathVariable Long id) {
        servicesService.deleteServices(id);
        return ResponseEntity.noContent().build();
    }
}
