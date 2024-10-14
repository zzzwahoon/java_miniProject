import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 미션 제목
        System.out.println("[주민등록번호 계산]");

        // 입력값
        System.out.print("출생년도를 입력해 주세요. (yyyy): ");
        int year = scanner.nextInt();
        System.out.print("출생월을 입력해 주세요. (mm): ");
        int month = scanner.nextInt();
        System.out.print("출생일을 입력해 주세요. (dd): ");
        int day = scanner.nextInt();
        System.out.print("성별을 입력해 주세요. (m/f): ");
        char gender = scanner.next().toLowerCase().charAt(0);

        // 뒷자리 첫 번째 숫자 계산 (2020년 이후)
        int genderNum;

        if (gender == 'm') {
            genderNum = 3;  // 남자는 3시작
        } else {
            genderNum = 4;  // 여자는 4시작
        }

        // 랜덤번호 생성
        int randomNum = random.nextInt(999999) + 1;

        // 결과값 출력
        System.out.printf("%02d%02d%02d-%d%06d%n", year % 100, month, day, genderNum, randomNum);

        scanner.close();
    }}