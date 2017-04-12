package lab;

import lab.commands.*;
import lab.contracts.*;
import lab.controllers.*;
import lab.mediator.Group;
import lab.models.Dragon;
import lab.models.Warrior;

public class Main {

    public static void main(String[] args) {
        Logger combatLogger = new CombatLogger();
        Logger targetLogger = new TargetLogger();
        Logger errorLogger = new ErrorLogger();
        Logger eventLogger = new EventLogger();

        combatLogger.setSuccessor(targetLogger);
        targetLogger.setSuccessor(errorLogger);
        errorLogger.setSuccessor(eventLogger);

        AttackGroup group = new Group();
        Attacker attacker = new Warrior("Warrior", 10, combatLogger);
        Attacker attacker1 = new Warrior("Gosho", 21, combatLogger);
        group.addMember(attacker);
        group.addMember(attacker1);

        ObservableTarget target = new Dragon("Dragon", 15, 25, combatLogger);

        Command targetCommand = new GroupTargetCommand(group, target);
        Command attackCommand = new GroupAttackCommand(group);

        Executor executor = new CommandExecutor();
        executor.executeCommand(targetCommand);
        executor.executeCommand(attackCommand);
    }
}
