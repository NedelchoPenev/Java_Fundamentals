package exercise.P03_Wild_farm.foods;

public abstract class Food {

    private int quantity;

    public Food(int quantity) {
        this.setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        if (quantity < 0){
            throw new IllegalArgumentException("Invalid input");
        }
        this.quantity = quantity;
    }
}
