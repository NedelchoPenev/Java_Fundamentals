package app;

import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.contracts.*;
import app.waste_disposal.core.BalanceManagerImpl;
import app.waste_disposal.core.CommandInterpreterImpl;
import app.waste_disposal.core.Engine;
import app.waste_disposal.factories.Factory;
import app.waste_disposal.factories.StrategyFactory;
import app.waste_disposal.factories.WasteFactory;
import app.waste_disposal.io.ConsoleReader;
import app.waste_disposal.io.ConsoleWriter;

public class Main {

    public static void main(String[] args) {
        StrategyHolder strategyHolder = new DefaultStrategyHolder();
        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(strategyHolder);
        BalanceManager balanceManager = new BalanceManagerImpl();
        Factory<Waste> wasteFactory = new WasteFactory();
        Factory<GarbageDisposalStrategy> strategyFactory = new StrategyFactory();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(garbageProcessor, strategyHolder,balanceManager, wasteFactory, strategyFactory);
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Runnable engine = new Engine(writer, reader, commandInterpreter);
        engine.run();
    }
}
