package com.devSuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devSuperior.dslist.entities.GameList;

//Interface que tem o papel de fazer buscas no banco de dados
public interface GameListRepository extends JpaRepository<GameList, Long>{//por se tratar de um componente que faz consultas no banco,
																  //vai precisar do tipo da Entidade (Game) e do tipo do id (Long).
	
	@Modifying
	@Query(nativeQuery = true, 
	value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);		
}
