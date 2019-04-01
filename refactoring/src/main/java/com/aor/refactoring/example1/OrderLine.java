package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }

    public Product getProduct(){
        return this.product;
    }

    public int getQuantity(){
        return this.quantity;
    }

    @Override
    public String toString() {
        return this.product.getName() + "(x" + this.quantity + "): " + (this.product.getPrice() * this.quantity) + "\n";
    }
}
