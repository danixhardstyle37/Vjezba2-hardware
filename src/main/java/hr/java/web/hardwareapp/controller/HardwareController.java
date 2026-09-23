package hr.java.web.hardwareapp.controller;

import hr.java.web.hardwareapp.service.HardwareService;
import hr.java.web.hardwareapp.dto.HardwareDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hardware")
public class HardwareController {

    private final HardwareService hardwareService;

    public HardwareController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping
    public List<HardwareDTO> getAll() {
        return hardwareService.findAll();
    }

    @GetMapping(params = "code")
    public HardwareDTO getByCode(@RequestParam final String code) {

        return hardwareService.findByCode(code);
    }

    @PostMapping
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody HardwareDTO hardwareDTO) {
        hardwareService.save(hardwareDTO);
        return new ResponseEntity<>(hardwareDTO, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HardwareDTO> update(@Valid @RequestBody HardwareDTO hardwareDTO) {

        return hardwareService.update(hardwareDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String code) {

        if (hardwareService.deleteByCode(code)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
