import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 미션 제목
        System.out.println("[달력 출력 프로그램]");

        // 입력값
        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
        int year = scanner.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm): ");
        int month = scanner.nextInt();

        // LocalDate 객체
        LocalDate current = LocalDate.of(year, month, 1);
        LocalDate previous = current.minusMonths(1);
        LocalDate next = current.plusMonths(1);

        // 달력 출력 (이전,현재,다음달)
        printCalendars(previous, current, next);

        scanner.close();
    }

    public static void printCalendars(LocalDate previous, LocalDate current, LocalDate next) {
        // 각달력별 ㅇㅇ년 ㅇㅇ월 출력
        System.out.printf("[%d년 %02d월]\t\t\t\t\t\t\t[%d년 %02d월]\t\t\t\t\t\t\t[%d년 %02d월]\n",
                previous.getYear(), previous.getMonthValue(),
                current.getYear(), current.getMonthValue(),
                next.getYear(), next.getMonthValue());

        // 요일 출력
        System.out.println("일\t월\t화\t수\t목\t금\t토\t\t\t\t일\t월\t화\t수\t목\t금\t토\t\t\t\t일\t월\t화\t수\t목\t금\t토");

        // 날짜 출력
        for (int week = 0; week < 6; week++) { // 최대 6주
            // 이전 달 날짜 출력
            printDay(previous, week);
            System.out.print("\t\t\t");

            // 현재 달 날짜 출력
            printDay(current, week);
            System.out.print("\t\t\t");

            // 다음 달 날짜 출력
            printDay(next, week);
            System.out.println();
        }
    }

    public static void printDay(LocalDate date, int week) {
        // 해당 월의 첫 번째 날
        LocalDate firstDay = date.withDayOfMonth(1);
        // 해당 월의 마지막 날
        LocalDate lastDay = date.withDayOfMonth(date.lengthOfMonth());

        // 첫 번째 날의 요일
        int dayOfWeek = firstDay.getDayOfWeek().getValue(); // 1(월), 2(화), 3(수), 4(목), 5(금), 6(토), 7(일)
        dayOfWeek = (dayOfWeek % 7); // 일요일 -> 0 으로 변환

        // 날짜 출력
        for (int day = 1; day <= 7; day++) {
            int currentDay = (week * 7 + day - dayOfWeek);
            if (currentDay >= 1 && currentDay <= lastDay.getDayOfMonth()) {
                System.out.printf("%02d\t", currentDay);
            } else {
                System.out.print("\t"); // 공백
            }
        }
    }
}
