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
        if (promptChar[7].equals("1")) {
            setA(promptChar[0].equals("1"));
            setB(promptChar[1].equals("1"));
            setC(promptChar[2].equals("1"));
            setD(promptChar[3].equals("1"));
            setE(promptChar[4].equals("1"));
            setF(promptChar[5].equals("1"));
            setG(promptChar[6].equals("1"));
        }
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
        for (int i = 2; i < 5; i++) {
            display[i][3] = state ? token: display[i][3];
        }
    }

    private void setD(boolean state) {
        for (int i = 3; i >= 0; i--) {
            display[4][i] = state ? token: display[4][i];
        }
    }

    private void setE(boolean state) {
        for (int i = 4; i >= 2; i--){
            display[i][0] = state ? token: display[i][0];
        }
    }

    private void setF(boolean state) {
        for (int i = 2; i >= 0; i--) {
            display[i][0] = state ? token: display[i][0];
        }
    }

    private void setG(boolean state) {
        for (int i = 0; i < 4; i++) {
            display[2][i] = state ? token: display[2][i];
        }
    }

    private void setDisplayBlank() {
        for (String[] row : display) {
            Arrays.fill(row, " ");
        }
    }

    public String[][] getDisplay() {
        return display;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        Arrays.stream(display).forEach(rows -> {
            Arrays.stream(rows).forEach(result::append);
            result.append("\n");
        });
        return result.toString();
    }
}
