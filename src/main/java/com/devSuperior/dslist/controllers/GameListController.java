package com.devSuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devSuperior.dslist.dto.GameListDTO;
import com.devSuperior.dslist.dto.GameMinDTO;
import com.devSuperior.dslist.services.GameListService;
import com.devSuperior.dslist.services.GameService;

//É o controlador que disponibiliza a API (maçaneta da porta).

@RestController //lembrar que se trata de uma API Rest (Rest: padronização de APIs)
@RequestMapping(value = "/lists") //definindo recurso Lists
public class GameListController {

	//injetando uma instância da classe GameListService
	//no GameListController (pois o GameListController está uma camada
	//acima do GameListService)
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;

	//mapeando verbo http para a busca dos recursos (GET)
	@GetMapping
	public List<GameListDTO> findAll()
	{
		List<GameListDTO> listGameListDto = gameListService.findAll();
		return listGameListDto;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId)
	{
		List<GameMinDTO> listGameMinDto = gameService.findByList(listId);
		return listGameMinDto;
	}
}
