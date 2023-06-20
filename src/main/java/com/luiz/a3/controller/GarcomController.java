package com.luiz.a3.controller;

import com.luiz.a3.model.dto.GarcomDto;
import com.luiz.a3.model.dto.GarcomQtdMesasDto;
import com.luiz.a3.model.entity.Garcom;
import com.luiz.a3.model.entity.Mesa;
import com.luiz.a3.service.GarcomService;
import com.luiz.a3.service.MesaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/garcom")
public class GarcomController {

    private final MesaService mesaService;
    private final GarcomService garcomService;

    public GarcomController(
            final MesaService mesaService,
            final GarcomService garcomService
    ) {
        this.mesaService = mesaService;
        this.garcomService = garcomService;
    }

    //GET
    @GetMapping("/")
    public List<GarcomDto> findAll() {
        return garcomService
            .findAll()
            .stream()
            .map(GarcomDto::converter)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GarcomDto findById(@PathVariable("id") Long id) {
        return GarcomDto.converter(garcomService.getOne(id));
    }


    @GetMapping("/{email}")
    public GarcomDto findByEmail(@PathVariable("email") String email) {
        return GarcomDto.converter(garcomService.findByEmail(email));
    }

    @GetMapping("/mesas-por-garcom")
    public List<GarcomQtdMesasDto> getQuantidadeMesas() {
        return findAll()
            .stream()
            .map(garcom -> {
                var mesas = mesaService.findAllByIdGarcom(garcom.getId());
                return GarcomQtdMesasDto.converter(garcom, mesas.size());
            })
            .collect(Collectors.toList());
    }

    //POST
    @PostMapping("/")
    public void cadastrarGarcom(
            @RequestBody GarcomDto garcom
    ) {
        var g = new Garcom();
        g.setId(garcom.getId());
        g.setNome(garcom.getNome());
        g.setCpf(garcom.getCpf());
        g.setDataNascimento(garcom.getDataNascimento());
        g.setEmail(garcom.getEmail());
        g.setTelefone(garcom.getTelefone());
        g.setSexo(garcom.getSexo());
        g.setSalario(garcom.getSalario());
        garcomService.save(g);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteGarcom(@PathVariable("id") Long id) {
        garcomService.deleteGarcom(id);
    }
}