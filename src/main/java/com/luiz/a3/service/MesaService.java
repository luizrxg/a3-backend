package com.luiz.a3.service;

import com.luiz.a3.controller.MesaController;
import com.luiz.a3.model.dto.MesaDto;
import com.luiz.a3.model.entity.Mesa;
import com.luiz.a3.repository.MesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.luiz.a3.model.enums.SituacaoMesa.OCUPADA;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;
    private final GarcomService garcomService;

    public MesaService(
            final MesaRepository mesaRepository,
            final GarcomService garcomService
    ) {
        this.mesaRepository = mesaRepository;
        this.garcomService = garcomService;
    }

    public MesaDto findByNumero(Long numero) {
        return MesaDto.converter(mesaRepository.findByNumero(numero));
    }

    public List<MesaDto> findBySituacao(String situacao) {
        return mesaRepository
                .findBySituacao(situacao)
                .stream()
                .map(MesaDto::converter)
                .collect(Collectors.toList());
    }

    public List<MesaDto> findAllByIdGarcom(Long idGarcom) {
        return mesaRepository
                .findAllByIdGarcom(idGarcom)
                .stream()
                .map(MesaDto::converter)
                .collect(Collectors.toList());
    }

    public MesaDto getOne(Long id) {
        return MesaDto.converter(mesaRepository.getOne(id));
    }

    public List<MesaDto> findAll() {
        return mesaRepository
                .findAll()
                .stream()
                .map(MesaDto::converter)
                .collect(Collectors.toList());
    }

    public void save(Mesa mesa) {
        mesaRepository.save(mesa);
    }

    public void deleteById(Long id) {
        mesaRepository.deleteById(id);
    }

    public void alterarGarcomMesa(Long id, Long idGarcom) {
        var m = mesaRepository.getOne(id);
        var g = garcomService.getOne(idGarcom);
        m.setIdGarcom(idGarcom);
        m.setNomeGarcom(g.getNome());
        save(m);
    }

    public void cadastrarMesa(MesaDto mesa) {
        var m = new Mesa();
        m.setId(mesa.getId());
        m.setNumero(mesa.getNumero());
        m.setSituacao(mesa.getSituacao());
        m.setCapacidadeMaxima(mesa.getCapacidadeMaxima());
        m.setIdGarcom(mesa.getIdGarcom());
        save(m);
    }

    public void alterarSituacaoMesa(Long id, String situacao) {
        var m = mesaRepository.getOne(id);
        m.setSituacao(situacao);
        save(m);
    }

    public List<MesaDto> findMesasOcupadasGarcom(Long id) {
        return findAllByIdGarcom(id)
                .stream()
                .filter(it -> it.getSituacao() == OCUPADA.getValor())
                .collect(Collectors.toList());
    }

    public List<MesaDto> findMesasPorCapacidadeMaxima(Long cap) {
        return findAll()
                .stream()
                .filter(it -> it.getCapacidadeMaxima() >= cap)
                .collect(Collectors.toList());
    }

    public List<MesaDto> findMesasByGarcom(Long id) {
        return findAllByIdGarcom(id);
    }

    public void removeMesasGarcom(Long id) {
        mesaRepository
            .findAllByIdGarcom(id)
            .forEach(it -> {
                if (it.getIdGarcom() == id) {
                    it.setIdGarcom(null);
                    it.setNomeGarcom(null);
                    mesaRepository.save(it);
                }
            });
    }
}
