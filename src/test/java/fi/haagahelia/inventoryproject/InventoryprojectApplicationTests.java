package fi.haagahelia.inventoryproject;

import fi.haagahelia.inventoryproject.web.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class InventoryprojectApplicationTests {

    @Autowired
    private ProductController productController;

    //Basic smoke testing
    //Test if the controller is created
    @Test
    void contextLoads() throws Exception {
        assertThat(productController).isNotNull();
    }

}
