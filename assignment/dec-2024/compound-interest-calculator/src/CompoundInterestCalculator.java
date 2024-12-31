import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CompoundInterestCalculator {
    private BigDecimal initialInvestment;
    private BigDecimal monthlyContribution;
    private int        durationInYears;
    private BigDecimal estimatedInterestRate;
    private int          compoundFrequency;
    private BigDecimal[] yearlyChangesInInvestmentValue;

    public CompoundInterestCalculator(BigDecimal initialInvestment, BigDecimal monthlyContribution,
                                      int durationInYears, BigDecimal estimatedInterestRate, int compoundFrequency) {
        setInitialInvestment(initialInvestment);
        setMonthlyContribution(monthlyContribution);
        setDurationInYears(durationInYears);
        setEstimatedInterestRate(estimatedInterestRate);
        setCompoundFrequency(compoundFrequency);
        setYearlyChangesInInvestmentValue(new BigDecimal[durationInYears]);
    }

    public BigDecimal getInitialInvestment() {
        return initialInvestment;
    }
    public void setInitialInvestment(BigDecimal initialInvestment) {
        this.initialInvestment = initialInvestment;
    }

    public BigDecimal getMonthlyContribution() {
        return monthlyContribution;
    }
    public void setMonthlyContribution(BigDecimal monthlyContribution) { this.monthlyContribution = monthlyContribution; }

    public int getDurationInYears() {
        return durationInYears;
    }
    public void setDurationInYears(int durationInYears) {
        this.durationInYears = durationInYears;
    }

    public BigDecimal getEstimatedInterestRate() {
        return estimatedInterestRate;
    }
    public void setEstimatedInterestRate(BigDecimal estimatedInterestRate) {
        this.estimatedInterestRate = estimatedInterestRate.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
    }

    public int getCompoundFrequency() { return compoundFrequency; }
    public void setCompoundFrequency(int compoundFrequency) { this.compoundFrequency = compoundFrequency; }

    public BigDecimal[] getYearlyChangesInInvestmentValue() { return yearlyChangesInInvestmentValue; }
    public void setYearlyChangesInInvestmentValue(BigDecimal[] yearlyChangesInInvestmentValue) { this.yearlyChangesInInvestmentValue = yearlyChangesInInvestmentValue; }


    public BigDecimal calculateCompoundInterest() {
        BigDecimal pv = getInitialInvestment();
        BigDecimal pmt = getMonthlyContribution();
        int t = getDurationInYears();
        BigDecimal r = getEstimatedInterestRate();
        int n = getCompoundFrequency();
        MathContext mathContext = new MathContext(28, RoundingMode.HALF_UP);

        BigDecimal[] values = getYearlyChangesInInvestmentValue();
        //int yearsIndex = getDurationInYears() - 1;
        for (int year = 1; year <= t; year++ ) {
            values[year - 1] = calculateCompoundInterestOnPrincipal(pv, year, r, n, mathContext).
                            add(calculateCompoundInterestOnMonthlyDeposits(pmt, year, r, n, mathContext));
        }
        setYearlyChangesInInvestmentValue(values);
        return values[t-1];
    }

    private BigDecimal calculateCompoundInterestOnPrincipal(BigDecimal pv, int yearNumber, BigDecimal r, int n, MathContext mathContext) {
        BigDecimal temp = BigDecimal.ONE.add(r.divide(BigDecimal.valueOf(n), mathContext));
        temp = temp.pow(n * yearNumber);
        return pv.multiply(temp);
    }

    private BigDecimal calculateCompoundInterestOnMonthlyDeposits(BigDecimal pmt, int yearNumber, BigDecimal r, int n, MathContext mathContext) {
        final BigDecimal periodicInterestRate = r.divide(BigDecimal.valueOf(n), mathContext);

        BigDecimal temp = BigDecimal.ONE.add(periodicInterestRate);
        temp = (temp.pow(yearNumber * n)).subtract(BigDecimal.ONE);
        temp = temp.divide(periodicInterestRate, mathContext);
        //since pmt is monthly
        switch (n) {
            case 1 -> pmt = pmt.multiply(BigDecimal.valueOf(12));
            case 2 -> pmt = pmt.multiply(BigDecimal.valueOf(6));
            case 4 -> pmt = pmt.multiply(BigDecimal.valueOf(3));
            case 365 -> pmt = pmt.divide(BigDecimal.valueOf(30), mathContext);
        }
        return pmt.multiply(temp);
    }

}
