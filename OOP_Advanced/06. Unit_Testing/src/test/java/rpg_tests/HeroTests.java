package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.RandomProvider;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTests {

    private static final int GIVE_XP = 10;

    @Test
    public void heroGainsXPWhenTargetDie() {
        Weapon weapon = Mockito.mock(Weapon.class);
        Hero hero = new Hero("Hero", weapon);

        Target mockTarget = Mockito.mock(Target.class);
        Mockito.when(mockTarget.isDead()).thenReturn(true);
        Mockito.when(mockTarget.giveExperience()).thenReturn(GIVE_XP);

        hero.attack(mockTarget, new RandomProvider.Implementation());
        Assert.assertEquals(GIVE_XP, hero.getExperience());
    }
}
