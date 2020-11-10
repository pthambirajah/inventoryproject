package fi.haagahelia.inventoryproject.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//In this repository you can see all the SQL queries that are sent to the DB
@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Add a product to the db
    public void save(Product product){
        String sql = "insert into products(product_name, product_description, product_price) values(?,?,?)";
        Object[] parameters = new Object[] { product.getProductName(), product.getProductDescription(),
                product.getProductPrice()};
        jdbcTemplate.update(sql, parameters);

    }

    //Update a product based on the given id
    public void update(Product product){
        String sql = "UPDATE products set product_name = ? , product_description = ? , product_price = ? where idproducts = ?";
        Object[] parameters = new Object[] { product.getProductName(), product.getProductDescription(),
                product.getProductPrice(), product.getProductId()};
        jdbcTemplate.update(sql, parameters);

    }
    //Delete a product based on the given id
    public void delete(int id){
        String sql = "delete from products where idproducts = ?";
        Object[] parameters = new Object[] { id };
        jdbcTemplate.update(sql, parameters);

    }

    //Find one allows me to reduce code in other functions
    //As this functionnality is often used, I created it and call it from other functions
    public Product findOne(int id) {
        String sql = "select idproducts, product_name, product_description,product_price from products where idproducts = ?";
        Object[] parameters = new Object[] { id };
        RowMapper<Product> mapper = new ProductRowMapper();

        Product product = jdbcTemplate.queryForObject(sql, parameters, mapper);
        return product;
    }

    //Find all is used to display all the products on a page
    public List<Product> findAll() {

        String sql = "select idproducts, product_name, product_description,product_price from products";
        RowMapper<Product> mapper = new ProductRowMapper();
        List<Product> products = jdbcTemplate.query(sql, mapper);

        return products;
    }
}
