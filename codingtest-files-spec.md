# 코딩테스트 풀이 파일 생성 스펙

## 개요

study-notes의 키워드별 문제 리스트를 기반으로 Java/JavaScript 풀이 템플릿 파일을 생성한다.
기존 연습문제 목록에서 입문과 겹치는 문제 중 "다른 메서드로 풀라"는 문제는
키워드 폴더 안에 별도 Ex 번호로 추가한다 (같은 문제번호, 다른 Ex번호).
연습문제 폴더에는 입문 문제와 완전히 다른 새 문제 10개를 넣는다 (키워드 힌트 없음).

---

## 디렉토리 구조

```
algorithm-study/
├── java/
│   ├── (기존 스터디 폴더들)
│   └── 26-q1/
│       └── src/
│           ├── Main.java
│           ├── arraylist/
│           ├── hashmap/
│           ├── comparator/
│           ├── stream/
│           └── practice/          ← 연습문제 (키워드 힌트 없음)
├── javascript/
│   └── 26-q1/
│       ├── array/
│       ├── object-map/
│       ├── sort-callback/
│       ├── higher-order-functions/
│       └── practice/              ← 연습문제 (키워드 힌트 없음)
└── study-notes/
    └── (이미 생성됨 또는 별도 스펙으로 생성)
```

---

## 파일명 규칙

- 형식: `Ex{순번}_{프로그래머스ID}`
- 순번: 키워드 폴더 내에서 001부터 시작 (3자리 zero-padding)
- 프로그래머스ID: URL 끝 숫자
  - 예: https://school.programmers.co.kr/learn/courses/30/lessons/42576 → 42576
- 같은 문제를 다른 메서드로 풀 때: Ex번호만 다르게 (예: Ex001_42576, Ex005_42576)

---

## Java 템플릿

```java
package src.{키워드};

import java.util.*;

public class Ex001_42576 {

    public static void main(String[] args) {
        // 문제: 완주하지 못한 선수
        // https://school.programmers.co.kr/learn/courses/30/lessons/42576
        // 키워드: HashMap - getOrDefault로 빈도를 셀 수 있는가
        // 레벨: Lv.1

        // TODO: 풀이 작성
    }
}
```

## JavaScript 템플릿

```javascript
// 문제: 완주하지 못한 선수
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
// 키워드: Object - Object로 빈도를 세고 비교할 수 있는가
// 레벨: Lv.1

function solution() {
    // TODO: 풀이 작성
}
```

## 연습문제 템플릿 (키워드 힌트 없음)

Java:
```java
package src.practice;

import java.util.*;

public class Ex001_42586 {

    public static void main(String[] args) {
        // 문제: 기능개발
        // https://school.programmers.co.kr/learn/courses/30/lessons/42586
        // 레벨: Lv.2

        // TODO: 풀이 작성
    }
}
```

JavaScript:
```javascript
// 문제: 기능개발
// https://school.programmers.co.kr/learn/courses/30/lessons/42586
// 레벨: Lv.2

function solution() {
    // TODO: 풀이 작성
}
```

## Main.java

```java
package src;

public class Main {
    public static void main(String[] args) {
        System.out.println("26-Q1 코딩테스트 준비");
    }
}
```

---

## 문제 목록

### Java 키워드별 입문 문제

같은 문제를 다른 메서드로 풀 때는 별도 Ex번호로 추가한다.
"조건" 항목이 있는 문제는 해당 메서드를 반드시 사용해서 풀어야 한다.

#### arraylist

| 순번 | 문제명 | ID | 레벨 | 무엇을 묻는가 | 조건 |
|---|---|---|---|---|---|
| 1 | 같은 숫자는 싫어 | 12906 | Lv.1 | 리스트를 스택처럼 활용해 중복 제거할 수 있는가 | |
| 2 | 크기가 작은 부분문자열 | 147355 | Lv.1 | subList/인덱스 기반 슬라이싱을 활용할 수 있는가 | |
| 3 | 카드 뭉치 | 159994 | Lv.1 | contains/indexOf로 순서 조건 검사를 할 수 있는가 | |
| 4 | 주식가격 | 42584 | Lv.2 | 리스트+인덱스 순회로 조건 비교를 할 수 있는가 | |

#### hashmap

| 순번 | 문제명 | ID | 레벨 | 무엇을 묻는가 | 조건 |
|---|---|---|---|---|---|
| 1 | 완주하지 못한 선수 | 42576 | Lv.1 | getOrDefault로 빈도를 셀 수 있는가 | getOrDefault 사용 |
| 2 | 폰켓몬 | 1845 | Lv.1 | keySet 크기로 중복 제거 결과를 활용할 수 있는가 | |
| 3 | 전화번호 목록 | 42577 | Lv.2 | containsKey/startsWith로 접두사 검사를 할 수 있는가 | |
| 4 | 위장 | 42578 | Lv.2 | entrySet 순회 + 경우의 수 계산을 할 수 있는가 | |
| 5 | 완주하지 못한 선수 | 42576 | Lv.1 | merge로 빈도를 셀 수 있는가 | merge 사용 |
| 6 | 숫자 짝꿍 | 131128 | Lv.1 | HashMap으로 교집합을 구할 수 있는가 | |

#### comparator

| 순번 | 문제명 | ID | 레벨 | 무엇을 묻는가 | 조건 |
|---|---|---|---|---|---|
| 1 | K번째수 | 42748 | Lv.1 | sort() 기본 정렬 적용을 할 수 있는가 | |
| 2 | 가장 큰 수 | 42746 | Lv.2 | 람다로 커스텀 정렬 기준을 정의할 수 있는가 | |
| 3 | H-Index | 42747 | Lv.2 | reversed()로 내림차순 + 인덱스 조건 검사를 할 수 있는가 | |
| 4 | 튜플 | 64065 | Lv.2 | thenComparing으로 다단계 정렬 기준을 적용할 수 있는가 | |

#### stream

| 순번 | 문제명 | ID | 레벨 | 무엇을 묻는가 | 조건 |
|---|---|---|---|---|---|
| 1 | 두 개 뽑아서 더하기 | 68644 | Lv.1 | sorted + distinct + collect로 파이프라인을 구성할 수 있는가 | |
| 2 | 소수 만들기 | 12977 | Lv.1 | filter로 조건 필터링을 할 수 있는가 | |
| 3 | 숫자 짝꿍 | 131128 | Lv.1 | map으로 변환 후 collect로 수집할 수 있는가 | Stream 사용 |
| 4 | 문자열 나누기 | 140108 | Lv.1 | reduce로 누적 처리를 할 수 있는가 | |

### JavaScript 키워드별 입문 문제

#### array

| 순번 | 문제명 | ID | 레벨 | 무엇을 묻는가 | 조건 |
|---|---|---|---|---|---|
| 1 | 핸드폰 번호 가리기 | 12948 | Lv.1 | slice + join으로 배열 자르기/합치기를 할 수 있는가 | |
| 2 | 제일 작은 수 제거하기 | 12935 | Lv.1 | indexOf + splice로 특정 요소를 찾아 제거할 수 있는가 | |
| 3 | 행렬의 덧셈 | 12950 | Lv.1 | 2차원 배열을 인덱스로 순회할 수 있는가 | |
| 4 | 올바른 괄호 | 12909 | Lv.2 | push/pop으로 배열을 스택처럼 활용할 수 있는가 | |

#### object-map

| 순번 | 문제명 | ID | 레벨 | 무엇을 묻는가 | 조건 |
|---|---|---|---|---|---|
| 1 | 완주하지 못한 선수 | 42576 | Lv.1 | Object로 빈도를 세고 비교할 수 있는가 | Object 사용 |
| 2 | 폰켓몬 | 1845 | Lv.1 | Set/Object로 중복 제거 후 크기를 활용할 수 있는가 | |
| 3 | 전화번호 목록 | 42577 | Lv.2 | Object 키 탐색으로 접두사 관계를 검사할 수 있는가 | |
| 4 | 위장 | 42578 | Lv.2 | entries 순회로 경우의 수를 계산할 수 있는가 | |
| 5 | 완주하지 못한 선수 | 42576 | Lv.1 | Map으로 빈도를 세고 비교할 수 있는가 | Map 사용 |

#### sort-callback

| 순번 | 문제명 | ID | 레벨 | 무엇을 묻는가 | 조건 |
|---|---|---|---|---|---|
| 1 | K번째수 | 42748 | Lv.1 | slice 후 sort 콜백으로 기본 정렬을 할 수 있는가 | |
| 2 | 가장 큰 수 | 42746 | Lv.2 | 문자열 연결 기준으로 커스텀 정렬을 할 수 있는가 | |
| 3 | H-Index | 42747 | Lv.2 | 내림차순 정렬 후 인덱스 조건 탐색을 할 수 있는가 | |
| 4 | 튜플 | 64065 | Lv.2 | 다단계 정렬 기준을 콜백으로 정의할 수 있는가 | |

#### higher-order-functions

| 순번 | 문제명 | ID | 레벨 | 무엇을 묻는가 | 조건 |
|---|---|---|---|---|---|
| 1 | 핸드폰 번호 가리기 | 12948 | Lv.1 | map으로 각 요소를 조건에 따라 변환할 수 있는가 | map 사용 |
| 2 | 소수 만들기 | 12977 | Lv.1 | filter + every로 조건 필터링을 할 수 있는가 | |
| 3 | 두 개 뽑아서 더하기 | 68644 | Lv.1 | reduce로 중첩 순회 결과를 누적할 수 있는가 | reduce 사용 |
| 4 | 숫자 짝꿍 | 131128 | Lv.1 | flatMap + filter로 교집합을 구할 수 있는가 | |

### 연습문제 10개 (Java/JS 공통, 키워드 힌트 없음)

키워드별 학습이 끝난 후 실전 감각을 위해 푸는 문제.
키워드 힌트를 주지 않는다. Java와 JS 둘 다로 풀 것.

| 순번 | 문제명 | ID | 레벨 | 링크 |
|---|---|---|---|---|
| 1 | 기능개발 | 42586 | Lv.2 | https://school.programmers.co.kr/learn/courses/30/lessons/42586 |
| 2 | 오픈채팅방 | 42888 | Lv.2 | https://school.programmers.co.kr/learn/courses/30/lessons/42888 |
| 3 | 체육복 | 42862 | Lv.1 | https://school.programmers.co.kr/learn/courses/30/lessons/42862 |
| 4 | 문자열 내 마음대로 정렬하기 | 12915 | Lv.1 | https://school.programmers.co.kr/learn/courses/30/lessons/12915 |
| 5 | 괄호 회전하기 | 76502 | Lv.2 | https://school.programmers.co.kr/learn/courses/30/lessons/76502 |
| 6 | 신규 아이디 추천 | 72410 | Lv.1 | https://school.programmers.co.kr/learn/courses/30/lessons/72410 |
| 7 | 모의고사 | 42840 | Lv.1 | https://school.programmers.co.kr/learn/courses/30/lessons/42840 |
| 8 | 프로세스 | 42587 | Lv.2 | https://school.programmers.co.kr/learn/courses/30/lessons/42587 |
| 9 | 스킬트리 | 49993 | Lv.2 | https://school.programmers.co.kr/learn/courses/30/lessons/49993 |
| 10 | 이진 변환 반복하기 | 70129 | Lv.2 | https://school.programmers.co.kr/learn/courses/30/lessons/70129 |

---

## 실행 순서

1. 폴더 구조 생성 (java/26-q1/src/ 하위, javascript/26-q1/ 하위)
2. Main.java 생성
3. Java 키워드별 입문 파일 생성 (arraylist → hashmap → comparator → stream)
4. Java 연습문제 파일 10개 생성
5. JavaScript 키워드별 입문 파일 생성 (array → object-map → sort-callback → higher-order-functions)
6. JavaScript 연습문제 파일 10개 생성

---

## 주의사항

- Java 패키지명에서 하이픈 사용 불가 → 언더스코어 또는 하이픈 없이 사용
- 각 파일 주석에 반드시 포함: 문제명, 프로그래머스 링크, 레벨
- 키워드별 입문 파일에는 추가로: 키워드, 무엇을 묻는가, 조건(있는 경우)
- 연습문제 파일에는 키워드를 적지 않는다
- 풀이 영역은 `// TODO: 풀이 작성` 으로 비워둔다
- 같은 문제가 Java와 JS에 모두 있을 수 있다 (정상)
- 같은 문제가 한 언어 내에서 다른 키워드 폴더에 있을 수 있다 (정상)
