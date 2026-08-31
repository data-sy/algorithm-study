# Part 1: 개념편 — Collections Framework 핵심 정리

---

## Chapter 1: HashMap

### 1.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: 키(key)와 값(value)을 쌍으로 저장하며, 키를 통해 O(1)로 값을 조회·삽입·삭제할 수 있는 자료구조.

**언제 쓰는가** (실무 상황 예시):
- 카테고리별 상품 개수를 세야 할 때
- 고객 ID로 주문 내역을 빠르게 조회해야 할 때
- 중복 데이터를 키 기준으로 묶어 그룹핑해야 할 때
- 두 리스트 간 매칭 여부를 빠르게 확인해야 할 때

### 1.2 핵심 메서드 정리표

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `put(K, V)` | 키-값 쌍 저장. 키가 이미 있으면 값 덮어쓰기 | O(1) | `map.put("apple", 3);` |
| `get(K)` | 키에 해당하는 값 반환. 없으면 `null` | O(1) | `int count = map.get("apple");` |
| `getOrDefault(K, V)` | 키에 해당하는 값 반환. 없으면 기본값 반환 | O(1) | `int count = map.getOrDefault("banana", 0);` |
| `containsKey(K)` | 해당 키가 존재하는지 확인 | O(1) | `if (map.containsKey("apple"))` |
| `containsValue(V)` | 해당 값이 존재하는지 확인 (전체 순회) | **O(n)** | `if (map.containsValue(3))` |
| `remove(K)` | 해당 키의 엔트리 삭제 | O(1) | `map.remove("apple");` |
| `size()` | 저장된 엔트리 수 반환 | O(1) | `int n = map.size();` |
| `isEmpty()` | 비어 있는지 확인 | O(1) | `if (map.isEmpty())` |
| `keySet()` | 모든 키를 Set으로 반환 (뷰) | O(1) | `for (String key : map.keySet())` |
| `values()` | 모든 값을 Collection으로 반환 (뷰) | O(1) | `for (int val : map.values())` |
| `entrySet()` | 모든 키-값 쌍을 Set으로 반환 (뷰) | O(1) | `for (var entry : map.entrySet())` |

> **참고**: `merge`, `computeIfAbsent`, `putIfAbsent` 등 Map 인터페이스의 default 메서드는 Chapter 12에서 상세히 다룹니다.

### 1.3 자매 자료구조 비교 (HashMap vs LinkedHashMap vs TreeMap)

| 비교 항목 | HashMap | LinkedHashMap | TreeMap |
|-----------|---------|---------------|---------|
| 순서 보장 | ❌ 없음 | ✅ 삽입 순서 | ✅ 키의 정렬 순서 |
| put/get 시간복잡도 | O(1) | O(1) | O(log n) |
| null 키 허용 | ✅ 1개 | ✅ 1개 | ❌ |
| 언제 쓰는가 | 순서가 필요 없고 빠른 조회만 필요할 때 | 삽입 순서를 유지해야 할 때 (최근 본 상품 등) | 키를 정렬된 상태로 유지하며 범위 검색이 필요할 때 |

**선택 기준 요약**: 순서가 필요 없으면 HashMap, 삽입 순서가 필요하면 LinkedHashMap, 키 정렬이 필요하면 TreeMap. 대부분의 코딩테스트에서는 HashMap으로 충분합니다.

### 1.4 실무에서 자주 하는 실수

**실수 1: 커스텀 객체를 키로 쓸 때 `equals()`/`hashCode()` 미구현**

```java
// ❌ equals/hashCode 미구현 — 같은 내용이어도 다른 키로 인식
class ProductClass { String id; }         // 일반 클래스는 직접 구현 필요!

// ✅ record는 자동 구현되므로 안전
record Product(String id, String name) {}
```

HashMap은 내부적으로 `hashCode()`로 버킷 위치를 결정하고, `equals()`로 키의 동일성을 판단합니다. 일반 클래스를 키로 쓸 때 이 두 메서드를 재정의하지 않으면, 논리적으로 같은 객체도 다른 키로 취급됩니다. **Java 17의 `record`는 모든 필드를 기준으로 `equals()`/`hashCode()`를 자동 생성하므로 안전합니다.**

**실수 2: `containsValue()`의 O(n) 성능 간과**

```java
// ❌ 값 기준으로 반복 검색 — 매번 O(n)
for (Order order : orders) {
    if (map.containsValue(order.customerId())) { ... }
}

// ✅ 값으로 자주 검색해야 하면 역방향 Map을 별도로 구성
Map<String, String> reverseMap = new HashMap<>();
for (var entry : map.entrySet()) {
    reverseMap.put(entry.getValue(), entry.getKey());
}
```

**실수 3: `get()` 반환값 null 체크 누락**

```java
// ❌ NullPointerException 위험 — auto-unboxing 시 NPE
int count = map.get("nonexistent");

// ✅ getOrDefault 사용
int count = map.getOrDefault("nonexistent", 0);
```

---

## Chapter 2: ArrayList

### 2.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: 내부적으로 배열을 사용하여 인덱스 기반 O(1) 접근이 가능한, 가장 범용적인 가변 길이 리스트.

**언제 쓰는가** (실무 상황 예시):
- 주문 목록, 상품 목록 등 순서가 있는 데이터를 저장할 때
- 결과를 모아서 반환해야 할 때
- 인덱스로 특정 위치의 요소에 빠르게 접근해야 할 때
- 정렬 후 순회가 필요할 때

### 2.2 핵심 메서드 정리표

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `add(E)` | 끝에 요소 추가 | O(1) 평균 | `list.add("item");` |
| `add(int, E)` | 지정 인덱스에 요소 삽입 (뒤 요소 이동) | **O(n)** | `list.add(0, "first");` |
| `get(int)` | 인덱스로 요소 조회 | O(1) | `String item = list.get(2);` |
| `set(int, E)` | 인덱스의 요소를 교체 | O(1) | `list.set(0, "updated");` |
| `remove(int)` | 인덱스의 요소 삭제 (뒤 요소 이동) | **O(n)** | `list.remove(0);` |
| `remove(Object)` | 첫 번째로 일치하는 요소 삭제 | **O(n)** | `list.remove("item");` |
| `contains(Object)` | 요소 존재 여부 확인 (순차 탐색) | **O(n)** | `if (list.contains("item"))` |
| `indexOf(Object)` | 첫 번째 일치 인덱스 반환. 없으면 -1 | **O(n)** | `int idx = list.indexOf("item");` |
| `size()` | 저장된 요소 수 반환 | O(1) | `int n = list.size();` |
| `isEmpty()` | 비어 있는지 확인 | O(1) | `if (list.isEmpty())` |
| `sort(Comparator)` | 리스트를 주어진 기준으로 정렬 | O(n log n) | `list.sort(Comparator.naturalOrder());` |
| `subList(int, int)` | 범위의 뷰(view) 반환 | O(1) | `List<String> sub = list.subList(0, 3);` |

### 2.3 자매 자료구조 비교 (ArrayList vs LinkedList)

| 비교 항목 | ArrayList | LinkedList |
|-----------|-----------|------------|
| 인덱스 접근 `get(i)` | O(1) | **O(n)** |
| 끝에 추가 `add(E)` | O(1) 평균 | O(1) |
| 중간 삽입/삭제 | **O(n)** (요소 이동) | **O(n)** (탐색) + O(1) (연결 변경) |
| 메모리 효율 | ✅ 연속 배열, 캐시 친화적 | ❌ 노드마다 포인터 2개 추가 |
| 실무 선택 빈도 | **거의 항상 ArrayList** | Iterator로 순회하며 삭제가 빈번한 극히 드문 경우 |

**결론**: 실무와 코딩테스트 모두 **ArrayList가 기본 선택**입니다. LinkedList가 "중간 삽입에 유리하다"는 교과서적 설명은, 삽입 위치를 찾기 위한 탐색 비용 O(n)을 고려하면 실제로는 거의 이점이 없습니다. ArrayList의 캐시 지역성(cache locality) 이점이 대부분의 시나리오에서 더 큽니다.

### 2.4 실무에서 자주 하는 실수

**실수 1: `remove(int)` vs `remove(Object)` 혼동**

```java
List<Integer> list = new ArrayList<>(List.of(10, 20, 30));
list.remove(1);           // 인덱스 1의 요소(20) 삭제
list.remove(Integer.valueOf(10)); // 값 10을 찾아서 삭제
```

`List<Integer>`에서 `remove(1)`은 "인덱스 1"로 해석됩니다. 값 1을 삭제하고 싶다면 `remove(Integer.valueOf(1))`을 사용해야 합니다.

**실수 2: `subList()`가 뷰라는 것을 모르고 원본 수정**

```java
List<String> original = new ArrayList<>(List.of("A", "B", "C", "D"));
List<String> sub = original.subList(0, 2); // ["A", "B"] — 원본의 뷰
original.add("E"); // 원본 구조 변경
// sub에 접근하면 ConcurrentModificationException!
```

`subList()`는 원본의 뷰이므로, 원본을 구조적으로 변경하면 뷰가 깨집니다. 독립 복사본이 필요하면 `new ArrayList<>(original.subList(0, 2))`로 감싸세요.

**실수 3: 빈번한 `contains()` 호출 — O(n)의 반복**

```java
// ❌ n개 주문에 대해 매번 contains → O(n²)
for (Order order : orders) {
    if (vipList.contains(order.customerId())) { ... }
}

// ✅ 조회 대상을 HashSet으로 변환 → O(n)
Set<String> vipSet = new HashSet<>(vipList);
for (Order order : orders) {
    if (vipSet.contains(order.customerId())) { ... }
}
```

---

## Chapter 3: HashSet

### 3.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: 중복을 허용하지 않는 요소의 집합으로, 내부적으로 HashMap을 사용하여 O(1)로 추가·조회·삭제가 가능한 자료구조.

**언제 쓰는가** (실무 상황 예시):
- 중복 쿠폰 코드를 제거해야 할 때
- 특정 고객이 이미 구매했는지 빠르게 확인할 때
- 두 그룹 간 교집합·합집합·차집합 연산이 필요할 때
- 리스트에서 고유한 값의 개수를 셀 때

### 3.2 핵심 메서드 정리표

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `add(E)` | 요소 추가. 이미 있으면 `false` 반환 | O(1) | `set.add("coupon-A");` |
| `remove(Object)` | 요소 삭제. 있었으면 `true` 반환 | O(1) | `set.remove("coupon-A");` |
| `contains(Object)` | 요소 존재 여부 확인 | O(1) | `if (set.contains("coupon-A"))` |
| `size()` | 저장된 요소 수 반환 | O(1) | `int n = set.size();` |
| `isEmpty()` | 비어 있는지 확인 | O(1) | `if (set.isEmpty())` |
| `addAll(Collection)` | 합집합 — 다른 컬렉션의 모든 요소 추가 | O(m) | `setA.addAll(setB);` |
| `retainAll(Collection)` | 교집합 — 공통 요소만 남기고 나머지 삭제 | O(n) | `setA.retainAll(setB);` |
| `removeAll(Collection)` | 차집합 — 다른 컬렉션에 있는 요소 모두 삭제 | O(m) | `setA.removeAll(setB);` |

### 3.3 자매 자료구조 비교 (HashSet vs LinkedHashSet vs TreeSet)

| 비교 항목 | HashSet | LinkedHashSet | TreeSet |
|-----------|---------|---------------|---------|
| 순서 보장 | ❌ 없음 | ✅ 삽입 순서 | ✅ 정렬 순서 |
| add/contains 시간복잡도 | O(1) | O(1) | O(log n) |
| null 허용 | ✅ 1개 | ✅ 1개 | ❌ |
| 언제 쓰는가 | 순서 불필요, 중복 제거만 할 때 | 삽입 순서를 유지하며 중복 제거할 때 | 정렬된 고유 값이 필요할 때 |

### 3.4 실무에서 자주 하는 실수

**실수 1: 집합 연산이 원본을 변경한다는 것을 모름**

```java
Set<String> groupA = new HashSet<>(Set.of("Kim", "Lee", "Park"));
Set<String> groupB = new HashSet<>(Set.of("Lee", "Choi"));

groupA.retainAll(groupB); // groupA가 {"Lee"}로 변경됨!

// ✅ 원본을 보존하려면 복사 후 연산
Set<String> intersection = new HashSet<>(groupA);
intersection.retainAll(groupB);
```

**실수 2: 커스텀 객체의 `equals()`/`hashCode()` 미구현** (HashMap과 동일한 원리)

HashSet은 내부적으로 HashMap을 사용하므로, 커스텀 객체를 저장할 때 `equals()`/`hashCode()`가 반드시 필요합니다. `record`를 사용하면 자동으로 해결됩니다.

**실수 3: Set에 순서를 기대하는 코드 작성**

```java
// ❌ HashSet은 순서를 보장하지 않음 — 매 실행마다 순서가 다를 수 있음
Set<String> set = new HashSet<>();
set.add("B"); set.add("A"); set.add("C");
// 순회 순서: "A", "B", "C" 일 수도, "C", "A", "B" 일 수도 있음

// ✅ 삽입 순서가 필요하면 LinkedHashSet
Set<String> ordered = new LinkedHashSet<>();
```

---

## Chapter 4: ArrayDeque

### 4.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: 양쪽 끝에서 O(1)로 삽입·삭제가 가능한 가변 길이 배열 기반 덱(Deque)으로, **Stack과 Queue 역할을 모두 대체**하는 자료구조.

**언제 쓰는가** (실무 상황 예시):
- 장바구니 실행취소(Undo) 기능 — Stack으로 활용
- 주문 처리 대기열 — Queue로 활용
- 최근 N개 이벤트 로그를 유지해야 할 때
- BFS(너비 우선 탐색) 구현 시 Queue로 활용

### 4.2 핵심 메서드 정리표 (Queue 용법)

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `offer(E)` / `offerLast(E)` | 뒤(tail)에 요소 추가 | O(1) | `queue.offer(order);` |
| `poll()` / `pollFirst()` | 앞(head)에서 요소 꺼내기. 비면 `null` | O(1) | `Order next = queue.poll();` |
| `peek()` / `peekFirst()` | 앞(head) 요소 확인. 꺼내지 않음 | O(1) | `Order front = queue.peek();` |
| `offerFirst(E)` | 앞(head)에 요소 추가 | O(1) | `deque.offerFirst(urgentOrder);` |
| `pollLast()` | 뒤(tail)에서 요소 꺼내기 | O(1) | `Order last = deque.pollLast();` |
| `peekLast()` | 뒤(tail) 요소 확인 | O(1) | `Order back = deque.peekLast();` |
| `size()` | 저장된 요소 수 반환 | O(1) | `int n = deque.size();` |
| `isEmpty()` | 비어 있는지 확인 | O(1) | `if (deque.isEmpty())` |

### 4.3 Stack으로서의 활용 (push/pop/peek)

ArrayDeque를 Stack처럼 사용할 때는 **LIFO(Last In, First Out)** 패턴으로, 한쪽 끝에서만 넣고 빼면 됩니다.

| Stack 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|-------------|---------|-----------|-----------|
| `push(E)` | 맨 앞에 요소 추가 (= `addFirst`) | O(1) | `stack.push(action);` |
| `pop()` | 맨 앞에서 요소 꺼내기 (= `removeFirst`) | O(1) | `Action last = stack.pop();` |
| `peek()` | 맨 앞 요소 확인 (= `peekFirst`) | O(1) | `Action top = stack.peek();` |

```java
// 장바구니 실행취소 예시
Deque<String> undoStack = new ArrayDeque<>();
undoStack.push("상품A 추가");
undoStack.push("상품B 추가");
undoStack.push("상품A 삭제");

String lastAction = undoStack.pop(); // "상품A 삭제"
```

### 4.4 java.util.Stack을 쓰지 않는 이유

`java.util.Stack`은 Java 1.0부터 존재하는 **레거시 클래스**입니다. 사용하지 않는 이유는 두 가지입니다:

1. **`Vector`를 상속**: `Stack`은 `Vector`를 상속하므로, 모든 메서드에 `synchronized`가 걸려 있어 단일 스레드 환경에서 불필요한 성능 오버헤드가 발생합니다.
2. **잘못된 상속 구조**: `Vector`의 인덱스 기반 메서드(`get(i)`, `add(i, e)`)가 그대로 노출되어, Stack의 LIFO 원칙을 깨는 접근이 가능합니다.

**Java 공식 문서도 `ArrayDeque`를 Stack 대용으로 권장합니다.**

### 4.5 실무에서 자주 하는 실수

**실수 1: Stack으로 쓸 때 `push`/`pop`의 방향 혼동**

`push()`는 `addFirst()`와 같고, `pop()`은 `removeFirst()`와 같습니다. 즉, ArrayDeque의 Stack 동작은 **앞쪽(head)**에서 일어납니다.

**실수 2: null을 넣으려다 `NullPointerException` 발생**

```java
Deque<String> deque = new ArrayDeque<>();
deque.offer(null); // NullPointerException!
```

ArrayDeque는 **null을 허용하지 않습니다**. `poll()`이 빈 덱에서 `null`을 반환하는 것과 구분하기 위함입니다.

**실수 3: Queue로 쓸 때 `add()`/`remove()` vs `offer()`/`poll()` 혼용**

- `add()` / `remove()`: 실패 시 **예외**를 던짐
- `offer()` / `poll()`: 실패 시 `false` 또는 `null`을 반환

코딩테스트에서는 `offer()`/`poll()`/`peek()` 사용을 권장합니다. 예외를 피하고 null 체크로 흐름을 제어하는 것이 더 안전합니다.

---

## Chapter 5: TreeMap

### 5.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: 키를 **정렬된 상태**로 유지하는 Map으로, Red-Black Tree 기반이며 범위 검색에 강한 자료구조.

**언제 쓰는가** (실무 상황 예시):
- 가격대별 상품을 범위로 검색해야 할 때 (10,000원~30,000원 사이 상품)
- 날짜순으로 정렬된 주문 내역을 조회해야 할 때
- "~이하", "~이상" 기준으로 가장 가까운 값을 찾아야 할 때
- 키의 최솟값·최댓값을 O(log n)으로 빠르게 가져와야 할 때

### 5.2 핵심 메서드 정리표

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `put(K, V)` | 키-값 쌍 저장 (정렬 위치에 삽입) | O(log n) | `treeMap.put(15000, "티셔츠");` |
| `get(K)` | 키에 해당하는 값 반환 | O(log n) | `String item = treeMap.get(15000);` |
| `remove(K)` | 해당 키의 엔트리 삭제 | O(log n) | `treeMap.remove(15000);` |
| `firstKey()` | 가장 작은 키 반환 | O(log n) | `int min = treeMap.firstKey();` |
| `lastKey()` | 가장 큰 키 반환 | O(log n) | `int max = treeMap.lastKey();` |
| `ceilingKey(K)` | 주어진 키 **이상**인 가장 작은 키 | O(log n) | `Integer k = treeMap.ceilingKey(12000);` |
| `floorKey(K)` | 주어진 키 **이하**인 가장 큰 키 | O(log n) | `Integer k = treeMap.floorKey(20000);` |
| `headMap(K)` | 주어진 키 **미만**의 부분 맵 (뷰) | O(log n) | `SortedMap<K,V> sub = treeMap.headMap(20000);` |
| `tailMap(K)` | 주어진 키 **이상**의 부분 맵 (뷰) | O(log n) | `SortedMap<K,V> sub = treeMap.tailMap(10000);` |
| `subMap(K, K)` | 두 키 사이의 부분 맵 (뷰, 시작 포함/끝 미포함) | O(log n) | `SortedMap<K,V> sub = treeMap.subMap(10000, 30000);` |

### 5.3 자매 자료구조 비교 (TreeMap vs HashMap vs LinkedHashMap)

| 상황 | 최적 선택 | 이유 |
|------|-----------|------|
| "가격이 10,000~30,000원인 상품은?" | **TreeMap** | `subMap()`으로 범위 검색 가능 |
| "이 상품 ID의 재고가 몇 개인지?" | **HashMap** | 단순 키 조회, O(1)이 O(log n)보다 빠름 |
| "고객이 본 상품 순서대로 보여줘" | **LinkedHashMap** | 삽입 순서 유지 |

**핵심 판단**: "키로 범위 검색이나 정렬이 필요한가?" → 예: TreeMap, 아니오: HashMap.

### 5.4 실무에서 자주 하는 실수

**실수 1: 범위 검색 경계의 포함/미포함 혼동**

```java
TreeMap<Integer, String> map = new TreeMap<>();
map.put(10000, "A"); map.put(20000, "B"); map.put(30000, "C");

map.subMap(10000, 30000); // {10000=A, 20000=B} — 시작 포함, 끝 미포함!
map.subMap(10000, true, 30000, true); // {10000=A, 20000=B, 30000=C} — 양쪽 포함
```

**실수 2: null 키 삽입 시도**

TreeMap은 키를 비교해야 하므로 **null 키를 허용하지 않습니다**. `put(null, value)`는 `NullPointerException`을 발생시킵니다.

**실수 3: 단순 조회에 TreeMap 사용 — 불필요한 성능 손해**

범위 검색이 필요 없는 단순 키-값 조회라면 HashMap(O(1))이 TreeMap(O(log n))보다 항상 효율적입니다. "혹시 나중에 정렬이 필요할까봐" 미리 TreeMap을 쓰는 것은 낭비입니다.

---

## Chapter 6: PriorityQueue

### 6.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: 요소를 넣는 순서와 무관하게, 꺼낼 때 항상 **우선순위가 가장 높은(가장 작은) 요소**가 먼저 나오는 큐.

**언제 쓰는가** (실무 상황 예시):
- 리뷰 평점 상위 N개 상품을 추출할 때 (Top-K 문제)
- 주문 처리에서 긴급 주문을 먼저 처리해야 할 때
- 배송비가 가장 저렴한 옵션을 빠르게 찾아야 할 때

### 6.2 핵심 메서드 정리표

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `offer(E)` | 우선순위에 맞는 위치에 요소 추가 | O(log n) | `pq.offer(order);` |
| `poll()` | 우선순위가 가장 높은 요소 꺼내기. 비면 `null` | O(log n) | `Order urgent = pq.poll();` |
| `peek()` | 우선순위가 가장 높은 요소 확인. 꺼내지 않음 | O(1) | `Order top = pq.peek();` |
| `size()` | 저장된 요소 수 반환 | O(1) | `int n = pq.size();` |
| `isEmpty()` | 비어 있는지 확인 | O(1) | `if (pq.isEmpty())` |
| `remove(Object)` | 특정 요소 삭제 | **O(n)** | `pq.remove(cancelledOrder);` |
| `contains(Object)` | 요소 존재 여부 확인 | **O(n)** | `if (pq.contains(order))` |

> **기본 정렬**: Comparator를 지정하지 않으면 **오름차순(자연 순서)**. 가장 작은 값이 먼저 나옵니다.

### 6.3 자매 자료구조 비교 (PriorityQueue vs TreeSet vs List+sort)

| 상황 | 최적 선택 | 이유 |
|------|-----------|------|
| "상위 N개만 뽑으면 됨, 중복 허용" | **PriorityQueue** | poll()을 N번 호출하면 끝. O(n log n) |
| "정렬된 고유 값 전체가 필요" | **TreeSet** | 중복 제거 + 정렬 동시 |
| "한 번 정렬 후 순서대로 순회" | **List + sort** | 정렬 후 인덱스 접근. 가장 단순 |

### 6.4 실무에서 자주 하는 실수

**실수 1: PriorityQueue를 그대로 순회하면 정렬 순서가 아님**

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(List.of(30, 10, 20));

// ❌ for-each로 순회하면 정렬 순서 보장되지 않음!
for (int val : pq) { System.out.print(val + " "); } // 10 30 20 (힙 내부 순서)

// ✅ 정렬 순서대로 꺼내려면 poll()을 반복
while (!pq.isEmpty()) {
    System.out.print(pq.poll() + " "); // 10 20 30
}
```

PriorityQueue는 내부적으로 **힙(heap)** 구조이므로, 전체가 정렬되어 있지 않습니다. 정렬 순서는 `poll()`로 꺼낼 때만 보장됩니다.

**실수 2: Top-K에서 최소 힙 vs 최대 힙 혼동**

```java
// "상위 3개"를 구할 때 — 최소 힙(size 3)을 유지하는 전략
PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 기본: 최소 힙
for (int score : scores) {
    minHeap.offer(score);
    if (minHeap.size() > 3) minHeap.poll(); // 가장 작은 값 제거 → 큰 값 3개 남음
}

// 전체를 최대 힙에 넣고 3번 poll하는 방법도 있음
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
```

**실수 3: Comparator 미지정 시 `ClassCastException`**

`Comparable`을 구현하지 않은 커스텀 객체를 Comparator 없이 넣으면 런타임 에러가 발생합니다. record에 자연 순서를 부여하려면 `Comparable`을 구현하거나, 생성 시 `Comparator`를 반드시 지정하세요.

---

## Chapter 7: LinkedHashMap

### 7.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: HashMap의 O(1) 성능을 유지하면서, **삽입 순서(또는 접근 순서)**를 기억하는 Map.

**언제 쓰는가** (실무 상황 예시):
- 고객이 최근 본 상품을 **본 순서대로** 보여줘야 할 때
- 설정 값을 넣은 순서대로 출력해야 할 때
- LRU(Least Recently Used) 캐시를 간단하게 구현할 때

### 7.2 핵심 메서드 정리표

기본 메서드는 HashMap과 동일하며(put, get, remove, containsKey 등 모두 O(1)), 핵심 차이는 **순회 순서**입니다.

| 메서드/특성 | 하는 일 | 시간복잡도 | 예시 코드 |
|------------|---------|-----------|-----------|
| `put(K, V)` | 키-값 쌍 저장. **삽입 순서 기록** | O(1) | `map.put("A", 1);` |
| `get(K)` | 키에 해당하는 값 반환. accessOrder면 **순서 갱신** | O(1) | `map.get("A");` |
| `entrySet()` 순회 | **삽입(또는 접근) 순서대로** 순회 | O(n) | `for (var entry : map.entrySet())` |
| `removeEldestEntry()` | 가장 오래된 엔트리 자동 삭제 조건 정의 (오버라이드용) | O(1) | 아래 예시 참조 |

### 7.3 삽입 순서 vs 접근 순서 (accessOrder)

```java
// 삽입 순서 모드 (기본값)
Map<String, Integer> insertionOrder = new LinkedHashMap<>();
insertionOrder.put("A", 1);
insertionOrder.put("B", 2);
insertionOrder.put("C", 3);
insertionOrder.get("A"); // 조회해도 순서 불변
// 순회: A → B → C

// 접근 순서 모드 (accessOrder = true)
Map<String, Integer> accessOrder = new LinkedHashMap<>(16, 0.75f, true);
accessOrder.put("A", 1);
accessOrder.put("B", 2);
accessOrder.put("C", 3);
accessOrder.get("A"); // A가 가장 최근 접근으로 이동
// 순회: B → C → A
```

**LRU 캐시 간단 구현**:

```java
Map<String, String> lruCache = new LinkedHashMap<>(16, 0.75f, true) {
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size() > 100; // 100개 초과 시 가장 오래된 항목 자동 삭제
    }
};
```

### 7.4 실무에서 자주 하는 실수

**실수 1: 기본 생성자가 삽입 순서라는 것을 모르고 접근 순서를 기대**

3-파라미터 생성자(`new LinkedHashMap<>(capacity, loadFactor, accessOrder)`)에서 세 번째 인자를 `true`로 줘야 접근 순서 모드입니다. 기본값은 `false`(삽입 순서)입니다.

**실수 2: accessOrder 모드에서 순회 중 `get()` 호출 → `ConcurrentModificationException`**

접근 순서 모드에서는 `get()`도 내부 구조를 변경(접근된 노드를 끝으로 이동)하므로, 순회 중 `get()`을 호출하면 예외가 발생합니다.

---

## Chapter 8: LinkedList

### 8.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: 이중 연결 리스트(Doubly Linked List) 기반 구현으로, **양쪽 끝 삽입/삭제가 O(1)**이며 `List`와 `Deque` 인터페이스를 모두 구현하는 자료구조.

**언제 쓰는가** (실무 상황 예시):
- Iterator를 통해 순회하면서 중간 삭제가 빈번할 때 (Iterator.remove() 활용)
- List와 Deque(Queue) 인터페이스를 동시에 필요로 하는 드문 경우

> **현실적 조언**: 실무와 코딩테스트 모두 ArrayList + ArrayDeque 조합이 LinkedList보다 거의 항상 낫습니다. LinkedList를 명시적으로 선택해야 하는 상황은 매우 드뭅니다.

### 8.2 핵심 메서드 정리표

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `add(E)` / `addLast(E)` | 끝에 요소 추가 | O(1) | `list.addLast(item);` |
| `addFirst(E)` | 앞에 요소 추가 | O(1) | `list.addFirst(item);` |
| `get(int)` | 인덱스로 요소 조회 (**순차 탐색**) | **O(n)** | `String item = list.get(3);` |
| `removeFirst()` | 앞의 요소 삭제 | O(1) | `list.removeFirst();` |
| `removeLast()` | 뒤의 요소 삭제 | O(1) | `list.removeLast();` |
| `remove(int)` | 인덱스의 요소 삭제 (탐색 후 연결 해제) | **O(n)** | `list.remove(2);` |
| `getFirst()` | 앞의 요소 확인 | O(1) | `String first = list.getFirst();` |
| `getLast()` | 뒤의 요소 확인 | O(1) | `String last = list.getLast();` |

### 8.3 자매 자료구조 비교 (LinkedList vs ArrayList — 언제 LinkedList가 유리한가)

| 연산 | ArrayList | LinkedList |
|------|-----------|------------|
| `get(i)` (인덱스 접근) | **O(1)** ✅ | O(n) |
| 끝에 추가 `add(E)` | O(1) 평균 | O(1) |
| **앞에 추가/삭제** | **O(n)** (요소 이동) | **O(1)** ✅ |
| Iterator로 순회 중 삭제 | O(n) (요소 이동) | **O(1)** (연결 해제) ✅ |
| 메모리 효율 | ✅ (연속 배열) | ❌ (노드당 포인터 2개) |

**LinkedList가 유리한 "이론적" 상황**: Iterator를 사용해 순회하면서, 조건에 맞는 요소를 빈번하게 삭제해야 하는 경우.
**현실**: 이 경우에도 `ArrayList` + `removeIf()`가 더 간결하고 대부분 충분합니다. LinkedList를 쓸 일이 있다면, "왜 ArrayList가 안 되는지"를 먼저 자문하세요.

### 8.4 실무에서 자주 하는 실수

**실수 1: 인덱스 기반 접근을 반복문에서 사용**

```java
// ❌ O(n²) — get(i)마다 처음부터 탐색
for (int i = 0; i < linkedList.size(); i++) {
    process(linkedList.get(i));
}

// ✅ O(n) — for-each 또는 Iterator 사용
for (String item : linkedList) {
    process(item);
}
```

**실수 2: "중간 삽입이 빠르다"는 말을 맹신**

교과서에서 "LinkedList는 중간 삽입이 O(1)"이라고 하지만, 이는 **이미 해당 노드의 참조를 가지고 있을 때**의 이야기입니다. 삽입 위치를 인덱스로 찾아야 한다면 탐색에 O(n)이 걸리므로 ArrayList와 차이가 없습니다.

---

## Chapter 9: TreeSet

### 9.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: 요소를 **정렬된 상태**로 유지하는 Set으로, 내부적으로 TreeMap을 사용하며 범위 탐색과 정렬된 고유 값 관리에 특화된 자료구조.

**언제 쓰는가** (실무 상황 예시):
- 가격 목록에서 중복 없이 정렬된 상태를 유지해야 할 때
- "10,000원 이상의 가격 중 가장 저렴한 것은?" 같은 범위 질의가 필요할 때
- 정렬 + 중복 제거를 동시에 해야 할 때

### 9.2 핵심 메서드 정리표

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `add(E)` | 정렬 위치에 요소 추가. 중복이면 `false` | O(log n) | `set.add(15000);` |
| `remove(Object)` | 요소 삭제 | O(log n) | `set.remove(15000);` |
| `contains(Object)` | 요소 존재 여부 확인 | O(log n) | `if (set.contains(15000))` |
| `first()` | 가장 작은 요소 | O(log n) | `int min = set.first();` |
| `last()` | 가장 큰 요소 | O(log n) | `int max = set.last();` |
| `ceiling(E)` | 주어진 값 **이상**인 가장 작은 요소 | O(log n) | `Integer val = set.ceiling(12000);` |
| `floor(E)` | 주어진 값 **이하**인 가장 큰 요소 | O(log n) | `Integer val = set.floor(20000);` |
| `headSet(E)` | 주어진 값 **미만**의 부분 집합 (뷰) | O(log n) | `SortedSet<Integer> sub = set.headSet(20000);` |
| `tailSet(E)` | 주어진 값 **이상**의 부분 집합 (뷰) | O(log n) | `SortedSet<Integer> sub = set.tailSet(10000);` |
| `subSet(E, E)` | 두 값 사이의 부분 집합 (뷰) | O(log n) | `SortedSet<Integer> sub = set.subSet(10000, 30000);` |

### 9.3 자매 자료구조 비교 (TreeSet vs HashSet vs LinkedHashSet)

| 상황 | 최적 선택 | 이유 |
|------|-----------|------|
| "고유 값만 필요, 순서 불필요" | **HashSet** | O(1) 성능 |
| "고유 값을 삽입 순서대로 유지" | **LinkedHashSet** | O(1) + 삽입 순서 |
| "고유 값을 정렬 순서로 유지, 범위 검색 필요" | **TreeSet** | O(log n) + 정렬 + 범위 |

### 9.4 실무에서 자주 하는 실수

**실수 1: Comparable 미구현 객체를 넣고 `ClassCastException`**

TreeSet은 요소를 비교해야 하므로, `Comparable`을 구현하지 않은 객체를 Comparator 없이 넣으면 런타임 에러가 발생합니다.

```java
// ✅ Comparator를 생성자에 전달
TreeSet<Product> set = new TreeSet<>(Comparator.comparing(Product::price));
```

**실수 2: `headSet`/`tailSet`/`subSet`의 경계 포함 여부 혼동** (TreeMap과 동일)

`subSet(from, to)`는 `from` 포함, `to` 미포함입니다. 양쪽 포함이 필요하면 `subSet(from, true, to, true)`를 사용하세요.

---

## Chapter 10: LinkedHashSet

### 10.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: **삽입 순서를 유지**하면서 중복을 허용하지 않는 Set으로, 내부적으로 LinkedHashMap을 사용하는 자료구조.

**언제 쓰는가** (실무 상황 예시):
- 중복 쿠폰 코드를 제거하되, **발급 순서를 유지**해야 할 때
- 고객 방문 기록에서 방문한 페이지를 중복 없이 **방문 순서대로** 보여줘야 할 때
- 결과의 순서가 테스트 케이스에서 검증 대상일 때 (순서 보장 필요)

### 10.2 핵심 메서드 정리표

HashSet과 메서드가 동일하며, 차이는 **순회 순서가 삽입 순서와 일치**한다는 점입니다.

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `add(E)` | 요소 추가. 이미 있으면 `false` | O(1) | `set.add("page-A");` |
| `remove(Object)` | 요소 삭제 | O(1) | `set.remove("page-A");` |
| `contains(Object)` | 요소 존재 여부 확인 | O(1) | `if (set.contains("page-A"))` |
| 순회 | **삽입 순서대로** 순회 | O(n) | `for (String page : set)` |

### 10.3 자매 자료구조 비교 (LinkedHashSet vs HashSet vs TreeSet)

| 비교 항목 | HashSet | LinkedHashSet | TreeSet |
|-----------|---------|---------------|---------|
| 순서 | ❌ | ✅ 삽입 순서 | ✅ 정렬 순서 |
| add/contains | O(1) | O(1) | O(log n) |
| 메모리 | 가장 적음 | 약간 더 사용 (연결 리스트 유지) | 가장 많음 (트리 노드) |
| 선택 기준 | 순서 불필요 | 삽입 순서 유지 | 정렬 필요 |

### 10.4 실무에서 자주 하는 실수

**실수 1: "이미 있는 요소를 다시 add하면 순서가 갱신될 것"이라는 오해**

```java
Set<String> set = new LinkedHashSet<>();
set.add("A"); set.add("B"); set.add("C");
set.add("A"); // 이미 존재 → false 반환, 순서 변경 없음!
// 순회: A → B → C (A가 끝으로 가지 않음)

// ✅ 순서를 갱신하려면 제거 후 재삽입
set.remove("A");
set.add("A");
// 순회: B → C → A
```

**실수 2: 정렬이 필요한데 LinkedHashSet을 사용**

LinkedHashSet은 **삽입 순서**를 유지할 뿐, 값을 정렬하지 않습니다. 정렬된 고유 값이 필요하면 TreeSet을 사용하세요.

---

## Chapter 11: Comparator / Collections.sort / List.sort

### 11.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: 객체 간의 정렬 순서를 정의하는 함수형 인터페이스(`Comparator`)와, 이를 적용하여 리스트를 정렬하는 메서드(`Collections.sort`, `List.sort`).

**언제 쓰는가** (실무 상황 예시):
- 주문 내역을 금액 내림차순으로 정렬할 때
- 상품을 카테고리순 → 같은 카테고리 내에서 가격순으로 다중 조건 정렬할 때
- PriorityQueue, TreeMap, TreeSet에 커스텀 정렬 기준을 지정할 때

### 11.2 핵심 메서드 정리표

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `Comparator.comparing(keyExtractor)` | 특정 필드 기준 Comparator 생성 | - | `Comparator.comparing(Order::amount)` |
| `.thenComparing(keyExtractor)` | 1차 정렬이 같을 때 2차 정렬 기준 추가 | - | `.thenComparing(Order::date)` |
| `.reversed()` | 정렬 순서 뒤집기 (내림차순) | - | `Comparator.comparing(Order::amount).reversed()` |
| `Comparator.naturalOrder()` | Comparable의 자연 순서 | - | `Comparator.naturalOrder()` |
| `Comparator.reverseOrder()` | 자연 순서의 역순 | - | `Comparator.reverseOrder()` |
| `list.sort(Comparator)` | List를 주어진 기준으로 정렬 (제자리) | O(n log n) | `orders.sort(Comparator.comparing(Order::amount));` |
| `Collections.sort(List)` | List를 자연 순서로 정렬 | O(n log n) | `Collections.sort(names);` |
| `Collections.sort(List, Comparator)` | List를 주어진 기준으로 정렬 | O(n log n) | `Collections.sort(orders, comp);` |

### 11.3 대안 접근법 비교 (Comparable vs Comparator, Collections.sort vs List.sort)

**Comparable vs Comparator**:

| 비교 항목 | Comparable | Comparator |
|-----------|-----------|------------|
| 구현 위치 | 클래스 내부에 `compareTo()` 구현 | 클래스 외부에서 별도 생성 |
| 정렬 기준 수 | 1개 (자연 순서) | **무제한** (상황별 다른 기준) |
| 적합한 상황 | "이 클래스의 기본 정렬 순서는 이것" | "지금 이 상황에서는 이 기준으로 정렬" |
| 코테 추천 | 거의 사용 안 함 | ✅ **Comparator.comparing + 람다** 권장 |

**Collections.sort vs List.sort**:

```java
// 둘 다 동일한 결과. List.sort가 더 간결하고 현대적
Collections.sort(orders, Comparator.comparing(Order::amount));
orders.sort(Comparator.comparing(Order::amount));  // ✅ 권장
```

`List.sort()`는 Java 8에서 추가된 default 메서드로, `Collections.sort()`보다 간결합니다. 내부적으로 동일한 Tim Sort 알고리즘을 사용하므로 성능 차이는 없습니다.

### 11.4 실무에서 자주 하는 실수

**실수 1: 다중 조건 정렬에서 `reversed()`의 적용 범위 혼동**

```java
// ❌ 전체 정렬 순서가 뒤집힘 — category도 역순이 됨
orders.sort(Comparator.comparing(Order::category)
        .thenComparing(Order::amount)
        .reversed());

// ✅ amount만 역순으로 하고 싶다면
orders.sort(Comparator.comparing(Order::category)
        .thenComparing(Comparator.comparing(Order::amount).reversed()));

// ✅ 또는 thenComparing에 reverseOrder 전달
orders.sort(Comparator.comparing(Order::category)
        .thenComparing(Order::amount, Comparator.reverseOrder()));
```

**실수 2: 원시 타입 필드 비교 시 박싱 비용**

```java
// 원시 타입 int 필드면 comparingInt 사용 권장 (불필요한 박싱 방지)
orders.sort(Comparator.comparingInt(Order::quantity));
// comparingLong, comparingDouble도 동일
```

**실수 3: null이 포함된 리스트 정렬 시 `NullPointerException`**

```java
// ✅ null을 처리하려면 nullsFirst / nullsLast 사용
orders.sort(Comparator.comparing(Order::category,
        Comparator.nullsLast(Comparator.naturalOrder())));
```

---

## Chapter 12: Map의 고급 메서드

### 12.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: Java 8+에서 Map 인터페이스에 추가된 default 메서드들로, **"키가 없으면 생성, 있으면 갱신"** 패턴을 한 줄로 처리할 수 있게 해주는 API.

**언제 쓰는가** (실무 상황 예시):
- 카테고리별 상품 개수를 셀 때 (`merge`)
- 고객별 구매 목록을 그룹핑할 때 (`computeIfAbsent`)
- 기본값을 제공하며 조회할 때 (`getOrDefault`)
- 키가 없을 때만 초기값을 넣고 싶을 때 (`putIfAbsent`)

### 12.2 핵심 메서드 정리표

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `getOrDefault(K, V)` | 키가 있으면 값 반환, 없으면 기본값 반환 | O(1) | `int cnt = map.getOrDefault("A", 0);` |
| `putIfAbsent(K, V)` | 키가 없을 때만 값 저장. 이미 있으면 기존 값 유지 | O(1) | `map.putIfAbsent("A", new ArrayList<>());` |
| `merge(K, V, BiFunction)` | 키가 없으면 값 저장, 있으면 BiFunction으로 기존+새 값 병합 | O(1) | `map.merge("A", 1, Integer::sum);` |
| `computeIfAbsent(K, Function)` | 키가 없을 때만 Function으로 값 생성하여 저장 | O(1) | `map.computeIfAbsent("A", k -> new ArrayList<>());` |
| `replaceAll(BiFunction)` | 모든 엔트리의 값을 BiFunction 결과로 교체 | O(n) | `map.replaceAll((k, v) -> v * 2);` |

### 12.3 대안 접근법 비교 (getOrDefault+put vs merge vs computeIfAbsent)

**패턴 1: 빈도 세기 (카운팅)**

```java
// 방법 A: getOrDefault + put — 가장 직관적
map.put(key, map.getOrDefault(key, 0) + 1);

// 방법 B: merge — 가장 간결 ✅ 권장
map.merge(key, 1, Integer::sum);
```

`merge`는 "없으면 1을 넣고, 있으면 기존 값에 1을 더한다"를 한 줄로 표현합니다. 빈도 세기의 정석입니다.

**패턴 2: 그룹핑 (키별 리스트 관리)**

```java
// 방법 A: containsKey + get + put — 장황함
if (!map.containsKey(key)) {
    map.put(key, new ArrayList<>());
}
map.get(key).add(value);

// 방법 B: computeIfAbsent — 간결하고 안전 ✅ 권장
map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
```

`computeIfAbsent`는 "키가 없으면 리스트를 만들어 넣고, 있으면 기존 리스트를 반환"하여 바로 `add()`를 체이닝할 수 있습니다.

**패턴 3: 초기값 설정 (최초 1회만)**

```java
// putIfAbsent: 키가 없을 때만 값 저장. 이미 있으면 무시
map.putIfAbsent("config", "default-value");
```

| 패턴 | 추천 메서드 | 핵심 차이 |
|------|-----------|-----------|
| 빈도 세기 | `merge` | 없으면 생성, 있으면 **기존 값과 합산** |
| 그룹핑 | `computeIfAbsent` | 없으면 생성, 있으면 **기존 컬렉션 반환** |
| 초기값 설정 | `putIfAbsent` | 없으면 생성, 있으면 **아무것도 안 함** |
| 안전한 조회 | `getOrDefault` | 값을 저장하지 않고 **기본값만 반환** |

### 12.4 실무에서 자주 하는 실수

**실수 1: `getOrDefault`가 Map에 값을 저장한다고 착각**

```java
int count = map.getOrDefault("A", 0); // Map에는 "A"가 여전히 없음!
// 값을 저장하려면 별도로 put 필요
```

**실수 2: `computeIfAbsent` vs `putIfAbsent` 혼동**

```java
// computeIfAbsent: 값 생성을 "필요할 때만" 지연 실행 (lazy)
map.computeIfAbsent("A", k -> expensiveCreate()); // "A"가 있으면 함수 실행 안 함

// putIfAbsent: 값이 이미 만들어져 있어야 함 (eager)
map.putIfAbsent("A", expensiveCreate()); // "A"가 있어도 함수는 이미 실행됨!
```

비용이 큰 객체 생성이라면 `computeIfAbsent`가 적합합니다.

**실수 3: `merge`의 BiFunction에서 null 반환 시 엔트리 삭제**

```java
// merge의 BiFunction이 null을 반환하면 해당 키가 Map에서 삭제됨!
map.merge("A", 1, (oldVal, newVal) -> oldVal + newVal > 10 ? null : oldVal + newVal);
// 합계가 10 초과면 키 자체가 삭제됨 — 의도치 않은 동작일 수 있음
```

---

## Chapter 13: Iterator와 안전한 순회 중 삭제

### 13.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: 컬렉션의 요소를 하나씩 순회하면서, **순회 도중 안전하게 요소를 삭제**할 수 있는 메커니즘.

**언제 쓰는가** (실무 상황 예시):
- 주문 목록에서 취소된 주문을 순회하며 제거해야 할 때
- 장바구니에서 재고가 없는 상품을 필터링해야 할 때
- Map에서 조건에 맞지 않는 엔트리를 제거해야 할 때

### 13.2 핵심 메서드 정리표

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `iterator()` | 컬렉션의 Iterator 반환 | O(1) | `Iterator<String> it = list.iterator();` |
| `hasNext()` | 다음 요소 존재 여부 확인 | O(1) | `while (it.hasNext())` |
| `next()` | 다음 요소 반환하고 커서 이동 | O(1) | `String item = it.next();` |
| `remove()` | `next()`로 마지막 반환된 요소 삭제 | O(1)~O(n) | `it.remove();` |
| `Collection.removeIf(Predicate)` | 조건에 맞는 모든 요소 삭제 | O(n) | `list.removeIf(o -> o.isCancelled());` |

### 13.3 대안 접근법 비교 (Iterator.remove vs removeIf vs 새 컬렉션 복사)

```java
List<Order> orders = new ArrayList<>(/* ... */);

// 방법 1: Iterator.remove — 명시적이고 세밀한 제어 가능
Iterator<Order> it = orders.iterator();
while (it.hasNext()) {
    Order order = it.next();
    if (order.isCancelled()) {
        it.remove();
    }
}

// 방법 2: removeIf — 가장 간결 ✅ 권장
orders.removeIf(Order::isCancelled);

// 방법 3: 새 컬렉션에 복사 — 원본을 유지해야 할 때
List<Order> activeOrders = new ArrayList<>();
for (Order order : orders) {
    if (!order.isCancelled()) {
        activeOrders.add(order);
    }
}
```

| 방법 | 장점 | 단점 |
|------|------|------|
| `Iterator.remove()` | 삭제 전후에 추가 로직 삽입 가능 | 코드가 장황 |
| `removeIf()` | **가장 간결**, 내부적으로 Iterator 사용 | 삭제 외 추가 동작 불가 |
| 새 컬렉션 복사 | 원본 불변 보장 | 메모리 추가 사용 |

### 13.4 실무에서 자주 하는 실수 (ConcurrentModificationException)

**실수 1: for-each 안에서 `remove()` 호출**

```java
// ❌ ConcurrentModificationException 발생!
for (Order order : orders) {
    if (order.isCancelled()) {
        orders.remove(order); // 순회 중 구조 변경 → 예외!
    }
}

// ✅ removeIf 사용
orders.removeIf(Order::isCancelled);
```

for-each 문은 내부적으로 Iterator를 사용하지만, 컬렉션의 `remove()`는 Iterator를 거치지 않으므로 **구조적 변경이 감지**되어 예외가 발생합니다.

**실수 2: Iterator에서 `next()` 없이 `remove()` 호출**

```java
Iterator<Order> it = orders.iterator();
it.remove(); // ❌ IllegalStateException — next()를 먼저 호출해야 함
```

`remove()`는 가장 최근에 `next()`로 반환된 요소를 삭제합니다. `next()` 호출 전이나, 이미 `remove()` 후 연속 `remove()` 호출은 `IllegalStateException`을 발생시킵니다.

**실수 3: Map 순회 중 삭제 — entrySet에서도 동일 규칙**

```java
// ❌ ConcurrentModificationException
for (var entry : map.entrySet()) {
    if (entry.getValue() == 0) {
        map.remove(entry.getKey()); // 예외!
    }
}

// ✅ Iterator 사용
Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
while (it.hasNext()) {
    if (it.next().getValue() == 0) {
        it.remove();
    }
}

// ✅ 또는 Java 8+ — entrySet().removeIf()
map.entrySet().removeIf(entry -> entry.getValue() == 0);
```

---

## Chapter 14: Collections 유틸리티

### 14.1 한 줄 정의 & 언제 쓰는가

**한 줄 정의**: `java.util.Collections` 클래스가 제공하는 정적 유틸리티 메서드 모음으로, 컬렉션의 최댓값·최솟값 조회, 빈도 계산, 불변 래핑 등을 제공.

**언제 쓰는가** (실무 상황 예시):
- 리스트에서 최댓값/최솟값을 빠르게 구할 때
- 특정 요소의 등장 횟수를 셀 때
- 외부에 반환하는 리스트를 수정 불가능하게 보호할 때

### 14.2 핵심 메서드 정리표

| 메서드 | 하는 일 | 시간복잡도 | 예시 코드 |
|--------|---------|-----------|-----------|
| `Collections.max(Collection)` | 자연 순서 기준 최댓값 반환 | O(n) | `int max = Collections.max(prices);` |
| `Collections.max(Collection, Comparator)` | 주어진 기준 최댓값 | O(n) | `Order top = Collections.max(orders, Comparator.comparing(Order::amount));` |
| `Collections.min(Collection)` | 자연 순서 기준 최솟값 반환 | O(n) | `int min = Collections.min(prices);` |
| `Collections.frequency(Collection, Object)` | 특정 요소의 등장 횟수 | O(n) | `int cnt = Collections.frequency(list, "apple");` |
| `Collections.unmodifiableList(List)` | 수정 불가능한 리스트 뷰 반환 | O(1) | `List<String> safe = Collections.unmodifiableList(list);` |
| `Collections.unmodifiableMap(Map)` | 수정 불가능한 맵 뷰 반환 | O(1) | `Map<K,V> safe = Collections.unmodifiableMap(map);` |
| `Collections.singletonList(E)` | 요소 1개짜리 불변 리스트 생성 | O(1) | `List<String> one = Collections.singletonList("only");` |
| `Collections.emptyList()` | 빈 불변 리스트 반환 | O(1) | `List<String> empty = Collections.emptyList();` |

### 14.3 대안 접근법 비교 (unmodifiableList vs List.of vs List.copyOf)

| 방법 | 원본 변경 반영 | null 허용 | 생성 방식 |
|------|--------------|-----------|-----------|
| `Collections.unmodifiableList(list)` | ✅ **반영됨** (뷰) | ✅ | 기존 리스트를 래핑 |
| `List.of("A", "B")` | - (새로 생성) | ❌ | 리터럴로 불변 리스트 생성 |
| `List.copyOf(list)` | ❌ 반영 안 됨 (복사본) | ❌ | 기존 리스트를 **복사**하여 불변화 |

```java
List<String> original = new ArrayList<>(List.of("A", "B"));

// unmodifiableList: 원본의 "뷰" — 원본이 바뀌면 뷰도 바뀜
List<String> view = Collections.unmodifiableList(original);
original.add("C");
System.out.println(view); // [A, B, C] — 원본 변경이 반영됨!

// List.copyOf: 독립 복사본 — 원본 변경 무관
List<String> copy = List.copyOf(original);
original.add("D");
System.out.println(copy); // [A, B, C] — 영향 없음
```

**코딩테스트 팁**: 결과를 반환할 때 외부 변경을 방지하고 싶다면 `List.copyOf()`가 가장 안전합니다. `Collections.unmodifiableList()`는 뷰이므로 원본이 바뀌면 함께 바뀝니다.

### 14.4 실무에서 자주 하는 실수

**실수 1: `unmodifiableList`가 "뷰"라는 것을 모르고 원본을 수정**

위 예시처럼, `unmodifiableList`는 래핑된 원본 리스트가 변경되면 함께 변경됩니다. 진정한 불변이 필요하면 `List.copyOf()`를 사용하세요.

**실수 2: 불변 리스트에 `add()`/`remove()` 호출 → `UnsupportedOperationException`**

```java
List<String> fixed = List.of("A", "B", "C");
fixed.add("D"); // UnsupportedOperationException!

// 수정이 필요하면 새 ArrayList로 복사
List<String> mutable = new ArrayList<>(fixed);
mutable.add("D"); // OK
```

**실수 3: `Collections.frequency()`를 대량 데이터에 반복 호출**

```java
// ❌ 요소마다 frequency 호출 → O(n) × n = O(n²)
for (String item : list) {
    int count = Collections.frequency(list, item);
}

// ✅ 빈도 세기는 HashMap.merge로 한 번에 O(n)
Map<String, Integer> freq = new HashMap<>();
for (String item : list) {
    freq.merge(item, 1, Integer::sum);
}
```

`Collections.frequency()`는 단일 조회에 편리하지만, 전체 빈도표가 필요하면 반드시 Map을 사용하세요.
