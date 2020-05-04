package com.example.fianchettochesstournamentmanagerserverjava.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fianchettochesstournamentmanagerserverjava.models.Match;
import com.example.fianchettochesstournamentmanagerserverjava.services.MatchService;

/**
 * The commented APIs can be used for implementing session.
 * @author fenilshah
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class MatchController {
	
	@Autowired
	MatchService matchService;



	//TO be updated
	@GetMapping("/api/matches")
	public List<Match> findAllMatches() {
		return matchService.findAllMatches();
	}
	
	@PostMapping("/api/matches")
	public Match createMatch(@RequestBody Match m) {
		return matchService.createMatch(m);
	}
	
	@PostMapping("/api/round/{roundId}/matches")
	public int createMatch(@RequestBody List<Match> m, @PathVariable ("roundId") Integer roundId) {
		return matchService.createMatch(m, roundId);
	}
	
	@GetMapping("/api/match/{matchId}")
	public Match findMatchById(@PathVariable ("matchId") Integer roundId) {
		return matchService.findMatchById(roundId);
	}
	
	@DeleteMapping("/api/match/{matchId}")
	public void deleteMatch(@PathVariable ("matchId") Integer roundId) {
		matchService.deleteMatch(roundId);
	}
	
	@GetMapping("/api/round/{roundId}/matches")
	public List<Match> findMatchesForRound(@PathVariable ("roundId") Integer roundId) {
		return matchService.findMatchesForRound(roundId);
	}
	
	@GetMapping("/api/user/{userId}/matches")
	public List<Match> findMatchesForUser(@PathVariable ("userId") Integer userId) {
		return matchService.findMatchesForUser(userId);
	}
	
//	@GetMapping("/api/matches")
//	public List<Match> findMatchesForUser(HttpSession session) {
//		if (session.getAttribute("user") != null) {
//			int id = ((User) session.getAttribute("user")).getId();
//			return matchService.findMatchesForUser(id);
//		}
//		return new ArrayList<>();
//	}
	
	@GetMapping("/api/tournament/{tournamentId}/matches")
	public String findAllMatchesForTournament(@PathVariable ("tournamentId") Integer tournamentId) {
		String result = "[";
		result += matchService.findAllMatchesForTournament(tournamentId);
		return result + "]";
	}
	
	@GetMapping("/api/user/{userId}/tournament/{tournamentId}/matches") 
	public List<Match> findUserMatchesForTournament(@PathVariable ("userId") Integer userId,
			@PathVariable("tournamentId") Integer tournamentId) {
		return matchService.findUserMatchesForTournament(userId, tournamentId);
	}
	
//	@GetMapping("/api/user/tournament/{tournamentId}/matches")
//	public List<Match> findUserMatchesForTournament(HttpSession session, @PathVariable ("tournamentId") Integer tournamentId) {
//		if (session.getAttribute("user") != null) {
//			int id = ((User) session.getAttribute("user")).getId();
//			return matchService.findUserMatchesForTournament(id, tournamentId);
//		}
//		return new ArrayList<>();
//	}
	
	@PutMapping("/api/match/{matchId}")
	public int updateMatchResult(@PathVariable ("matchId") Integer matchId, @RequestBody Match match) {
		return matchService.updateMatchResult(matchId, match);
	}
	
	@PutMapping("/api/matches")
	public int updateMatchResults(@RequestBody List<Match> matches) {
		return matchService.updateMatchResults(matches);
	}
}
