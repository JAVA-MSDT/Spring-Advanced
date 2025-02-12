package com.javamsdt.security.controller;

import com.javamsdt.security.repository.RoleRepository;
import com.javamsdt.security.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${app.api.version}/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleRepository roleRepository;

    @GetMapping
    public ResponseEntity<?> getRoles() {
        System.out.println("Get Role: getRoles");
        return new ResponseEntity<>(roleRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveRole(@RequestBody Role role) {
        System.out.println("Save Role: " + role.getName());
        return new ResponseEntity<>(roleRepository.save(role), HttpStatus.OK);
    }
}
