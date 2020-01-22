package com.mohanty.Modelapp.resources;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohanty.Modelapp.entity.UserRest;
import com.mohanty.Modelapp.exception.UserNotFoundException;
import com.mohanty.Modelapp.exception.UserServiceException;
import com.mohanty.Modelapp.repository.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public ResponseEntity<List<UserRest>> getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "20") int limit) {

		/*
		 * //Trouble code
		 * 
		 * String testStr = null; int length = testStr.length();
		 * 
		 * if(true) throw new UserServiceException("Custom Exception class thrown");
		 */
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable int userId) {

		if (repository.findById(userId).isPresent())
			return new ResponseEntity<>(repository.findById(userId).get(), HttpStatus.OK);

		else
			return new ResponseEntity<>(
					repository.findById(userId)
							.orElseGet(() -> new UserRest("Error Resposne", "XXX", "xxx@abc.com", "123@321")),
					HttpStatus.BAD_REQUEST);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> createuser(@Valid @RequestBody UserRest userDetails) {

		UserRest modelSaved = repository.save(userDetails);

		return new ResponseEntity<>(modelSaved, HttpStatus.CREATED);
	}

	/*
	 * @PutMapping (path="/{userId}" ,consumes = { MediaType.APPLICATION_JSON_VALUE,
	 * MediaType.APPLICATION_XML_VALUE }, produces = {
	 * MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }) public
	 * ResponseEntity<UserRest> updateUser(@PathVariable int userId
	 * ,@Valid @RequestBody UserRest userDetails) {
	 * 
	 * return new ResponseEntity<>( repository.findById(userId).map( new
	 * Function<UserRest, UserRest>() {
	 * 
	 * @Override public UserRest apply(UserRest user) {
	 * user.setFirstName(userDetails.getFirstName());
	 * user.setLastName(userDetails.getLastName());
	 * user.setUserEmail(userDetails.getUserEmail());
	 * user.setPassword(userDetails.getPassword()); return repository.save(user);
	 * 
	 * } } ).orElseGet(() -> repository.save(userDetails) ) , HttpStatus.OK) ;
	 * 
	 * }
	 */

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> updateUser(@PathVariable int userId, @Valid @RequestBody UserRest userDetails) {

		UserRest userToUpdate = repository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User does not exist, Please use POST mapping to create a new user"));

		userToUpdate.setFirstName(userDetails.getFirstName());
		userToUpdate.setLastName(userDetails.getLastName());
		userToUpdate.setUserEmail(userDetails.getUserEmail());
		userToUpdate.setPassword(userDetails.getPassword());

		return new ResponseEntity<>(repository.save(userToUpdate), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId) {
		repository.deleteById(userId);
		return new ResponseEntity<>("Record deleted", HttpStatus.OK);
	}
}
