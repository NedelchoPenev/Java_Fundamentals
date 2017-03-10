package pawninc;

import pawninc.Animals.Animal;
import pawninc.Animals.Cat;
import pawninc.Animals.Dog;
import pawninc.Centers.AdoptionCenter;
import pawninc.Centers.CastrationCenter;
import pawninc.Centers.CleansingCenter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalCenterManager implements iCenterManager {

    private HashMap<String, AdoptionCenter> adoptionCenters;
    private HashMap<String, CleansingCenter> cleansingCenters;
    private HashMap<String, CastrationCenter> castrationCenter;
    private List<Animal> cleansedAnimals;
    private List<Animal> castratedAnimals;
    private List<Animal> adoptedAnimals;

    public AnimalCenterManager() {
        this.adoptionCenters = new HashMap<>();
        this.cleansingCenters = new HashMap<>();
        this.castrationCenter = new HashMap<>();
        this.cleansedAnimals = new ArrayList<>();
        this.adoptedAnimals = new ArrayList<>();
        this.castratedAnimals = new ArrayList<>();
    }

    @Override
    public void registerCleansingCenter(String name) {
        CleansingCenter cleansingCenter = new CleansingCenter(name);
        this.cleansingCenters.putIfAbsent(name, cleansingCenter);
    }

    @Override
    public void registerAdoptionCenter(String name) {
        AdoptionCenter adoptionCenter = new AdoptionCenter(name);
        this.adoptionCenters.putIfAbsent(name, adoptionCenter);
    }

    public void registerCastrationCenter(String name) {
        CastrationCenter castrationCenter = new CastrationCenter(name);
        this.castrationCenter.putIfAbsent(name, castrationCenter);
    }

    @Override
    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = new Dog(name, age, adoptionCenterName, learnedCommands);
        this.adoptionCenters.get(adoptionCenterName).register(dog);
    }

    @Override
    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = new Cat(name, age, adoptionCenterName, intelligenceCoefficient);
        this.adoptionCenters.get(adoptionCenterName).register(cat);
    }

    @Override
    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCleansing(cleansingCenter);
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        CastrationCenter castrationCenter = this.castrationCenter.get(castrationCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCastration(castrationCenter);
    }

    @Override
    public void cleanse(String cleansingCenterName) {
        List<Animal> cleansedAnimals = this.cleansingCenters.get(cleansingCenterName).cleanse();
        for (Animal cleansedAnimal : cleansedAnimals) {
            this.adoptionCenters.get(cleansedAnimal.getAdoptionCenter()).register(cleansedAnimal);
        }

        this.cleansedAnimals.addAll(cleansedAnimals);
    }

    public void castrate(String castrationCenterName) {
        List<Animal> castratedAnimals = this.castrationCenter.get(castrationCenterName).castrate();
        for (Animal castratedAnimal : castratedAnimals) {
            this.adoptionCenters.get(castratedAnimal.getAdoptionCenter()).register(castratedAnimal);
            this.castratedAnimals.add(castratedAnimal);
        }
    }

    @Override
    public void adopt(String adoptionCenterName) {
        List<Animal> adoptedAnimals = this.adoptionCenters.get(adoptionCenterName).adopt();

        this.adoptedAnimals.addAll(adoptedAnimals);
    }

    private String getAdoptedAnimals(List<Animal> animals){
        if (animals.isEmpty()){
            return "None";
        }

        List<String> sorted = animals.stream()
                .map(Animal::getName)
                .sorted(Collator.getInstance())
                .collect(Collectors.toList());

        return String.join(", ", sorted);
    }

    private int getAwaitingCleansingCount() {
        int count = this.cleansingCenters.values()
                .stream()
                .flatMap(c -> c.getAnimals().stream())
                .collect(Collectors.toList())
                .size();

        return count;
    }

    private int getAwaitingCount() {
        int count = this.adoptionCenters.values()
                .stream()
                .flatMap(c -> c.getAnimals().stream())
                .filter(Animal::isCleansed)
                .collect(Collectors.toList())
                .size();

        return count;
    }

    @Override
    public void printStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("Paw Incorporative Regular Statistics").append(System.lineSeparator());
        sb.append(String.format("Adoption Centers: %s%n", this.adoptionCenters.size()));
        sb.append(String.format("Cleansing Centers: %s%n", this.cleansingCenters.size()));
        sb.append(String.format("Adopted Animals: %s%n", getAdoptedAnimals(this.adoptedAnimals)));
        sb.append(String.format("Cleansed Animals: %s%n", getAdoptedAnimals(this.cleansedAnimals)));
        sb.append(String.format("Animals Awaiting Adoption: %d%n", getAwaitingCount()));
        sb.append(String.format("Animals Awaiting Cleansing: %d%n", getAwaitingCleansingCount()));

        System.out.println(sb.toString());
    }

    public void printCastrationStatistics(){
        System.out.printf("Paw Inc. Regular Castration Statistics\n" +
                "Castration Centers: %s\n" +
                "Castrated Animals: %s\n",
                this.castrationCenter.size(),
                getAdoptedAnimals(this.castratedAnimals));
    }
}
