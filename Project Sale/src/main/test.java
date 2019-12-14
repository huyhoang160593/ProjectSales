package main;

import java.time.LocalDateTime;

public class test {
	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		String ldtString = ldt.toString();
		ldtString = ldtString.replace('T', ' ');
		System.out.println(ldtString);
	}
}
