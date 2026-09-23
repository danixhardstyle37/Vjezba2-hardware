package hr.java.web.hardwareapp.service;

import hr.java.web.hardwareapp.dto.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAll();

    HardwareDTO findByCode(String code);

    void save(HardwareDTO hardwareDTO);

    Optional<HardwareDTO> update(HardwareDTO hardwareDTO);

    boolean deleteByCode(String code);

}
