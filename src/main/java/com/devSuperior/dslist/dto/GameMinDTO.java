package com.devSuperior.dslist.dto;

import com.devSuperior.dslist.entities.Game;
import com.devSuperior.dslist.projection.GameMinProjection;

//Esta Classe refere-se ao que será visto no catálogo de jogos, isso é feito
//para economizar tráfego de dados desnecessrários, como, por exemplo, descrição
//longa do game.
public class GameMinDTO {// Uma classe DTO não necessita de um mapeamento para o banco

	//Apenas atributos necessários:
	
	private Long id;
	private String title;	
	private Integer year;//'year' é uma palavra reservada do SQL, se deixarmos, pode causar problemas
	private String imgUrl;
	private String shortDescription;
	
	public GameMinDTO()
	{
		
	}

	public GameMinDTO(Game entity) {//construtor recebe um objeto Game
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.year = entity.getYear();
		this.imgUrl = entity.getImgUrl();
		this.shortDescription = entity.getShortDescription();
	}
	
	public GameMinDTO(GameMinProjection projection) {
		super();
		this.id = projection.getId();
		this.title = projection.getTitle();
		this.year = projection.getYear();
		this.imgUrl = projection.getImgUrl();
		this.shortDescription = projection.getShortDescription();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
}
