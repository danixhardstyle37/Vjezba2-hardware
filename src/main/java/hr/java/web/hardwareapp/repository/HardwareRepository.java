package hr.java.web.hardwareapp.repository;

import hr.java.web.hardwareapp.domain.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> findAll();

    Optional<Hardware> findByCode(String code);

    void save(Hardware hardware);

    Optional<Hardware> update(Hardware hardware);

    boolean deleteByCode(String code);

}
