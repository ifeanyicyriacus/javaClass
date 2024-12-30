import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
                1. Annual
                2. Semiannual
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
                System.out.println("Invalid choice: (Your default will be set to ANNUALLY)");
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

        Currency naira = Currency.getInstance("NGN");
        NumberFormat nairaFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("en-NG"));
        nairaFormat.setCurrency(naira);

        System.out.printf("Investment balance 1: %s%n", nairaFormat.format(investment.calculateCompoundInterest()));
        System.out.printf("Investment balance 2: %s%n", nairaFormat.format(investmentUpperBound.calculateCompoundInterest()));
        System.out.printf("Investment balance 3: %s%n", nairaFormat.format(investmentLowerBound.calculateCompoundInterest()));




    }

//    private String displayInvestmentSummarySheet(BigDecimal[] yearlyInvestmentValues,
//                                                 BigDecimal[] upperBoundValues,
//                                                 BigDecimal[] lowerBoundValues) {
//
//        int noOfYears = yearlyInvestmentBalances.length;
//        System.out.printf("",);"Years"	"Variance Above (25.00%)"	"Future Value (20.00%)"	"Variance Below (15.00%)"
//
//        Year 0	$100,000.00	$100,000.00	$100,000.00
//
//
//        Year 1	$127,442.93	$121,550.63	$115,865.04
//        Year 2	$162,417.01	$147,745.54	$134,247.08
//        Year 3	$206,989.00	$179,585.63	$155,545.43
//        Year 4	$263,792.85	$218,287.46	$180,222.78
//        Year 5	$336,185.34	$265,329.77	$208,815.20
//
//
//    }
}