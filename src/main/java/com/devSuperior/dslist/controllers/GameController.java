package com.devSuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devSuperior.dslist.dto.GameMinDTO;
import com.devSuperior.dslist.services.GameService;

//É o controlador que disponibiliza a API (maçaneta da porta).

@RestController //lembrar que se trata de uma API Rest (Rest: padronização de APIs)
@RequestMapping(value = "/games") //definindo recurso Games
public class GameController {

	//injetando uma instância da interface GameService
	//no GameController (pois o GameController está uma camada
	//acima do GameService
	@Autowired
	private GameService gameService;
	
	//mapeando verbo http para a busca dos recursos (GET)
	@GetMapping
	public List<GameMinDTO> findAll()
	{
		List<GameMinDTO> listaGames = gameService.findAll();
		
		return listaGames;
	}
}
