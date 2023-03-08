package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.GamesStats;

public interface Repos extends JpaRepository<GamesStats, Integer>{

}
