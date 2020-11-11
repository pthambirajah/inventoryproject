package fi.haagahelia.inventoryproject.web;

import fi.haagahelia.inventoryproject.domain.Product;
import fi.haagahelia.inventoryproject.domain.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Main controller to make actions on products
@Controller
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Welcome to the shop inventory";
    }

    //List all the products
    @RequestMapping(value="/productlist")
    public String productList(Model model) {
        List<Product> products = productDAO.findAll();
        model.addAttribute("products", products);
        return "productlist";
    }

    // Add new product functionnality
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
