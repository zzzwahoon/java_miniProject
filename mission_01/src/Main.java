public class Main {
    public static void main(String[] args) {
        // 미션 제목
        System.out.println("[구구단 출력]");

        // 구구단 1단부터 9단까지 2중 반복문 사용
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(String.format("%02d x %02d = %02d   ", j, i, j * i));
            }
            // 줄 바꿈
            System.out.println();
        }
    }
}