package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname,
            @RequestParam(name = "nId", required = false) Integer nId) {
        List<User> users = userService.getAll(name, surname, nId);
        List<UserDTO> userDTOS = userDTOS = users.stream().map(UserDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok(ResponseDTO.of(userDTOS));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUserById(@PathVariable int id) {
        User user = userService.getById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok(ResponseDTO.of(userDTO));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userService.addUser(user);
        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user), "Successfully added"));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable int id) {
        User user = userService.getById(id);
        userService.removeUser(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok(ResponseDTO.of(userDTO, "Successfully deleted"));
    }


}
