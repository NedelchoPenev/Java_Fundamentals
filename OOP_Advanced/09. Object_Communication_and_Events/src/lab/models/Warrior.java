package lab.models;

import lab.contracts.Handler;
import lab.contracts.ObservableTarget;
import lab.enums.LogType;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    private Handler handler;

    public Warrior(String id, int dmg, Handler handler) {
        super(id, dmg, handler);
    }

    @Override
    protected void executeClassSpecificAttack(Handler handler, ObservableTarget target, int dmg) {
        handler.handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));

        target.receiveDamage(dmg);
    }

}
