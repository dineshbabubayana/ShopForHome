package com.shopping.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.User;
import com.shopping.service.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {
	private final UserService userService;

	public UserResource(UserService userService) {
		super();
		this.userService = userService;
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=userService.findAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	
	@CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newuser = userService.addUser(user);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }
	
	@CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
	
	@CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

	
}
