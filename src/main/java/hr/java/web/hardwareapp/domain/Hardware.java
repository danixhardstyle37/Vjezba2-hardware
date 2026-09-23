package hr.java.web.hardwareapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Hardware {
    private String name;
    private Type type;
    private String code;
    private long stock;
    private BigDecimal price;
}
