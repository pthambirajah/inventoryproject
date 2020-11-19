package fi.haagahelia.inventoryproject;

import fi.haagahelia.inventoryproject.domain.Product;
import fi.haagahelia.inventoryproject.domain.ProductDAOImpl;
import fi.haagahelia.inventoryproject.domain.User;
import fi.haagahelia.inventoryproject.domain.UserRepository;
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
    public CommandLineRunner demo(ProductDAOImpl productDAO, UserRepository userRepository) {
        return (args) -> {
            User user1 = new User("user","$2a$10$HcRhold2nXktBId7hBk2jOBmMbPFWbe9Ns4o.HQafyE8SVufGbjs2","USER");
            User user2 = new User("admin5","$2a$10$gQT0fLGlAkzJjY8CJmT0De/Wzd5g/PcsZ33ubk3pWzg3Xj.OWsVSS","ADMIN");
            //Password = Admin

            //userRepository.save(user1);
            //userRepository.save(user2);
            //productDAO.save(new Product("Uncle Ben", "Rice", 29));
            //productDAO.save(new Product("Barilla", "Pasta", 39));
            //productDAO.save(new Product("Twix", "Chocolate bar", 19));

        };
    }

}
