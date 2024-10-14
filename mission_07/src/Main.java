import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 미션 제목
        System.out.println("[로또 당첨 프로그램]");

        // 입력값 받기
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10): ");
        int ticketNum = scanner.nextInt();

        // 로또 발행하기
        int[][] myTicket = new int[ticketNum][6];
        String[] ticketLabel = new String[ticketNum];

        for (int i = 0; i < ticketNum; i++) {
            ticketLabel[i] = String.valueOf((char) ('A' + i)); // 티켓 라벨 A, B, C ...
            myTicket[i] = randomNum();
        }

        // 랜덤번호로 당첨 번호 만들기
        int[] winnerNum = randomNum();

        // 내 로또 번호 출력
        System.out.println("\n[내 로또 번호]");
        for (int i = 0; i < ticketNum; i++) {
            System.out.println(ticketLabel[i] + " " + Arrays.toString(myTicket[i]).replace(",", "").replace("[", "").replace("]", ""));
        }

        // 당첨 로또 번호 출력
        System.out.print("\n[로또 발표]\n");
        System.out.println(Arrays.toString(winnerNum).replace(",", "").replace("[", "").replace("]", ""));

        // 내 로또 번호 결과 값 출력
        System.out.println("\n[내 로또 결과]");
        for (int i = 0; i < ticketNum; i++) {
            int match = matchCount(myTicket[i], winnerNum);
            System.out.println(ticketLabel[i] + " " + Arrays.toString(myTicket[i]).replace(",", "").replace("[", "").replace("]", "") + " => " + match + "개 일치");
        }

        scanner.close();
    }

    // 6개의 랜덤 로또 번호 생성
    private static int[] randomNum() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            int num = (int) (Math.random() * 45) + 1; // 1부터 45 사이의 랜덤 숫자
            numbers.add(num);
        }

        // 배열생성후 정렬
        int[] result = numbers.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);
        return result;
    }

    // 내 로또번호와 당첨 번호 비교
    private static int matchCount(int[] ticket, int[] winnerNum) {
        int matchCount = 0;
        for (int number : ticket) {
            for (int winningNumber : winnerNum) {
                if (number == winningNumber) {
                    matchCount++;
                }
            }
        }
        return matchCount;
    }
}
