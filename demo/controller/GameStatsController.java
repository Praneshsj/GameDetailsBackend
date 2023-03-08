package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.GamesStats;
import com.example.demo.repos.Repos;



@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/GM/")
public class GameStatsController {
	
	@Autowired
	Repos repo;

	@GetMapping("/games")
	public List<GamesStats> getList(){
		return repo.findAll();
	}
	
	@PostMapping("/games")
	public GamesStats postList(@RequestBody GamesStats gst){
		return repo.save(gst);
	}
	@GetMapping("/games/{id}")
	public ResponseEntity<GamesStats> getGameById(@PathVariable int id) {
		GamesStats game = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Game does not exist with id :" + id));
		return ResponseEntity.ok(game);
	}
	@DeleteMapping("/games/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteGame(@PathVariable int id){
		GamesStats game = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Game does not exist with id :" + id));
		
		repo.delete(game);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	@PutMapping("/games/{id}")
	public ResponseEntity<GamesStats> updateGame(@PathVariable int id, @RequestBody GamesStats gsm){
		GamesStats game = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Game does not exist with id :" + id));
		
		game.setGameName(gsm.getGameName());
		game.setPublisherName(gsm.getPublisherName());
		game.setGenre(gsm.getGenre());
		game.setUrl(gsm.getUrl());
		GamesStats updatedGame = repo.save(game);
		return ResponseEntity.ok(updatedGame);
	}
}

