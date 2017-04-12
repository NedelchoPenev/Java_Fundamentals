package lab.contracts;

public interface AttackGroup {

    void addMember(Attacker attacker);

    void groupTarget(ObservableTarget target);

    void groupAttack();

}
