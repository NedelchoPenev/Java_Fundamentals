package sistemSplit.models;

public class PowerHardwareComponent extends HardwareComponent {

    public PowerHardwareComponent(String name, int capacity, int memory) {
        super(name, "Power");
        this.setCapacity(capacity);
        this.setMemory(memory);
    }

    @Override
    public int getCapacity() {
        return super.getCapacity() - ((super.getCapacity() * 3) / 4);
    }

    @Override
    public int getMemory() {
        return super.getMemory() + ((super.getMemory() * 3) / 4);
    }
}
