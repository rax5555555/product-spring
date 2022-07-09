package com.spring.product.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 15.11.2021
 * 20. Java IO
 *
 * @author Rakhmatullin Timur (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private int id;
    private String name;
    private int cost;
    private int quantity;
}
