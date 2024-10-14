import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입장권 가격
        final int basicTicket = 10000;
        final int specialDiscount = 4000;
        final int generalDiscount = 8000;

        // 미션 제목
        System.out.println("[입장권 계산]");

        // 나이
        System.out.print("나이를 입력해 주세요. (숫자): ");
        int age = sc.nextInt();

        // 입장시간
        System.out.print("입장시간을 입력해 주세요. (숫자입력): ");
        int time = sc.nextInt();

        // 국가유공자 여부
        System.out.print("국가유공자 여부를 입력해 주세요. (y/n): ");
        char veteranYN = sc.next().charAt(0);

        // 복지카드 여부
        System.out.print("복지카드 여부를 입력해 주세요. (y/n): ");
        char welfareYN = sc.next().charAt(0);

        // 입장료 계산
        int fare = basicTicket;

        if (age < 3) {  // 3세 미만 무료 입장
            fare = 0;
        } else if (age < 13 || time >= 17) {  // 13세미만이면 특별 할인 적용, 17시이후에 입장하면 특별 할인 적용
            fare = specialDiscount;
        } else if (veteranYN == 'y' || welfareYN == 'y') {  // 복지카드와 국가유공자의 경우 일반 할인 적용
            fare = generalDiscount;
        }

        // 결과값 출력
        System.out.println("입장료: " + fare + "원");

        sc.close();
    }
}