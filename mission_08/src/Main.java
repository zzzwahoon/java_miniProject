import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 미션 제목
        System.out.println("[과세금액 계산 프로그램]");

        // 연소득 입력 받기
        System.out.print("연소득을 입력해 주세요.: ");
        long annualIncome = scanner.nextLong();

        long totalTax = calculateTax(annualIncome);

        System.out.printf("[세율에 의한 세금]:   %,d원\n", totalTax);
        System.out.printf("[누진공제 계산에 의한 세금]: %,d원\n", totalTax);

        scanner.close();
    }

    private static long calculateTax(long income) {
        long tax = 0;
        long taxableIncome;

        // 세율과 누진공제 배열
        long[] tax_base = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
        double[] rates = {0.06, 0.15, 0.24, 0.35, 0.38, 0.40, 0.42, 0.45};
        long[] deductions = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000};

        long prevBase = 0;

        for (int i = 0; i < tax_base.length; i++) {
            if (income > prevBase) {
                if (income > tax_base[i]) {
                    taxableIncome = tax_base[i] - prevBase;
                    long taxPerBase = calcTaxBase(taxableIncome, rates[i]);
                    tax += taxPerBase;
                    System.out.printf("   %,d * %.0f%% = %,d\n", taxableIncome + prevBase - prevBase, rates[i] * 100, taxPerBase);
                    prevBase = tax_base[i];
                } else {
                    taxableIncome = income - prevBase;
                    long taxPerBase = calcTaxBase(taxableIncome, rates[i]);
                    tax += taxPerBase;
                    System.out.printf("   %,d * %.0f%% = %,d\n", taxableIncome + prevBase - prevBase, rates[i] * 100, taxPerBase);
                    prevBase = income; // 마지막 브래킷으로 설정
                    break;
                }
            }
        }

        // 누진공제 적용
        for (int i = 1; i < deductions.length; i++) {
            if (prevBase > tax_base[i - 1]) {
                tax -= deductions[i - 1];
                break;
            }
        }

        return Math.round(tax);
    }

    private static long calcTaxBase(long income, double rate) {
        return Math.round(income * rate);
    }
}
