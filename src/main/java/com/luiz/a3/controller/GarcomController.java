package com.luiz.a3.controller;

import com.luiz.a3.model.dto.GarcomDto;
import com.luiz.a3.model.entity.Garcom;
import com.luiz.a3.repository.GarcomRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/garcom")
public class GarcomController {

    private final GarcomRepository garcomRepository;

    public GarcomController(GarcomRepository garcomRepository) {
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
        var garcom = garcomRepository.getOne(id);
        return GarcomDto.converter(garcom);
    }

    @PostMapping("/")
    public void saveGarcom(
            @RequestBody GarcomDto garcom
    ) {
        var p = new Garcom();
        p.setNome(garcom.getNome());

        garcomRepository.save(p);
    }
}