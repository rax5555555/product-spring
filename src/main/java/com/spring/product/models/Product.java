package com.spring.product.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

/**
 * @author Rakhmatullin Timur
 * @version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {

    public enum Role {
        ADMIN, USER
    }
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer cost;
    private Integer quantity;

    @Column(unique = true)
    private String email;

    private String hashPassword;

    @OneToMany(mappedBy = "owner")
    private List<Prop> products;
}
