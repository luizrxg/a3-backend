package com.luiz.a3.controller;

import com.luiz.a3.model.dto.MesaDto;
import com.luiz.a3.model.entity.Mesa;
import com.luiz.a3.repository.MesaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    private final MesaRepository mesaRepository;

    public MesaController(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    @GetMapping("/")
    public List<MesaDto> findAll() {
        var garcons = mesaRepository.findAll();
        return garcons
                .stream()
                .map(MesaDto::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MesaDto findById(
            @PathVariable("id") Long id
    ) {
        var mesa = mesaRepository.getOne(id);
        return MesaDto.converter(mesa);
    }

    @PostMapping("/")
    public void saveMesa(
            @RequestBody MesaDto mesa
    ) {
        var m = new Mesa();
        m.setId(mesa.getId());
        m.setNumero(mesa.getNumero());
        m.setSituacao(mesa.getSituacao());
        m.setCapacidadeMaxima(mesa.getCapacidadeMaxima());
        m.setIdGarcom(mesa.getIdGarcom());
        mesaRepository.save(m);
    }
}