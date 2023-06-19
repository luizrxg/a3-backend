package com.luiz.a3.controller;

import com.luiz.a3.model.dto.MesaDto;
import com.luiz.a3.model.entity.Mesa;
import com.luiz.a3.repository.GarcomRepository;
import com.luiz.a3.repository.MesaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.luiz.a3.model.enums.SituacaoMesa.LIVRE;
import static com.luiz.a3.model.enums.SituacaoMesa.OCUPADA;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    private final MesaRepository mesaRepository;
    private final GarcomRepository garcomRepository;

    public MesaController(
            MesaRepository mesaRepository,
            GarcomRepository garcomRepository
    ) {
        this.mesaRepository = mesaRepository;
        this.garcomRepository = garcomRepository;
    }

    @GetMapping("/")
    public List<MesaDto> findAll() {
        var mesas = mesaRepository.findAll();
        return mesas
            .stream()
            .map(MesaDto::converter)
            .collect(Collectors.toList());
    }

    @GetMapping("/{numero}")
    public MesaDto findByNumero(
            @PathVariable("numero") Long numero
    ) {
        var mesa = mesaRepository.findByNumero(numero);
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

    @GetMapping("/livres")
    public List<MesaDto> findMesasLivres() {
        return findMesasBySituacao(LIVRE.getValor());
    }

    @GetMapping("/ocupadas")
    public List<MesaDto> findMesasOcupadas() {
        return findMesasBySituacao(OCUPADA.getValor());
    }

    @GetMapping("/{cap}")
    public List<MesaDto> findMesasPorCapacidadeMaxima(@PathVariable("cap") Long cap) {
        return mesaRepository
            .findAll()
            .stream()
            .filter(it -> it.getCapacidadeMaxima() >= cap)
            .map(MesaDto::converter)
            .collect(Collectors.toList());
    }

    @GetMapping("/ocupadas-garcom/{id}")
    public List<MesaDto> findMesasOcupadasGarcom(@PathVariable("id") Long id) {
        return mesaRepository
            .findAllByIdGarcom(id)
            .stream()
            .filter(it -> it.getSituacao() == OCUPADA.getValor())
            .map(MesaDto::converter)
            .collect(Collectors.toList());
    }

    @GetMapping("/{idGarcom}")
    public List<MesaDto> findMesasByGarcom(@PathVariable("id") Long id) {
        return mesaRepository
            .findAllByIdGarcom(id)
            .stream()
            .map(MesaDto::converter)
            .collect(Collectors.toList());
    }

    public List<MesaDto> findMesasBySituacao(String situacao) {
        return mesaRepository
            .findBySituacao(situacao)
            .stream()
            .map(MesaDto::converter)
            .collect(Collectors.toList());
    }
}