package pawninc.Centers;

import pawninc.Animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class CastrationCenter extends Center {

    public CastrationCenter(String name) {
        super(name);
    }

    public List<Animal> castrate(){
        List<Animal> castrate = new ArrayList<>();
        super.getAnimals().forEach(a -> {
            a.castrate();
            castrate.add(a);
        });

        super.remove(castrate);
        return castrate;
    }
}
