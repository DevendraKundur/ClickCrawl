package org.example.onlinevotingapplication.service;

import org.example.onlinevotingapplication.model.Admin;
import org.example.onlinevotingapplication.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> login(String username, String password) {
        Optional<Admin> admin = adminRepository.findByUsername(username);
        return admin.filter(a -> a.getPassword().equals(password));
    }
}
