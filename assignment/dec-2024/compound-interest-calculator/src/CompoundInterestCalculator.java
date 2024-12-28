import java.math.BigDecimal;

public class CompoundInterestCalculator {
    private       BigDecimal        principal;
    private       BigDecimal        monthlyContribution;
    private       int               durationInYears;
    private       BigDecimal        estimatedInterestRate;
    private       BigDecimal        interestRateVarianceRange;
    private final CompoundFrequency compoundFrequency;

    private enum CompoundFrequency{ DAILY, WEEKLY, MONTHLY , YEARLY}


    public CompoundInterestCalculator(BigDecimal principal, BigDecimal monthlyContribution, int durationInYears, BigDecimal estimatedInterestRate, BigDecimal interestRateVarianceRange, CompoundFrequency compoundFrequency) {
        this.compoundFrequency = compoundFrequency;
        setPrincipal(principal);
        setMonthlyContribution(monthlyContribution);
        setDurationInYears(durationInYears);
        setEstimatedInterestRate(estimatedInterestRate);
        setInterestRateVarianceRange(interestRateVarianceRange);
    }

    public CompoundFrequency getCompoundFrequency() {
        return compoundFrequency;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(BigDecimal monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }

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
        this.estimatedInterestRate = estimatedInterestRate;
    }

    public BigDecimal getInterestRateVarianceRange() {
        return interestRateVarianceRange;
    }

    public void setInterestRateVarianceRange(BigDecimal interestRateVarianceRange) {
        this.interestRateVarianceRange = interestRateVarianceRange;
    }


}
