package p10_Tire_Pressure_Monitoring_System_Tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import p10_Tire_Pressure_Monitoring_System.Alarm;
import p10_Tire_Pressure_Monitoring_System.Sensor;

import java.lang.reflect.Field;

public class Alarm_Tests {

    private static final double NORMAL_PSI = 18.0;
    private static final double LOW_PSI = 16.0;
    private static final double HIGH_PSI = 22.01;
    public static final String SENSOR_FIELD_NAME = "sensor";

    @Test
    public void alarmIsOff() throws NoSuchFieldException, IllegalAccessException {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PSI);

        Alarm alarm = new Alarm();

        Field fieldSensor = Alarm.class.getDeclaredField(SENSOR_FIELD_NAME);
        fieldSensor.setAccessible(true);
        fieldSensor.set(alarm, sensor);

        alarm.check();
        boolean isAlarmOff = alarm.getAlarmOn();

        Assert.assertFalse(isAlarmOff);
    }

    @Test
    public void alarmIsOnWhenValueIsLow() throws NoSuchFieldException, IllegalAccessException {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PSI);

        Alarm alarm = new Alarm();

        Field fieldSensor = Alarm.class.getDeclaredField(SENSOR_FIELD_NAME);
        fieldSensor.setAccessible(true);
        fieldSensor.set(alarm, sensor);

        alarm.check();
        boolean isAlarmOff = alarm.getAlarmOn();

        Assert.assertTrue(isAlarmOff);
    }

    @Test
    public void alarmIsOnWhenValueIsHigh() throws IllegalAccessException, NoSuchFieldException {
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PSI);

        Alarm alarm = new Alarm();

        Field fieldSensor = Alarm.class.getDeclaredField(SENSOR_FIELD_NAME);
        fieldSensor.setAccessible(true);
        fieldSensor.set(alarm, sensor);

        alarm.check();
        boolean isAlarmOff = alarm.getAlarmOn();

        Assert.assertTrue(isAlarmOff);
    }
}
