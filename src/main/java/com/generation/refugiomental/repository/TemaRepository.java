package com.generation.refugiomental.repository;

import com.generation.refugiomental.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
    List<Tema> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
