package lab.commands;

import lab.contracts.AttackGroup;
import lab.contracts.Command;

public class GroupAttackCommand implements Command {

    private AttackGroup attacker;

    public GroupAttackCommand(AttackGroup attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.groupAttack();
    }
}
