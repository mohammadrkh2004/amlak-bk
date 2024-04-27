package ir.amlak.amlaktamrin.controller;

import ir.amlak.amlaktamrin.dto.EstateDTO;
import ir.amlak.amlaktamrin.service.EstateService;

import ir.amlak.amlaktamrin.service.Impl.EstateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estate")
public class EstateController {
    @Autowired
    private EstateServiceImpl estateService;

    @PostMapping({"","/"})
    public ResponseEntity<EstateDTO> create (@RequestBody EstateDTO estateDTO, @RequestParam String nationalCode){
        return ResponseEntity.ok(estateService.create(estateDTO, nationalCode));
    }

    @GetMapping({"","/"})
    public ResponseEntity<EstateDTO> getEstate (@RequestParam String trackingCode){
        return ResponseEntity.ok((estateService.getEstate(trackingCode)));
    }

    @DeleteMapping({"","/"})
    public ResponseEntity<Boolean> deleteUser (@RequestParam String trackingCode){
        return ResponseEntity.ok(estateService.deleteEstate(trackingCode));
    }

    @PutMapping({"","/"})
    public ResponseEntity<EstateDTO> updateUser(@RequestParam String trackingCode, @RequestBody EstateDTO estateDTO){
        return ResponseEntity.ok((estateService.updateEstate(trackingCode,estateDTO)));

    }

    @GetMapping({"getAll","/getAll"})
    public ResponseEntity <List<EstateDTO>> getAllEstates(){
        return ResponseEntity.ok(estateService.getAllEstates());

    }
}
