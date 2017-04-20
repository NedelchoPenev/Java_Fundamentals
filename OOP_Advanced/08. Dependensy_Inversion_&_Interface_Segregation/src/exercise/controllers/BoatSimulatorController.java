package exercise.controllers;

import exercise.contracts.IBoatSimulatorController;
import exercise.contracts.Race;
import exercise.contracts.Sailable;
import exercise.database.BoatSimulatorDatabase;
import exercise.enumeration.EngineType;
import exercise.exeptions.*;
import exercise.models.boats.PowerBoat;
import exercise.models.boats.RowBoat;
import exercise.models.boats.SailBoat;
import exercise.models.boats.Yacht;
import exercise.models.engines.BaseEngine;
import exercise.models.engines.JetEngine;
import exercise.models.engines.SterndriveEngine;
import exercise.models.race.RaceImpl;
import exercise.utility.Constants;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class BoatSimulatorController implements IBoatSimulatorController {

    private BoatSimulatorDatabase database;
    private Race currentRace;
    //private Map<Sailable, Double> winners;

    public BoatSimulatorController() {
        this.database = new BoatSimulatorDatabase();
        this.currentRace = null;
        //this.winners = new LinkedHashMap<>();
    }

    @Override
    public BoatSimulatorDatabase getDatabase() {
        return this.database;
    }

    @Override
    public Race getCurrentRace() {
        return this.currentRace;
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        BaseEngine engine;
        switch (engineType) {
            case Jet:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case Sterndrive:
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
            default:
                throw new NotImplementedException();
        }

        this.database.getEngines().add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Sailable boat = new RowBoat(model, weight, oars);
        this.database.getBoats().add(boat);
        return "Row boat with model " + boat.getModel() + " registered successfully.";
    }

    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Sailable boat = new SailBoat(model, weight, sailEfficiency);
        this.database.getBoats().add(boat);
        return "Sail boat with model " + boat.getModel() + " registered successfully.";
    }

    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        List<BaseEngine> engines = new ArrayList<>();
        engines.add(this.database.getEngines().getItem(firstEngineModel));
        engines.add(this.database.getEngines().getItem(secondEngineModel));
        Sailable boat = new PowerBoat(model, weight, engines);
        this.database.getBoats().add(boat);
        return "Power boat with model " + boat.getModel() + " registered successfully.";
    }

    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        BaseEngine engine = this.database.getEngines().getItem(engineModel);
        Sailable boat = new Yacht(model, weight, cargoWeight, engine);
        this.database.getBoats().add(boat);
        return "Yacht with model " + boat.getModel() + " registered successfully.";
    }

    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        Race race = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.ValidateRaceIsEmpty();
        this.currentRace = race;
        return
                String.format(
                        "A new race with distance %s meters, wind speed %s m/s and ocean current speed %s m/s has been set.",
                        distance, windSpeed, oceanCurrentSpeed);
    }

    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Sailable boat = this.database.getBoats().getItem(model);
        this.ValidateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats() && boat.isMotorBoat()) {
            throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
        }
        this.currentRace.addParticipant(boat);
        return "Boat with model " + model + " has signed up for the current Race.";
    }

    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.ValidateRaceIsSet();
        Map<Sailable, Double> winners = this.currentRace.getParticipants();
        if (winners.size() < 3) {
            throw new InsufficientContestantsException(Constants.InsufficientContestantsMessage);
        }

        winners = winners.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .limit(3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder result = new StringBuilder();
        List<String> places = Arrays.asList("First", "Second", "Third");
        Iterator<String> nextIndex = places.iterator();
        for (Map.Entry<Sailable, Double> boat : winners.entrySet()) {
            result.append(String.format("%s place: %s Model: %s Time: %s%n",
                    nextIndex.next(),
                    boat.getKey().getClass().getSimpleName(),
                    boat.getKey().getModel(),
                    isFinished(boat.getValue())));
        }

        this.currentRace = null;

        return result.toString().trim();
    }

    private String isFinished(Double key) {
        if (key == Double.MAX_VALUE) {
            return "Did not finish!";
        }
        return String.format("%.2f sec", key);
    }

    @Override
    public String getStatistic() {
        double participants = this.currentRace.getParticipants().size();
        double powerBoatPercentage = this.currentRace.getParticipants().keySet().stream()
                .filter(p -> p.getClass().getSimpleName().contains("Power")).count() / participants * 100;
        double rowBoatPercentage = this.currentRace.getParticipants().keySet().stream()
                .filter(p -> p.getClass().getSimpleName().contains("Row")).count() / participants * 100;
        double sailBoatPercentage = this.currentRace.getParticipants().keySet().stream()
                .filter(p -> p.getClass().getSimpleName().contains("Sail")).count() / participants * 100;
        double yachtBoatPercentage = this.currentRace.getParticipants().keySet().stream()
                .filter(p -> p.getClass().getSimpleName().contains("Yacht")).count() / participants * 100;

        return String.format("PowerBoat -> %.2f%% %nRowBoat -> %.2f%% %nSailBoat -> %.2f%% %nYacht -> %.2f%%",
                powerBoatPercentage, rowBoatPercentage, sailBoatPercentage, yachtBoatPercentage);
    }

    private void ValidateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }
    }

    private void ValidateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }
    }
}
