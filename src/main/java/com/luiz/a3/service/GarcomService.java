package com.luiz.a3.service;

import com.luiz.a3.model.entity.Garcom;
import com.luiz.a3.repository.GarcomRepository;
import com.luiz.a3.repository.MesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarcomService {

    private final GarcomRepository garcomRepository;
    private final MesaRepository mesaRepository;
    private final MesaService mesaService;

    public GarcomService(
            final GarcomRepository garcomRepository,
            final MesaRepository mesaRepository,
            final MesaService mesaService
    ) {
        this.garcomRepository = garcomRepository;
        this.mesaRepository = mesaRepository;
        this.mesaService = mesaService;
    }
    
    public Garcom getOne(Long id) {
        return garcomRepository.getOne(id);    
    }
    
    public List<Garcom> findAll() {
        return garcomRepository.findAll();
    }

    public Garcom findByEmail(String email) {
        return garcomRepository.findByEmail(email);
    }
    
    public void save(Garcom garcom) {
        garcomRepository.save(garcom);
    }

    public void deleteById(Long id) {
        garcomRepository.deleteById(id);
    }

    public void deleteGarcom(Long id) {
        deleteById(id);
        mesaService.removeMesasGarcom(id);
    }
}
