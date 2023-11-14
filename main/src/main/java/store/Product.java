public class Product {
    private String product_id;
    private double cost;
    private String product_name;
    private Seller seller;
    public String getProductId() {
        return product_id;
    }
    public void setProduct_id(String productId) {
        this.product_id = product_id;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String productName) {
        this.product_name = productName;
    }
    public Seller getSeller() {
        return seller;
    }
    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    public Product(String product_id, double cost, String product_name, Seller seller) {
        this.product_id = product_id;
        this.cost = cost;
        this.product_name = product_name;
        this.seller = seller;
    }
    public Product(){
    }
}
