

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex000_test {
	
	public static void main(String[] args) throws IOException {

		// 아스키코드로 알파벳 세기 테스트 : char - 97 
//		String str = "abczyx";
//		for (int i=0; i<str.length(); i++) {
//			int n = str.charAt(i)-97;
//			System.out.println(n);
//		}
		
		// Scanner사용 
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		sc.nextLine(); // 개행 문자를 소비하기 위한 추가 코드를 넣어줘야 에러가 나지 않
//		String b = sc.nextLine();
//		int c = sc.nextInt();
//		
//		System.out.println("a : " + a);
//		System.out.println("b : " + b);
//		System.out.println("c : " + c);
		
//		// BufferReader 사용
//		// 입력 데이터 ABCDE
//		// 			abcde
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		String[] arr = new String[2];
//		for(int i=0; i<2; i++) {
//			arr[i] = br.readLine();
//			System.out.println(arr[i]);
//		}

//		// for문 안에서 i 조작 ok 
//		for (int i=0; i<10; i++) {
//			System.out.println(i++);
//		}
		
//		// ++ 붙이는 것
//		int n = 4;
//		int i = 2;
//		int j = 2;
//		int a = n*i++;
//		int b = n*(j++);
//		// 같은 건가봐.
//		System.out.println(a);
//		System.out.println(i);
//		System.out.println(b);
//		System.out.println(j);

//		// boolean 배열 초기값 :false
//		boolean[] arr = new boolean[3];
//		System.out.println(Arrays.toString(arr));
		
//		// 조건을 만족하지 않으면 아얘 for문에 안 들어 가는지 => yes
//		String str = "ab";
//		for(int i=2; i<str.length(); i++) System.out.println(i);
		
//		// 문자열 곱셈
//		// 자바는 * 로 문자열 곱셈 못함
//		// repeat 메서드 사용 (자바11)
//		String str = "string";
//		int n = 3;
////		str = n*"0" + str; // 빨간 줄 
//		str = "0".repeat(n) + str;
//		System.out.println(str);
		
//		// sb insert 사용
//		// int 넣어도 알아서 문자열 처리 됨 
//		StringBuilder sb = new StringBuilder();
//		int n = 1;
//		int m = 2;
//		sb.insert(0, n);
//		sb.insert(0, m);
//		System.out.println(sb);
		
//		char[] arrC = new char[5];
//		System.out.println(Arrays.toString(arrC));
//		String[] arrS = new String[5]; 
//		System.out.println(Arrays.toString(arrS));
		
//		// ++가 while문 안에서 F 여도 작동하는지 => yes!
//		int i = 1;
//		for (int j=0; j<10; j++) {
//			while(i++<5) System.out.println(i);
//		}
//		// 만약 작동하면 6이 나오고, 작동하지 않으면 5가 나오겠지?!
//		// 작동해! 그래서 심지어 6이 아니라 바깥 for문을 계속 돌아가서면 나온 15
//		System.out.println("최종 : "+ i);
		
//		// Stringbuilder 문자 뒤에 한번에 줄바꿈 넣기 => 가능!
//		StringBuilder sb = new StringBuilder();
//		sb.append("a\n");
//		sb.append("a\nb\n");
//		System.out.println(sb);
		
//		// 비어있을 때 peek => EmptyStackException 에러가 뜸 
//		Stack<Integer> stack = new Stack<>();
//		stack.push(1);
//		stack.pop();
//		System.out.println(stack.peek());
		
		// LinkedList 인덱스 add
//		LinkedList<String> list = new LinkedList<>();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add(2, "d");
//		System.out.println(list);

//		// for문 밖에서 선언해도 되는지
//		int i=0;
//		for (i=1; i<5; i++) System.out.println(i);
//		System.out.println(++i);
		
//		// "001"은 1로 바뀌는지
//		String str = "0000201";
//		int i = Integer.parseInt(str);
//		System.out.println(i);
		
//		// Collections.sort는 사전식 정렬
//		// "231231", "43"는 첫번째 문자열의 아스키코드를 정렬하므로 "231231"이 "43"보다 앞에 옴 
//		ArrayList<String> list = new ArrayList<>();
////		list.add("111");
////		list.add("005");
////		list.add("010");
////		list.add("000");
//		list.add("231231");
//		list.add("43");
//		Collections.sort(list);
//		for (String str : list) {
//			System.out.println(str);
//		}
		
//		// EntrySet 자료구조 리턴 형태 맞는지 확인
//		Map<Integer, String> map = new HashMap<>();
//		Set<Integer> keySet = map.keySet();
//		Set<Entry<Integer, String>> entrySet = map.entrySet();		
//		for (Entry<Integer, String> entry : map.entrySet()) {	
//			System.out.println(entry.getKey() + " : " + entry.getValue());	
//		}

		
		// 내림차순 정렬 
//		ArrayList<String> list = new ArrayList<>();
//		Collections.sort(list);
//		Collections.reverse(list);
//		Collections.binarySearch(list, "찾고싶은값");
		// 정렬 안 했을 때로 테스트 (오류는 안 나지만 이상한 값 반환)
//		list.add("ccc");
//		list.add("bbb");
//		list.add("aaa");
////		Collections.sort(list);
//		System.out.println(Collections.binarySearch(list, "bbb"));
	
//		// TreeMap 메서드
//		TreeMap<Integer, String> map = new TreeMap<>();
//		map.put(10, "asdf");
//		map.put(5, "a3df");
//		map.put(100, "kkjl");
//		map.put(2, "a");
//		SortedMap<Integer, String> toMap = map.headMap(5);;
//		SortedMap<Integer, String> fromMap = map.tailMap(5);
//		toMap.forEach((k, v)-> System.out.println("헤드 =>" + k + ":" + v));
//		fromMap.forEach((k, v)-> System.out.println("테일 =>" + k + ":" + v));
//		System.out.println(map.firstKey());
//		System.out.println(map.firstEntry().getKey());
//		System.out.println(map.pollFirstEntry());
//		System.out.println(map.firstKey());
//		System.out.println(map.lastKey());
//		System.out.println(map.lastEntry().getValue());
//		System.out.println(map.pollLastEntry());
//		System.out.println(map.size());
//		map.headMap(1);
//		map.tailMap(1);
		
		// Deque 실습 => 이거는 나중에 그래머스_no06컬렉션_덱 으로 이동 
//		Deque<String> deque = new LinkedList<>();
//		
//		// 스택으로 생각하면 앞이 push, pop, peek 하는 쪽 
//
//		// 데이터 추가 
//		// 용량 초과 시 : add 예외 발생, offer F 리턴 
//		// 앞 
//		deque.push(null);
//		deque.addFirst(null);
//		deque.offerFirst(null);
//		// 뒤
//		deque.add(null);
//		deque.offer(null);
//		deque.addLast(null);
//		deque.offerLast(null);
//		
//		// 데이터 삭제 (해당 데이터 리턴)
//		// 비어있을 시 : remove 예외 발생, poll null 리턴 
//		// 앞 
//		deque.pop();
//		deque.element();
//		deque.remove();
//		deque.poll();
//		deque.removeFirst();
//		deque.pollFirst();
//		// 뒤
//		deque.removeLast();
//		deque.pollLast();
//		
//		// 데이터 확인  
//		// 앞
//		deque.peek();
//		deque.peekFirst();
//		deque.getFirst();
//		// 뒤
//		deque.peekLast();
//		deque.getLast();
//		
//		// 탐색하여 나오는 첫 데이터를 제거
//		// 앞에서부터 탐색
//		deque.remove("제거할값");
//		deque.removeFirstOccurrence("제거할값");		
//		// 뒤에서부터 탐색 
//		deque.removeLastOccurrence("제거할값");
//		
//		// 데이터가 존재하는지 확인
//		deque.contains("확인할값");
//		
//		
//		// 순회
//		// for문
//		deque.forEach(e -> System.out.println(e));
//		for (String elem : deque) {
//			  System.out.println(elem);
//		}
//		
//		// 실습 		
//		deque.add("1번 ");
//		deque.add("2번 ");
//		deque.addFirst("3번 ");
////		deque.push("3번 ");
//		deque.forEach(e-> System.out.println(e));
		
//		// String.format 반올림 테스트 => OK
//		System.out.println(String.format("%.4f", 3.777777));
		
//		int[] arr = {1, 2, 3};
		
//		// 반례 개수 세기
//        int[] numbers = {
//                36, 58, 169, 78, 30, 97, 23, 115, 105, 102,
//                35, 106, 57, 91, 110, 81, 193, 68, 191, 74,
//                164, 38, 33, 129, 40, 131, 77, 124, 74, 119
//            };
//
//        // 각 숫자의 개수를 저장할 HashMap 생성
//        Map<Integer, Integer> countMap = new HashMap<>();
//
//        // 숫자 배열을 순회하면서 각 숫자의 개수를 세기
//        for (int number : numbers) {
//        	countMap.put(number, countMap.getOrDefault(number, 0)+1);
//        }
//
//        // 결과 출력
//        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//            if(entry.getValue()==203) System.out.println("쿠키 있어");
//        }

//        // 빅인트 연산
//        BigInteger a = new BigInteger("0");
//        int cost = 10;
//        int d = 50;
//        BigInteger tmp = BigInteger.valueOf(cost).multiply(BigInteger.valueOf(d));
//        System.out.println(a.add(tmp));
//        System.out.println(a.multiply(tmp));

//        // 00 ~ 59 안에 3의 개수
//        int cnt=0;
//        for (int i=0; i<60 ; i++){
//            if (Integer.toString(i).contains("3")) cnt++;
//        }
//        System.out.println(cnt);

//        // TreeSet의 ceiling, floor 사용
//        TreeSet<Integer> set = new TreeSet<>();
//        set.add(2);
//        set.add(5);
//        set.add(10);
//		// floor : 자기 자신보다 작거나 같은 원소
//		System.out.println(set.floor(5)); // 5
//		System.out.println(set.floor(7)); // 5
//			// 없으면 null 반환
//		System.out.println(set.floor(1)); // null
//		// ceiling : 자기 자신보다 크거나 같은 원소
//		System.out.println(set.ceiling(5)); // 5
//		System.out.println(set.ceiling(7)); // 10
//			// 없으면 null 반환
//		System.out.println(set.ceiling(15)); // null
//
//        // 내림차순 정렬일 때
//        TreeSet<Integer> set2 = new TreeSet<>(Collections.reverseOrder());
//        set2.add(2);
//        set2.add(5);
//        set2.add(10);
//        System.out.println(set2.ceiling(7)); // 5
//        System.out.println(set2.floor(7)); // 10

//            // 50000의 sqrt
//            System.out.println(Math.sqrt(50000));

//		// 음수 int 나누기 => 잘 됨!!
//		int a = 1;
//		int b = 3;
//		int c = -1;
//		int d = 4;
//		int e = 1;
//		int f = 7;
//		int num = (a*f-c*d)/(a*e-b*d);
//		System.out.println(num);


//        // 배열을 String으로 넣었을 때 key가 될 수 있는지 => yes!
//        HashMap<String, Integer> map = new HashMap<>();
//        int[] arr1 = new int[] {1, 2};
//        int[] arr2 = new int[] {3, 7};
//        int[] arr3 = new int[] {5, 3};
//        int[] arr4 = new int[] {6, 2};
//        int[] arr5 = new int[] {7, 9};
//
//        map.put(arr1.toString(), 1);
//        map.put(arr2.toString(), 2);
//        map.put(arr3.toString(), 3);
//        map.put(arr4.toString(), 4);
//        map.put(arr5.toString(), 5);
//
//        System.out.println(map.getOrDefault(arr3.toString(), 0));
//        // 같은 값을 가져도 새롭게 생성되면 다른 원소
//        System.out.println(map.getOrDefault(new int[] {5, 3}, 0));

//            String str1 = "Hello"; // 문자열 리터럴을 이용한 방식
//            String str2 = "Hello";
//            String str3 = str2;
//            System.out.println(str1 == str2); // true : 리터럴 문자열은 같은 주소
//            System.out.println(str1 == str3); // true : 리터럴 문자열은 같은 주소

//        // replaceAll
//        String str = "001010";
//        String str2 = str.replaceAll("^0+", "");
//        System.out.println(str2);

//        // String 객체가 regex 가능한지
//        // 우선 리터럴로 해당 정규식 찾음
//        System.out.println(Pattern.matches("^a[a-z]*d$", "abcd"));
//        // String으로 같은 정규식이 되게 하려면?
//        String str = "\\^a[a-z]\\*d\\$";
//        System.out.println(str);
//        System.out.println(Pattern.matches(str, "abcd"));


//        // 빈 문자열의 길이 확인 => 0
//        String str = "";
//        System.out.println(str.length());

	}

}
