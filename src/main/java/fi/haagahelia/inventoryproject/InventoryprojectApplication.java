package fi.haagahelia.inventoryproject;

import fi.haagahelia.inventoryproject.domain.Product;
import fi.haagahelia.inventoryproject.domain.ProductDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryprojectApplication {

    private static final Logger log = LoggerFactory.getLogger(InventoryprojectApplication.class);
    public static void main(String[] args) { SpringApplication.run(InventoryprojectApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductDAOImpl productDAO) {
        return (args) -> {
          /*  productDAO.save(new Product("Uncle Ben", "Rice", 29));
            productDAO.save(new Product("Barilla", "Pasta", 39));
            productDAO.save(new Product("Twix", "Chocolate bar", 19));
            */
        };
    }

}
