package seven.segment.display;

import java.util.Arrays;

public class SevenSegmentDisplay {

    private final String[][] display = new String[5][4];

    private final String token = "#";

    public void enterPrompt(String prompt) {
        setSegmentsValue(prompt);
    }

    private void setSegmentsValue(String prompt) {
        var promptChar = prompt.split("");
        setDisplayBlank();
        setA(promptChar[0].equals("1"));
        setB(promptChar[1].equals("1"));
        setC(promptChar[2].equals("1"));
        setD(promptChar[3].equals("1"));
        setE(promptChar[4].equals("1"));
        setF(promptChar[5].equals("1"));
        setG(promptChar[6].equals("1"));
        toggleDisplayOnOrOff(promptChar[7].equals("1"));
    }

    private void setA(boolean state) {
        for (int i = 0; i < 4; i++) {
            display[0][i] = state ? token: display[0][i];
        }
    }

    private void setB(boolean state) {
        for (int i = 0; i < 3; i++) {
            display[i][3] = state ? token: display[i][3];
        }
    }

    private void setC(boolean state) {
        display[2][3] = state ? token: display[2][3];
        display[3][3] = state ? token: display[3][3];
        display[4][3] = state ? token: display[4][3];
    }

    private void setD(boolean state) {
        display[4][3] = state ? token: display[4][3];
        display[4][2] = state ? token: display[4][2];
        display[4][1] = state ? token: display[4][1];
        display[4][0] = state ? token: display[4][0];
    }

    private void setE(boolean state) {
        display[4][0] = state ? token: display[4][0];
        display[3][0] = state ? token: display[3][0];
        display[2][0] = state ? token: display[2][0];
    }

    private void setF(boolean state) {
        display[2][0] = state ? token: display[2][0];
        display[1][0] = state ? token: display[1][0];
        display[0][0] = state ? token: display[0][0];
    }

    private void setG(boolean state) {
        display[2][0] = state ? token: display[2][0];
        display[2][1] = state ? token: display[2][1];
        display[2][2] = state ? token: display[2][2];
        display[2][3] = state ? token: display[2][3];
    }

    private void toggleDisplayOnOrOff(boolean state) {
        if (!state) {
            setDisplayBlank();
        }
    }

    private void setDisplayBlank() {
        for (String[] strings : display) {
            Arrays.fill(strings, " ");
        }
    }

    public String[][] getDisplay() {
        return display;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (String[] rows : display) {
            for (String cell : rows) {
                sb.append(cell);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
