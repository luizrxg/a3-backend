package com.luiz.a3.controller;

import com.luiz.a3.model.dto.MesaDto;
import com.luiz.a3.model.entity.Mesa;
import com.luiz.a3.service.GarcomService;
import com.luiz.a3.service.MesaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.luiz.a3.model.enums.SituacaoMesa.LIVRE;
import static com.luiz.a3.model.enums.SituacaoMesa.OCUPADA;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    private final MesaService mesaService;
    private final GarcomService garcomService;

    public MesaController(
            final MesaService mesaService,
            final GarcomService garcomService
    ) {
        this.mesaService = mesaService;
        this.garcomService = garcomService;
    }


    //GET
    @GetMapping("/")
    public List<MesaDto> findAll() {
        return mesaService.findAll();
    }

    @GetMapping("/{numero}")
    public MesaDto findByNumero(@PathVariable("numero") Long numero) {
        return mesaService.findByNumero(numero);
    }

    @GetMapping("/livres")
    public List<MesaDto> findMesasLivres() {
        return mesaService.findBySituacao(LIVRE.getValor());
    }

    @GetMapping("/ocupadas")
    public List<MesaDto> findMesasOcupadas() {
        return mesaService.findBySituacao(OCUPADA.getValor());
    }

    @GetMapping("/{cap}")
    public List<MesaDto> findMesasPorCapacidadeMaxima(@PathVariable("cap") Long cap) {
        return mesaService.findMesasPorCapacidadeMaxima(cap);

    }

    @GetMapping("/ocupadas-garcom/{id}")
    public List<MesaDto> findMesasOcupadasGarcom(@PathVariable("id") Long id) {
        return mesaService.findMesasOcupadasGarcom(id);
    }

    @GetMapping("/{idGarcom}")
    public List<MesaDto> findMesasByGarcom(@PathVariable("idGarcom") Long id) {
        return mesaService.findMesasByGarcom(id);
    }


    //POST
    @PostMapping("/")
    public void cadastrarMesa(@RequestBody MesaDto mesa) {
        mesaService.cadastrarMesa(mesa);
    }

    @PostMapping("/{id}&{situacao}")
    public void alterarSituacaoMesa(
            @PathVariable("id") Long id,
            @PathVariable("situacao") String situacao
    ) {
        mesaService.alterarSituacaoMesa(id, situacao);
    }

    @PostMapping("/{id}&{situacao}")
    public void alterarGarcomMesa(
            @PathVariable("id") Long id,
            @PathVariable("idGarcom") Long idGarcom
    ) {
        mesaService.alterarGarcomMesa(id, idGarcom);
    }


    //DELETE
    @DeleteMapping("/{id}")
    public void deleteMesa(@PathVariable("id") Long id) {
        mesaService.deleteById(id);
    }
}