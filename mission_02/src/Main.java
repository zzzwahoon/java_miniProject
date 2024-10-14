import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 미션 제목
        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요. (금액): ");
        int paymentAmount = scanner.nextInt();

        // 캐시백 가격 계산 (결제 금액의 10%)
        int cashback = (int)(paymentAmount * 0.1);

        // 캐시백 결과값 100원 단위로 환산
        cashback = (cashback / 100) * 100;

        // 캐시백 최대값 설정 (300원)
        if (cashback > 300) {
            cashback = 300;
        }

        // 결과값 출력
        System.out.println("결제 금액은 " + paymentAmount + "원이고, 캐시백은 " + cashback + "원 입니다.");

        scanner.close();
    }
}