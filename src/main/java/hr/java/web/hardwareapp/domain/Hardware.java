package hr.java.web.hardwareapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Hardware")
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    private String code;
    private long stock;
    private BigDecimal price;

    public Hardware() {
    }

    public Hardware(String name, Type type, String code, long stock, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }
}