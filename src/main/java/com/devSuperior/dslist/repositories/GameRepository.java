package com.devSuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devSuperior.dslist.entities.Game;
import com.devSuperior.dslist.projection.GameMinProjection;

//Interface que tem o papel de fazer buscas no banco de dados
public interface GameRepository extends JpaRepository<Game, Long>{//por se tratar de um componente que faz consultas no banco,
																  //vai precisar do tipo da Entidade (Game) e do tipo do id (Long).

	
	//Em cima do método, uma query escrita com o auxílio de uma Anotation Query
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	//No Spring, o resultado de uma consulta SQL precisa ser uma Lista de componentes do tipo interface.
	List<GameMinProjection> searchByList(Long listId);//Consulta costumizada do Spring Data JPA.
	//Assinatura do método: expressar no nome do método o conceito da Query, para melhor compreensão.
	//Não esquecer de passar por parâmetro o que é preciso para sua busca ser realizada, no caso, o id da lista de Games.
	//O parâmetro passado pelo método deve casar com sua utilização na consulta SQL (linha 21).
}
