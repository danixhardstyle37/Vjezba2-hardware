package hr.java.web.hardwareapp.repository;

import hr.java.web.hardwareapp.domain.Hardware;
import hr.java.web.hardwareapp.domain.Type;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class MockHardwareRepository implements HardwareRepository{

    private final List<Hardware> MOCKED_HARDWARE = new ArrayList<>(List.of(
            new Hardware("Asus TUF RTX 3080", Type.GPU, "1234561", 0, BigDecimal.valueOf(1599.00)),
            new Hardware("EVGA XC3 RTX 3070 Ti", Type.GPU, "1234562", 0, BigDecimal.valueOf(1299.00)),
            new Hardware("AMD Ryzen 5950X", Type.CPU, "1234563", 0, BigDecimal.valueOf(899.00)),
            new Hardware("Samsung 980 PRO SSD 1TB", Type.STORAGE, "1234564", 0, BigDecimal.valueOf(299.00)),
            new Hardware("Kingston FURY Beast DDR5 32GB", Type.RAM, "1234565", 0, BigDecimal.valueOf(699.00))
    ));


    @Override
    public List<Hardware> findAll() {
        return MOCKED_HARDWARE;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return MOCKED_HARDWARE.stream().filter(hardware -> Objects.equals(hardware.getCode(), code)).findAny();
    }

    @Override
    public void save(Hardware hardware) {
        MOCKED_HARDWARE.add(hardware);
    }

    @Override
    public Optional<Hardware> update(Hardware hardware) {

        Optional<Hardware> existingHardware = findByCode(hardware.getCode());

        if (existingHardware.isPresent()) {
            Hardware existing = existingHardware.get();

            existing.setName(hardware.getName());
            existing.setType(hardware.getType());
            existing.setStock(hardware.getStock());
            existing.setPrice(hardware.getPrice());

            return Optional.of(existing);
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteByCode(String code) {
        return MOCKED_HARDWARE.removeIf(hardware -> Objects.equals(hardware.getCode(), code));
    }
}
