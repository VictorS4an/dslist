package com.devSuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devSuperior.dslist.dto.GameDTO;
import com.devSuperior.dslist.dto.GameMinDTO;
import com.devSuperior.dslist.entities.Game;
import com.devSuperior.dslist.projection.GameMinProjection;
import com.devSuperior.dslist.repositories.GameRepository;


//Componente responsável por controlar lógicas de negócio
@Service
public class GameService {

	//injetando uma instância da interface GameRepository
	//no GameService (pois o GameService está uma camada
	//acima do GameRepository
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)//notação que garante que haja consistência na transação de dados
	public GameDTO findById(Long id)
	{
		//Por conta: fazer tratamento para caso o id for Nulo ou não existir no banco.
		Game gameBuscado = gameRepository.findById(id).get();
		GameDTO gameDto = new GameDTO(gameBuscado);
		return gameDto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll()
	{	
		List<Game> listGames = gameRepository.findAll();
		List<GameMinDTO> listGameMinDto = listGames.stream().map(x -> new GameMinDTO(x)).toList();
		return listGameMinDto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId)
	//apesar de ser um método feito no GameService, não será o GameController que o utilizará,
	//será o GameListController (Polêmico rsrs).
	{	
		List<GameMinProjection> listGames = gameRepository.searchByList(listId);
		List<GameMinDTO> listGameDto = listGames.stream().map(x -> new GameMinDTO(x)).toList();
		return listGameDto;
	}
}
