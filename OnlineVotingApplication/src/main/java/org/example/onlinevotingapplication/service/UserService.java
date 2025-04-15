package org.example.onlinevotingapplication.service;

import org.example.onlinevotingapplication.model.User;
import org.example.onlinevotingapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public Optional<User> login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.filter(u -> u.getPassword().equals(password));
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    public List<User> getAllCandidates() {
        return userRepository.findAll().stream()
                .filter(user -> "candidate".equalsIgnoreCase(user.getRole()))
                .toList();
    }

}
