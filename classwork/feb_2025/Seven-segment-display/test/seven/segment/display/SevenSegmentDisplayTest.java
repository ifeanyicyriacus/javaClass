package seven.segment.display;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SevenSegmentDisplayTest {
    SevenSegmentDisplay display;
    final String ZERO_PROMPT    = "11111101";
    final String ONE_PROMPT     = "01100001";
    final String TWO_PROMPT     = "11011011";
    final String THREE_PROMPT   = "11110011";
    final String FOUR_PROMPT    = "01100111";
    final String FIVE_PROMPT    = "10110111";
    final String SIX_PROMPT     = "10111111";
    final String SEVEN_PROMPT   = "11100001";
    final String EIGHT_PROMPT   = "11111111";
    final String NINE_PROMPT    = "11100111";
    final String BLANK_PROMPT   = "11110110";

    final String[][] ZERO = {
            {"#", "#", "#", "#"},
            {"#", " ", " ", "#"},
            {"#", " ", " ", "#"},
            {"#", " ", " ", "#"},
            {"#", "#", "#", "#"},};

    final String[][] ONE = {
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},};

    final String[][] TWO = {
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {"#", "#", "#", "#"},
            {"#", " ", " ", " "},
            {"#", "#", "#", "#"},};

    final String[][] THREE = {
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {"#", "#", "#", "#"},};

    final String[][] FOUR = {
            {"#", " ", " ", "#"},
            {"#", " ", " ", "#"},
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},};

    final String[][] FIVE = {
            {"#", "#", "#", "#"},
            {"#", " ", " ", " "},
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {"#", "#", "#", "#"},};

    final String[][] SIX = {
            {"#", "#", "#", "#"},
            {"#", " ", " ", " "},
            {"#", "#", "#", "#"},
            {"#", " ", " ", "#"},
            {"#", "#", "#", "#"},};

    final String[][] SEVEN = {
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},};

    final String[][] EIGHT = {
            {"#", "#", "#", "#"},
            {"#", " ", " ", "#"},
            {"#", "#", "#", "#"},
            {"#", " ", " ", "#"},
            {"#", "#", "#", "#"},};

    final String[][] NINE = {
            {"#", "#", "#", "#"},
            {"#", " ", " ", "#"},
            {"#", "#", "#", "#"},
            {" ", " ", " ", "#"},
            {" ", " ", " ", "#"},};

    final String[][] BLANK = {
            {" ", " ", " ", " "},
            {" ", " ", " ", " "},
            {" ", " ", " ", " "},
            {" ", " ", " ", " "},
            {" ", " ", " ", " "},};

    @BeforeEach
    public void setUp() {
        display = new SevenSegmentDisplay();
    }

    @Test
    public void testDisplayIsBlankWhenBlankPromptIsGiven() {
        display.enterPrompt(BLANK_PROMPT);
        String[][] actual = display.getDisplay();
        System.out.println(display);
        assertArrayEquals(BLANK, actual);
    }

    @Test
    public void testDisplayIsZeroWhenZeroPromptIsGiven() {
        display.enterPrompt(ZERO_PROMPT);
        String[][] actual = display.getDisplay();
        System.out.println(display);
        assertArrayEquals(ZERO, actual);
    }

    @Test
    public void testDisplayIsOneWhenOnePromptIsGiven() {
        display.enterPrompt(ONE_PROMPT);
        String[][] actual = display.getDisplay();
        System.out.println(display);
        assertArrayEquals(ONE, actual);
    }

    @Test
    public void testDisplayIsTwoWhenTwoPromptIsGiven() {
        display.enterPrompt(TWO_PROMPT);
        String[][] actual = display.getDisplay();
        System.out.println(display);
        assertArrayEquals(TWO, actual);
    }

    @Test
    public void testDisplayIsThreeWhenThreePromptIsGiven() {
        display.enterPrompt(THREE_PROMPT);
        String[][] actual = display.getDisplay();
        System.out.println(display);
        assertArrayEquals(THREE, actual);
    }

    @Test
    public void testDisplayIsFourWhenFourPromptIsGiven() {
        display.enterPrompt(FOUR_PROMPT);
        String[][] actual = display.getDisplay();
        System.out.println(display);
        assertArrayEquals(FOUR, actual);
    }

    @Test
    public void testDisplayIsFiveWhenFivePromptIsGiven() {
        display.enterPrompt(FIVE_PROMPT);
        String[][] actual = display.getDisplay();
        System.out.println(display);
        assertArrayEquals(FIVE, actual);
    }

    @Test
    public void testDisplayIsSixWhenSixPromptIsGiven() {
        display.enterPrompt(SIX_PROMPT);
        String[][] actual = display.getDisplay();
        System.out.println(display);
        assertArrayEquals(SIX, actual);
    }

    @Test
    public void testDisplayIsSevenWhenSevenPromptIsGiven() {
        display.enterPrompt(SEVEN_PROMPT);
        String[][] actual = display.getDisplay();
        System.out.println(display);
        assertArrayEquals(SEVEN, actual);
    }

    @Test
    public void testDisplayIsEightWhenEightPromptIsGiven() {
        display.enterPrompt(EIGHT_PROMPT);
        String[][] actual = display.getDisplay();
        System.out.println(display);
        assertArrayEquals(EIGHT, actual);
    }

    @Test
    public void testDisplayIsNineWhenNinePromptIsGiven() {
        display.enterPrompt(NINE_PROMPT);
        String[][] actual = display.getDisplay();
        System.out.println(display);
        assertArrayEquals(NINE, actual);
    }
}
