package com.migomed.backend.Service;

import com.migomed.backend.Entity.Users;
import com.migomed.backend.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public Users getUsersById(Long id){
        return usersRepository.findById(id).orElse(null);
    }

    public Users saveUsers(Users users){
        return usersRepository.save(users);
    }

    public void deleteUsers(Long id){
        usersRepository.deleteById(id);
    }
}
