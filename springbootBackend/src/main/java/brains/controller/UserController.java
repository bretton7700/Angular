package brains.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
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



import brains.model.User;
import brains.repository.UserRepository;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("users")
	public List<User> getUsers(){
		return this.userRepository.findAll();
	}
	
	//create user 
	@PostMapping("users")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) 
	{
		User user =userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid user at id :"+id));
					
			return ResponseEntity.ok().body(user);
		}
	@PutMapping("users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id ,@RequestBody User userDetails){
		User user =userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid user at id :"+id));
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		User updatedUser=userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
		
	}
		
	@DeleteMapping("users/{id}")	
	public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable Long id){
		User user =userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid user at id :"+id));
		userRepository.delete(user);
		Map<String,Boolean>response =new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
		
	}


