package com.luiz.a3.controller;

import com.luiz.a3.model.dto.MesaDto;
import com.luiz.a3.model.dto.MesaLivreDto;
import com.luiz.a3.model.entity.Mesa;
import com.luiz.a3.repository.GarcomRepository;
import com.luiz.a3.repository.MesaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.luiz.a3.model.enums.SituacaoMesa.LIVRE;

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
    public List<MesaLivreDto> findMesasLivres() {
        var mesas = mesaRepository.findBySituacao(LIVRE.getValor());
        return mesas
            .stream()
            .map(it -> {
                var garcom = garcomRepository.findById(it.getIdGarcom());
                return MesaLivreDto.converter(it, garcom.isPresent() ? garcom.get().getNome() : "");
            }).collect(Collectors.toList());
    }


}