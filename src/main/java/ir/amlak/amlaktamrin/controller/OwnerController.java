package ir.amlak.amlaktamrin.controller;

import ir.amlak.amlaktamrin.dto.OwnerDTO;
import ir.amlak.amlaktamrin.entity.OwnerEntity;
import ir.amlak.amlaktamrin.service.Impl.OwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
    @Autowired
    private OwnerServiceImpl ownerService;

    @PostMapping({"", "/"})
    public ResponseEntity<OwnerDTO> saveOwner(@RequestBody OwnerDTO ownerDTO) throws Exception {
        return ResponseEntity.ok(ownerService.save(ownerDTO));
    }

    @GetMapping({"search", "/search"})
    public ResponseEntity<OwnerDTO> getOwner(@RequestParam String nationalCode) {
        return ResponseEntity.ok(ownerService.getUser(nationalCode));
    }

    @DeleteMapping({"/delete", "delete"})
    public ResponseEntity<Boolean> deleteUser(@RequestParam String nationalCode) throws Exception {
        return ResponseEntity.ok(ownerService.deleteUser(nationalCode));
    }

    @PutMapping({"update", "/update"})
    public ResponseEntity<OwnerDTO> updateOwner(@RequestParam String nationalCode, @RequestBody OwnerDTO ownerDTO) {
        return ResponseEntity.ok(ownerService.updateUser(nationalCode, ownerDTO));
    }
    @GetMapping({"all","/all"})
    public ResponseEntity<List<OwnerDTO>> getAllUsers (){
        return ResponseEntity.ok(ownerService.getAll());
    }

}
