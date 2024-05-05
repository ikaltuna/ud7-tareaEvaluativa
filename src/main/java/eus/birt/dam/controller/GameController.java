package eus.birt.dam.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Game;
import eus.birt.dam.repository.GameRepository;
import eus.birt.dam.repository.ConsoleRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/game")
public class GameController {

	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	ConsoleRepository consoleRepository;
		
	@GetMapping({"/",""})
	public List <Game> index() {
		return gameRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Game show(@PathVariable("id") Long id) {
		return gameRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"","/"})
	@ResponseStatus (HttpStatus.CREATED)
	public Game create(@RequestBody Game game) {
		return gameRepository.save(game);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Game update(@RequestBody Game game, @PathVariable("id") Long id) {
		Game tempGame = gameRepository.findById(id).orElse(null);
		
		tempGame.setName(game.getName());
		tempGame.setReleaseDate(game.getReleaseDate());
		tempGame.setDeveloper(game.getDeveloper());
		tempGame.setConsole(game.getConsole());
		
		return gameRepository.save(tempGame);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		gameRepository.deleteById(id);
	}
	
}