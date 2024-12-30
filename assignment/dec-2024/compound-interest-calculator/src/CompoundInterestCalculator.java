import java.math.BigDecimal;

public class CompoundInterestCalculator {
    private BigDecimal initialInvestment;
    private BigDecimal monthlyContribution;
    private int        durationInYears;
    private BigDecimal estimatedInterestRate;
    private BigDecimal interestRateVarianceRange;
    private int        compoundFrequency;

    public CompoundInterestCalculator(BigDecimal initialInvestment, BigDecimal monthlyContribution,
                                      int durationInYears, BigDecimal estimatedInterestRate,
                                      BigDecimal interestRateVarianceRange, int compoundFrequency) {
        setInitialInvestment(initialInvestment);
        setMonthlyContribution(monthlyContribution);
        setDurationInYears(durationInYears);
        setEstimatedInterestRate(estimatedInterestRate);
        setInterestRateVarianceRange(interestRateVarianceRange);
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
    public void setEstimatedInterestRate(BigDecimal estimatedInterestRate) { this.estimatedInterestRate = estimatedInterestRate; }

    public BigDecimal getInterestRateVarianceRange() {
        return interestRateVarianceRange;
    }
    public void setInterestRateVarianceRange(BigDecimal interestRateVarianceRange) { this.interestRateVarianceRange = interestRateVarianceRange; }

    public int getCompoundFrequency() { return compoundFrequency; }
    public void setCompoundFrequency(int compoundFrequency) { this.compoundFrequency = compoundFrequency; }

    public BigDecimal calculateCompoundInterest() {
        return calculateCompoundInterestOnPrincipal().add(calculateCompoundInterestOnMonthlyDeposits());
    }
    private BigDecimal calculateCompoundInterestOnPrincipal(){
        return getInitialInvestment().multiply(BigDecimal.ONE.add((getEstimatedInterestRate().divide(BigDecimal.valueOf(getCompoundFrequency())))).pow(getCompoundFrequency() * getDurationInYears()));
    }
    private BigDecimal calculateCompoundInterestOnMonthlyDeposits(){
        return BigDecimal.ZERO;
    }

//    A = P (1 + r/n)^(nt) + ∑[PMT × ((1 + r/n)^(nt-i) - 1) / (r/n)]
//    assuming all variable are provided
//    first calculate the compound interest based on variable amount of compounding frequency
//    then, calculate the compound interest on all the monthly deposit, also apply other varaible like compounding frequency

//    A = the future value of the investment/loan, including interest
//    P = principal investment amount (the initial deposit or loan amount)
//    r = annual interest rate (in decimal form - e.g., 4% = 0.04)
//    n = number of times that interest is compounded per year
//               t = time the money is invested or borrowed for, in years
//    PMT = monthly deposit amount
//                  i = month number (from 1 to nt)

}
