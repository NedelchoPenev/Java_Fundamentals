import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class p09_Zoned_Date_Time_Tests {

    @Test
    public void testSomething() {
        ZonedDateTime zonedDateTime = Mockito.mock(ZonedDateTime.class);
        ZonedDateTime time = ZonedDateTime.of(2017, 6, 16, 0, 0, 0, 0, ZoneId.systemDefault());
        Mockito.when(zonedDateTime.now()).thenReturn(time);

        ZonedDateTime currentTime = time.plusDays(1);
        ZonedDateTime expectedValue = ZonedDateTime.of(2017, 6, 17, 0, 0, 0, 0, ZoneId.systemDefault());

        Assert.assertEquals(currentTime, expectedValue);
    }

}
