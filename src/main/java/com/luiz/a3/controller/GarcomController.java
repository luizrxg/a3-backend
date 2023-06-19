package com.luiz.a3.controller;

import com.luiz.a3.model.dto.GarcomDto;
import com.luiz.a3.model.dto.GarcomQtdMesasDto;
import com.luiz.a3.model.entity.Garcom;
import com.luiz.a3.repository.GarcomRepository;
import com.luiz.a3.repository.MesaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/garcom")
public class GarcomController {

    private final MesaRepository mesaRepository;
    private final GarcomRepository garcomRepository;

    public GarcomController(
            MesaRepository mesaRepository,
            GarcomRepository garcomRepository
    ) {
        this.mesaRepository = mesaRepository;
        this.garcomRepository = garcomRepository;
    }

    @GetMapping("/")
    public List<GarcomDto> findAll() {
        var garcons = garcomRepository.findAll();
        return garcons
            .stream()
            .map(GarcomDto::converter)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GarcomDto findById(
            @PathVariable("id") Long id
    ) {
        return GarcomDto.converter(garcomRepository.getOne(id));
    }

    @PostMapping("/")
    public void saveGarcom(
            @RequestBody GarcomDto garcom
    ) {
        var p = new Garcom();
        p.setId(garcom.getId());
        p.setNome(garcom.getNome());
        p.setCpf(garcom.getCpf());
        p.setDataNascimento(garcom.getDataNascimento());
        p.setEmail(garcom.getEmail());
        p.setTelefone(garcom.getTelefone());
        p.setSexo(garcom.getSexo());
        p.setSalario(garcom.getSalario());
        garcomRepository.save(p);
    }

    @GetMapping("/{email}")
    public GarcomDto findByEmail(
            @PathVariable("email") String email
    ) {
        return GarcomDto.converter(garcomRepository.findByEmail(email));
    }

    @GetMapping("/mesas-por-garcom")
    public List<GarcomQtdMesasDto> getQuantidadeMesas() {
        return findAll()
            .stream()
            .map(it -> {
                var mesas = mesaRepository.findAllByIdGarcom(it.getId());
                return GarcomQtdMesasDto.converter(it, mesas.size());
            })
            .collect(Collectors.toList());
    }
}