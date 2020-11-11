package fi.haagahelia.inventoryproject.domain;


import org.springframework.stereotype.Repository;

import java.util.List;

//My interface which present all my functionnalities
public interface ProductDAO {
    public void save(Product product);

    public void update(Product product);

    public Product findOne(int id);

    public void delete(int id);

    public List<Product> findAll();

}
