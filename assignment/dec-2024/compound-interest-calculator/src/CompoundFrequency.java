public enum CompoundFrequency {
    DAILY(365),
    MONTHLY(12),
    QUARTERLY(4),
    SEMIANNUALLY(2),
    ANNUALLY(1);


    private final int frequency;

    CompoundFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }
}