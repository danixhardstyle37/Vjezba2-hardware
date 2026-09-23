package hr.java.web.hardwareapp.service;

import hr.java.web.hardwareapp.domain.Hardware;
import hr.java.web.hardwareapp.dto.HardwareDTO;
import hr.java.web.hardwareapp.repository.HardwareRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardwareServiceImpl implements HardwareService{

    private final HardwareRepository hardwareRepository;

    public HardwareServiceImpl(HardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }

    private Hardware convertToHardware(HardwareDTO dto) {
        return new Hardware(dto.getName(), dto.getType(), dto.getCode(), dto.getStock(), dto.getPrice());
    }

    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll().stream().map(HardwareDTO::new).collect(Collectors.toList());
    }

    @Override
    public HardwareDTO findByCode(String code) {
        return hardwareRepository.findByCode(code).map(HardwareDTO::new).orElse(null);
    }

    @Override
    public void save(HardwareDTO hardwareDTO) {
        hardwareRepository.save(convertToHardware(hardwareDTO));
    }

    @Override
    public Optional<HardwareDTO> update(HardwareDTO hardwareDTO) {
        return hardwareRepository.update(convertToHardware(hardwareDTO)).map(HardwareDTO::new);
    }

    @Override
    public boolean deleteByCode(String code) {
        return hardwareRepository.deleteByCode(code);
    }

}
