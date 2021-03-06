package p10_Tire_Pressure_Monitoring_System_Tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import p10_Tire_Pressure_Monitoring_System.Sensor;

import java.util.Random;

public class Sensor_Tests {

    private static final int OFFSET = 16;
    public static final double ZERO_ADDITION = 0.0;

    @Test
    public void testSensorClass(){
        Sensor sensor = new Sensor();

        double psi = sensor.popNextPressurePsiValue();

        Assert.assertTrue(psi > OFFSET);
    }

    @Test
    public void testSensorClassRandomNumber(){
        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextDouble()).thenReturn(ZERO_ADDITION);
        Sensor sensor = new Sensor();

        int psi = (int) sensor.popNextPressurePsiValue();

        Assert.assertEquals(OFFSET, psi);
    }
}
