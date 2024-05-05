package eus.birt.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	
}