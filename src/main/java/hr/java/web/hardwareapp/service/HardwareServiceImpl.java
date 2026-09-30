package hr.java.web.hardwareapp.service;

import hr.java.web.hardwareapp.domain.Hardware;
import hr.java.web.hardwareapp.domain.Type;
import hr.java.web.hardwareapp.dto.HardwareDTO;
import hr.java.web.hardwareapp.repository.SpringDataHardwareRepository;
import hr.java.web.hardwareapp.repository.SpringDataTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardwareServiceImpl implements HardwareService {

    private final SpringDataHardwareRepository hardwareRepository;
    private final SpringDataTypeRepository typeRepository;

    public HardwareServiceImpl(SpringDataHardwareRepository hardwareRepository, SpringDataTypeRepository typeRepository) {
        this.hardwareRepository = hardwareRepository;
        this.typeRepository = typeRepository;
    }

    private Hardware convertToHardware(HardwareDTO dto) {
        Type type = typeRepository.findById(dto.getTypeId()).orElseThrow();
        return new Hardware(dto.getName(), type, dto.getCode(), dto.getStock(), dto.getPrice());
    }

    @Override
    public List<HardwareDTO> findAll() {
        return hardwareRepository.findAll().stream()
                .map(HardwareDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public HardwareDTO findByCode(String code) {
        return hardwareRepository.findByCode(code)
                .map(HardwareDTO::new)
                .orElse(null);
    }

    @Override
    public void save(HardwareDTO hardwareDTO) {
        hardwareRepository.save(convertToHardware(hardwareDTO));
    }

    @Override
    public Optional<HardwareDTO> update(HardwareDTO hardwareDTO) {
        return hardwareRepository.findByCode(hardwareDTO.getCode())
                .map(existing -> {
                    Type type = typeRepository.findById(hardwareDTO.getTypeId()).orElseThrow();
                    existing.setName(hardwareDTO.getName());
                    existing.setType(type);
                    existing.setStock(hardwareDTO.getStock());
                    existing.setPrice(hardwareDTO.getPrice());
                    return new HardwareDTO(hardwareRepository.save(existing));
                });
    }

    @Override
    public boolean deleteByCode(String code) {
        Optional<Hardware> hardware = hardwareRepository.findByCode(code);

        if (hardware.isPresent()) {
            hardwareRepository.delete(hardware.get());
            return true;
        }

        return false;
    }
}