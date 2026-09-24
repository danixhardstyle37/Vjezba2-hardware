package hr.java.web.hardwareapp.repository;

import hr.java.web.hardwareapp.domain.Hardware;
import hr.java.web.hardwareapp.domain.Type;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JdbcHardwareRepository implements HardwareRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcHardwareRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hardware> findAll() {
        return jdbcTemplate.query("SELECT id, name, type, code, stock, price FROM hardware", this::mapRow);
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return jdbcTemplate.query("SELECT id, name, type, code, stock, price FROM hardware WHERE code = ?", this::mapRow, code).stream().findFirst();
    }

    @Override
    public void save(Hardware hardware) {
        jdbcTemplate.update(
                "INSERT INTO hardware (name, type, code, stock, price)     VALUES (?, ?, ?, ?, ?)",
                hardware.getName(),
                hardware.getType().name(),
                hardware.getCode(),
                hardware.getStock(),
                hardware.getPrice()
        );
    }

    @Override
    public Optional<Hardware> update(Hardware hardware) {

        int rowsUpdated = jdbcTemplate.update(
                "UPDATE hardware SET name = ?, type = ?, stock = ?, price = ? WHERE code = ? ",
                hardware.getName(),
                hardware.getType().name(),
                hardware.getStock(),
                hardware.getPrice(),
                hardware.getCode()
        );

        if (rowsUpdated == 0) {
            return Optional.empty();
        }

        return findByCode(hardware.getCode());
    }

    @Override
    public boolean deleteByCode(String code) {
        int rowsDeleted = jdbcTemplate.update("DELETE FROM hardware WHERE code = ?", code);

        return rowsDeleted > 0;
    }

    private Hardware mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
        return new Hardware(
                rs.getLong("id"),
                rs.getString("name"),
                Type.valueOf(rs.getString("type")),
                rs.getString("code"),
                rs.getLong("stock"),
                rs.getBigDecimal("price")
        );
    }
}