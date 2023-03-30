package model;

public class Cart {
	private Product prod;
	private int quantity;
	public Cart() {
		
	}
	public Cart(Product prod, int quantity) {
        this.prod = prod;
        this.quantity = quantity;
    }

    public Product getProd() {
        return prod;
    }

    public void setProd(Product prod) {
        this.prod = prod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
