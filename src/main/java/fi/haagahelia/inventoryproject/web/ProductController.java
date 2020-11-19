package fi.haagahelia.inventoryproject.web;

import fi.haagahelia.inventoryproject.domain.Product;
import fi.haagahelia.inventoryproject.domain.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Main controller to make actions on products
@Controller
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/")
    public String home() {
        return "homepage";
    }

    //List all the products

    @RequestMapping(value="/productlist")
    public String productList(Model model) {
        List<Product> products = productDAO.findAll();
        model.addAttribute("products", products);
        return "productlist";
    }
    //List all the products REST
    @RequestMapping(value="/products", method = RequestMethod.GET)
    public @ResponseBody List<Product> productListRest() {
        return (List<Product>) productDAO.findAll();
    }

    //Get one product by it's id REST
    @RequestMapping(value="/product/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Product> findProductRest(@PathVariable("id") int productId) {
        return Optional.ofNullable(productDAO.findOne(productId));
    }

    // Add new product functionnality
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    // Save new product functionnality, called by addproduct.html
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Product product){
        productDAO.save(product);
        return "redirect:productlist";
    }

    // Update a product functionnality, called by editproduct.html
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Product product){
        productDAO.update(product);
        return "redirect:productlist";
    }

    // Delete a product functionality, can be called directly from product list
    // there is a delete button next to each product
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int productId, Model model) {
        productDAO.delete(productId);
        return "redirect:../productlist";
    }

    // Edit a product functionnality, can be called directly from product list
    // There is an edit button next to each product
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int productId, Model model) {
        Product product = productDAO.findOne(productId);
        model.addAttribute("product", product );
        //In the future I will need to also list all the categories
        //model.addAttribute("categories", categoryRepository.findAll());
        return "editproduct";
    }
}
