package com.spring.product.repositories;

import com.spring.product.models.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class ProductRepositoryJdbcTemplateImpl implements ProductsRepository {

/**
 * 26.11.2021
 * 24. SQL & JDBC
 *
 * @author Rakhmatullin Timur (First Software Engineering Platform)
 * @version v1.0
 */

    //language=SQL
    private static final String SQL_INSERT = "insert into product(name, cost, quantity) values(?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from product order by id";

    //language=SQL
    private static final String SQL_SELECT_ALL_BY_PRICE = "select * from product";

    private JdbcTemplate jdbcTemplate;

    public ProductRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<Product> userRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String name = row.getString("name");
        int cost = row.getInt("cost");
        int quantity = row.getInt("quantity");

        return new Product(id, name, cost, quantity);
    };

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public List<Product> findAllByPrice(double price) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BY_PRICE + " where cost = " + price, userRowMapper);
    }

    @Override
    public void save(Product product) {
        jdbcTemplate.update(SQL_INSERT, product.getName(), product.getCost(), product.getQuantity());
    }

}
