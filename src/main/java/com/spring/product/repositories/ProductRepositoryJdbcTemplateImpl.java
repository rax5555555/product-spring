package com.spring.product.repositories;

import com.spring.product.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Timur Rakhmatullin
 * @version 1.0
 */

@Component
public class ProductRepositoryJdbcTemplateImpl implements ProductsRepository {

    //language=SQL
    private static final String SQL_INSERT = "insert into product(name, cost, quantity) values(?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_ALL = "select * from product order by id";

    //language=SQL
    private static final String SQL_SELECT_ALL_BY_PRICE = "select * from product";

    //language=SQL
    private static final String SQL_DELETE_BY_ID = "delete from product where id = ?";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from product where id = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
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

    @Override
    public void delete(Long productId) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, productId);
    }

    @Override
    public Product findById(Long productId) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, productId);
    }

}
