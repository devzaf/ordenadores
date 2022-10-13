package com.example.ordenadores.repository;

import com.example.ordenadores.entity.Ordenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenadorRepository extends JpaRepository<Ordenador, Long> {
}
