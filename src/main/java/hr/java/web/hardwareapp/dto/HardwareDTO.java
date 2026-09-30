package hr.java.web.hardwareapp.dto;

import hr.java.web.hardwareapp.domain.Hardware;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class HardwareDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Type cannot be null")
    private Long typeId;

    @NotBlank(message = "Code cannot be blank")
    private String code;

    @PositiveOrZero(message = "Stock must be zero or positive")
    private long stock;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", message = "Price must be zero or positive")
    private BigDecimal price;

    public HardwareDTO() {
    }

    public HardwareDTO(Hardware hardware) {
        this.name = hardware.getName();
        this.typeId = hardware.getType().getId();
        this.code = hardware.getCode();
        this.stock = hardware.getStock();
        this.price = hardware.getPrice();
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getTypeId() {
        return typeId;
    }

    public String getCode() {
        return code;
    }

    public long getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "HardwareDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}