# Java vs JavaScript — 코딩테스트 관점 비교

> 같은 문제를 두 언어로 풀 때 혼동하기 쉬운 차이점과 대응 관계를 정리한다.

---

## 1. 대응표

| Java | JavaScript | 역할 |
|---|---|---|
| `ArrayList` | `Array` | 순서 있는 동적 배열 |
| `HashMap` | `Object` / `Map` | Key-Value 저장소 |
| `Comparator` | `sort()` 콜백 | 정렬 기준 정의 |
| `Stream API` | 고차 함수 (filter/map/reduce) | 배열 처리 파이프라인 |
| `HashSet` | `Set` | 중복 제거 |
| `Iterator` | `for...of` / `Symbol.iterator` | 순회 메커니즘 |
| `Optional` | `?.` / `??` / undefined 체크 | null 안전 처리 |

---

## 2. 핵심 차이점 — 코딩테스트에서 자주 실수하는 부분

### JS Array = Java ArrayList + Stream
```javascript
// JS: Array 하나로 저장 + 처리 모두 가능
const nums = [3, 1, 4, 1, 5];
const result = nums.filter(n => n > 2).map(n => n * 10); // [30, 40, 50]
```
```java
// Java: ArrayList(저장) + Stream(처리) 분리
List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5);
List<Integer> result = nums.stream()
        .filter(n -> n > 2)
        .map(n -> n * 10)
        .collect(Collectors.toList()); // [30, 40, 50]
```

### JS sort()는 기본이 문자열 정렬 (Java는 Comparable 기반)
```javascript
// JS: 콜백 없으면 문자열 정렬 — 반드시 콜백 필요!
[10, 9, 1, 2].sort();            // [1, 10, 2, 9] ← 틀림!
[10, 9, 1, 2].sort((a, b) => a - b); // [1, 2, 9, 10] ← 올바름
```
```java
// Java: Collections.sort()는 Comparable 기반 (숫자는 자동 숫자순)
List<Integer> nums = new ArrayList<>(Arrays.asList(10, 9, 1, 2));
Collections.sort(nums); // [1, 2, 9, 10] — 문제 없음
```

### Java는 collect() 필요 vs JS는 바로 배열 반환
```javascript
// JS: filter/map 결과가 바로 배열
const filtered = [1, 2, 3, 4].filter(n => n % 2 === 0); // [2, 4]
```
```java
// Java: collect()로 수집해야 List가 됨
List<Integer> filtered = Arrays.asList(1, 2, 3, 4).stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList()); // [2, 4]
```

### Java Stream은 일회용 vs JS 배열은 재사용 가능
```javascript
// JS: 같은 배열로 여러 번 처리 가능
const arr = [1, 2, 3];
const sum = arr.reduce((a, b) => a + b, 0); // 6
const doubled = arr.map(n => n * 2);         // [2, 4, 6] — 같은 arr 재사용
```
```java
// Java: Stream은 한 번 쓰면 끝
// Stream<Integer> s = Arrays.asList(1, 2, 3).stream();
// s.reduce(0, Integer::sum); // 6
// s.map(n -> n * 2); // IllegalStateException — 재사용 불가!
```

### Java는 타입 선언 필수 vs JS는 동적 타입
```javascript
// JS: 타입 없이 자유롭게
const map = {};
map["key"] = 42;
map["key"] = "hello"; // 같은 키에 다른 타입 가능
```
```java
// Java: 타입 명시 필수
Map<String, Integer> map = new HashMap<>();
map.put("key", 42);
// map.put("key", "hello"); // 컴파일 에러! Integer만 가능
```

---

## 3. 같은 문제, 두 언어 — 코드 비교

### 비교 1: 빈도 세기

**문제**: 배열에서 각 요소의 등장 횟수를 구하라.

```java
// Java: HashMap + getOrDefault
import java.util.*;

public class FrequencyCount {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "a", "c", "b", "a"};

        Map<String, Integer> count = new HashMap<>();
        for (String s : arr) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        System.out.println(count); // {a=3, b=2, c=1}
    }
}
```

```javascript
// JS: Object + || 0 패턴
const arr = ["a", "b", "a", "c", "b", "a"];

const count = {};
for (const s of arr) {
    count[s] = (count[s] || 0) + 1;
}

console.log(count); // { a: 3, b: 2, c: 1 }
```

### 비교 2: 커스텀 정렬

**문제**: 문자열 배열을 길이 오름차순으로, 같은 길이면 사전순으로 정렬하라.

```java
// Java: Comparator + thenComparing
import java.util.*;

public class CustomSort {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(
            Arrays.asList("banana", "fig", "apple", "kiwi", "date")
        );

        words.sort(Comparator.comparingInt(String::length)
                             .thenComparing(Comparator.naturalOrder()));

        System.out.println(words); // [fig, date, kiwi, apple, banana]
    }
}
```

```javascript
// JS: sort 콜백에서 || 연산자로 다단계
const words = ["banana", "fig", "apple", "kiwi", "date"];

words.sort((a, b) =>
    a.length - b.length || a.localeCompare(b)
);

console.log(words); // ["fig", "date", "kiwi", "apple", "banana"]
```

### 비교 3: 필터 + 변환 파이프라인

**문제**: 숫자 배열에서 짝수만 골라 제곱한 리스트를 구하라.

```java
// Java: Stream filter → map → collect
import java.util.*;
import java.util.stream.*;

public class FilterMap {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result = nums.stream()
                .filter(n -> n % 2 == 0)    // [2, 4, 6]
                .map(n -> n * n)            // [4, 16, 36]
                .collect(Collectors.toList());

        System.out.println(result); // [4, 16, 36]
    }
}
```

```javascript
// JS: filter → map 체이닝 (collect 불필요)
const nums = [1, 2, 3, 4, 5, 6];

const result = nums
    .filter(n => n % 2 === 0)  // [2, 4, 6]
    .map(n => n * n);          // [4, 16, 36]

console.log(result); // [4, 16, 36]
```

---

## 4. 실무 관점

### Java의 강점
- **타입 안정성**: 컴파일 타임에 오류를 잡을 수 있어 대규모 서비스에서 유리
- **엔터프라이즈 생태계**: Spring 기반 백엔드에서 압도적 점유율
- **멀티스레딩**: 병렬 처리와 동시성 제어에 강력한 도구 제공

### JavaScript의 강점
- **프로토타이핑 속도**: 동적 타입 + 유연한 문법으로 빠르게 구현
- **풀스택 가능**: Node.js로 백엔드, React/Vue로 프론트엔드 — 한 언어로 전체 스택
- **비동기 처리**: 이벤트 루프 기반으로 I/O 집약적 작업에 효율적

### 두 언어를 모두 아는 것의 이점
- 백엔드(Java) ↔ 프론트엔드(JS) 간 소통 능력
- 한 언어의 개념을 다른 언어로 매핑할 수 있는 사고력
- 코딩테스트에서 문제에 따라 유리한 언어 선택 가능
