package com.generation.refugiomental.repository;

import com.generation.refugiomental.model.Postagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagens, Long> {
    List<Postagens> findAllByAtendimentoContainingIgnoreCase(@Param("atendimento") String atendimento);
}
