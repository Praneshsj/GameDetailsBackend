package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GamesStats {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String gameName;
private String publisherName;
private String genre;
private String url;
public GamesStats() {
	super();
	// TODO Auto-generated constructor stub
}
public GamesStats(int id, String gameName, String publisherName, String genre, String url) {
	super();
	this.id = id;
	this.gameName = gameName;
	this.publisherName = publisherName;
	this.genre = genre;
	this.url = url;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getGameName() {
	return gameName;
}
public void setGameName(String gameName) {
	this.gameName = gameName;
}
public String getPublisherName() {
	return publisherName;
}
public void setPublisherName(String publisherName) {
	this.publisherName = publisherName;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
}

