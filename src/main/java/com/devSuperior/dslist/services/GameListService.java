package com.devSuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devSuperior.dslist.dto.GameListDTO;
import com.devSuperior.dslist.entities.GameList;
import com.devSuperior.dslist.repositories.GameListRepository;


//Componente responsável por controlar lógicas de negócio
@Service
public class GameListService {

	//injetando uma instância da interface GameListRepository
	//no GameListService (pois o GameListService está uma camada
	//acima do GameListRepository
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll()
	{	
		List<GameList> listGameList = gameListRepository.findAll();
		List<GameListDTO> listGameListDto = listGameList.stream().map(x -> new GameListDTO(x)).toList();
		return listGameListDto;
	}
}
