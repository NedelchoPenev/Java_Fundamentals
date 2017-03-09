package sistemSplit.commands;

import sistemSplit.models.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TheSystem implements iTheSystem {

    private LinkedHashMap<String, HardwareComponent> hardwareComponents;
    private LinkedHashMap<String, SoftwareComponent> softwareComponents;
    private LinkedHashMap<String, HardwareComponent> dumpComponents;

    public TheSystem() {
        this.hardwareComponents = new LinkedHashMap<>();
        this.softwareComponents = new LinkedHashMap<>();
        this.dumpComponents = new LinkedHashMap<>();
    }

    @Override
    public void registerPowerHardware(String name, int capacity, int memory) {
        HardwareComponent hardwareComponent = new PowerHardwareComponent(name, capacity, memory);
        this.hardwareComponents.putIfAbsent(name, hardwareComponent);
    }

    @Override
    public void registerHeavyHardware(String name, int capacity, int memory) {
        HardwareComponent hardwareComponent = new HeavyHardwareComponent(name, capacity, memory);
        this.hardwareComponents.putIfAbsent(name, hardwareComponent);
    }

    @Override
    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        SoftwareComponent softwareComponent =
                new ExpressSoftwareComponent(name, capacity, memory);
        this.softwareComponents.putIfAbsent(name, softwareComponent);
        registerSoftware(hardwareComponentName, softwareComponent);
    }

    @Override
    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        SoftwareComponent softwareComponent =
                new LightSoftwareComponent(name, capacity, memory);
        this.softwareComponents.putIfAbsent(name, softwareComponent);
        registerSoftware(hardwareComponentName, softwareComponent);
    }

    private void registerSoftware(String hardwareComponentName, SoftwareComponent softwareComponent) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            int maxCapacity = this.hardwareComponents.get(hardwareComponentName).getCapacity();
            int maxMemory =
                    this.hardwareComponents.get(hardwareComponentName).getMemory();
            int availableCapacity =
                    maxCapacity - this.hardwareComponents.get(hardwareComponentName).getCapacityTaken();
            int availableMemory = maxMemory - this.hardwareComponents.get(hardwareComponentName).getMemoryTaken();

            if (availableCapacity >= softwareComponent.getCapacity() &&
                    availableMemory >= softwareComponent.getMemory()) {

                this.hardwareComponents.get(hardwareComponentName)
                        .registerSoftwareComponent(softwareComponent);
            }
        }
    }

    @Override
    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        SoftwareComponent softwareComponent = this.softwareComponents.get(softwareComponentName);
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            this.hardwareComponents.get(hardwareComponentName).releaseSoftwareComponent(softwareComponent);
            this.softwareComponents.remove(hardwareComponentName);
        }
    }

    @Override
    public void analyze() {
        System.out.printf("System Analysis\n" +
                        "Hardware Components: %d\n" +
                        "Software Components: %d\n" +
                        "Total Operational Memory: %d / %d\n" +
                        "Total Capacity Taken: %d / %d\n",
                this.hardwareComponents.size(),
                getSoftwareComponents(),
                totalOperationalMemoryInUse(),
                maximumMemory(),
                totalCapacityTaken(),
                maximumCapacity());
    }

    private int getSoftwareComponents() {
        int count = this.hardwareComponents.values()
                .stream()
                .flatMap(c -> c.getComponents().stream())
                .collect(Collectors.toList())
                .size();

        return count;
    }

    private int totalOperationalMemoryInUse() {
        int totalOperationalMemoryInUse = 0;
        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            totalOperationalMemoryInUse += hardwareComponent.getMemoryTaken();
        }

        return totalOperationalMemoryInUse;
    }

    private int maximumMemory() {
        int maximumMemory = 0;
        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            maximumMemory += hardwareComponent.getMemory();
        }
        return maximumMemory;
    }

    private int totalCapacityTaken() {
        int totalCapacityTaken = 0;
        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            totalCapacityTaken += hardwareComponent.getCapacityTaken();
        }

        return totalCapacityTaken;
    }

    private int maximumCapacity() {
        int maximumCapacity = 0;
        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            maximumCapacity += hardwareComponent.getCapacity();
        }

        return maximumCapacity;
    }

    @Override
    public void split() {
        for (HardwareComponent hardwareComponent : hardwareComponents.values()) {
            System.out.printf("Hardware Component - %s\n" +
                            "Express Software Components - %d\n" +
                            "Light Software Components - %d\n" +
                            "Memory Usage: %d / %d\n" +
                            "Capacity Usage: %d / %d\n" +
                            "Type: %s\n" +
                            "Software Components: %s\n",
                    hardwareComponent.getName(),
                    countOfExpressSoftwareComponents(hardwareComponent),
                    countOfLightSoftwareComponents(hardwareComponent),
                    hardwareComponent.getMemoryTaken(),
                    hardwareComponent.getMemory(),
                    hardwareComponent.getCapacityTaken(),
                    hardwareComponent.getCapacity(),
                    hardwareComponent.getType(),
                    getComponents(hardwareComponent.getComponents()));
        }
    }

    private String getComponents(List<SoftwareComponent> components) {
        if (components.isEmpty()) {
            return "None";
        }

        List<String> names = components.stream()
                .map(SoftwareComponent::getName)
                .collect(Collectors.toList());

        return String.join(", ", names);
    }

    private long countOfExpressSoftwareComponents(HardwareComponent hardwareComponent) {
        return hardwareComponent.getComponents()
                .stream()
                .filter(c -> c.getType().equals("Express"))
                .count();
    }

    private long countOfLightSoftwareComponents(HardwareComponent hardwareComponent) {
        return hardwareComponent.getComponents()
                .stream()
                .filter(c -> c.getType().equals("Light"))
                .count();
    }

    public void dump(String hardwareComponentName) {
        if (this.hardwareComponents.containsKey(hardwareComponentName)) {
            this.dumpComponents.put(hardwareComponentName, this.hardwareComponents.get(hardwareComponentName));
            this.hardwareComponents.remove(hardwareComponentName);
        }
    }

    public void restore(String hardwareComponentName) {
        if (this.dumpComponents.containsKey(hardwareComponentName)) {
            this.hardwareComponents.put(hardwareComponentName, this.dumpComponents.get(hardwareComponentName));
            this.dumpComponents.remove(hardwareComponentName);
        }
    }

    public void destroy(String hardwareComponentName) {
        if (this.dumpComponents.containsKey(hardwareComponentName)) {
            this.dumpComponents.remove(hardwareComponentName);
        }
    }

    public void dumpAnalyze() {
        System.out.printf("Dump Analysis\n" +
                        "Power Hardware Components: %s\n" +
                        "Heavy Hardware Components: %s\n" +
                        "Express Software Components: %d\n" +
                        "Light Software Components: %d\n" +
                        "Total Dumped Memory: %s\n" +
                        "Total Dumped Capacity: %s\n",
                gerPowerHardware(),
                getHeavyHardware(),
                countOfExpressSoftwareComponents(),
                countOfLightSoftwareComponents(),
                totalDumpedMemory(),
                totalDumpedCapacity());

    }

    private long totalDumpedCapacity() {
        long total = 0;
        for (HardwareComponent hardwareComponent : dumpComponents.values()) {
            total += hardwareComponent.getCapacityTaken();
        }

        return total;
    }

    private long totalDumpedMemory() {
        long total = 0;
        for (HardwareComponent hardwareComponent : dumpComponents.values()) {
            total += hardwareComponent.getMemoryTaken();
        }

        return total;
    }

    private long countOfLightSoftwareComponents() {
        long total = 0;
        for (HardwareComponent hardwareComponent : dumpComponents.values()) {
            total += hardwareComponent.getComponents()
                    .stream()
                    .filter(c -> c.getType().equals("Light"))
                    .count();
        }

        return total;
    }

    private long countOfExpressSoftwareComponents() {
        long total = 0;
        for (HardwareComponent hardwareComponent : dumpComponents.values()) {
            total += hardwareComponent.getComponents()
                    .stream()
                    .filter(c -> c.getType().equals("Express"))
                    .count();
        }

        return total;
    }

    private long getHeavyHardware() {
        return this.dumpComponents.values()
                .stream()
                .filter(c -> c.getType().equals("Heavy"))
                .count();
    }

    private long gerPowerHardware() {
        return this.dumpComponents.values()
                .stream()
                .filter(c -> c.getType().equals("Power"))
                .count();
    }
}
