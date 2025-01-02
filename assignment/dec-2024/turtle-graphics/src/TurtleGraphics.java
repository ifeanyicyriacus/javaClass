public class TurtleGraphics {
    private String[][] pixels;

    TurtleGraphics(String[][] pixels) {
        this.pixels = pixels;
    }

    public String[][] getPixels() {
        return pixels;
    }

    public void setPixels(String[][] pixels) {
        this.pixels = pixels;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String[] row: getPixels()){
            for (String pixel: row){
                builder.append(pixel.equals("1") ? "*": " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
