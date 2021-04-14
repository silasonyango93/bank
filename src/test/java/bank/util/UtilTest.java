package bank.util;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UtilTest {

    @Test
    public void isTodayTest() {

        Date dateToday = null;
        Calendar calendar = Calendar.getInstance();
        dateToday = calendar.getTime();
        assertTrue(Util.isToday(dateToday));

    }
}
