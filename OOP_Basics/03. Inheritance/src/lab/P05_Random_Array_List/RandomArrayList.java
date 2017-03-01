package lab.P05_Random_Array_List;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private Random rnd;

    public RandomArrayList(){
        this.rnd = new Random();
    }

    public Object getRandomElement(){
        int index = this.rnd.nextInt(super.size());
        Object element = super.get(index);
        super.set(index, super.get(super.size() - 1));
        super.remove(super.size() - 1);

        return element;
    }
}
