package no04_String;

import java.util.Arrays;

public class Ex02_�޼��� {

	public static void main(String[] args) {

		String str = "Hello World";
		String str2 = "       Hello    World       ";
		String str3 = "a:b:c";
		
		System.out.println("===== startsWith/endswith : ���ڿ��� Ư�� ���ڷ� ���۵Ǵ���/�������� �Ǻ� =====");
		System.out.println(str.startsWith("H")); // T
		System.out.println(str.startsWith("h")); // F	
		System.out.println(str.endsWith("d")); // T
		System.out.println(str.endsWith("D")); // F
		System.out.println("===== contains : Ư�� ���ڿ� ���ԵǾ� �ִ��� �Ǻ� =====");
		System.out.println(str.contains("Hello")); // T
		System.out.println(str.contains("Hi")); // F	
		System.out.println("===== equals : ���ڿ� �� �� =====");
		System.out.println(str.equals("Hello World")); // T
		System.out.println(str.equals("hello world")); // F
		
		
		System.out.println("===== indexOf : �ε��� ��ġ ã�� =====");
		System.out.println(str.indexOf("o")); // 4
		System.out.println(str.indexOf("W")); // 6
		System.out.println(str.indexOf(" ")); // 5
		System.out.println(str.indexOf("a")); // ������ -1 ��ȯ
		System.out.println("===== charAt : �ε��� =====");
		System.out.println(str.charAt(0)); // H
		System.out.println(str.charAt(9)); // l
		//System.out.println(str.charAt(20)); // �ε��� ũ�⸦ �ѱ�� ����
		System.out.println("===== substring : �����̽� =====");
		System.out.println(str.substring(4)); // o World
		System.out.println(str.substring(3, 7)); // lo W
		
		
		System.out.println("===== replace(A, B) : A�� B�� ġȯ =====");
		System.out.println(str.replace("Hello", "Hi")); // Hi World
		System.out.println(str); // ���� ���ڿ��� �ٲ����� ����  Hello World
		System.out.println(str.replaceAll(" ", "")); // HelloWorld
		System.out.println("abcdefdef".replaceAll("^abc|def$", ""));
		System.out.println("===== toLowerCase, toUpperCase  : ��/�빮�ڷ� ��ȯ =====");
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		System.out.println("===== trim, strip : �� �� ���� ���� (���δ� x) =====");
		System.out.println(str2.trim());
		System.out.println(str2.strip());
		System.out.println(str2.stripLeading());
		System.out.println(str2.stripTrailing());
		
		
		System.out.println("===== split(������) : �����ڸ� �������� ���� ���� �迭�� ��ȯ =====");
		String[] splitStr = str.split(" ");
		for(int i = 0; i<splitStr.length; i++ ) {
			System.out.println(splitStr[i]);			
		}
		String[] splitStr3 = str3.split(":");
		for(int i = 0; i<splitStr3.length; i++ ) {
			System.out.println(splitStr3[i]);			
		}
		
		// join �߰��ϱ� 
		
		System.out.println("===== toCharArray() : String�� char �迭�� ��ȯ =====");
		// cf. toCharArray�� ó���ӵ��� ������ charAt�� ����ϴ� �� (��ó : https://woogienote.tistory.com/22)
		char[] charArr = str.toCharArray();
		System.out.println(Arrays.toString(charArr));
		for(char c : charArr ) {
			System.out.print(c + "//");
		}
		
		// compareTo()
		System.out.println("===== compareTo() : ũ�� �� ����� int�� ��ȯ =====");
		// ������ (Integer) : (a, b)���� a�� b���� ũ�� (1), ����(0), �۴�(-1)
		Integer x = 2;
		Integer y = 3;
		Integer z = 2;
		System.out.println(x.compareTo(1)); // 1
		System.out.println(x.compareTo(z)); // 0
		System.out.println(x.compareTo(y)); // -1
			// int ����Ϸ��� compare�� 
		System.out.println(Integer.compare(2, 1)); // 1
		System.out.println(Integer.compare(1, 1)); // 0
		System.out.println(Integer.compare(1, 2)); // -1
		// ������
			// ù��° ���ں��� ������� �� 
			// ���ڰ� �� ���� (��, �񱳴�� ���ԵǾ� ���� ��) : ���ڿ� ������ ���̰� ��ȯ
				// ��, ���ڿ��� ������ ������ 0 ��ȯ 
        System.out.println( "abcd".compareTo("abcd") );  // 0
        System.out.println( "abcd".compareTo("ab") );  //  2
        System.out.println( "abcd".compareTo("a") );  //  3
        System.out.println( "abcd".compareTo("") );  //  4 
        	// ���ڰ� �ٸ� ��� ������ : �� char�� �ƽ�Ű�ڵ� ���� ���̰� ����
        System.out.println( "abcd".compareTo("c") );  //  -2 (a�� c�� �ƽ�Ű ���̰� 97-99=-2 ����)
        System.out.println( "abcd".compareTo("ac") );  //  -1 (b�� c)
        System.out.println( "abcd".compareTo("A") );  //  32 (a 97�� A 65) 
        // ��ҹ��� �����ϰ� �� : compareToIgnorecase()
    	System.out.println( "a".compareToIgnoreCase("A") );  // 0	 
	}

}
