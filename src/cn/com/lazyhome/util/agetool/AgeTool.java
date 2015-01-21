package cn.com.lazyhome.util.agetool;

import java.util.Calendar;

import cn.huxi.tools.util.ChineseCalendar;

public class AgeTool {
	public static final ChineseCalendar darlinBirthday = new ChineseCalendar(1987, 12, 28);
	public static final ChineseCalendar meBirthday = new ChineseCalendar(1984, 02, 26);

	public static void main(String[] args) {
		ChineseCalendar birthday = new ChineseCalendar(true, 1987, 5, 7);
		//
//		birthday = darlinBirthday;
		
		ChineseCalendar date = new ChineseCalendar(true, 1988, 1, 15);
		
		System.out.println(calcAge(birthday, date));
		int age = calcAge(darlinBirthday);
		System.out.println(age);
		int[] month = MorF.MFarr[age - 27];
		
		System.out.println("1 2 3 4 5 6 7 8 9 101112");
		for(int i=0; i<month.length; i++) {
			System.out.print(month[i] + " ");
		}
	}
	
	public static void me() {
		ChineseCalendar pubCalendar = new ChineseCalendar(1984, 02, 26);
		System.out.println(pubCalendar.toString());
		
		ChineseCalendar chineseCalendar = new ChineseCalendar(true, 1984, 01, 25);
		System.out.println(chineseCalendar.toString());
		
		ChineseCalendar notChineseCalendar = new ChineseCalendar(false, 1984, 2, 26);
		System.out.println(notChineseCalendar.toString());
	}
	
	public static void darlin() {
		ChineseCalendar pubCalendar = new ChineseCalendar(1987, 12, 28);
		System.out.println(pubCalendar.toString());
	}
	
	public static int calcAge(ChineseCalendar birthday) {
		ChineseCalendar now = new ChineseCalendar();
		
		return calcAge(birthday, now);
	}
	public static int calcAge(ChineseCalendar birthday, ChineseCalendar date) {
		ChineseCalendar newBirthday = new ChineseCalendar(birthday.get(Calendar.YEAR), birthday.get(Calendar.MONTH), birthday.get(Calendar.DATE));
		newBirthday.add(Calendar.MONTH, 9);
		
		int age = date.get(Calendar.YEAR) - newBirthday.get(Calendar.YEAR);
		newBirthday.add(Calendar.YEAR, age);
		if(date.after(newBirthday)) {
			// 当前日期（date）比生日（晚），说明已经过了生日
			age = age + 1;
		}
		
		return age;
	}
}
