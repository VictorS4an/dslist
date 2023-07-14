package com.devSuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devSuperior.dslist.dto.GameDTO;
import com.devSuperior.dslist.dto.GameMinDTO;
import com.devSuperior.dslist.services.GameService;

//É o controlador que disponibiliza a API (maçaneta da porta).

@RestController //lembrar que se trata de uma API Rest (Rest: padronização de APIs)
@RequestMapping(value = "/games") //definindo recurso Games
public class GameController {

	//injetando uma instância da classe GameService
	//no GameController (pois o GameController está uma camada
	//acima do GameService)
	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/{id}")//mapeando verbo http especificando para retornar por id (GET)
	public GameDTO findById(@PathVariable Long id)
	{
		GameDTO gameDTO = gameService.findById(id);
		return gameDTO;
	}
	
	//mapeando verbo http para a busca dos recursos (GET)
	@GetMapping
	public List<GameMinDTO> findAll()
	{
		List<GameMinDTO> listGameDto = gameService.findAll();
		return listGameDto;
	}
}
