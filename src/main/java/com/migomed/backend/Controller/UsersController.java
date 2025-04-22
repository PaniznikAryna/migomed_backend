package com.migomed.backend.Controller;


import com.migomed.backend.Entity.Users;
import com.migomed.backend.Service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){
        List<Users> usersList = usersService.getAllUsers();
        return ResponseEntity.ok(usersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable Long id){
        Users users = usersService.getUsersById(id);
        if (users == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<Users> createUsers(@RequestBody Users users){
        Users savedUsers = usersService.saveUsers(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable Long id, @RequestBody Users updatedUsersData) {
        Users existingUsers = usersService.getUsersById(id);
        if (existingUsers == null) {
            return ResponseEntity.notFound().build();
        }
        existingUsers.setSurname(updatedUsersData.getSurname());
        existingUsers.setName(updatedUsersData.getName());
        existingUsers.setPatronymic(updatedUsersData.getPatronymic());
        existingUsers.setPassportNumber(updatedUsersData.getPassportNumber());
        existingUsers.setDateOfBirth(updatedUsersData.getDateOfBirth());
        existingUsers.setWorker(updatedUsersData.isWorker());

        Users updatedUsers = usersService.saveUsers(existingUsers);
        return ResponseEntity.ok(updatedUsers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
        usersService.deleteUsers(id);
        return ResponseEntity.noContent().build();
    }
}
