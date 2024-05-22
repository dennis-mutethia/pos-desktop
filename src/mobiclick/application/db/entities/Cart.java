package mobiclick.application.db.entities;

/**
 *
 * @author DennisMutethia
 */
public class Cart {
    private Product product;
    private double qty;
    
    public Cart(Product product, double qty){
        this.product = product;
        this.qty = qty;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the qty
     */
    public double getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(double qty) {
        this.qty = qty;
    }
}
