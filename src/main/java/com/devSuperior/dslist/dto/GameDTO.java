package com.devSuperior.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.devSuperior.dslist.entities.Game;

//Por que fazer um GameDTO se ele vai ter todos os mesmos atributos de Game?
// 1- Padronização das aplicações em Camadas que utilizam-se do Spring-Boot;
// 2- Evitar retorno cíclico.
public class GameDTO {

	private Long id;
	private String title;	
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	private String shortDescription;
	private String longDescription;
	
	public GameDTO()
	{
		
	}
	
	public GameDTO(Game entity) {
		//classe utilitaria do Spring que copia todos os dados, sem necessidade de escrever get por get
		BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
}
