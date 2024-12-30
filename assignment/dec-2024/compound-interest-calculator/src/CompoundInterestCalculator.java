import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CompoundInterestCalculator {
    private BigDecimal initialInvestment;
    private BigDecimal monthlyContribution;
    private int        durationInYears;
    private BigDecimal estimatedInterestRate;
    private int          compoundFrequency;
    private BigDecimal[] yearlyChangesInInvestmentValue = new BigDecimal[durationInYears];

    public CompoundInterestCalculator(BigDecimal initialInvestment, BigDecimal monthlyContribution,
                                      int durationInYears, BigDecimal estimatedInterestRate, int compoundFrequency) {
        setInitialInvestment(initialInvestment);
        setMonthlyContribution(monthlyContribution);
        setDurationInYears(durationInYears);
        setEstimatedInterestRate(estimatedInterestRate);
        setCompoundFrequency(compoundFrequency);
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
        return calculateCompoundInterestOnPrincipal().add(calculateCompoundInterestOnMonthlyDeposits());
    }
    private BigDecimal calculateCompoundInterestOnPrincipal(){
        MathContext mathContext = new MathContext(28, RoundingMode.HALF_UP);
        return getInitialInvestment().multiply(BigDecimal.ONE.add((getEstimatedInterestRate().divide(BigDecimal.valueOf(getCompoundFrequency()), mathContext))).pow(getCompoundFrequency() * getDurationInYears()));
    }
    private BigDecimal calculateCompoundInterestOnMonthlyDeposits(){
        return BigDecimal.ZERO;
    }

}
