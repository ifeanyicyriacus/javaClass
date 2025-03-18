public class main {
    public static void main(String[] args) {

        int num1 = 4;
        int num2 = 6;
        num1 += num2;
        num2 = num1 - num2;
        num1 -= num2;
        System.out.println(num1);
        System.out.println(num2);

        num1 = 4;
        num2 = 6;
        num1 = num1 - (num1 - num2);
        num2 = num1 - Math.abs(num2 - num1);
        System.out.println(num1);
        System.out.println(num2);
    }
}
