package app.waste_disposal.models.garbage;

import app.waste_disposal.annotations.Burnable;

@Burnable
public class BurnableGarbage extends BaseGarbage {

    public BurnableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
