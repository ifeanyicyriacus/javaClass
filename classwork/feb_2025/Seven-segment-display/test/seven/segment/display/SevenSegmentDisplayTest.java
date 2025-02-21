package seven.segment.display;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SevenSegmentDisplayTest {
    SevenSegmentDisplay display;
    @BeforeEach
    public void setUp() {
        display = new SevenSegmentDisplay();
    }

    @Test
    public void testDisplayDoesNotDisplayAnythingAfterCreation() {
//        String expected = """
//                ####
//                #  #
//                ####
//                #  #
//                ####
//                """;

        String expected = """
                    
                    
                        
                    
                """;
        String actual  = display.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testReceiveInputReturnsAnArrayOfIntBetween0and1ForCorrectInput() {
//        dei

    }

}
