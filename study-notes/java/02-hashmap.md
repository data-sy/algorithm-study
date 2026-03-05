# HashMap — 해시 테이블 기반 Key-Value 저장소

> 코딩테스트에서 빈도 세기, 존재 여부 확인, 그룹 분류에 핵심적으로 쓰이는 자료구조.

**계층 위치**: `Map` (interface) → `HashMap` (class) — Collection 계층과는 별도

---

## 핵심 메서드

| 메서드 | 설명 | 시간복잡도 |
|---|---|---|
| `put(key, value)` | 키-값 저장 (기존 키면 덮어씀) | O(1) |
| `get(key)` | 키로 값 조회 (없으면 null) | O(1) |
| `getOrDefault(key, default)` | 키로 값 조회 (없으면 기본값) | O(1) |
| `merge(key, value, remapping)` | 키 있으면 remapping 적용, 없으면 value 저장 | O(1) |
| `containsKey(key)` | 키 존재 여부 | O(1) |
| `containsValue(value)` | 값 존재 여부 | O(n) |
| `keySet()` | 모든 키의 Set 반환 | O(1) |
| `values()` | 모든 값의 Collection 반환 | O(1) |
| `entrySet()` | 모든 키-값 쌍의 Set 반환 | O(1) |
| `size()` | 저장된 쌍의 개수 | O(1) |
| `isEmpty()` | 비어있는지 확인 | O(1) |
| `remove(key)` | 키로 삭제 | O(1) |

---

## 패턴 1: 빈도 세기 — getOrDefault vs merge

### 언제 쓰는가
- 각 요소가 몇 번 등장하는지 카운트할 때
- 코딩테스트에서 가장 자주 나오는 HashMap 패턴

### 실무에서는
- 로그 분석 (에러 코드별 빈도), 투표 집계, 장바구니 수량 관리

```java
import java.util.*;

public class FrequencyCounting {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};

        // === 방법 1: getOrDefault ===
        // 직관적이고 읽기 쉬움. 코딩테스트에서 가장 많이 쓰는 방식.
        Map<String, Integer> count1 = new HashMap<>();
        for (String word : words) {
            count1.put(word, count1.getOrDefault(word, 0) + 1);
        }
        System.out.println(count1); // {banana=2, cherry=1, apple=3}

        // === 방법 2: merge ===
        // 더 간결하지만 remapping 함수 이해가 필요.
        // merge(key, 1, Integer::sum) → 키가 없으면 1 저장, 있으면 기존값 + 1
        Map<String, Integer> count2 = new HashMap<>();
        for (String word : words) {
            count2.merge(word, 1, Integer::sum);
        }
        System.out.println(count2); // {banana=2, cherry=1, apple=3}
    }
}
```

---

## 패턴 2: keySet/Set 크기로 고유 개수 구하기

### 언제 쓰는가
- 서로 다른 종류가 몇 개인지 셀 때
- "종류의 수"를 구하는 문제

### 실무에서는
- 고유 사용자 수, 카테고리 목록 추출

```java
import java.util.*;

public class UniqueCount {
    public static void main(String[] args) {
        String[] animals = {"cat", "dog", "cat", "bird", "dog", "fish"};

        // 방법 1: HashMap으로 빈도를 세고 keySet 크기
        Map<String, Integer> map = new HashMap<>();
        for (String animal : animals) {
            map.put(animal, map.getOrDefault(animal, 0) + 1);
        }
        System.out.println("종류 수: " + map.keySet().size()); // 종류 수: 4

        // 방법 2: 단순히 고유 개수만 필요하면 HashSet이 더 간단
        Set<String> set = new HashSet<>(Arrays.asList(animals));
        System.out.println("종류 수: " + set.size()); // 종류 수: 4
    }
}
```

---

## 패턴 3: containsKey + startsWith로 접두사 검사

### 언제 쓰는가
- 한 문자열이 다른 문자열의 접두사인지 확인할 때
- 전화번호부 문제 등

### 실무에서는
- 전화번호 자동완성, URL 라우트 매칭

```java
import java.util.*;

public class PrefixCheck {
    public static void main(String[] args) {
        // 전화번호부에서 어떤 번호가 다른 번호의 접두사인지 확인
        String[] phoneBook = {"119", "97674223", "1195524421"};

        Map<String, Boolean> map = new HashMap<>();
        for (String phone : phoneBook) {
            map.put(phone, true);
        }

        boolean hasPrefix = false;
        for (String phone : phoneBook) {
            // 한 글자씩 늘려가며 접두사가 존재하는지 확인
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (map.containsKey(prefix)) {
                    System.out.println(prefix + "는 " + phone + "의 접두사입니다");
                    // 119는 1195524421의 접두사입니다
                    hasPrefix = true;
                }
            }
        }

        System.out.println("접두사 존재: " + hasPrefix); // 접두사 존재: true
    }
}
```

---

## 패턴 4: entrySet 순회 + 조합 계산

### 언제 쓰는가
- 그룹별로 분류한 뒤 조합 수를 계산할 때
- "같은 종류끼리 짝짓기" 유형

### 실무에서는
- 상품 옵션 조합, A/B 테스트 그룹 배정

```java
import java.util.*;

public class EntrySetCombination {
    public static void main(String[] args) {
        // 같은 색상의 옷 중 2개를 고르는 경우의 수
        String[] clothes = {"red", "red", "red", "blue", "blue", "green"};

        // 색상별 개수 세기
        Map<String, Integer> colorCount = new HashMap<>();
        for (String color : clothes) {
            colorCount.merge(color, 1, Integer::sum);
        }

        // 각 색상에서 2개를 고르는 조합 수: nC2 = n*(n-1)/2
        int totalPairs = 0;
        for (Map.Entry<String, Integer> entry : colorCount.entrySet()) {
            int n = entry.getValue();
            if (n >= 2) {
                int pairs = n * (n - 1) / 2;
                System.out.println(entry.getKey() + ": " + n + "개 → " + pairs + "쌍");
                totalPairs += pairs;
            }
        }
        // red: 3개 → 3쌍
        // blue: 2개 → 1쌍
        System.out.println("총 쌍의 수: " + totalPairs); // 총 쌍의 수: 4
    }
}
```

---

## 주의사항

### HashMap은 순서를 보장하지 않는다
```java
Map<String, Integer> map = new HashMap<>();
map.put("C", 3);
map.put("A", 1);
map.put("B", 2);
System.out.println(map); // 순서가 삽입 순서와 다를 수 있음
// 순서가 필요하면 LinkedHashMap 사용
```

### Key의 equals/hashCode 관계
- HashMap은 `hashCode()`로 버킷을 찾고, `equals()`로 키를 비교
- 커스텀 객체를 키로 쓰려면 둘 다 오버라이드 필수
- String, Integer 등 기본 타입은 이미 구현되어 있어서 걱정 없음

### null 키와 null 값
```java
Map<String, Integer> map = new HashMap<>();
map.put(null, 100);         // null 키 1개 허용
map.put("key", null);       // null 값 여러 개 허용
System.out.println(map.get(null));  // 100
System.out.println(map.get("key")); // null
```
