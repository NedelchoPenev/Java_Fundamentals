package lab.p03_Coffee_Machine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private List<Coin> coins;
    private List<Coffee> coffeeList;

    public CoffeeMachine() {
        this.coffeeList = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void buyCoffee(String size, String type){
        CoffeeSize sizeC = CoffeeSize.valueOf(size.toUpperCase());
        CoffeeType typeC = CoffeeType.valueOf(type.toUpperCase());
        Coffee coffee = new Coffee(sizeC, typeC);
        int price = coffee.getPrice();
        int currentSum = this.coins.stream().mapToInt(Coin::getValue).sum();
        if (currentSum > price) {
            this.coffeeList.add(coffee);
            this.coins.clear();
        }
    }

    public void insertCoin(String coin){
        this.coins.add(Coin.valueOf(coin.toUpperCase()));
    }

    public Iterable<Coffee> coffeesSold(){
        return this.coffeeList;
    }

}
