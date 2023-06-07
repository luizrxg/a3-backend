package com.luiz.a3.repository;

import com.luiz.a3.model.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    Mesa findByNumero(Long numero);

    List<Mesa> findBySituacao(String situacao);
}
