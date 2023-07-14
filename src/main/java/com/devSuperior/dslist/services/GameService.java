package com.devSuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devSuperior.dslist.dto.GameMinDTO;
import com.devSuperior.dslist.entities.Game;
import com.devSuperior.dslist.repositories.GameRepository;

//Componente responsável por controlar lógicas de negócio
@Service
public class GameService {

	//injetando uma instância da interface GameRepository
	//no GameService (pois o GameService está uma camada
	//acima do GameRepository
	@Autowired
	private GameRepository gameRepository;
					
	public List<GameMinDTO> findAll(){
		
		List<Game> listaGames = gameRepository.findAll();
		List<GameMinDTO> dto = listaGames.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
