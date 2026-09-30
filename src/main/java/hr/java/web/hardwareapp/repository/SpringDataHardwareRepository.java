package hr.java.web.hardwareapp.repository;

import hr.java.web.hardwareapp.domain.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataHardwareRepository extends JpaRepository<Hardware, Long> {
    Optional<Hardware> findByCode(String code);
    void deleteByCode(String code);
}