package lab.commands;

import lab.contracts.AttackGroup;
import lab.contracts.Command;
import lab.contracts.ObservableTarget;

public class GroupTargetCommand implements Command {

    private AttackGroup attackGroup;
    private ObservableTarget target;

    public GroupTargetCommand(AttackGroup attackGroup, ObservableTarget target) {
        this.attackGroup = attackGroup;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attackGroup.groupTarget(this.target);
    }
}
