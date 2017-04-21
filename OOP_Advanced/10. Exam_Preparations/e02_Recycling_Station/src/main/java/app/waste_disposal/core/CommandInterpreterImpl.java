package app.waste_disposal.core;

import app.waste_disposal.contracts.*;
import app.waste_disposal.factories.Factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private GarbageProcessor garbageProcessor;
    private StrategyHolder strategyHolder;
    private BalanceManager balanceManager;
    private Factory<Waste> wasteFactory;
    private Factory<GarbageDisposalStrategy> strategyFactory;
    private ManagementRequirement managementRequirement;

    public CommandInterpreterImpl(GarbageProcessor garbageProcessor, StrategyHolder strategyHolder, BalanceManager
            balanceManager, Factory<Waste> wasteFactory, Factory<GarbageDisposalStrategy> strategyFactory) {
        this.garbageProcessor = garbageProcessor;
        this.strategyHolder = strategyHolder;
        this.balanceManager = balanceManager;
        this.wasteFactory = wasteFactory;
        this.strategyFactory = strategyFactory;
    }

    @Override
    public String processCommands(String command, String[] input) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        switch (command) {
            case "ProcessGarbage":
                String[] params = input[1].split("[\\s|\\|]+");
                String name = params[0];
                double weight = Double.valueOf(params[1]);
                String type = params[params.length -1];

                if (this.managementRequirement != null && this.managementRequirement.getType().equals(type) && (this.balanceManager.getEnergy() < this.managementRequirement.getEnergy() || this.balanceManager.getCapital() < this.managementRequirement.getCapital())){
                    return "Processing Denied!";
                } else {
                    Waste garbage = addStrategy(params);
                    ProcessingData data = this.garbageProcessor.processWaste(garbage);
                    this.balanceManager.processData(data);
                    return String.format("%.2f kg of %s successfully processed!", weight, name);
                }
            case "Status":
                return String.format("Energy: %.2f Capital: %.2f", this.balanceManager.getEnergy(), this
                        .balanceManager.getCapital());
            case "ChangeManagementRequirement":
                String[] paramsForCMR = input[1].split("\\|");
                double energy = Double.valueOf(paramsForCMR[0]);
                double capital = Double.valueOf(paramsForCMR[1]);
                String typeForCMR = paramsForCMR[paramsForCMR.length -1];

                this.managementRequirement = new ManagementRequirementImpl(energy, capital, typeForCMR);
                return "Management requirement changed!";
            default:
                return "Invalid command";
        }
    }

    private Waste addStrategy(String[] params) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Waste garbage = this.wasteFactory.create(params);

        Class aClass = garbage.getClass();
        Annotation annotation = aClass.getAnnotations()[0];
        Class garbageClass = annotation.annotationType();

        GarbageDisposalStrategy strategy = this.strategyFactory.create(params);

        this.strategyHolder.addStrategy(garbageClass, strategy);
        return garbage;
    }
}
