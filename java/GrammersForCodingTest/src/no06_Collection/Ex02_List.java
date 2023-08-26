package no06_Collection;

import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Ex02_List {

	public static void main(String[] args) {
		
		// List는 인터페이스이므로 구현클래스(ArrayList, Vector, LinkedList) 생성자로 동적 컬렉션 객체 생성
		List<String> arrList = new ArrayList<String>();
		List<String> vecList = new Vector<String>();
		List<String> linkedList = new LinkedList<String>();
		
		// Arrays.asList로 정적 컬렉션 객체 생성
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
			// 추가 add, 삭제 remove 불가. 변경인 set은 가능
			// 데이터 개수 고정됐을 때 사용 (예) 요일 월~일 )
		
		// 메서드
		// 제일 자주 사용되는 ArrayList에 적용해 
			// 추가 add(A), add(n, A)
		System.out.println("===== add : 리스트 끝에 원소 추가 =====");
		arrList.add("one");
		arrList.add("two");
		arrList.add("three");
			// 한 번에 출력 toString
		System.out.println(arrList.toString());
		System.out.println();
		System.out.println("===== add(n, A) : 인덱스 n에 원소 A 추가 =====");
		arrList.add(2, "two2");
		System.out.println(arrList.get(2)); //two2
		
			// 변경 set(n, A)
			// 삭제 remove(n), remove(A), clear()
		
			// 추출 get(n)
		System.out.println("===== get(n) : 인덱스 n의 원소 반환 =====");
		System.out.println(arrList.get(3)); // three
		
			// 원소 개수 size()
			// 비어있는지 여부 isEmpty()
		
			// 배열로 변환 toArray()
			// 특정 타입으로 다운캐스팅 toArray(T[] t)
		System.out.println("===== toArray() : Object 배열로 변환 =====");
		String[] strArr = arrList.toArray(new String[0]); // list의 크기를 살리기 위해 0 사용

		// Vector
			// 동기화 메서드로 구현되어 있음. 멀티 쓰레드에 적합
		
		// LinkedList
			// ArrayList와는 내부적으로 데이터를 저장하는 방식이 다르다.
				// 인덱스로 저장하는 게 아니라, linked로 관리
			// 추가, 삭제에서는 Linked가 더 성능 좋고
			// 검색에서는 array가 더 성능 좋음
	}

}
