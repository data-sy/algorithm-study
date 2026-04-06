# Part 3: 실전편 — 실무형 코딩테스트 문제

> 모든 문제의 시나리오는 **이커머스** 도메인으로 통일합니다.
> 풀이는 `java.util.stream` 패키지를 사용하지 않습니다.

---

## 전체 문제 목록

| 문제 번호 | 문제 제목                     | 핵심 스킬                                           | 난이도  | 출제 빈도 | 예상 소요 시간 |
| ----- | ------------------------- | ----------------------------------------------- | ---- | ----- | -------- |
| 1-1   | 카테고리별 주문 건수 집계            | HashMap, merge                                  | Lv.1 | 필수    | 10분      |
| 1-2   | 고객별 구매 상품 목록 그룹핑          | HashMap, computeIfAbsent                        | Lv.1 | 필수    | 10분      |
| 1-3   | 상품별 총 매출액 Top-N           | HashMap, merge, List.sort                       | Lv.2 | 높음    | 20분      |
| 2-1   | 중복 쿠폰 코드 제거 (순서 보장)       | LinkedHashSet                                   | Lv.1 | 필수    | 10분      |
| 2-2   | 두 프로모션의 공통 구매 고객 추출       | HashSet, retainAll                              | Lv.2 | 높음    | 15분      |
| 2-3   | 단골 고객 식별 — 3개 이상 카테고리 구매자 | HashMap, HashSet                                | Lv.2 | 높음    | 15분      |
| 3-1   | 주문 내역 다중 조건 정렬            | Comparator.comparing, thenComparing             | Lv.1 | 필수    | 10분      |
| 3-2   | 가격대별 상품 범위 검색             | TreeMap, subMap                                 | Lv.2 | 보통    | 15분      |
| 3-3   | 리뷰 평점 상위 N개 상품 추출         | HashMap, PriorityQueue                          | Lv.2 | 높음    | 20분      |
| 4-1   | 최근 본 상품 목록 관리             | LinkedHashSet                                   | Lv.2 | 높음    | 15분      |
| 4-2   | 장바구니 실행취소 기능              | ArrayDeque (Stack)                              | Lv.1 | 보통    | 10분      |
| 4-3   | 주문 처리 대기열 시뮬레이션           | ArrayDeque (Queue), PriorityQueue               | Lv.2 | 보통    | 20분      |
| 5-1   | 카테고리별 월간 베스트 상품 리포트       | HashMap, computeIfAbsent, List.sort, Comparator | Lv.3 | 높음    | 25분      |
| 5-2   | 고객 재구매율 분석                | HashMap, HashSet, Iterator                      | Lv.3 | 보통    | 25분      |
| 5-3   | 실시간 인기 검색어 순위             | HashMap, merge, TreeSet, Comparator             | Lv.3 | 보통    | 25분      |

---

## 범주 1: 빈도 계산 & 그룹핑

---

### 문제 1-1: 카테고리별 주문 건수 집계

**난이도**: Lv.1
**출제 빈도**: 필수
**핵심 스킬**: HashMap, merge
**예상 소요 시간**: 10분

**시나리오**:
이커머스 플랫폼에서 전체 주문 데이터를 분석하여, 각 카테고리에 몇 건의 주문이 있었는지 집계해야 합니다.

**입력 데이터**:

```java
record Order(String orderId, String category, int amount) {}

List<Order> orders = List.of(
    new Order("O001", "식품", 15000),
    new Order("O002", "의류", 32000),
    new Order("O003", "식품", 8000),
    new Order("O004", "전자", 150000),
    new Order("O005", "의류", 27000),
    new Order("O006", "식품", 12000)
);
```

**요구사항**:

```java
// 카테고리별 주문 건수를 반환
Map<String, Integer> countByCategory(List<Order> orders)
```

**예시 입출력**:
- Input: 위 orders
- Output: `{식품=3, 의류=2, 전자=1}`

**힌트**: HashMap의 `merge()` 또는 `getOrDefault()` + `put()`을 활용하세요.

**모범 답안**:

```java
import java.util.HashMap;
import java.util.List;
import java.util.Map;

Map<String, Integer> countByCategory(List<Order> orders) {
    Map<String, Integer> countMap = new HashMap<>();
    for (Order order : orders) {
        countMap.merge(order.category(), 1, Integer::sum);
    }
    return countMap;
}
```

**핵심 포인트 해설**:
- `merge(key, 1, Integer::sum)`: 키가 없으면 1을 저장, 있으면 기존 값 + 1.
- 동일한 결과를 내는 대안: `countMap.put(order.category(), countMap.getOrDefault(order.category(), 0) + 1);`
- `merge`가 더 간결하고 빈도 세기의 정석 패턴입니다.

**자주 하는 실수와 주의점**:
- `getOrDefault()`가 Map에 값을 저장한다고 착각하여 `put` 없이 사용하는 실수.
- `Map<String, int>`는 불가능합니다. 원시 타입은 제네릭에 사용할 수 없으므로 `Integer`를 사용해야 합니다.

**시간복잡도 분석**:
- `orders` 리스트를 1회 순회: O(n)
- 각 순회마다 `HashMap.merge()`: O(1)
- **전체: O(n)** (n = 주문 수)

---

### 문제 1-2: 고객별 구매 상품 목록 그룹핑

**난이도**: Lv.1
**출제 빈도**: 필수
**핵심 스킬**: HashMap, computeIfAbsent
**예상 소요 시간**: 10분

**시나리오**:
고객별로 어떤 상품을 구매했는지 그룹핑하여, 마케팅팀이 고객 취향을 분석할 수 있도록 데이터를 준비해야 합니다.

**입력 데이터**:

```java
record OrderItem(String customerId, String productName, int price) {}

List<OrderItem> items = List.of(
    new OrderItem("C001", "운동화", 89000),
    new OrderItem("C002", "티셔츠", 25000),
    new OrderItem("C001", "백팩", 65000),
    new OrderItem("C003", "모자", 18000),
    new OrderItem("C002", "청바지", 45000),
    new OrderItem("C001", "양말", 5000)
);
```

**요구사항**:

```java
// 고객별 구매 상품명 리스트를 반환
Map<String, List<String>> groupByCustomer(List<OrderItem> items)
```

**예시 입출력**:
- Input: 위 items
- Output: `{C001=[운동화, 백팩, 양말], C002=[티셔츠, 청바지], C003=[모자]}`

**힌트**: `computeIfAbsent()`를 사용하면 키가 없을 때 자동으로 빈 리스트를 생성하고, 바로 `add()`를 체이닝할 수 있습니다.

**모범 답안**:

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

Map<String, List<String>> groupByCustomer(List<OrderItem> items) {
    Map<String, List<String>> grouped = new HashMap<>();
    for (OrderItem item : items) {
        grouped.computeIfAbsent(item.customerId(), k -> new ArrayList<>())
               .add(item.productName());
    }
    return grouped;
}
```

**핵심 포인트 해설**:
- `computeIfAbsent(key, k -> new ArrayList<>())`: 키가 없으면 빈 ArrayList를 생성하여 Map에 저장하고 반환. 있으면 기존 리스트를 반환.
- 반환된 리스트에 바로 `.add()`를 체이닝하여 한 줄로 처리.
- 대안: `putIfAbsent`를 사용할 수도 있지만, `computeIfAbsent`는 키가 있을 때 불필요한 ArrayList 생성을 피함 (lazy 평가).

**자주 하는 실수와 주의점**:
- `computeIfAbsent` 대신 매번 `new ArrayList<>()`를 `putIfAbsent`로 전달하면, 키가 이미 있을 때도 리스트 객체가 생성됨 (비효율).
- `containsKey` + `get` + `put` 조합으로 장황하게 작성하는 것도 실수는 아니지만, `computeIfAbsent` 한 줄이 훨씬 간결합니다.

**시간복잡도 분석**:
- `items` 리스트를 1회 순회: O(n)
- 각 순회마다 `HashMap.computeIfAbsent()`: O(1), `ArrayList.add()`: O(1) 평균
- **전체: O(n)** (n = 주문 항목 수)

---

### 문제 1-3: 상품별 총 매출액 Top-N

**난이도**: Lv.2
**출제 빈도**: 높음
**핵심 스킬**: HashMap, merge, List.sort, Comparator
**예상 소요 시간**: 20분

**시나리오**:
이커머스 플랫폼에서 전체 주문 데이터를 분석하여, 총 매출액 기준 상위 N개 상품을 추출해야 합니다. 매출액은 `가격 × 수량`으로 계산합니다.

**입력 데이터**:

```java
record SalesItem(String productId, String productName, int price, int quantity) {}

List<SalesItem> sales = List.of(
    new SalesItem("P001", "운동화", 89000, 3),
    new SalesItem("P002", "티셔츠", 25000, 10),
    new SalesItem("P001", "운동화", 89000, 2),
    new SalesItem("P003", "백팩", 65000, 1),
    new SalesItem("P002", "티셔츠", 25000, 5),
    new SalesItem("P004", "모자", 18000, 8),
    new SalesItem("P003", "백팩", 65000, 3)
);
```

**요구사항**:

```java
record ProductSales(String productId, String productName, long totalSales) {}

// 총 매출액 기준 상위 N개 상품을 반환 (매출액 내림차순)
List<ProductSales> topNBySales(List<SalesItem> sales, int n)
```

**예시 입출력**:
- Input: 위 sales, n = 3
- Output: `[ProductSales[P001, 운동화, 445000], ProductSales[P002, 티셔츠, 375000], ProductSales[P003, 백팩, 260000]]`
  - P001: 89000×3 + 89000×2 = 445,000
  - P002: 25000×10 + 25000×5 = 375,000
  - P003: 65000×1 + 65000×3 = 260,000

**힌트**: 1단계 — 상품별 매출 합산 (HashMap + merge). 2단계 — 매출액 기준 정렬 후 상위 N개 추출.

**모범 답안**:

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

List<ProductSales> topNBySales(List<SalesItem> sales, int n) {
    // 1단계: 상품별 매출 합산
    Map<String, Long> salesMap = new HashMap<>();
    Map<String, String> nameMap = new HashMap<>();

    for (SalesItem item : sales) {
        long revenue = (long) item.price() * item.quantity();
        salesMap.merge(item.productId(), revenue, Long::sum);
        nameMap.putIfAbsent(item.productId(), item.productName());
    }

    // 2단계: 결과 리스트 생성 및 정렬
    List<ProductSales> result = new ArrayList<>();
    for (var entry : salesMap.entrySet()) {
        String id = entry.getKey();
        result.add(new ProductSales(id, nameMap.get(id), entry.getValue()));
    }

    result.sort(Comparator.comparingLong(ProductSales::totalSales).reversed());

    // 3단계: 상위 N개 추출
    return result.subList(0, Math.min(n, result.size()));
}
```

**핵심 포인트 해설**:
- `merge(productId, revenue, Long::sum)`: 같은 상품의 매출을 자동 합산.
- `putIfAbsent`로 상품명은 최초 1회만 저장 (동일 상품은 이름이 같으므로).
- `Comparator.comparingLong(...).reversed()`로 매출 내림차순 정렬.
- `Math.min(n, result.size())`로 n이 전체 상품 수보다 클 때 `IndexOutOfBoundsException` 방지.

**자주 하는 실수와 주의점**:
- `int × int`의 결과가 int 오버플로우를 일으킬 수 있으므로 `(long) price * quantity`로 캐스팅.
- `subList()`는 뷰를 반환하므로, 독립 복사본이 필요하면 `new ArrayList<>(result.subList(...))`로 감싸야 합니다.
- `reversed()`를 `comparingLong()` 뒤에 붙여야 내림차순이 됩니다. 체인 순서를 주의하세요.

**시간복잡도 분석**:
- 1단계 순회: O(n), 각 `merge`/`putIfAbsent`: O(1) → O(n)
- 2단계 리스트 생성: O(m) (m = 고유 상품 수)
- 2단계 정렬: O(m log m)
- 3단계 subList: O(1) (뷰)
- **전체: O(n + m log m)** — 보통 m ≤ n이므로 O(n log n)

---

## 범주 2: 중복 제거 & 집합 연산

---

### 문제 2-1: 중복 쿠폰 코드 제거 (순서 보장)

**난이도**: Lv.1
**출제 빈도**: 필수
**핵심 스킬**: LinkedHashSet
**예상 소요 시간**: 10분

**시나리오**:
프로모션 이벤트에서 고객에게 쿠폰 코드를 발급했습니다. 시스템 오류로 중복 발급된 코드가 있어, 중복을 제거하되 **최초 발급 순서**를 유지해야 합니다.

**입력 데이터**:

```java
List<String> coupons = List.of(
    "SUMMER10", "WELCOME5", "SUMMER10", "FLASH20",
    "WELCOME5", "VIP30", "FLASH20", "SUMMER10"
);
```

**요구사항**:

```java
// 중복을 제거하고, 최초 등장 순서를 유지한 리스트를 반환
List<String> removeDuplicates(List<String> coupons)
```

**예시 입출력**:
- Input: 위 coupons
- Output: `[SUMMER10, WELCOME5, FLASH20, VIP30]`

**힌트**: 삽입 순서를 유지하면서 중복을 제거하는 자료구조를 떠올려 보세요.

**모범 답안**:

```java
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

List<String> removeDuplicates(List<String> coupons) {
    Set<String> uniqueSet = new LinkedHashSet<>(coupons);
    return new ArrayList<>(uniqueSet);
}
```

**핵심 포인트 해설**:
- `LinkedHashSet`은 삽입 순서를 유지하면서 중복을 자동 제거합니다.
- 생성자에 `Collection`을 전달하면 순회하며 삽입하므로, 최초 등장 순서가 보존됩니다.
- `new ArrayList<>(set)`으로 Set을 List로 변환하여 반환.

**자주 하는 실수와 주의점**:
- `HashSet`을 사용하면 중복은 제거되지만 **순서가 보장되지 않습니다**.
- `LinkedHashSet`에 이미 존재하는 요소를 `add()`하면 순서가 갱신되지 않고 무시됩니다 (최초 위치 유지).

**시간복잡도 분석**:
- LinkedHashSet 생성 (n개 순회, 각 add O(1)): O(n)
- ArrayList 변환: O(m) (m = 고유 쿠폰 수)
- **전체: O(n)**

---

### 문제 2-2: 두 프로모션의 공통 구매 고객 추출

**난이도**: Lv.2
**출제 빈도**: 높음
**핵심 스킬**: HashSet, retainAll
**예상 소요 시간**: 15분

**시나리오**:
마케팅팀에서 "여름 세일"과 "가을 신상" 두 프로모션에 **모두** 참여한 고객을 찾아, 크로스셀링 캠페인을 진행하려 합니다. 각 프로모션의 주문 데이터에서 공통 구매 고객 ID를 추출하세요.

**입력 데이터**:

```java
record PromoOrder(String orderId, String customerId, String promoName) {}

List<PromoOrder> summerOrders = List.of(
    new PromoOrder("S01", "C001", "여름세일"),
    new PromoOrder("S02", "C002", "여름세일"),
    new PromoOrder("S03", "C003", "여름세일"),
    new PromoOrder("S04", "C001", "여름세일"),
    new PromoOrder("S05", "C005", "여름세일")
);

List<PromoOrder> fallOrders = List.of(
    new PromoOrder("F01", "C002", "가을신상"),
    new PromoOrder("F02", "C004", "가을신상"),
    new PromoOrder("F03", "C003", "가을신상"),
    new PromoOrder("F04", "C002", "가을신상"),
    new PromoOrder("F05", "C006", "가을신상")
);
```

**요구사항**:

```java
// 두 프로모션에 모두 참여한 고객 ID 집합을 반환
Set<String> findCommonCustomers(List<PromoOrder> promoA, List<PromoOrder> promoB)
```

**예시 입출력**:
- Input: 위 summerOrders, fallOrders
- Output: `{C002, C003}` (순서 무관)

**힌트**: 각 프로모션의 고객 ID를 Set으로 추출한 뒤, 교집합 연산을 수행하세요.

**모범 답안**:

```java
import java.util.HashSet;
import java.util.List;
import java.util.Set;

Set<String> findCommonCustomers(List<PromoOrder> promoA, List<PromoOrder> promoB) {
    Set<String> customersA = new HashSet<>();
    for (PromoOrder order : promoA) {
        customersA.add(order.customerId());
    }

    Set<String> customersB = new HashSet<>();
    for (PromoOrder order : promoB) {
        customersB.add(order.customerId());
    }

    // 교집합: customersA에서 customersB에 없는 요소를 제거
    customersA.retainAll(customersB);
    return customersA;
}
```

**핵심 포인트 해설**:
- 각 프로모션의 주문에서 고객 ID를 HashSet으로 추출하면 중복이 자동 제거됩니다.
- `retainAll()`은 교집합 연산으로, **호출 대상(customersA)을 직접 변경**합니다.

**자주 하는 실수와 주의점**:
- `retainAll()`이 원본을 변경한다는 것을 잊고, 원본 Set을 이후에도 사용하려 하면 문제가 됩니다. 원본 보존이 필요하면 `new HashSet<>(customersA)`로 복사 후 연산하세요.
- 합집합은 `addAll()`, 차집합은 `removeAll()`을 사용합니다.

**시간복잡도 분석**:
- customersA 생성: O(a) (a = promoA 주문 수)
- customersB 생성: O(b) (b = promoB 주문 수)
- `retainAll()`: O(min(|customersA|, |customersB|))
- **전체: O(a + b)**

---

### 문제 2-3: 단골 고객 식별 — 3개 이상 카테고리 구매자

**난이도**: Lv.2
**출제 빈도**: 높음
**핵심 스킬**: HashMap, HashSet
**예상 소요 시간**: 15분

**시나리오**:
이커머스 플랫폼에서 **3개 이상의 서로 다른 카테고리**에서 구매한 고객을 "단골 고객"으로 정의합니다. 주문 데이터에서 단골 고객 ID 목록을 추출하세요.

**입력 데이터**:

```java
record CategoryOrder(String customerId, String category, int amount) {}

List<CategoryOrder> orders = List.of(
    new CategoryOrder("C001", "식품", 15000),
    new CategoryOrder("C001", "의류", 32000),
    new CategoryOrder("C002", "식품", 8000),
    new CategoryOrder("C001", "전자", 150000),
    new CategoryOrder("C003", "의류", 27000),
    new CategoryOrder("C002", "식품", 12000),
    new CategoryOrder("C003", "전자", 88000),
    new CategoryOrder("C001", "식품", 9000),
    new CategoryOrder("C003", "뷰티", 45000),
    new CategoryOrder("C002", "의류", 55000)
);
```

**요구사항**:

```java
// 3개 이상 서로 다른 카테고리에서 구매한 고객 ID 리스트를 반환
List<String> findLoyalCustomers(List<CategoryOrder> orders, int minCategories)
```

**예시 입출력**:
- Input: 위 orders, minCategories = 3
- Output: `[C001, C003]` (순서 무관)
  - C001: 식품, 의류, 전자 (3개)
  - C002: 식품, 의류 (2개) → 미달
  - C003: 의류, 전자, 뷰티 (3개)

**힌트**: 고객별로 구매한 카테고리를 Set으로 관리하면, 중복 카테고리를 자동으로 제거하면서 고유 카테고리 수를 셀 수 있습니다.

**모범 답안**:

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

List<String> findLoyalCustomers(List<CategoryOrder> orders, int minCategories) {
    // 1단계: 고객별 구매 카테고리 Set 구성
    Map<String, Set<String>> customerCategories = new HashMap<>();
    for (CategoryOrder order : orders) {
        customerCategories.computeIfAbsent(order.customerId(), k -> new HashSet<>())
                          .add(order.category());
    }

    // 2단계: 기준 이상의 카테고리를 가진 고객 추출
    List<String> loyalCustomers = new ArrayList<>();
    for (var entry : customerCategories.entrySet()) {
        if (entry.getValue().size() >= minCategories) {
            loyalCustomers.add(entry.getKey());
        }
    }

    return loyalCustomers;
}
```

**핵심 포인트 해설**:
- `computeIfAbsent(customerId, k -> new HashSet<>())`: 고객 ID가 처음 등장하면 빈 HashSet 생성.
- HashSet에 `add()`하면 같은 카테고리를 여러 번 넣어도 자동 중복 제거.
- `set.size() >= minCategories`로 고유 카테고리 수를 판단.

**자주 하는 실수와 주의점**:
- 카테고리를 List로 관리하면 중복이 제거되지 않아, `contains()` 체크를 매번 해야 하는 비효율이 발생합니다. **Set이 적합한 자료구조**입니다.
- `computeIfAbsent` 대신 `putIfAbsent(id, new HashSet<>())`를 쓰면, 키가 이미 있어도 매번 새 HashSet 객체를 생성합니다 (비효율).

**시간복잡도 분석**:
- 1단계 순회: O(n), 각 `computeIfAbsent` + `add`: O(1) → O(n)
- 2단계 순회: O(c) (c = 고유 고객 수), 각 `set.size()`: O(1) → O(c)
- **전체: O(n)** (n = 주문 수, c ≤ n)

---

## 범주 3: 정렬 & 우선순위

---

### 문제 3-1: 주문 내역 다중 조건 정렬

**난이도**: Lv.1
**출제 빈도**: 필수
**핵심 스킬**: Comparator.comparing, thenComparing, reversed
**예상 소요 시간**: 10분

**시나리오**:
고객 서비스팀이 주문 내역을 조회할 때, **카테고리 오름차순 → 같은 카테고리 내에서 금액 내림차순**으로 정렬하여 보여주어야 합니다.

**입력 데이터**:

```java
record OrderEntry(String orderId, String category, int amount) {}

List<OrderEntry> orders = List.of(
    new OrderEntry("O001", "의류", 32000),
    new OrderEntry("O002", "식품", 15000),
    new OrderEntry("O003", "의류", 58000),
    new OrderEntry("O004", "전자", 150000),
    new OrderEntry("O005", "식품", 8000),
    new OrderEntry("O006", "의류", 25000),
    new OrderEntry("O007", "전자", 89000)
);
```

**요구사항**:

```java
// 카테고리 오름차순, 같은 카테고리 내에서 금액 내림차순으로 정렬된 리스트를 반환
List<OrderEntry> sortOrders(List<OrderEntry> orders)
```

**예시 입출력**:
- Input: 위 orders
- Output:
  ```
  [O003 의류 58000, O001 의류 32000, O006 의류 25000,
   O002 식품 15000, O005 식품 8000,
   O004 전자 150000, O007 전자 89000]
  ```

**힌트**: `Comparator.comparing()`으로 1차 정렬, `thenComparing()`에 `Comparator.reverseOrder()`를 전달하여 2차 역순 정렬을 구성하세요.

**모범 답안**:

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

List<OrderEntry> sortOrders(List<OrderEntry> orders) {
    List<OrderEntry> sorted = new ArrayList<>(orders);
    sorted.sort(Comparator.comparing(OrderEntry::category)
            .thenComparing(OrderEntry::amount, Comparator.reverseOrder()));
    return sorted;
}
```

**핵심 포인트 해설**:
- `Comparator.comparing(OrderEntry::category)`: 카테고리 기준 오름차순 (String의 자연 순서 = 사전순).
- `.thenComparing(OrderEntry::amount, Comparator.reverseOrder())`: 2차 기준으로 금액 내림차순.
- 원본을 보존하기 위해 `new ArrayList<>(orders)`로 복사 후 정렬.

**자주 하는 실수와 주의점**:
- `.reversed()`를 체인 끝에 붙이면 **전체** 정렬이 뒤집힙니다 (카테고리도 역순). 특정 필드만 역순으로 하려면 `thenComparing(field, Comparator.reverseOrder())`를 사용하세요.
- `int` 필드를 비교할 때 `comparingInt(OrderEntry::amount)`를 쓰면 불필요한 박싱을 피할 수 있습니다.

**시간복잡도 분석**:
- ArrayList 복사: O(n)
- `List.sort()` (Tim Sort): O(n log n)
- **전체: O(n log n)**

---

### 문제 3-2: 가격대별 상품 범위 검색

**난이도**: Lv.2
**출제 빈도**: 보통
**핵심 스킬**: TreeMap, subMap
**예상 소요 시간**: 15분

**시나리오**:
이커머스 플랫폼의 상품 검색 기능에서, 사용자가 지정한 **가격 범위**(최소~최대)에 해당하는 상품 목록을 빠르게 조회해야 합니다.

**입력 데이터**:

```java
record Product(String productId, String name, int price) {}

List<Product> products = List.of(
    new Product("P001", "양말", 5000),
    new Product("P002", "티셔츠", 25000),
    new Product("P003", "모자", 18000),
    new Product("P004", "운동화", 89000),
    new Product("P005", "백팩", 65000),
    new Product("P006", "벨트", 35000),
    new Product("P007", "스카프", 22000)
);
```

**요구사항**:

```java
// minPrice 이상, maxPrice 이하인 상품 목록을 가격 오름차순으로 반환
List<Product> searchByPriceRange(List<Product> products, int minPrice, int maxPrice)
```

**예시 입출력**:
- Input: 위 products, minPrice = 20000, maxPrice = 70000
- Output: `[P007 스카프 22000, P002 티셔츠 25000, P006 벨트 35000, P005 백팩 65000]`

**힌트**: TreeMap에 가격을 키로 넣으면 `subMap()`으로 범위 검색이 가능합니다. 같은 가격의 상품이 여러 개일 수 있으므로 값을 리스트로 관리하세요.

**모범 답안**:

```java
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

List<Product> searchByPriceRange(List<Product> products, int minPrice, int maxPrice) {
    // 1단계: 가격을 키로 하는 TreeMap 구성 (같은 가격 → 리스트)
    TreeMap<Integer, List<Product>> priceMap = new TreeMap<>();
    for (Product p : products) {
        priceMap.computeIfAbsent(p.price(), k -> new ArrayList<>()).add(p);
    }

    // 2단계: 범위 검색 (양쪽 포함)
    List<Product> result = new ArrayList<>();
    for (var entry : priceMap.subMap(minPrice, true, maxPrice, true).entrySet()) {
        result.addAll(entry.getValue());
    }

    return result;
}
```

**핵심 포인트 해설**:
- `TreeMap`은 키(가격)를 정렬된 상태로 유지하므로, 범위 검색에 최적입니다.
- `subMap(minPrice, true, maxPrice, true)`: 양쪽 **포함**인 4-파라미터 버전. 2-파라미터 버전은 끝 값이 미포함이므로 주의.
- 같은 가격의 상품이 여러 개일 수 있어 `List<Product>`를 값으로 사용.

**자주 하는 실수와 주의점**:
- 2-파라미터 `subMap(from, to)`는 `from` 포함, `to` **미포함**입니다. `maxPrice`를 포함하려면 4-파라미터 버전을 사용하거나 `subMap(minPrice, maxPrice + 1)`로 처리해야 합니다.
- 범위 검색이 필요 없는 단순 조회라면 HashMap이 O(1)로 더 효율적입니다.

**시간복잡도 분석**:
- TreeMap 구성: O(n log n) (n개 요소 각각 O(log n)으로 삽입)
- `subMap()`: O(log n)으로 시작점 탐색
- 범위 내 순회: O(r) (r = 결과 개수)
- **전체: O(n log n + r)**
- 이 구조를 한 번 만들어 두면, 이후 범위 검색은 O(log n + r)로 반복 수행 가능합니다.

---

### 문제 3-3: 리뷰 평점 상위 N개 상품 추출

**난이도**: Lv.2
**출제 빈도**: 높음
**핵심 스킬**: HashMap, merge, PriorityQueue, Comparator
**예상 소요 시간**: 20분

**시나리오**:
이커머스 플랫폼에서 상품 리뷰 데이터를 분석하여, **평균 평점 상위 N개 상품**을 추출해야 합니다. 같은 평점이면 리뷰 수가 많은 상품이 우선입니다.

**입력 데이터**:

```java
record Review(String productId, String reviewer, int rating) {} // rating: 1~5

List<Review> reviews = List.of(
    new Review("P001", "유진", 5),
    new Review("P002", "서연", 3),
    new Review("P001", "하은", 4),
    new Review("P003", "지민", 5),
    new Review("P002", "도윤", 4),
    new Review("P003", "수아", 5),
    new Review("P004", "민서", 3),
    new Review("P001", "채원", 5),
    new Review("P003", "예은", 4),
    new Review("P004", "시우", 2),
    new Review("P005", "하린", 4),
    new Review("P005", "지호", 5)
);
```

**요구사항**:

```java
record ProductRating(String productId, double avgRating, int reviewCount) {}

// 평균 평점 상위 N개 상품을 반환 (평점 내림차순 → 리뷰 수 내림차순)
List<ProductRating> topRatedProducts(List<Review> reviews, int n)
```

**예시 입출력**:
- Input: 위 reviews, n = 3
- Output:
  ```
  [ProductRating[P003, 4.67, 3], ProductRating[P001, 4.67, 3], ProductRating[P005, 4.50, 2]]
  ```
  - P003: (5+5+4)/3 = 4.67, 3건
  - P001: (5+4+5)/3 = 4.67, 3건 → 동점이면 리뷰 수 같으므로 순서 무관
  - P005: (4+5)/2 = 4.50, 2건

**힌트**: 1단계 — 상품별 평점 합산 & 리뷰 수 카운팅 (HashMap 2개 또는 중간 record). 2단계 — PriorityQueue(최소 힙, 크기 N) 또는 List + sort로 Top-N 추출.

**모범 답안**:

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

List<ProductRating> topRatedProducts(List<Review> reviews, int n) {
    // 1단계: 상품별 평점 합산 & 리뷰 수 집계
    Map<String, Integer> sumMap = new HashMap<>();
    Map<String, Integer> countMap = new HashMap<>();

    for (Review review : reviews) {
        sumMap.merge(review.productId(), review.rating(), Integer::sum);
        countMap.merge(review.productId(), 1, Integer::sum);
    }

    // 2단계: ProductRating 리스트 생성
    List<ProductRating> ratings = new ArrayList<>();
    for (String productId : sumMap.keySet()) {
        int total = sumMap.get(productId);
        int count = countMap.get(productId);
        double avg = (double) total / count;
        ratings.add(new ProductRating(productId, avg, count));
    }

    // 3단계: 평균 평점 내림차순 → 리뷰 수 내림차순 정렬
    ratings.sort(Comparator.comparingDouble(ProductRating::avgRating).reversed()
            .thenComparing(Comparator.comparingInt(ProductRating::reviewCount).reversed()));

    return ratings.subList(0, Math.min(n, ratings.size()));
}
```

**핵심 포인트 해설**:
- 두 개의 HashMap(`sumMap`, `countMap`)으로 평점 합산과 리뷰 수를 동시 집계.
- `(double) total / count`로 평균 계산. 정수끼리 나누면 소수점이 잘리므로 캐스팅 필수.
- `comparingDouble(...).reversed()`로 내림차순 정렬. `comparingDouble`은 `double` 필드에 박싱 없이 대응.

**자주 하는 실수와 주의점**:
- 정수 나눗셈으로 평균을 계산하면 소수점이 버려집니다. 반드시 `(double)` 캐스팅.
- `reversed()`를 체인 끝에 한 번만 쓰면 모든 정렬 기준이 뒤집히므로, 각 기준별로 `reversed()`를 따로 적용해야 합니다.
- 리뷰가 0건인 상품은 이 데이터에서 발생하지 않지만, 실무에서는 0으로 나누기를 방지해야 합니다.

**시간복잡도 분석**:
- 1단계 순회: O(r), 각 merge O(1) → O(r) (r = 리뷰 수)
- 2단계 리스트 생성: O(p) (p = 고유 상품 수)
- 3단계 정렬: O(p log p)
- **전체: O(r + p log p)**
