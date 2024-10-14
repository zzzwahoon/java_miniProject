import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 총 진행할 투표수 받기
        System.out.print("총 진행할 투표수를 입력해 주세요: ");
        int totalVotes = scanner.nextInt();

        // 가상 선거를 진행할 후보자 인원 수 받기
        System.out.print("가상 선거를 진행할 후보자 인원을 입력해 주세요: ");
        int candidateNum = scanner.nextInt();
        String[] candidates = new String[candidateNum];
        int[] votes = new int[candidateNum];

        // 가상 선거 후보자 이름 받기
        for (int i = 0; i < candidateNum; i++) {
            System.out.print((i + 1) + "번째 후보자 이름을 입력해 주세요: ");
            candidates[i] = scanner.next();
        }

        // 투표 시작
        for (int i = 0; i < totalVotes; i++) {
            // 후보자 랜덤 선택
            int voteIdx = random.nextInt(candidateNum);
            votes[voteIdx]++;

            // 현재 투표 진행률 출력
            double currentStatus = (i + 1) / (double) totalVotes * 100;
            System.out.printf("[투표진행률]: %.2f%% %d명 투표 => %s\n", currentStatus, (i + 1), candidates[voteIdx]);

            // 현재 각 가상 후보자 투표율 출력
            for (int j = 0; j < candidateNum; j++) {
                double percentage = (votes[j] / (double) (i + 1)) * 100;
                System.out.printf("[기호:%d] %s: %.2f%% (투표수: %d)\n", j + 1, candidates[j], percentage, votes[j]);
            }
            System.out.println();
        }

        // 결과값 출력
        int winnerIndex = 0;
        for (int i = 1; i < candidateNum; i++) {
            if (votes[i] > votes[winnerIndex]) {
                winnerIndex = i;
            }
        }
        System.out.printf("[투표결과] 당선인 : %s\n", candidates[winnerIndex]);

        scanner.close();
    }
}
