package lab.commands;

import lab.contracts.Attacker;
import lab.contracts.Command;
import lab.contracts.ObservableTarget;

public class TargetCommand implements Command {

    private ObservableTarget target;
    private Attacker attacker;

    public TargetCommand(Attacker attacker, ObservableTarget target) {
        this.target = target;
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
        this.attacker.attack();
    }
}
