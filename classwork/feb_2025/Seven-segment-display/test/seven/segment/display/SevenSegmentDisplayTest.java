package seven.segment.display;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SevenSegmentDisplayTest {
    SevenSegmentDisplay display;

    final String ZERO_PROMPT = "11111101";
    final String[][] ZERO = {
            {"#", "#", "#", "#"},
            {"#", " ", " ", "#"},
            {"#", " ", " ", "#"},
            {"#", " ", " ", "#"},
            {"#", "#", "#", "#"},
    };

    final String ONE_PROMPT = "";
    final String[][] ONE = {
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
    };

    final String TWO_PROMPT = "";
    final String[][] TWO = {
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {"#", "#", "#", "#"},
            {"#", " ", " ", " "},
            {"#", "#", "#", "#"},
    };

    final String THREE_PROMPT = "";
    final String[][] THREE = {
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {"#", "#", "#", "#"},
    };

    final String FOUR_PROMPT = "";
    final String[][] FOUR = {
            {"#", " ", " ", "#"},
            {"#", " ", " ", "#"},
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
    };

    final String FIVE_PROMPT = "";
    final String[][] FIVE = {
            {"#", "#", "#", "#"},
            {"#", " ", " ", " "},
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {"#", "#", "#", "#"},
    };

    final String SIX_PROMPT = "";
    final String[][] SIX = {
            {"#", "#", "#", "#"},
            {"#", " ", " ", " "},
            {"#", "#", "#", "#"},
            {"#", " ", " ", "#"},
            {"#", "#", "#", "#"},
    };

    final String SEVEN_PROMPT = "";
    final String[][] SEVEN = {
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
    };

    final String EIGHT_PROMPT = "";
    final String[][] EIGHT = {
            {"#", "#", "#", "#"},
            {"#", " ", " ", "#"},
            {"#", "#", "#", "#"},
            {"#", " ", " ", "#"},
            {"#", "#", "#", "#"},
    };

    final String NINE_PROMPT = "";
    final String[][] NINE = {
            {"#", "#", "#", "#"},
            {"#", " ", " ", "#"},
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
    };





    @BeforeEach
    public void setUp() {
        display = new SevenSegmentDisplay();
    }

    @Test


}
