package hr.java.web.hardwareapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Hardware {

    private Long id;
    private String name;
    private Type type;
    private String code;
    private long stock;
    private BigDecimal price;

    public Hardware(String name, Type type, String code, long stock, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }
}