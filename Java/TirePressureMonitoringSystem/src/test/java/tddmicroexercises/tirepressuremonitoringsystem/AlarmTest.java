package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class AlarmTest {

    @Test
    public void foo() {
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmPressureIsTooLow() {
        //WHEN
        when(mockSensor.popNextPressurePsiValue()).thenReturn(16.0);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmPressureIsTooHigh() {
        //WHEN
        when(mockSensor.popNextPressurePsiValue()).thenReturn(22.0);
        alarm.check();
        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void testAlarmPressureIsNormal() {
        //WHEN
        when(mockSensor.popNextPressurePsiValue()).thenReturn(18.0);
        alarm.check();
        assertFalse(alarm.isAlarmOn());
    }
}
