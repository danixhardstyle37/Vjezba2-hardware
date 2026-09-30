package hr.java.web.hardwareapp.repository;

import hr.java.web.hardwareapp.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataTypeRepository extends JpaRepository<Type, Long> {
}