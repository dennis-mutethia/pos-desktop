package mobiclick.application.db.entities;

/**
 *
 * @author DennisMutethia
 */
public class Product {

    private int id;
    private int supplier_id;
    private int category_id;
    private String name;
    private String barcode;
    private double buying_price;
    private double stockist_price;
    private double wholesale_price;
    private double retail_price;
    private double quantity;
    private double restock_value;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the supplier_id
     */
    public int getSupplier_id() {
        return supplier_id;
    }

    /**
     * @param supplier_id the supplier_id to set
     */
    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    /**
     * @return the category_id
     */
    public int getCategory_id() {
        return category_id;
    }

    /**
     * @param category_id the category_id to set
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     * @return the buying_price
     */
    public double getBuying_price() {
        return buying_price;
    }

    /**
     * @param buying_price the buying_price to set
     */
    public void setBuying_price(double buying_price) {
        this.buying_price = buying_price;
    }

    /**
     * @return the stockist_price
     */
    public double getStockist_price() {
        return stockist_price;
    }

    /**
     * @param stockist_price the stockist_price to set
     */
    public void setStockist_price(double stockist_price) {
        this.stockist_price = stockist_price;
    }

    /**
     * @return the wholesale_price
     */
    public double getWholesale_price() {
        return wholesale_price;
    }

    /**
     * @param wholesale_price the wholesale_price to set
     */
    public void setWholesale_price(double wholesale_price) {
        this.wholesale_price = wholesale_price;
    }

    /**
     * @return the retail_price
     */
    public double getRetail_price() {
        return retail_price;
    }

    /**
     * @param retail_price the retail_price to set
     */
    public void setRetail_price(double retail_price) {
        this.retail_price = retail_price;
    }

    /**
     * @return the quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the restock_value
     */
    public double getRestock_value() {
        return restock_value;
    }

    /**
     * @param restock_value the restock_value to set
     */
    public void setRestock_value(double restock_value) {
        this.restock_value = restock_value;
    }    

}
