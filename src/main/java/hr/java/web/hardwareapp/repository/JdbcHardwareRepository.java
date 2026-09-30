package hr.java.web.hardwareapp.repository;

import com.mysql.cj.jdbc.MysqlDataSource;
import hr.java.web.hardwareapp.domain.Hardware;
import hr.java.web.hardwareapp.domain.Type;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcHardwareRepository { //implements HardwareRepository {

    /*
    private final DataSource dataSource;

    public JdbcHardwareRepository() {
        this.dataSource = createDataSource();
    }

    private DataSource createDataSource() {
        MysqlDataSource ds = new MysqlDataSource();

        ds.setServerName("localhost");
        ds.setPortNumber(3307);
        ds.setUser("root");
        ds.setDatabaseName("hardwareapp");

        return ds;
    }

    @Override
    public List<Hardware> findAll() {
        List<Hardware> hardwareList = new ArrayList<>();

        String sql = "SELECT Name, Type, Code, Stock, Price FROM Hardware";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Hardware hardware = new Hardware(
                        rs.getString("Name"),
                        Type.valueOf(rs.getString("Type")),
                        rs.getString("Code"),
                        rs.getInt("Stock"),
                        rs.getBigDecimal("Price")
                );

                hardwareList.add(hardware);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Dogodila se greska pri dohvaćanju hardvera.", e);
        }

        return hardwareList;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        String sql = "SELECT Name, Type, Code, Stock, Price FROM Hardware WHERE Code = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, code);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Hardware hardware = new Hardware(
                            rs.getString("Name"),
                            Type.valueOf(rs.getString("Type")),
                            rs.getString("Code"),
                            rs.getInt("Stock"),
                            rs.getBigDecimal("Price")
                    );

                    return Optional.of(hardware);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Dogodila se greska pri dohvaćanju hardvera.", e);
        }

        return Optional.empty();
    }

    @Override
    public void save(Hardware hardware) {
        String sql = "INSERT INTO Hardware (Name, Type, Code, Stock, Price) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, hardware.getName());
            stmt.setString(2, hardware.getType().name());
            stmt.setString(3, hardware.getCode());
            stmt.setInt(4, (int) hardware.getStock());
            stmt.setBigDecimal(5, hardware.getPrice());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Dogodila se greska pri spremanju hardvera.", e);
        }
    }

    @Override
    public Optional<Hardware> update(Hardware hardware) {
        String sql = "UPDATE Hardware SET Name = ?, Type = ?, Stock = ?, Price = ? WHERE Code = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, hardware.getName());
            stmt.setString(2, hardware.getType().name());
            stmt.setInt(3, (int) hardware.getStock());
            stmt.setBigDecimal(4, hardware.getPrice());
            stmt.setString(5, hardware.getCode());

            int brojPromijenjenihRedaka = stmt.executeUpdate();

            if (brojPromijenjenihRedaka > 0) {
                return findByCode(hardware.getCode());
            }

        } catch (SQLException e) {
            throw new RuntimeException("Dogodila se greska pri izmjeni hardvera.", e);
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteByCode(String code) {
        String sql = "DELETE FROM Hardware WHERE Code = ?";

        try (Connection connection = dataSource.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, code);

            int brojObrisanihRedaka = stmt.executeUpdate();

            return brojObrisanihRedaka > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Dogodila se greska pri brisanju hardvera.", e);
        }
    }
    */
}
