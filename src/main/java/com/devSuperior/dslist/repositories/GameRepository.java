package com.devSuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devSuperior.dslist.entities.Game;

//Interface que tem o papel de fazer buscas no banco de dados
public interface GameRepository extends JpaRepository<Game, Long>{//por se tratar de um componente que só faz consultas no banco,
																  //vai precisar do tipo da Entidade (Game) e do tipo do id (Long).

	
}
