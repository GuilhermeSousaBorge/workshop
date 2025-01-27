package com.mechanic.workshop.controller;

import com.mechanic.workshop.dto.PartRequestDto;
import com.mechanic.workshop.dto.PartResponseDto;
import com.mechanic.workshop.model.Part;
import com.mechanic.workshop.repository.PartRepository;
import com.mechanic.workshop.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
public class PartController {

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private PartService partService;

    @PostMapping
    public ResponseEntity<Part> createPart(@RequestBody PartRequestDto payload){

        Part response = this.partService.createPart(payload);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartResponseDto> getPart(@PathVariable long id){

        PartResponseDto response = this.partService.getPart(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PartResponseDto>> getParts(){
        List<PartResponseDto> allParts = this.partService.getParts();
        return ResponseEntity.ok(allParts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long>  updatePart(@PathVariable long id, @RequestBody PartRequestDto payload){
        long response = this.partService.updatePart(id, payload);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePart(@PathVariable long id){
        long response = this.partService.deletePart(id);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
