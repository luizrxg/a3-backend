package com.luiz.a3.repository;

import com.luiz.a3.model.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
//    List<Mesa> findByNome(String name);
}
