package com.example.fianchettochesstournamentmanagerserverjava.controllers;

import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;
import com.example.fianchettochesstournamentmanagerserverjava.models.User;
import com.example.fianchettochesstournamentmanagerserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * The commented APIs can be used for implementing session.
 * @author fenilshah
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class NUserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/newapi/user")
	public User findUserById(@PathVariable ("userId") Integer userId) {
		return userService.findUserById(userId);
	}
	
	@GetMapping("/newapi/user/{userId}")
	public List<Tournament> findTournamentsForUser (@PathVariable ("userId") Integer userId) {
		return userService.findTournamentsForUser(userId);
	}

	@PostMapping("/newapi/user")
	public User login(HttpSession session, @RequestBody User u) {
		User user = userService.login(u);
		return user;
	}

	@PutMapping("/newapi/user/{userId}")
	public User updateInfo(@PathVariable("userId") Integer id ,@RequestBody User u) {
		return userService.updateInfo(id, u);
	}


	@DeleteMapping("/newapi/user/{userId}")
	public int deregisterFromTournamement(@PathVariable ("userId") Integer userId, @PathVariable ("tournamentId") Integer tournamentId) {
		return userService.deregisterFromTournamement(userId, tournamentId);
	}
	


}
