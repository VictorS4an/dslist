package com.devSuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devSuperior.dslist.dto.GameListDTO;
import com.devSuperior.dslist.entities.GameList;
import com.devSuperior.dslist.projection.GameMinProjection;
import com.devSuperior.dslist.repositories.GameListRepository;
import com.devSuperior.dslist.repositories.GameRepository;


//Componente responsável por controlar lógicas de negócio
@Service
public class GameListService {

	//injetando uma instância da interface GameListRepository
	//no GameListService (pois o GameListService está uma camada
	//acima do GameListRepository
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll()
	{	
		List<GameList> listGameList = gameListRepository.findAll();
		List<GameListDTO> listGameListDto = listGameList.stream().map(x -> new GameListDTO(x)).toList();
		return listGameListDto;
	}
	
	//Método que troca o game de posição dentro da Lista que o contém (No Banco)	
	@Transactional
	public void moveInList(Long listId, int sourceIndex, int destinationIndex)
	{
		List<GameMinProjection> listGames = gameRepository.searchByList(listId);
		
		GameMinProjection game = listGames.remove(sourceIndex);
		listGames.add(destinationIndex, game);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i <= max; i++)
		{
			gameListRepository.updateBelongingPosition(listId, listGames.get(i).getId(), i);
		}

	}
}
