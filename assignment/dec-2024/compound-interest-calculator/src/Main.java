import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Currency     naira       = Currency.getInstance("NGN");
    private static final NumberFormat nairaFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("en-NG"));

    private static String nairaFormat(BigDecimal amount) {
        nairaFormat.setCurrency(naira);
        return nairaFormat.format(amount);
    }

    public static void main(String[] args) {
        System.out.println("\033[32m\033[1mCompound Interest Calculator\033[0m");
        System.out.println("Determine how much your money can grow using the power of compound interest.");
        Scanner input = new Scanner(System.in);

        System.out.println("\033[32m\033[1mStep1: Initial Investment\033[0m");
        System.out.println("\033[1mEnter your initial investment: \033[0m\n" +
                "\033[3m(The amount of money available to invest initially.)\033[0m");
        BigDecimal initialInvestment = input.nextBigDecimal();

        System.out.println("\033[32m\033[1mStep2: Contribute\033[0m");
        System.out.println("\033[1mEnter monthly contribution: (Enter '0' to skip)\033[0m \n" +
                "\033[3m(Amount that you plan to add to the principal every month, or a negative number for the amount that you plan to withdraw every month.)\033[0m");
        BigDecimal monthlyContribution = input.nextBigDecimal();
        System.out.println("\033[1mEnter the length of time in years:\033[0m \n" +
                "\033[3m(Length of time, in years, that you plan to save.)\033[0m");
        int durationInYears = input.nextInt();

        System.out.println("\033[32m\033[1mStep3: Interest Rate\033[0m");
        System.out.println("\033[1mEnter the estimated interest rate:\033[0m \n" +
                "\033[3m(Your estimated annual interest rate.)\033[0m");
        BigDecimal estimatedInterestRate = input.nextBigDecimal();
        System.out.println("\033[1mEnter the interest rate variance range: (Enter '0' to skip)\033[0m \n" +
                "\033[3m(Range of interest rates (above and below the rate entered above) that you desire to see results for.)\033[0m");
        BigDecimal interestRateVarianceRange = input.nextBigDecimal();
        BigDecimal upperBoundInterestRate = estimatedInterestRate.add(interestRateVarianceRange);
        BigDecimal lowerBoundInterestRate = estimatedInterestRate.subtract(interestRateVarianceRange);

        System.out.println("\033[32m\033[1mStep4: Compound it\033[0m");
        System.out.println("""
                \033[1mChoose the Compound frequency from the following options:\033[0m
                \033[3m(Times per year that interest will be compounded.)\033[0m
                1. Annually
                2. Semiannually
                3. Quarterly
                4. Monthly
                5. Daily
                >>>""");
        int compoundFrequency = switch (input.nextInt()) {
            case 1 -> CompoundFrequency.ANNUALLY.getFrequency();
            case 2 -> CompoundFrequency.SEMIANNUALLY.getFrequency();
            case 3 -> CompoundFrequency.QUARTERLY.getFrequency();
            case 4 -> CompoundFrequency.MONTHLY.getFrequency();
            case 5 -> CompoundFrequency.DAILY.getFrequency();
            default -> {
                System.out.println("Invalid choice: (Your default will be set to 1. ANNUALLY)");
                yield CompoundFrequency.ANNUALLY.getFrequency();
            }
        };

        CompoundInterestCalculator investment = new CompoundInterestCalculator(
                initialInvestment, monthlyContribution, durationInYears,
                estimatedInterestRate, compoundFrequency);
        CompoundInterestCalculator investmentUpperBound = new CompoundInterestCalculator(
                initialInvestment, monthlyContribution, durationInYears,
                upperBoundInterestRate, compoundFrequency);
        CompoundInterestCalculator investmentLowerBound = new CompoundInterestCalculator(
                initialInvestment, monthlyContribution, durationInYears,
                lowerBoundInterestRate, compoundFrequency);



        System.out.printf("Investment balance 1: %s%n", nairaFormat(investment.calculateCompoundInterest()));
        System.out.printf("Investment balance 2: %s%n", nairaFormat(investmentUpperBound.calculateCompoundInterest()));
        System.out.printf("Investment balance 3: %s%n", nairaFormat(investmentLowerBound.calculateCompoundInterest()));

        String investmentSummary = generateInvestmentSummarySheet(investment, estimatedInterestRate, interestRateVarianceRange,
                investment.getYearlyChangesInInvestmentValue(),
                investmentUpperBound.getYearlyChangesInInvestmentValue(),
                investmentLowerBound.getYearlyChangesInInvestmentValue());
        System.out.println(investmentSummary);
    }

    private static String generateInvestmentSummarySheet(CompoundInterestCalculator investment,
                                                        BigDecimal estimatedInterestRate,
                                                        BigDecimal interestRateVarianceRange,
                                                        BigDecimal[] yearlyInvestmentValues,
                                                        BigDecimal[] upperBoundValues,
                                                        BigDecimal[] lowerBoundValues) {
        int noOfYears = investment.getDurationInYears();
        StringBuilder investmentSummarySheet = new StringBuilder();
        investmentSummarySheet.append(String.format("%n%n\033[1m\033[32mResult: in %d years, you will have %s\033[0m%n%n", noOfYears, nairaFormat(investment.calculateCompoundInterest())));
        investmentSummarySheet.append(String.format("\033[1m| %8s | %25s | %25s | %25s | %25s |\033[0m%n",
                "Years", "Total Contribution",
                "Variance Above (" + estimatedInterestRate.add(interestRateVarianceRange) + "%)",
                "Future Value (" + estimatedInterestRate + "%)",
                "Variance Below (" + estimatedInterestRate.subtract(interestRateVarianceRange) + "%)")
        );

        final String lineSeparator = String.format("\033[1m+ %8s + %25s + %25s + %25s + %25s +\033[0m%n",
                "-".repeat(8), "-".repeat(25), "-".repeat(25), "-".repeat(25), "-".repeat(25));
        investmentSummarySheet.append(lineSeparator);
        BigDecimal currentInvestment = investment.getInitialInvestment();
        investmentSummarySheet.append(String.format("\033[1m| %8s | %25s | %25s | %25s | %25s |\033[0m%n",
                "Year 0", nairaFormat(currentInvestment), nairaFormat(currentInvestment), nairaFormat(currentInvestment),nairaFormat(currentInvestment)));
        investmentSummarySheet.append(lineSeparator);

        BigDecimal yearlyMonthlyContribution = investment.getMonthlyContribution().multiply(BigDecimal.valueOf(12));

        for (int i = 0; i < noOfYears; i++) {
            currentInvestment = currentInvestment.add(yearlyMonthlyContribution);
            investmentSummarySheet.append(String.format("\033[1m| %8s | %25s | %25s | %25s | %25s |\033[0m%n",
                    "Year " + (i + 1),
                    nairaFormat(currentInvestment),
                    nairaFormat(upperBoundValues[i]),
                    nairaFormat(yearlyInvestmentValues[i]),
                    nairaFormat(lowerBoundValues[i])));
            investmentSummarySheet.append(lineSeparator);
        }
        return investmentSummarySheet.toString();
    }
}