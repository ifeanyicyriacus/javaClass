package enums;

import org.junit.jupiter.api.Test;

import static enums.NigeriaStateGeoPoliticalZones.*;
import static enums.NigeriaStateGeoPoliticalZonesFunctions.getGeoPoliticalZoneByState;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestNigeriaStateGeoPoliticalZonesFunctions {
    private final String state1     = "Imo";
    private final String state2     = "Nasarawa";
    private final String state3     = "Taraba";
    private final String state4     = "Kebbi";
    private final String state5     = "Akwa-Ibom";
    private final String state6     = "Lagos";
    private final String wrongState = "New York";

    @Test
    void testNigeriaStateGeoPoliticalZonesFunctionsReturnCorrectZoneValue() {
        assertEquals(SOUTH_EAST, getGeoPoliticalZoneByState(state1));
        assertEquals(NORTH_CENTRAL, getGeoPoliticalZoneByState(state2));
        assertEquals(NORTH_EAST, getGeoPoliticalZoneByState(state3));
        assertEquals(NORTH_WEST, getGeoPoliticalZoneByState(state4));
        assertEquals(SOUTH_SOUTH, getGeoPoliticalZoneByState(state5));
        assertEquals(SOUTH_WEST, getGeoPoliticalZoneByState(state6));
    }

    @Test
    void testNigeriaStateGeoPoliticalZonesFunctionsThrowsExceptionForWrongState() {
        assertThrows(IllegalArgumentException.class, () -> getGeoPoliticalZoneByState(wrongState));
    }

    @Test
    void testNigeriaStateGeoPoliticalZonesFunctionsReturnCorrectZoneAsReadableString() {
        assertEquals("South-East", getGeoPoliticalZoneByState(state1).toString());
        assertEquals("North-Central", getGeoPoliticalZoneByState(state2).toString());
        assertEquals("North-East", getGeoPoliticalZoneByState(state3).toString());
        assertEquals("North-West", getGeoPoliticalZoneByState(state4).toString());
        assertEquals("South-South", getGeoPoliticalZoneByState(state5).toString());
        assertEquals("South-West", getGeoPoliticalZoneByState(state6).toString());
    }
}
