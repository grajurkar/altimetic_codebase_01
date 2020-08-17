package com.gaurav.restwebservice.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gaurav.restwebservice.exception.UserNotFoundException;

@RestController

public class UserDataResource {

	@Autowired
	UserDataCrudOprearionRepository userDaoService;

	@GetMapping("/users")
	public List<UserData> getAllUser() {

		return userDaoService.findAll();
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserData user) {
		UserData newUsr = userDaoService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUsr.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users/{id}")
	public Optional<UserData> getOneUser(@PathVariable(name = "id") int id) {

		Optional<UserData> reqUser = userDaoService.findById(id);
		if (reqUser == null)
			throw new UserNotFoundException("User not found for id" + id);
		return reqUser;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable(name = "id") int id) {

		userDaoService.deleteById(id);

	}

}
