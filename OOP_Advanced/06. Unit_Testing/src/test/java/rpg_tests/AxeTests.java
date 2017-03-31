package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AxeTests {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_DURABILITY = 9;

    private Axe axe;
    private Target dummy;
    private List<Weapon> weapons;

    @Before
    public void initializeTestObjects(){
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.weapons = new ArrayList<>(Arrays.asList(new Axe(10, 10), new Axe(20, 20)));
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP, this.weapons);
    }

    @Test
    public void weaponAttackLosesDurability(){
        this.axe.attack(this.dummy);

        Assert.assertEquals("Wrong Durability", EXPECTED_DURABILITY, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack(){
        while (this.axe.getDurabilityPoints() > 0) {
            this.axe.attack(this.dummy);
        }
    }
}
