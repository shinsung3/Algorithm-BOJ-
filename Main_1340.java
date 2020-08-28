import java.util.Scanner;

public class Main_1340 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		String[] time = sc.nextLine().split(" ");
//		System.out.println(Arrays.toString(time));

		// 1. 윤달인지 먼저 판단하기.
		int year = Integer.parseInt(time[2]);
		boolean yearCheck = false;
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			yearCheck = true;
		}

		// 2. 무슨 달인지 확인
		String month = time[0];
		int mon = 0;
//		January, February, March, April, May, June, July, August, September, October, November, December 
		switch (month) {
		case "January":
			mon = 1;
			break;
		case "February":
			mon = 2;
			break;
		case "March":
			mon = 3;
			break;
		case "April":
			mon = 4;
			break;
		case "May":
			mon = 5;
			break;
		case "June":
			mon = 6;
			break;
		case "July":
			mon = 7;
			break;
		case "August":
			mon = 8;
			break;
		case "September":
			mon = 9;
			break;
		case "October":
			mon = 10;
			break;
		case "November":
			mon = 11;
			break;
		case "December":
			mon = 12;
			break;
		}

		// 3. 날짜 확인
		int days[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int day = Integer.parseInt(time[1].split(",")[0]);
		int dayCnt = 0;
		for (int i = 1; i < mon; i++) {
			// 3-1. 윤달이라면?
			if (yearCheck && i == 2) {
				dayCnt += 29;
				continue;
			}
			dayCnt += days[i];

		}
		dayCnt += day;
//		System.out.println(dayCnt);

		// 4. 시간
		int hour = 60 * Integer.parseInt(time[3].split(":")[0]);
		int min = Integer.parseInt(time[3].split(":")[1]);
		int timeHM = hour + min;
//		System.out.println(60*24 - (hour+min));

		// 5. 날짜를 시간으로 환산하기.
		int timeTohour = 60 * 24 * (dayCnt-1) +timeHM;
//		System.out.println(timeTohour);

		// 6. 윤달일때 아닐때 차이
		int totalYear = 0;
		if (yearCheck) {
			totalYear = 366 * 60 * 24;
		} else {
			totalYear = 365 * 60 * 24;
		}
//		System.out.println(totalYear);
		System.out.println((double) ((double) timeTohour * 100 / (double) totalYear));
	}

	private static String src = "May 10, 1981 00:31";
}