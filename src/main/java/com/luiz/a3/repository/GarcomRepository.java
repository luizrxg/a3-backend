package com.luiz.a3.repository;

import com.luiz.a3.model.entity.Garcom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GarcomRepository extends JpaRepository<Garcom, Long> {
//    List<Garcom> findByNome(String name);
}