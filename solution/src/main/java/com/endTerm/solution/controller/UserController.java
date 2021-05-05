package com.endTerm.solution.controller;

import com.endTerm.solution.model.UserDTO;
import com.endTerm.solution.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/saveUser")
    public UserDTO createUser(@Valid @RequestBody UserDTO user) {
        return userRepository.save(user);
    }

    @GetMapping("/search")
    public List<UserDTO> searchUsersByPattern(@RequestParam("keyword") String keyword) {
        return userRepository.findByNameIgnoreCaseContaining(keyword);
    }

    @GetMapping("/AllUsers")
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/editUser/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable(value = "id") Integer userId,
                                              @Valid @RequestBody UserDTO userDetails) throws Exception {
        UserDTO user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("Employee not found for this id :: " + userId));

        user.setName(userDetails.getName());
        user.setAddress(userDetails.getAddress());
        user.setAge(userDetails.getAge());
        user.setEmailId(userDetails.getEmailId());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public List<UserDTO> deleteUser(@PathVariable(value = "id") Integer userId) {
         userRepository.deleteById(userId);
         return userRepository.findAll();
    }

}
