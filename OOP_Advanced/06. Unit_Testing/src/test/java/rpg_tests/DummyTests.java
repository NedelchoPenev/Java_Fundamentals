package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DummyTests {

    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int ATTACK_POINTS = 10;
    private static final int EXPECTED_HEALTH = 0;

    private Dummy dummy;
    private List<Weapon> weapons = new ArrayList<>(Arrays.asList(new Axe(10, 10), new Axe(20, 20)));

    @Before
    public void initializeTestObjects(){
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP, this.weapons);
    }

    @Test
    public void testDummyHealth(){
        this.dummy.takeAttack(ATTACK_POINTS);

        Assert.assertEquals("Wrong Health", EXPECTED_HEALTH, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummy(){
        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(1);
    }

    @Test
    public void testDeadDummyGivePointsWhenKilled() {
        this.dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals("Wrong Experience", DUMMY_XP, this.dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyNotGiveXP(){
        this.dummy.giveExperience();
    }
}
