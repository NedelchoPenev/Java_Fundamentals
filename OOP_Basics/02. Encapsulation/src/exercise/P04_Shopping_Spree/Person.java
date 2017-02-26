package exercise.P04_Shopping_Spree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.setProducts(new ArrayList<>());
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    private List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    private void setProducts(List<Product> products) {
        this.products = products;
    }

    public void buyProduct(Product product){
        if (product.getCost() <= this.getMoney()){
            products.add(product);
            this.setMoney(this.getMoney() - product.getCost());
            this.productBought(product);
        } else {
            this.notEnoughMoney(product);
        }
    }

    private void notEnoughMoney(Product product) {
        System.out.printf("%s can't afford %s%n", this.getName(), product);
    }

    private void productBought(Product product) {
        System.out.printf("%s bought %s%n", this.getName(), product);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.getProducts().size() == 0){
            result.append(String.format("%s - Nothing bought%n", this.getName()));
        } else if (this.getProducts().size() == 1){
            result.append(String.format("%s - %s", this.getName(), this.getProducts().get(0)));
        } else {
            result.append(this.getName()).append(" - ");
            for (Product product : products) {
                result.append(product).append(", ");
            }

            result.delete(result.length() - 2, result.length());
        }

        return result.toString();
    }
}
