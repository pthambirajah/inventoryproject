package fi.haagahelia.inventoryproject.domain;

//This is the main object of this project
//It defines an article that is sold in the shop
public class Product {

    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;

    public Product(){
        this.productId = 0;
        this.productName = "";
        this.productDescription = "";
        this.productPrice = 0;

    }
    public Product(String productName, String productDescription, double productPrice){
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
