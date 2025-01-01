import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class TestCompoundInterestCalculator {
    BigDecimal[] initialInvestments = {BigDecimal.valueOf(-100_000), BigDecimal.valueOf(0), BigDecimal.valueOf(100_000)};
    BigDecimal[] monthlyContributions = {BigDecimal.valueOf(-2_000), BigDecimal.valueOf(0), BigDecimal.valueOf(2_000)};
    int[] durationsInYears = {-7, 0, 7};
    BigDecimal[] estimatedInterestRates = {BigDecimal.valueOf(-23), BigDecimal.valueOf(0), BigDecimal.valueOf(23)};
    int weeklyUnsupported = 52;
    int[] compoundFrequencies = {
            CompoundFrequency.ANNUALLY.getFrequency(),
            CompoundFrequency.SEMIANNUALLY.getFrequency(),
            CompoundFrequency.QUARTERLY.getFrequency(),
            CompoundFrequency.MONTHLY.getFrequency(),
            CompoundFrequency.DAILY.getFrequency(),
            weeklyUnsupported
    };

    MathContext mathContext = new MathContext(2, RoundingMode.HALF_UP);

    @Test
    public void testThatCompoundInterestCalculatorExist(){
        assertTrue(CompoundInterestCalculator.isExist());
    }

//    @Test
//    public void testThatCompoundInterestCalculatorThrowIllegalArgumentExceptionWhenInitialInvestmentIsLessThanZero(){
//        new CompoundInterestCalculator(
//                initialInvestments[0], monthlyContributions[2], durationsInYears[2],
//                estimatedInterestRates[2], compoundFrequencies[3]);
//    }

//    @Test
//    public void testThatCompoundInterestCalculatorThrowIllegalArgumentExceptionWhenYearsEqualsZero(){
//        new CompoundInterestCalculator(
//                initialInvestments[2], monthlyContributions[2], durationsInYears[1],
//                estimatedInterestRates[2], compoundFrequencies[3]);
//    }

//    @Test
//    public void testThatCompoundInterestCalculatorThrowIllegalArgumentExceptionWhenEstimatedInterestRateEqualsZero(){
//        new CompoundInterestCalculator(
//                initialInvestments[2], monthlyContributions[2], durationsInYears[2],
//                estimatedInterestRates[1], compoundFrequencies[3]);
//    }

//    @Test
//    public void testThatCompoundInterestCalculatorThrowIllegalArgumentExceptionWhenCompoundFrequencyIsNotSupported(){
//        new CompoundInterestCalculator(
//                initialInvestments[2], monthlyContributions[2], durationsInYears[2],
//                estimatedInterestRates[2], compoundFrequencies[5]);
//    }

    @Test
    public void testThatCompoundInterestCalculatorReturnCorrectValueWhenMonthlyContributionsIsNegative(){
        CompoundInterestCalculator investment = new CompoundInterestCalculator(
                initialInvestments[2], monthlyContributions[0], durationsInYears[2],
                estimatedInterestRates[2], compoundFrequencies[0]);
        BigDecimal actual = investment.calculateCompoundInterest();
        BigDecimal expected = BigDecimal.valueOf(85829.23);
        assertEquals(actual.setScale(mathContext.getPrecision(), mathContext.getRoundingMode()),
                expected.setScale(mathContext.getPrecision(), mathContext.getRoundingMode()));
    }

    @Test
    public void testThatCompoundInterestCalculatorReturnCorrectValurWhenOneOrBothInitialInvestmentAndMonthlyContributionsAreZero(){
        CompoundInterestCalculator investment = new CompoundInterestCalculator(
                initialInvestments[1], monthlyContributions[1], durationsInYears[2],
                estimatedInterestRates[2], compoundFrequencies[1]);
        BigDecimal actual = investment.calculateCompoundInterest();
        BigDecimal expected = BigDecimal.valueOf(0.00);
        assertEquals(actual.setScale(mathContext.getPrecision(), mathContext.getRoundingMode()),
                expected.setScale(mathContext.getPrecision(), mathContext.getRoundingMode()));

        investment = new CompoundInterestCalculator(
                initialInvestments[1], monthlyContributions[0], durationsInYears[2],
                estimatedInterestRates[2], compoundFrequencies[1]);
        actual = investment.calculateCompoundInterest();
        expected = BigDecimal.valueOf(-374647.80);
        assertEquals(actual.setScale(mathContext.getPrecision(), mathContext.getRoundingMode()),
                expected.setScale(mathContext.getPrecision(), mathContext.getRoundingMode()));

        investment = new CompoundInterestCalculator(
                initialInvestments[1], monthlyContributions[0], durationsInYears[2],
                estimatedInterestRates[2], compoundFrequencies[2]);
        actual = investment.calculateCompoundInterest();
        expected = BigDecimal.valueOf(-394920.41);
        assertEquals(actual.setScale(mathContext.getPrecision(), mathContext.getRoundingMode()),
                expected.setScale(mathContext.getPrecision(), mathContext.getRoundingMode()));

        investment = new CompoundInterestCalculator(
                initialInvestments[2], monthlyContributions[1], durationsInYears[2],
                estimatedInterestRates[2], compoundFrequencies[3]);
        actual = investment.calculateCompoundInterest();
        expected = BigDecimal.valueOf(492717.20);
        assertEquals(actual.setScale(mathContext.getPrecision(), mathContext.getRoundingMode()),
                expected.setScale(mathContext.getPrecision(), mathContext.getRoundingMode()));
    }

    @Test
    public void testThatCompoundInterestCalculatorReturnCorrectValueWhenAllArgumentArePositive(){
        CompoundInterestCalculator investment = new CompoundInterestCalculator(
                initialInvestments[2], monthlyContributions[2], durationsInYears[2],
                estimatedInterestRates[2], compoundFrequencies[4]);
        BigDecimal actual = investment.calculateCompoundInterest();
        BigDecimal expected = BigDecimal.valueOf(917447.54);
        assertEquals(actual.setScale(mathContext.getPrecision(), mathContext.getRoundingMode()),
                expected.setScale(mathContext.getPrecision(), mathContext.getRoundingMode()));
    }
}
