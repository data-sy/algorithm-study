# Part 2: 확인편 — 개념 점검 문제

---

## Chapter 15: List 계열 확인문제 (ArrayList, LinkedList)

### Q1. `remove(int)` vs `remove(Object)` — 출력 결과는?

```java
List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40));
list.remove(1);
list.remove(Integer.valueOf(30));
System.out.println(list);
```

<details>
<summary>정답 및 해설</summary>

**정답**: `[10, 40]`

1. `list.remove(1)` → 인덱스 1의 요소(20)를 삭제 → `[10, 30, 40]`
2. `list.remove(Integer.valueOf(30))` → 값 30을 찾아서 삭제 → `[10, 40]`

`List<Integer>`에서 `remove(1)`은 **인덱스**로 해석됩니다. 값 1을 삭제하려면 `remove(Integer.valueOf(1))`을 사용해야 합니다. 이 구분은 코딩테스트에서 자주 실수하는 포인트입니다.
</details>

---

### Q2. `subList()`의 동작 — 아래 코드의 실행 결과는?

```java
List<String> original = new ArrayList<>(List.of("A", "B", "C", "D"));
List<String> sub = original.subList(1, 3);
sub.set(0, "X");
System.out.println(original);
original.add("E");
System.out.println(sub.size());
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- 첫 번째 출력: `[A, X, C, D]`
- 두 번째 줄: `ConcurrentModificationException` 발생

`subList()`는 원본의 **뷰(view)**를 반환합니다. `sub.set(0, "X")`는 원본의 인덱스 1을 변경하므로 원본도 `[A, X, C, D]`가 됩니다. 그러나 그 뒤 `original.add("E")`로 **원본의 구조를 변경**하면, `sub`에 접근할 때 `ConcurrentModificationException`이 발생합니다. 독립 복사본이 필요하면 `new ArrayList<>(original.subList(1, 3))`을 사용하세요.
</details>

---

### Q3. `add(int, E)`와 `add(E)`의 시간복잡도 차이

ArrayList에서 `add(E)`(끝에 추가)와 `add(0, E)`(맨 앞에 삽입)의 시간복잡도를 각각 말하고, 차이가 나는 이유를 설명하세요.

<details>
<summary>정답 및 해설</summary>

- `add(E)`: **O(1)** 평균 — 내부 배열의 끝에 요소를 추가하므로 다른 요소를 이동할 필요가 없습니다. (배열 확장이 필요한 경우에도 amortized O(1))
- `add(0, E)`: **O(n)** — 기존 모든 요소를 한 칸씩 뒤로 이동해야 합니다.

ArrayList는 내부적으로 연속된 배열을 사용하므로, 중간이나 앞에 삽입하면 뒤쪽 요소를 모두 밀어야 하는 비용이 발생합니다.
</details>

---

### Q4. `contains()`의 성능 문제 — 아래 코드의 시간복잡도와 개선 방법은?

```java
List<String> vipList = List.of("C001", "C002", /* ... 10,000개 */);
List<Order> orders = List.of(/* ... 50,000개 */);

for (Order order : orders) {
    if (vipList.contains(order.customerId())) {
        // VIP 주문 처리
    }
}
```

<details>
<summary>정답 및 해설</summary>

**시간복잡도**: **O(n × m)** — orders 50,000개 × vipList.contains() 10,000개 = 최대 5억 번 비교.

ArrayList의 `contains()`는 매번 순차 탐색 O(n)을 수행합니다. 이를 개선하려면 `vipList`를 **HashSet으로 변환**하여 조회를 O(1)로 만들면 됩니다:

```java
Set<String> vipSet = new HashSet<>(vipList); // O(m) 1회
for (Order order : orders) {
    if (vipSet.contains(order.customerId())) { // O(1)
        // VIP 주문 처리
    }
}
```

개선 후 전체 시간복잡도: **O(n + m)**.
</details>

---

### Q5. `get(int)`과 `set(int, E)` — ArrayList vs LinkedList

ArrayList의 `get(3)`과 LinkedList의 `get(3)`의 시간복잡도를 각각 말하고, 왜 다른지 설명하세요.

<details>
<summary>정답 및 해설</summary>

- ArrayList `get(3)`: **O(1)** — 내부 배열의 인덱스로 바로 접근합니다. `array[3]`과 동일.
- LinkedList `get(3)`: **O(n)** — head부터 노드를 하나씩 따라가며 3번째 노드를 찾아야 합니다.

이 차이 때문에 LinkedList에서 `for (int i = 0; i < list.size(); i++) { list.get(i); }` 패턴은 O(n²)이 됩니다. LinkedList를 순회할 때는 반드시 for-each 또는 Iterator를 사용하세요.
</details>

---

### Q6. `indexOf()`의 동작 — 출력 결과는?

```java
List<String> list = new ArrayList<>(List.of("A", "B", "C", "B", "D"));
System.out.println(list.indexOf("B"));
System.out.println(list.indexOf("Z"));
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `1`
- `-1`

`indexOf()`는 **첫 번째로** 일치하는 요소의 인덱스를 반환합니다. "B"가 인덱스 1과 3에 있지만, 첫 번째인 1을 반환합니다. 존재하지 않는 요소는 `-1`을 반환합니다. 시간복잡도는 O(n)으로, 앞에서부터 순차 탐색합니다.
</details>

---

### Q7. `sort()`와 `isEmpty()` — 아래 코드의 출력 결과는?

```java
List<Integer> list = new ArrayList<>(List.of(30, 10, 20));
list.sort(Comparator.reverseOrder());
System.out.println(list);
System.out.println(list.isEmpty());
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `[30, 20, 10]`
- `false`

`List.sort(Comparator.reverseOrder())`는 리스트를 **내림차순으로 제자리 정렬**합니다. `isEmpty()`는 리스트가 비어 있는지를 O(1)로 확인하며, 요소가 3개 있으므로 `false`를 반환합니다.
</details>

---

### Q8. LinkedList의 양쪽 끝 연산 — 시간복잡도는?

LinkedList에서 `addFirst(E)`, `addLast(E)`, `getFirst()`, `getLast()`, `removeFirst()`, `removeLast()`의 시간복잡도는 각각 무엇인가요? 그리고 이 메서드들이 O(1)인 이유는?

<details>
<summary>정답 및 해설</summary>

**정답**: 모두 **O(1)**.

LinkedList는 **이중 연결 리스트**로 구현되어 있어, head와 tail 노드에 대한 참조를 직접 가지고 있습니다. 따라서 양쪽 끝에서의 삽입·삭제·조회는 노드를 탐색할 필요 없이 포인터만 변경하면 되므로 O(1)입니다.

이 특성 때문에 LinkedList는 Deque 인터페이스도 함께 구현하지만, 실무에서는 **ArrayDeque**가 캐시 효율과 메모리 면에서 더 낫습니다.
</details>

---

### Q9. "LinkedList는 중간 삽입이 빠르다" — 맞는 말인가요?

교과서에서 "LinkedList는 중간 삽입이 O(1)"이라고 합니다. 이 설명이 실무에서 왜 오해를 일으키는지 설명하세요.

<details>
<summary>정답 및 해설</summary>

O(1)이라는 것은 **이미 삽입 위치의 노드 참조를 가지고 있을 때**의 이야기입니다. 삽입 위치를 인덱스로 찾아야 한다면 해당 노드까지 순차 탐색하는 데 **O(n)**이 걸리므로, 실제 `add(int index, E element)` 호출은 **O(n)**입니다.

ArrayList의 중간 삽입도 O(n)(요소 이동)이므로, 인덱스 기반 중간 삽입에서 LinkedList의 이점은 거의 없습니다. 오히려 ArrayList의 **캐시 지역성(cache locality)** 덕분에 대부분의 상황에서 ArrayList가 더 빠릅니다.

LinkedList의 중간 삭제가 진정으로 유리한 경우는 **Iterator로 순회하면서 삭제**하는 상황뿐입니다. 이때는 현재 노드의 참조를 이미 가지고 있으므로 O(1)로 삭제할 수 있습니다.
</details>

---

## Chapter 16: Map 계열 확인문제 (HashMap, LinkedHashMap, TreeMap, Map 고급 메서드)

### Q1. HashMap — `equals()`/`hashCode()`의 역할

아래 코드의 출력 결과는? 그리고 이유를 설명하세요.

```java
class Product {
    String id;
    Product(String id) { this.id = id; }
}

Map<Product, Integer> stock = new HashMap<>();
stock.put(new Product("P001"), 100);
System.out.println(stock.get(new Product("P001")));
```

<details>
<summary>정답 및 해설</summary>

**정답**: `null`

`Product` 클래스가 `equals()`와 `hashCode()`를 재정의하지 않았으므로, 두 `new Product("P001")`은 내용이 같아도 **다른 객체**로 인식됩니다. Object의 기본 `hashCode()`는 객체 메모리 주소 기반이고, `equals()`는 참조 동일성(`==`)을 비교합니다.

**해결**: `record Product(String id) {}`를 사용하면 `equals()`/`hashCode()`가 모든 필드를 기준으로 자동 생성됩니다.
</details>

---

### Q2. HashMap — `containsValue()`의 성능 특성

HashMap에서 `containsKey()`는 O(1)인데, `containsValue()`는 O(n)인 이유를 설명하세요.

<details>
<summary>정답 및 해설</summary>

`containsKey()`는 키의 `hashCode()`로 버킷 위치를 직접 계산하여 O(1)에 찾을 수 있습니다. 반면 `containsValue()`는 값에 대한 해시 인덱스가 없으므로, **모든 엔트리를 순회**해야 합니다. 따라서 O(n)입니다.

값으로 자주 조회해야 하는 경우, 값을 키로 하는 **역방향 Map**을 별도로 구성하여 O(1) 조회가 가능하게 할 수 있습니다.
</details>

---

### Q3. HashMap — `get()` 반환값과 `getOrDefault()`

아래 코드에서 발생하는 문제와 해결 방법을 설명하세요.

```java
Map<String, Integer> map = new HashMap<>();
int count = map.get("apple");
```

<details>
<summary>정답 및 해설</summary>

**문제**: `NullPointerException` 발생.

`map.get("apple")`은 키가 없으므로 `null`을 반환합니다. `null`을 `int`로 auto-unboxing할 때 NPE가 발생합니다.

**해결**:
```java
int count = map.getOrDefault("apple", 0); // 키가 없으면 0 반환
```

`getOrDefault()`는 키가 존재하지 않을 때 **기본값을 반환**하지만, Map에 값을 저장하지는 않습니다.
</details>

---

### Q4. HashMap — `keySet()`, `values()`, `entrySet()` 순회 비교

키와 값을 동시에 사용해야 할 때, `keySet()`으로 키를 순회하면서 `get()`을 호출하는 방식과 `entrySet()`을 순회하는 방식 중 어느 것이 더 효율적인가요?

<details>
<summary>정답 및 해설</summary>

**`entrySet()`이 더 효율적**입니다.

```java
// 방식 A: keySet + get — put 시의 해시 계산을 다시 수행
for (String key : map.keySet()) {
    Integer value = map.get(key); // 추가 해시 계산 O(1)
}

// 방식 B: entrySet — 키와 값을 한 번에 접근 ✅
for (var entry : map.entrySet()) {
    String key = entry.getKey();
    Integer value = entry.getValue(); // 추가 해시 계산 없음
}
```

`entrySet()`은 키-값 쌍을 직접 순회하므로, `get()`을 위한 추가 해시 조회가 불필요합니다. 실무에서 키와 값이 동시에 필요한 경우 항상 `entrySet()`을 사용하세요.
</details>

---

### Q5. HashMap vs LinkedHashMap vs TreeMap — 자료구조 선택

다음 각 상황에 가장 적합한 Map 구현체를 고르고 이유를 말하세요.

- (A) 상품 ID로 재고 수량을 빠르게 조회해야 한다.
- (B) 고객이 클릭한 상품을 클릭 순서대로 보여줘야 한다.
- (C) 가격 10,000원~50,000원 범위의 상품만 조회해야 한다.

<details>
<summary>정답 및 해설</summary>

- **(A) HashMap** — 순서 불필요, 단순 키-값 조회. O(1) 성능이 최적.
- **(B) LinkedHashMap** — 삽입 순서를 유지하면서 O(1) 조회 가능.
- **(C) TreeMap** — `subMap(10000, 50001)` 또는 `subMap(10000, true, 50000, true)`로 범위 검색 가능. HashMap이나 LinkedHashMap으로는 범위 검색이 불가능.
</details>

---

### Q6. LinkedHashMap — 삽입 순서 vs 접근 순서

아래 코드의 출력 결과는?

```java
Map<String, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
map.put("A", 1);
map.put("B", 2);
map.put("C", 3);
map.get("A");
map.put("B", 20);

for (String key : map.keySet()) {
    System.out.print(key + " ");
}
```

<details>
<summary>정답 및 해설</summary>

**정답**: `C A B`

생성자의 세 번째 인자가 `true`이므로 **접근 순서 모드**입니다.

1. 삽입: A → B → C (순서: A, B, C)
2. `get("A")`: A가 가장 최근 접근으로 이동 → (순서: B, C, A)
3. `put("B", 20)`: B를 갱신(접근)하여 가장 최근으로 이동 → (순서: C, A, B)

접근 순서 모드에서는 `get()`과 `put()`(기존 키 갱신) 모두 해당 엔트리를 **가장 최근 위치로 이동**시킵니다. 기본 생성자(`new LinkedHashMap<>()`)는 삽입 순서 모드이며 이 경우 출력은 `A B C`입니다.
</details>

---

### Q7. LinkedHashMap — accessOrder 모드에서의 주의점

accessOrder가 `true`인 LinkedHashMap을 for-each로 순회하면서 `get()`을 호출하면 어떤 일이 발생하나요?

<details>
<summary>정답 및 해설</summary>

**`ConcurrentModificationException`이 발생합니다.**

접근 순서 모드에서 `get()`은 **내부 연결 구조를 변경**(접근된 노드를 끝으로 이동)합니다. for-each는 내부적으로 Iterator를 사용하는데, Iterator는 순회 도중 구조 변경을 감지하면 예외를 던집니다.

삽입 순서 모드(기본값)에서는 `get()`이 구조를 변경하지 않으므로 이 문제가 발생하지 않습니다.
</details>

---

### Q8. TreeMap — `subMap()` 경계값

아래 코드의 출력 결과는?

```java
TreeMap<Integer, String> map = new TreeMap<>();
map.put(10, "A"); map.put(20, "B"); map.put(30, "C"); map.put(40, "D");

System.out.println(map.subMap(10, 30));
System.out.println(map.subMap(10, true, 30, true));
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `{10=A, 20=B}` — 2-파라미터 `subMap(from, to)`: from **포함**, to **미포함**
- `{10=A, 20=B, 30=C}` — 4-파라미터: 양쪽 **모두 포함**

`headMap(key)`도 key **미포함**, `tailMap(key)`는 key **포함**입니다. 경계 포함 여부는 코딩테스트에서 자주 실수하는 부분이므로, 양쪽 포함이 필요하면 4-파라미터 버전을 사용하세요.
</details>

---

### Q9. TreeMap — `ceilingKey()`와 `floorKey()`

아래 코드의 출력 결과는?

```java
TreeMap<Integer, String> map = new TreeMap<>();
map.put(10, "A"); map.put(20, "B"); map.put(30, "C");

System.out.println(map.ceilingKey(15));
System.out.println(map.floorKey(15));
System.out.println(map.ceilingKey(50));
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `20` — 15 **이상**인 가장 작은 키
- `10` — 15 **이하**인 가장 큰 키
- `null` — 50 이상인 키가 없음

`ceilingKey()`는 "이상(≥)", `floorKey()`는 "이하(≤)"입니다. 조건을 만족하는 키가 없으면 `null`을 반환합니다. 이 메서드들은 모두 O(log n)입니다.
</details>

---

### Q10. TreeMap — null 키와 성능 선택

(A) TreeMap에 `put(null, "value")`를 호출하면 어떤 일이 발생하나요?
(B) 단순 키-값 조회만 필요한 상황에서 TreeMap을 사용하면 어떤 문제가 있나요?

<details>
<summary>정답 및 해설</summary>

**(A)** `NullPointerException` 발생. TreeMap은 키를 정렬 비교해야 하므로, `compareTo()` 또는 `Comparator.compare()` 호출 시 null 키를 처리할 수 없습니다.

**(B)** 불필요한 성능 손해. TreeMap의 put/get은 O(log n)이고, HashMap은 O(1)입니다. 범위 검색이나 정렬이 필요 없다면 HashMap이 항상 더 효율적입니다. "나중에 정렬이 필요할지도 모른다"는 이유로 미리 TreeMap을 쓰는 것은 YAGNI(You Ain't Gonna Need It) 원칙에 어긋납니다.
</details>

---

### Q11. `getOrDefault()` vs `putIfAbsent()` — 차이점

아래 두 코드의 실행 후 Map 상태의 차이를 설명하세요.

```java
// 코드 A
Map<String, Integer> mapA = new HashMap<>();
int val = mapA.getOrDefault("key", 0);

// 코드 B
Map<String, Integer> mapB = new HashMap<>();
mapB.putIfAbsent("key", 0);
```

<details>
<summary>정답 및 해설</summary>

- **코드 A**: `mapA`는 여전히 **비어 있음**. `getOrDefault()`는 값을 반환만 하고 Map에 저장하지 않습니다.
- **코드 B**: `mapB`에 `{"key": 0}`이 **저장됨**. `putIfAbsent()`는 키가 없을 때 값을 실제로 저장합니다.

`getOrDefault()`는 **조회 전용**, `putIfAbsent()`는 **저장 포함**이라는 차이를 기억하세요.
</details>

---

### Q12. `merge()` — 빈도 세기 패턴

아래 두 코드가 동일한 결과를 내는 이유를 설명하세요.

```java
// 방법 A
map.put(key, map.getOrDefault(key, 0) + 1);

// 방법 B
map.merge(key, 1, Integer::sum);
```

<details>
<summary>정답 및 해설</summary>

`merge(key, value, remappingFunction)`의 동작:
- 키가 **없으면**: 두 번째 인자 `1`을 그대로 저장
- 키가 **있으면**: 기존 값과 새 값에 `Integer::sum`을 적용하여 저장 (기존값 + 1)

따라서 "없으면 1, 있으면 +1"이라는 빈도 세기 로직이 한 줄로 완성됩니다. 방법 A는 `getOrDefault`로 기본값 0을 가져온 후 +1하여 다시 `put`하므로 결과는 동일합니다.

**추가 주의**: `merge`의 remappingFunction이 `null`을 반환하면 해당 엔트리가 **삭제**됩니다. 의도치 않은 삭제에 주의하세요.
</details>

---

### Q13. `computeIfAbsent()` vs `putIfAbsent()` — 차이점

아래 두 코드의 차이를 설명하세요. 특히 `expensiveCreate()`가 비용이 큰 연산일 때 어떤 코드가 더 적합한가요?

```java
// 코드 A
map.computeIfAbsent("key", k -> expensiveCreate());

// 코드 B
map.putIfAbsent("key", expensiveCreate());
```

<details>
<summary>정답 및 해설</summary>

- **코드 A** (`computeIfAbsent`): "key"가 이미 있으면 `expensiveCreate()`를 **실행하지 않음** (lazy 평가)
- **코드 B** (`putIfAbsent`): "key"가 이미 있든 없든 `expensiveCreate()`가 **항상 실행됨** (eager 평가). 키가 이미 있으면 생성한 값을 버림.

비용이 큰 객체 생성이라면 **`computeIfAbsent`가 적합**합니다. 불필요한 객체 생성을 피할 수 있기 때문입니다.

**`computeIfAbsent`의 대표적 사용처**: 그룹핑 패턴
```java
map.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
```
</details>

---

### Q14. `replaceAll()` — 출력 결과는?

```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 10); map.put("B", 20); map.put("C", 30);
map.replaceAll((key, value) -> value * 3);
System.out.println(map);
```

<details>
<summary>정답 및 해설</summary>

**정답**: `{A=30, B=60, C=90}`

`replaceAll(BiFunction)`은 모든 엔트리의 값을 BiFunction의 결과로 교체합니다. 시간복잡도는 O(n)이며, 모든 엔트리를 한 번씩 순회합니다.
</details>

---

### Q15. HashMap — `size()`와 `isEmpty()`

`map.size() == 0`과 `map.isEmpty()`는 동일한 결과를 내나요? 차이가 있다면 무엇인가요?

<details>
<summary>정답 및 해설</summary>

기능적으로 **동일한 결과**를 냅니다. 둘 다 O(1)입니다. 다만 **`isEmpty()`가 권장**됩니다. 의도가 명확하고 가독성이 좋으며, 일부 컬렉션 구현체에서 size 계산이 O(n)인 경우에도 isEmpty는 O(1)로 최적화되어 있을 수 있기 때문입니다.
</details>

---

## Chapter 17: Set 계열 확인문제 (HashSet, LinkedHashSet, TreeSet)

### Q1. HashSet — `add()` 반환값의 활용

아래 코드의 출력 결과는?

```java
Set<String> set = new HashSet<>();
System.out.println(set.add("A"));
System.out.println(set.add("B"));
System.out.println(set.add("A"));
System.out.println(set.size());
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `true`
- `true`
- `false` (이미 존재하는 요소)
- `2`

`add()`는 요소가 성공적으로 추가되면 `true`, 이미 존재하면 `false`를 반환합니다. 이 반환값을 활용하면 별도로 `contains()`를 호출할 필요 없이 중복 여부를 판단할 수 있습니다.
</details>

---

### Q2. HashSet — 집합 연산이 원본을 변경한다

아래 코드 실행 후 `groupA`의 내용은?

```java
Set<String> groupA = new HashSet<>(Set.of("Kim", "Lee", "Park"));
Set<String> groupB = new HashSet<>(Set.of("Lee", "Choi"));

groupA.retainAll(groupB);
```

<details>
<summary>정답 및 해설</summary>

**정답**: `groupA` = `{"Lee"}`

`retainAll()`은 **교집합** 연산으로, `groupB`에 없는 요소를 `groupA`에서 **삭제**합니다. 원본인 `groupA`가 직접 변경됩니다.

원본을 보존하려면:
```java
Set<String> intersection = new HashSet<>(groupA);
intersection.retainAll(groupB); // intersection만 변경, groupA는 보존
```
</details>

---

### Q3. HashSet — `addAll()`과 `removeAll()`

아래 코드의 출력 결과는?

```java
Set<Integer> a = new HashSet<>(Set.of(1, 2, 3, 4));
Set<Integer> b = new HashSet<>(Set.of(3, 4, 5, 6));

Set<Integer> union = new HashSet<>(a);
union.addAll(b);

Set<Integer> diff = new HashSet<>(a);
diff.removeAll(b);

System.out.println(union);
System.out.println(diff);
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `union` = `{1, 2, 3, 4, 5, 6}` (합집합)
- `diff` = `{1, 2}` (차집합: a에서 b에 있는 요소 제거)

`addAll()`은 합집합, `removeAll()`은 차집합 연산입니다. 두 메서드 모두 호출 대상을 직접 변경하므로, 원본 보존이 필요하면 새 Set으로 복사 후 연산하세요.
</details>

---

### Q4. HashSet — 순서를 기대하면 안 되는 이유

아래 코드의 출력 결과가 `A B C`라고 보장할 수 있나요?

```java
Set<String> set = new HashSet<>();
set.add("A"); set.add("B"); set.add("C");
for (String s : set) { System.out.print(s + " "); }
```

<details>
<summary>정답 및 해설</summary>

**보장할 수 없습니다.** HashSet은 순서를 보장하지 않습니다. 내부 해시 버킷 구조에 따라 순회 순서가 결정되며, JVM 구현이나 실행 시점에 따라 달라질 수 있습니다.

삽입 순서를 유지하려면 **LinkedHashSet**, 정렬 순서가 필요하면 **TreeSet**을 사용하세요.
</details>

---

### Q5. HashSet — `equals()`/`hashCode()`와 중복 판단

아래 코드의 출력 결과는?

```java
record Product(String id, String name) {}

Set<Product> set = new HashSet<>();
set.add(new Product("P001", "셔츠"));
set.add(new Product("P001", "셔츠"));
System.out.println(set.size());
```

<details>
<summary>정답 및 해설</summary>

**정답**: `1`

`record`는 모든 필드를 기반으로 `equals()`와 `hashCode()`를 자동 생성합니다. 두 `Product("P001", "셔츠")`는 같은 id와 name을 가지므로 동일한 객체로 판단되어, 두 번째 `add()`는 무시됩니다.

만약 일반 `class`로 `equals()`/`hashCode()`를 재정의하지 않았다면 결과는 `2`가 됩니다.
</details>

---

### Q6. LinkedHashSet — 삽입 순서 보장과 중복 재삽입

아래 코드의 출력 결과는?

```java
Set<String> set = new LinkedHashSet<>();
set.add("X"); set.add("Y"); set.add("Z");
set.add("X"); // 이미 존재하는 요소 재삽입
for (String s : set) { System.out.print(s + " "); }
```

<details>
<summary>정답 및 해설</summary>

**정답**: `X Y Z`

이미 존재하는 요소를 `add()`하면 `false`를 반환하고, **순서는 변경되지 않습니다**. "X"는 원래 첫 번째 위치를 유지합니다.

"X"를 마지막으로 이동하고 싶다면 `remove("X")` 후 `add("X")`를 해야 합니다:
```java
set.remove("X");
set.add("X");
// 순회: Y Z X
```
</details>

---

### Q7. LinkedHashSet — 삽입 순서와 정렬의 차이

LinkedHashSet에 `3, 1, 2` 순서로 삽입하면 순회 시 `1, 2, 3`으로 나오나요?

<details>
<summary>정답 및 해설</summary>

**아니요.** LinkedHashSet은 **삽입 순서**를 유지하므로 `3 1 2` 순서로 순회됩니다. 정렬 순서(`1 2 3`)가 필요하다면 **TreeSet**을 사용해야 합니다.

```java
Set<Integer> linked = new LinkedHashSet<>();
linked.add(3); linked.add(1); linked.add(2);
// 순회: 3 → 1 → 2 (삽입 순서)

Set<Integer> tree = new TreeSet<>();
tree.add(3); tree.add(1); tree.add(2);
// 순회: 1 → 2 → 3 (정렬 순서)
```
</details>

---

### Q8. TreeSet — `Comparable` 미구현 시 예외

아래 코드를 실행하면 어떤 일이 발생하나요?

```java
record Product(String id, int price) {}

TreeSet<Product> set = new TreeSet<>();
set.add(new Product("P001", 10000));
```

<details>
<summary>정답 및 해설</summary>

**`ClassCastException` 발생.**

TreeSet은 요소를 정렬하기 위해 비교가 필요합니다. `Product` record는 `Comparable`을 구현하지 않았고, Comparator도 제공하지 않았으므로 예외가 발생합니다.

**해결**:
```java
TreeSet<Product> set = new TreeSet<>(Comparator.comparingInt(Product::price));
```
</details>

---

### Q9. TreeSet — `ceiling()`과 `floor()`

아래 코드의 출력 결과는?

```java
TreeSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30, 40, 50));

System.out.println(set.ceiling(25));
System.out.println(set.floor(25));
System.out.println(set.ceiling(30));
System.out.println(set.floor(5));
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `30` — 25 이상인 가장 작은 요소
- `20` — 25 이하인 가장 큰 요소
- `30` — 30 이상인 가장 작은 요소 (30 자체 포함)
- `null` — 5 이하인 요소 없음

`ceiling()`은 **이상(≥)**, `floor()`는 **이하(≤)**입니다. 정확히 일치하는 값이 있으면 그 값 자체를 반환합니다.
</details>

---

### Q10. TreeSet — `headSet()`과 `tailSet()`

아래 코드의 출력 결과는?

```java
TreeSet<Integer> set = new TreeSet<>(Set.of(10, 20, 30, 40));

System.out.println(set.headSet(30));
System.out.println(set.tailSet(30));
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `[10, 20]` — 30 **미만**
- `[30, 40]` — 30 **이상**

`headSet(toElement)`: toElement **미포함** (미만)
`tailSet(fromElement)`: fromElement **포함** (이상)

양쪽을 포함하거나 제외하고 싶다면 2-파라미터 버전을 사용하세요:
```java
set.headSet(30, true); // [10, 20, 30] — 30 포함
```
</details>

---

## Chapter 18: Queue/Deque 계열 확인문제 (ArrayDeque, PriorityQueue)

### Q1. ArrayDeque — Queue로 사용할 때의 기본 동작

아래 코드의 출력 결과는?

```java
Deque<String> queue = new ArrayDeque<>();
queue.offer("주문1");
queue.offer("주문2");
queue.offer("주문3");

System.out.println(queue.poll());
System.out.println(queue.peek());
System.out.println(queue.size());
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `주문1` — FIFO이므로 먼저 넣은 것이 먼저 나옴
- `주문2` — 다음 꺼낼 요소를 확인만 하고 제거하지 않음
- `2` — poll()로 1개 제거했으므로 2개 남음

Queue로 사용할 때: `offer()` → 뒤에 추가, `poll()` → 앞에서 제거, `peek()` → 앞의 요소 확인.
</details>

---

### Q2. ArrayDeque — Stack으로 사용할 때의 동작

아래 코드의 출력 결과는?

```java
Deque<String> stack = new ArrayDeque<>();
stack.push("A");
stack.push("B");
stack.push("C");

System.out.println(stack.pop());
System.out.println(stack.peek());
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `C` — LIFO이므로 마지막에 넣은 것이 먼저 나옴
- `B` — pop() 후 맨 위 요소 확인

`push()`는 `addFirst()`와 같고, `pop()`은 `removeFirst()`와 같습니다. Stack 동작은 **head 쪽**에서 일어납니다.
</details>

---

### Q3. ArrayDeque — null 삽입 시도

아래 코드를 실행하면 어떤 일이 발생하나요? 그리고 null을 허용하지 않는 이유는?

```java
Deque<String> deque = new ArrayDeque<>();
deque.offer(null);
```

<details>
<summary>정답 및 해설</summary>

**`NullPointerException`이 발생합니다.**

ArrayDeque가 null을 허용하지 않는 이유: `poll()`과 `peek()`가 **덱이 비어 있을 때 `null`을 반환**하기 때문입니다. 만약 null 요소를 허용하면 "실제 null 요소"와 "비어서 null을 반환한 것"을 구분할 수 없게 됩니다.
</details>

---

### Q4. ArrayDeque — `offer()`/`poll()` vs `add()`/`remove()`

`offer()`와 `add()`, `poll()`과 `remove()`의 차이점은 무엇인가요? 코딩테스트에서 어느 쪽을 권장하나요?

<details>
<summary>정답 및 해설</summary>

| 메서드 | 실패 시 동작 |
|--------|-------------|
| `offer()` | `false` 반환 |
| `add()` | `IllegalStateException` 예외 |
| `poll()` | `null` 반환 |
| `remove()` | `NoSuchElementException` 예외 |
| `peek()` | `null` 반환 |
| `element()` | `NoSuchElementException` 예외 |

코딩테스트에서는 **`offer()`/`poll()`/`peek()`를 권장**합니다. 예외를 던지는 대신 반환값으로 성공/실패를 판단할 수 있어 흐름 제어가 더 안전합니다.
</details>

---

### Q5. ArrayDeque — `push()`/`pop()`의 방향

ArrayDeque에서 `push()`는 어느 쪽(head/tail)에 추가하나요? 이것이 `offer()`와 어떻게 다른가요?

<details>
<summary>정답 및 해설</summary>

- `push(E)` = `addFirst(E)` → **head**에 추가
- `offer(E)` = `offerLast(E)` → **tail**에 추가

Stack으로 사용할 때 `push()`/`pop()`은 모두 head에서 동작합니다. Queue로 사용할 때 `offer()`는 tail에 넣고 `poll()`은 head에서 꺼냅니다.

```
[head] ←push/pop    offer→ [tail]
        ←poll                    
```
</details>

---

### Q6. ArrayDeque — Deque 양방향 활용

아래 코드의 출력 결과는?

```java
Deque<Integer> deque = new ArrayDeque<>();
deque.offerLast(1);
deque.offerLast(2);
deque.offerFirst(0);
deque.offerLast(3);

System.out.println(deque.peekFirst());
System.out.println(deque.peekLast());
System.out.println(deque.pollLast());
System.out.println(deque);
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `0` — head 확인
- `3` — tail 확인
- `3` — tail에서 제거
- `[0, 1, 2]` — 3이 제거된 상태

삽입 과정: `[1]` → `[1, 2]` → `[0, 1, 2]` → `[0, 1, 2, 3]`
`pollLast()`로 tail의 3을 제거하면 `[0, 1, 2]`가 남습니다.
</details>

---

### Q7. PriorityQueue — 순회 vs poll 순서

아래 코드의 두 출력이 다른 이유를 설명하세요.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(List.of(50, 10, 40, 20, 30));

// 출력 1: for-each 순회
for (int val : pq) { System.out.print(val + " "); }
System.out.println();

// 출력 2: poll 반복
while (!pq.isEmpty()) { System.out.print(pq.poll() + " "); }
```

<details>
<summary>정답 및 해설</summary>

- **출력 1**: `10 20 40 50 30` (또는 다른 순서) — 정렬 순서 **보장되지 않음**
- **출력 2**: `10 20 30 40 50` — 정렬 순서 **보장됨**

PriorityQueue는 내부적으로 **힙(heap)** 구조입니다. 힙은 "최솟값이 루트에 있다"는 것만 보장하고, 전체 배열이 정렬되어 있지는 않습니다. 정렬 순서가 보장되는 것은 **`poll()`로 하나씩 꺼낼 때**뿐입니다.
</details>

---

### Q8. PriorityQueue — Top-K 전략

상품 1만 개 중 리뷰 평점이 가장 높은 3개를 추출하려 합니다. 다음 두 전략의 차이를 설명하세요.

```java
// 전략 A: 최소 힙 (크기 3 유지)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
for (int score : scores) {
    minHeap.offer(score);
    if (minHeap.size() > 3) minHeap.poll();
}

// 전략 B: 최대 힙에 전부 넣고 3번 poll
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
for (int score : scores) { maxHeap.offer(score); }
// 3번 poll
```

<details>
<summary>정답 및 해설</summary>

**전략 A (최소 힙)**:
- 힙 크기를 3으로 유지하면서, 새 값이 들어올 때 가장 작은 값을 제거 → 큰 값 3개가 남음
- 공간: O(K) = O(3), 시간: O(n log K)
- 메모리 효율적이며, n이 매우 클 때 유리

**전략 B (최대 힙)**:
- 전체를 힙에 넣고(O(n log n)) 3번 poll
- 공간: O(n), 시간: O(n log n)
- 구현이 직관적이지만 메모리를 더 사용

**결론**: 데이터가 크고 K가 작을 때는 **전략 A(최소 힙)가 효율적**입니다.
</details>

---

### Q9. PriorityQueue — Comparator 미지정

`Comparable`을 구현하지 않은 record를 Comparator 없이 PriorityQueue에 넣으면 어떤 일이 발생하나요?

```java
record Order(String id, int amount) {}
PriorityQueue<Order> pq = new PriorityQueue<>();
pq.offer(new Order("O1", 5000));
```

<details>
<summary>정답 및 해설</summary>

**`ClassCastException` 발생.** PriorityQueue는 요소를 `Comparable`로 캐스팅하여 비교합니다. record는 `Comparable`을 자동 구현하지 않으므로 캐스팅에 실패합니다.

**해결**:
```java
PriorityQueue<Order> pq = new PriorityQueue<>(Comparator.comparingInt(Order::amount));
```
</details>

---

### Q10. `java.util.Stack`을 사용하지 않는 이유

`java.util.Stack` 대신 `ArrayDeque`를 사용해야 하는 이유 두 가지를 설명하세요.

<details>
<summary>정답 및 해설</summary>

1. **`Vector`를 상속하여 모든 메서드가 `synchronized`**: 단일 스레드 환경에서 불필요한 동기화 오버헤드가 발생합니다.

2. **잘못된 상속으로 캡슐화 위반**: `Vector`의 `get(i)`, `add(i, e)` 등 인덱스 기반 메서드가 그대로 노출되어, Stack의 LIFO 원칙을 깨고 중간 요소에 접근할 수 있습니다.

Java 공식 문서도 Stack 대용으로 `ArrayDeque`를 권장합니다:
```java
Deque<String> stack = new ArrayDeque<>(); // ✅ 권장
Stack<String> legacy = new Stack<>();     // ❌ 레거시
```
</details>

---

## Chapter 19: API·패턴 확인문제 (Comparator, Iterator, Collections 유틸리티)

### Q1. Comparator — `reversed()`의 적용 범위

아래 두 코드의 정렬 결과 차이를 설명하세요.

```java
record Order(String category, int amount) {}
List<Order> orders = List.of(
    new Order("식품", 3000), new Order("의류", 5000),
    new Order("식품", 1000), new Order("의류", 2000)
);

// 코드 A
List<Order> listA = new ArrayList<>(orders);
listA.sort(Comparator.comparing(Order::category)
        .thenComparing(Order::amount)
        .reversed());

// 코드 B
List<Order> listB = new ArrayList<>(orders);
listB.sort(Comparator.comparing(Order::category)
        .thenComparing(Order::amount, Comparator.reverseOrder()));
```

<details>
<summary>정답 및 해설</summary>

**코드 A** — `.reversed()`가 **전체 체인을 뒤집음**:
- category도 역순(ㅇ → ㅅ), amount도 역순
- 결과: 의류 5000 → 의류 2000 → 식품 3000 → 식품 1000

**코드 B** — `reverseOrder()`가 **amount에만 적용**:
- category는 정순(ㅅ → ㅇ), amount만 역순
- 결과: 식품 3000 → 식품 1000 → 의류 5000 → 의류 2000

특정 필드만 역순 정렬하고 싶다면 `thenComparing(field, Comparator.reverseOrder())`를 사용하세요. 체인 끝의 `.reversed()`는 전체를 뒤집습니다.
</details>

---

### Q2. Comparator — `comparingInt()`의 장점

`Comparator.comparing(Order::amount)`와 `Comparator.comparingInt(Order::amount)`의 차이는?

<details>
<summary>정답 및 해설</summary>

- `comparing()`: `amount`를 `Integer`로 **박싱(boxing)** 후 비교
- `comparingInt()`: `int` 원시 타입 그대로 비교 — **박싱 비용 없음**

기능적 결과는 동일하지만, 정렬 대상이 많을 때 `comparingInt()`가 불필요한 객체 생성을 피하여 약간 더 효율적입니다. `comparingLong()`, `comparingDouble()`도 동일한 목적입니다.
</details>

---

### Q3. Comparator — null 처리

아래 코드를 실행하면 어떤 일이 발생하나요? 그리고 해결 방법은?

```java
List<String> list = new ArrayList<>(Arrays.asList("B", null, "A", "C"));
list.sort(Comparator.naturalOrder());
```

<details>
<summary>정답 및 해설</summary>

**`NullPointerException` 발생.** `naturalOrder()`는 null을 처리하지 못합니다.

**해결**: `nullsFirst()` 또는 `nullsLast()`로 감싸기
```java
list.sort(Comparator.nullsLast(Comparator.naturalOrder()));
// 결과: [A, B, C, null]

list.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
// 결과: [null, A, B, C]
```
</details>

---

### Q4. `List.sort()` vs `Collections.sort()` — 차이점

두 메서드의 결과와 성능에 차이가 있나요?

```java
list.sort(Comparator.naturalOrder());
Collections.sort(list);
```

<details>
<summary>정답 및 해설</summary>

**결과와 성능 모두 동일합니다.** 둘 다 내부적으로 **Tim Sort** 알고리즘(O(n log n))을 사용합니다.

`List.sort()`는 Java 8에서 추가된 default 메서드로 더 간결합니다. `Collections.sort()`는 이전 버전과의 호환성을 위해 존재합니다. 현대 Java 코드에서는 **`List.sort()` 권장**입니다.
</details>

---

### Q5. Comparable vs Comparator — 언제 어떤 것을 쓰나요?

아래 record를 항상 price 기준으로 정렬하고 싶다면, Comparable과 Comparator 중 어떤 방식이 적합한가요? 코딩테스트에서는 어느 쪽을 주로 쓰나요?

```java
record Product(String name, int price) {}
```

<details>
<summary>정답 및 해설</summary>

**Comparable**: 클래스에 **단 하나의 "자연 순서"**를 고정하고 싶을 때 적합합니다.
```java
record Product(String name, int price) implements Comparable<Product> {
    @Override
    public int compareTo(Product o) { return Integer.compare(this.price, o.price); }
}
```

**Comparator**: 상황에 따라 **다른 기준**으로 정렬하고 싶을 때 적합합니다.
```java
products.sort(Comparator.comparingInt(Product::price));       // 가격순
products.sort(Comparator.comparing(Product::name));           // 이름순
```

**코딩테스트에서는 Comparator를 주로 사용합니다.** 정렬 기준이 문제마다 달라지고, `Comparator.comparing()` 체인이 간결하기 때문입니다.
</details>

---

### Q6. Iterator — for-each에서 remove 호출 시 예외

아래 코드에서 예외가 발생하는 이유와 해결 방법 2가지를 제시하세요.

```java
List<String> list = new ArrayList<>(List.of("A", "B", "C", "D"));
for (String item : list) {
    if (item.equals("B")) {
        list.remove(item);
    }
}
```

<details>
<summary>정답 및 해설</summary>

**`ConcurrentModificationException` 발생.**

for-each는 내부적으로 Iterator를 사용하지만, `list.remove()`는 Iterator를 거치지 않고 컬렉션을 직접 변경합니다. Iterator는 순회 중 구조 변경을 감지하면 예외를 던집니다.

**해결 1: `removeIf()` 사용 (권장)**
```java
list.removeIf(item -> item.equals("B"));
```

**해결 2: Iterator 명시적 사용**
```java
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    if (it.next().equals("B")) {
        it.remove(); // Iterator를 통한 안전한 삭제
    }
}
```
</details>

---

### Q7. Iterator — `next()` 없이 `remove()` 호출

아래 코드의 실행 결과는?

```java
List<String> list = new ArrayList<>(List.of("A", "B", "C"));
Iterator<String> it = list.iterator();
it.remove();
```

<details>
<summary>정답 및 해설</summary>

**`IllegalStateException` 발생.**

`remove()`는 가장 최근에 `next()`로 반환된 요소를 삭제합니다. `next()`를 호출하지 않은 상태에서 `remove()`를 호출하면, 삭제할 대상이 없으므로 예외가 발생합니다. 또한 `remove()`를 두 번 연속 호출해도 같은 예외가 발생합니다.
</details>

---

### Q8. Iterator — Map 순회 중 삭제

아래 코드에서 예외가 발생하는 이유와 해결 방법을 설명하세요.

```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 0); map.put("B", 5); map.put("C", 0);

for (var entry : map.entrySet()) {
    if (entry.getValue() == 0) {
        map.remove(entry.getKey());
    }
}
```

<details>
<summary>정답 및 해설</summary>

**`ConcurrentModificationException` 발생.** List와 동일한 원리입니다. `entrySet()`의 for-each 역시 내부적으로 Iterator를 사용하며, `map.remove()`는 Iterator를 거치지 않으므로 예외가 발생합니다.

**해결 1: `entrySet().removeIf()` (권장)**
```java
map.entrySet().removeIf(entry -> entry.getValue() == 0);
```

**해결 2: Iterator 명시적 사용**
```java
Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
while (it.hasNext()) {
    if (it.next().getValue() == 0) {
        it.remove();
    }
}
```
</details>

---

### Q9. `removeIf()` — Iterator.remove()와의 관계

`list.removeIf(predicate)`는 내부적으로 어떻게 동작하나요? 직접 `Iterator.remove()`를 쓰는 것과 비교하면?

<details>
<summary>정답 및 해설</summary>

`removeIf()`는 내부적으로 **Iterator를 사용하여 순회하며 조건에 맞는 요소를 안전하게 삭제**합니다. 따라서 `ConcurrentModificationException`이 발생하지 않습니다.

| 비교 항목 | `Iterator.remove()` | `removeIf()` |
|-----------|---------------------|-------------|
| 코드 분량 | 4~5줄 (while + if + remove) | 1줄 |
| 삭제 외 추가 로직 | ✅ 가능 (삭제 전 로깅 등) | ❌ 삭제만 가능 |
| 권장 상황 | 삭제 전후에 추가 작업 필요할 때 | 단순 조건 삭제 |

대부분의 경우 **`removeIf()`가 더 간결하고 안전합니다.**
</details>

---

### Q10. Collections — `max()`, `min()` 사용법

아래 코드의 출력 결과는?

```java
List<Integer> prices = List.of(15000, 8000, 32000, 4500);
System.out.println(Collections.max(prices));
System.out.println(Collections.min(prices));
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `32000`
- `4500`

`Collections.max()`와 `Collections.min()`은 자연 순서(Comparable)를 기준으로 최댓값/최솟값을 O(n)에 반환합니다.

커스텀 기준을 적용하려면 Comparator를 전달하세요:
```java
Order topOrder = Collections.max(orders, Comparator.comparingInt(Order::amount));
```
</details>

---

### Q11. Collections — `frequency()`의 성능 주의점

아래 코드의 시간복잡도와 개선 방법은?

```java
List<String> items = List.of(/* 10,000개 */);
for (String item : items) {
    int count = Collections.frequency(items, item);
    System.out.println(item + ": " + count);
}
```

<details>
<summary>정답 및 해설</summary>

**시간복잡도**: **O(n²)** — `frequency()`는 매번 전체 리스트를 순회(O(n))하며, 이를 n번 반복합니다.

**개선**: HashMap으로 한 번에 빈도표를 생성하여 O(n)으로 줄입니다.
```java
Map<String, Integer> freq = new HashMap<>();
for (String item : items) {
    freq.merge(item, 1, Integer::sum);
}
freq.forEach((item, count) -> System.out.println(item + ": " + count));
```

`Collections.frequency()`는 **단일 요소의 등장 횟수를 한 번만** 확인할 때 편리하지만, 전체 빈도표가 필요하면 반드시 Map을 사용하세요.
</details>

---

### Q12. Collections — `unmodifiableList()` vs `List.copyOf()`

아래 코드의 출력 결과 차이를 설명하세요.

```java
List<String> original = new ArrayList<>(List.of("A", "B"));

List<String> view = Collections.unmodifiableList(original);
List<String> copy = List.copyOf(original);

original.add("C");

System.out.println(view);
System.out.println(copy);
```

<details>
<summary>정답 및 해설</summary>

**정답**:
- `view`: `[A, B, C]` — 원본 변경이 **반영됨**
- `copy`: `[A, B]` — 원본 변경이 **반영되지 않음**

`Collections.unmodifiableList()`는 원본의 **뷰(래퍼)**입니다. 뷰 자체는 수정 불가(`add()`/`remove()` 시 `UnsupportedOperationException`)이지만, **원본이 변경되면 뷰도 변경**됩니다.

`List.copyOf()`는 **독립 복사본**입니다. 원본과 완전히 분리되므로 원본 변경의 영향을 받지 않습니다.

진정한 불변이 필요하면 **`List.copyOf()`**를 사용하세요. 단, `List.copyOf()`는 null 요소를 허용하지 않습니다.
</details>

---

### Q13. Collections — 불변 리스트에 `add()` 호출

아래 코드의 실행 결과는?

```java
List<String> list = List.of("A", "B", "C");
list.add("D");
```

<details>
<summary>정답 및 해설</summary>

**`UnsupportedOperationException` 발생.**

`List.of()`는 불변 리스트를 생성합니다. 이 리스트에 `add()`, `remove()`, `set()` 등 수정 연산을 호출하면 모두 예외가 발생합니다.

수정 가능한 리스트가 필요하면 새 ArrayList로 복사하세요:
```java
List<String> mutable = new ArrayList<>(List.of("A", "B", "C"));
mutable.add("D"); // OK
```
</details>

---

### Q14. Collections — `singletonList()`와 `emptyList()`

`Collections.singletonList("X")`와 `Collections.emptyList()`로 생성한 리스트에 `add()`를 호출하면 어떤 일이 발생하나요?

<details>
<summary>정답 및 해설</summary>

둘 다 **`UnsupportedOperationException` 발생.** 두 메서드 모두 **불변 리스트**를 반환합니다.

- `singletonList("X")`: 요소 1개짜리 불변 리스트 `["X"]`
- `emptyList()`: 비어 있는 불변 리스트 `[]`

Java 9+에서는 `List.of("X")`, `List.of()`가 더 현대적인 대안입니다. 기능은 동일합니다.
</details>

---

### Q15. Collections — `unmodifiableMap()` 사용

아래 코드의 실행 결과는?

```java
Map<String, Integer> original = new HashMap<>();
original.put("A", 1);

Map<String, Integer> safe = Collections.unmodifiableMap(original);
safe.put("B", 2);
```

<details>
<summary>정답 및 해설</summary>

**`UnsupportedOperationException` 발생.** `unmodifiableMap()`이 반환한 맵에 `put()`, `remove()` 등 수정 연산을 호출하면 예외가 발생합니다.

단, **원본 `original`에 직접 수정**하면 `safe`에도 반영됩니다 (뷰이므로). 독립적으로 보호하려면 `Map.copyOf(original)`을 사용하세요.
</details>
