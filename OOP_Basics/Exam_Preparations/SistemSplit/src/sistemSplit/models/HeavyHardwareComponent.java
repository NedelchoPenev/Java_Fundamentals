package sistemSplit.models;

public class HeavyHardwareComponent extends HardwareComponent {

    public HeavyHardwareComponent(String name, int capacity, int memory) {
        super(name, "Heavy");
        this.setCapacity(capacity);
        this.setMemory(memory);
    }

    @Override
    public int getCapacity() {
        return super.getCapacity() * 2;
    }

    @Override
    public int getMemory() {
        return super.getMemory() - (super.getMemory() / 4);
    }
}
