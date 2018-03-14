package com.data_rest_example.web;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.data_rest_example.domain.User;
import com.data_rest_example.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/{page}/{recordsNumber}")
//    public ResponseEntity usersProfiles(@PathVariable("page") Integer page,
//                                        @PathVariable("recordsNumber") Integer recordsNumber) {
//        Pageable pageable = new PageRequest(page, recordsNumber);
//        return ResponseEntity.ok(userService.getUsers(pageable));
//    }

    @GetMapping("/current")
    public ResponseEntity currentUserProfile(Principal principal) {
        return ResponseEntity.ok(userRepository.findUserByEmail(principal.getName()));
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity userProfile(@PathVariable String id) {
//        return userService.find(id)
//                .map(v -> new ResponseEntity(v, OK))
//                .orElse(new ResponseEntity(NOT_FOUND));
//    }

//    @PostMapping
//    public void registerNewUser(@Valid UserRegistrationDto userDto) {
//        userService.registerNewUser(userDto);
//    }

//    @PutMapping
//    @ResponseStatus(NO_CONTENT)
//    public void updateUser(User userData, Principal principal) {
//        userRepository.save(userData);
//    }

}

