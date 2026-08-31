## 범주 4: 순서 & 이력 관리

---

### 문제 4-1: 최근 본 상품 목록 관리

**난이도**: Lv.2
**출제 빈도**: 높음
**핵심 스킬**: LinkedHashSet
**예상 소요 시간**: 15분

**시나리오**:
이커머스 앱에서 고객이 상품을 클릭할 때마다 "최근 본 상품" 목록을 갱신합니다. 규칙은 다음과 같습니다:
1. 가장 최근에 본 상품이 **맨 뒤**에 위치
2. 이미 본 상품을 다시 클릭하면 **기존 위치에서 제거 후 맨 뒤로 이동**
3. 목록의 최대 크기는 `maxSize`개. 초과 시 **가장 오래된 상품**(맨 앞)을 제거

**입력 데이터**:

```java
List<String> viewHistory = List.of(
    "P001", "P002", "P003", "P004", "P005",
    "P002", "P006", "P001"
);
int maxSize = 5;
```

**요구사항**:

```java
// 최근 본 상품 목록을 반환 (오래된 순 → 최신 순)
List<String> getRecentProducts(List<String> viewHistory, int maxSize)
```

**예시 입출력**:
- Input: 위 viewHistory, maxSize = 5
- 처리 과정:
  1. P001 → `[P001]`
  2. P002 → `[P001, P002]`
  3. P003 → `[P001, P002, P003]`
  4. P004 → `[P001, P002, P003, P004]`
  5. P005 → `[P001, P002, P003, P004, P005]`
  6. P002 → 기존 P002 제거 후 맨 뒤 추가 → `[P001, P003, P004, P005, P002]`
  7. P006 → 5개 초과 → 가장 오래된 P001 제거 → `[P003, P004, P005, P002, P006]`
  8. P001 → 5개 초과 → 가장 오래된 P003 제거 → `[P004, P005, P002, P006, P001]`
- Output: `[P004, P005, P002, P006, P001]`

**힌트**: LinkedHashSet은 삽입 순서를 유지합니다. 이미 존재하는 요소를 `remove()` → `add()`하면 맨 뒤로 이동시킬 수 있습니다.

**모범 답안**:

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

List<String> getRecentProducts(List<String> viewHistory, int maxSize) {
    Set<String> recent = new LinkedHashSet<>();

    for (String productId : viewHistory) {
        // 이미 있으면 제거 (순서 갱신을 위해)
        recent.remove(productId);
        // 맨 뒤에 추가
        recent.add(productId);

        // 최대 크기 초과 시 가장 오래된 항목(맨 앞) 제거
        if (recent.size() > maxSize) {
            Iterator<String> it = recent.iterator();
            it.next();
            it.remove();
        }
    }

    return new ArrayList<>(recent);
}
```

**핵심 포인트 해설**:
- `remove()` → `add()` 패턴으로 기존 요소를 맨 뒤로 이동. LinkedHashSet의 `add()`는 이미 존재하면 순서를 갱신하지 않으므로, 반드시 먼저 `remove()`를 해야 합니다.
- 가장 오래된 항목은 Iterator로 첫 번째 요소를 가져온 뒤 `it.remove()`로 삭제합니다.

**자주 하는 실수와 주의점**:
- LinkedHashSet에 이미 있는 요소를 `add()`만 하면 **순서가 갱신되지 않습니다**. 반드시 `remove()` 후 `add()` 해야 합니다.
- `iterator().next()`로 첫 번째 요소를 가져오는 것은 O(1)입니다.

**시간복잡도 분석**:
- viewHistory n건 순회: O(n)
- 각 순회마다 `remove` O(1) + `add` O(1) + 가끔 Iterator 삭제 O(1) → O(1)
- **전체: O(n)**

---

### 문제 4-2: 장바구니 실행취소 기능

**난이도**: Lv.1
**출제 빈도**: 보통
**핵심 스킬**: ArrayDeque (Stack)
**예상 소요 시간**: 10분

**시나리오**:
이커머스 앱의 장바구니에서 고객이 상품을 추가(ADD)하거나 삭제(REMOVE)할 수 있습니다. 고객이 **실행취소(Undo)**를 요청하면, 마지막 동작을 취소합니다. K번 실행취소한 후의 장바구니 상태를 구하세요.

**입력 데이터**:

```java
record CartAction(String type, String productId) {} // type: "ADD" 또는 "REMOVE"

List<CartAction> actions = List.of(
    new CartAction("ADD", "P001"),
    new CartAction("ADD", "P002"),
    new CartAction("ADD", "P003"),
    new CartAction("REMOVE", "P001"),
    new CartAction("ADD", "P004")
);
int undoCount = 2;
```

**요구사항**:

```java
// K번 실행취소 후 장바구니에 담긴 상품 ID 리스트를 반환
List<String> getCartAfterUndo(List<CartAction> actions, int undoCount)
```

**예시 입출력**:
- Input: 위 actions, undoCount = 2
- 처리 과정:
  1. ADD P001 → 장바구니 `[P001]`
  2. ADD P002 → 장바구니 `[P001, P002]`
  3. ADD P003 → 장바구니 `[P001, P002, P003]`
  4. REMOVE P001 → 장바구니 `[P002, P003]`
  5. ADD P004 → 장바구니 `[P002, P003, P004]`
  6. Undo 1회: ADD P004 취소 → P004 제거 → `[P002, P003]`
  7. Undo 2회: REMOVE P001 취소 → P001 복원 → `[P002, P003, P001]`
- Output: `[P002, P003, P001]`

**힌트**: 각 동작을 Stack에 push하고, Undo 시 pop하여 **반대 동작**을 수행하세요.

**모범 답안**:

```java
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

List<String> getCartAfterUndo(List<CartAction> actions, int undoCount) {
    List<String> cart = new ArrayList<>();
    Deque<CartAction> history = new ArrayDeque<>();

    // 동작 수행 및 이력 기록
    for (CartAction action : actions) {
        if (action.type().equals("ADD")) {
            cart.add(action.productId());
        } else {
            cart.remove(action.productId());
        }
        history.push(action);
    }

    // 실행취소: 마지막 동작의 반대를 수행
    int actualUndo = Math.min(undoCount, history.size());
    for (int i = 0; i < actualUndo; i++) {
        CartAction lastAction = history.pop();
        if (lastAction.type().equals("ADD")) {
            // ADD 취소 → 제거
            cart.remove(lastAction.productId());
        } else {
            // REMOVE 취소 → 복원
            cart.add(lastAction.productId());
        }
    }

    return cart;
}
```

**핵심 포인트 해설**:
- `ArrayDeque`를 Stack으로 사용: `push()`로 동작 이력을 쌓고, `pop()`으로 최신 동작부터 꺼냄 (LIFO).
- Undo는 원래 동작의 **반대**를 수행: ADD의 취소 = REMOVE, REMOVE의 취소 = ADD.
- `Math.min(undoCount, history.size())`로 이력보다 많은 Undo 요청을 방어.

**자주 하는 실수와 주의점**:
- `java.util.Stack` 대신 `ArrayDeque`를 사용합니다. Stack은 레거시 클래스입니다.
- `cart.remove(productId)`는 `remove(Object)`이므로 첫 번째 일치 항목을 삭제합니다. 같은 상품이 여러 개 담긴 경우를 고려해야 한다면 추가 로직이 필요합니다.

**시간복잡도 분석**:
- 동작 수행: O(n), 각 `cart.add` O(1), `cart.remove` O(m) (m = 장바구니 크기)
- Undo K회: O(K × m)
- **전체: O(n × m)** — 장바구니 크기가 작으면 사실상 O(n)

---

### 문제 4-3: 주문 처리 대기열 시뮬레이션

**난이도**: Lv.2
**출제 빈도**: 보통
**핵심 스킬**: ArrayDeque (Queue), PriorityQueue
**예상 소요 시간**: 20분

**시나리오**:
이커머스 물류센터에서 주문을 처리합니다. 주문에는 **긴급(URGENT)**과 **일반(NORMAL)** 두 등급이 있습니다. 처리 규칙:
1. 긴급 주문은 일반 주문보다 **항상 먼저** 처리
2. 같은 등급 내에서는 **접수 순서(FIFO)**대로 처리

모든 주문을 처리 순서대로 반환하세요.

**입력 데이터**:

```java
record ProcessOrder(String orderId, String priority, long receivedAt) {}
// priority: "URGENT" 또는 "NORMAL"

List<ProcessOrder> orders = List.of(
    new ProcessOrder("O001", "NORMAL", 1000),
    new ProcessOrder("O002", "URGENT", 1001),
    new ProcessOrder("O003", "NORMAL", 1002),
    new ProcessOrder("O004", "URGENT", 1003),
    new ProcessOrder("O005", "NORMAL", 1004),
    new ProcessOrder("O006", "URGENT", 1005)
);
```

**요구사항**:

```java
// 처리 순서대로 주문 ID 리스트를 반환
List<String> processOrders(List<ProcessOrder> orders)
```

**예시 입출력**:
- Input: 위 orders
- Output: `[O002, O004, O006, O001, O003, O005]`
  - 긴급(접수순): O002 → O004 → O006
  - 일반(접수순): O001 → O003 → O005

**힌트**: 등급별로 별도의 Queue(ArrayDeque)를 사용하거나, 우선순위가 포함된 Comparator를 가진 PriorityQueue를 사용하세요.

**모범 답안 (방법 1: 등급별 Queue 분리)**:

```java
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

List<String> processOrders(List<ProcessOrder> orders) {
    Deque<ProcessOrder> urgentQueue = new ArrayDeque<>();
    Deque<ProcessOrder> normalQueue = new ArrayDeque<>();

    for (ProcessOrder order : orders) {
        if (order.priority().equals("URGENT")) {
            urgentQueue.offer(order);
        } else {
            normalQueue.offer(order);
        }
    }

    List<String> result = new ArrayList<>();

    // 긴급 주문 먼저 처리
    while (!urgentQueue.isEmpty()) {
        result.add(urgentQueue.poll().orderId());
    }
    // 일반 주문 처리
    while (!normalQueue.isEmpty()) {
        result.add(normalQueue.poll().orderId());
    }

    return result;
}
```

**모범 답안 (방법 2: PriorityQueue)**:

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

List<String> processOrders(List<ProcessOrder> orders) {
    // URGENT < NORMAL (URGENT이 먼저 오도록), 같은 등급이면 접수 시간순
    PriorityQueue<ProcessOrder> pq = new PriorityQueue<>(
        Comparator.comparing(ProcessOrder::priority) // "NORMAL" > "URGENT" (사전순)
                  .thenComparingLong(ProcessOrder::receivedAt)
    );

    for (ProcessOrder order : orders) {
        pq.offer(order);
    }

    List<String> result = new ArrayList<>();
    while (!pq.isEmpty()) {
        result.add(pq.poll().orderId());
    }
    return result;
}
```

**핵심 포인트 해설**:
- **방법 1**: 직관적이고 간단. 등급이 2개뿐이면 이 방법이 더 명확합니다.
- **방법 2**: PriorityQueue에 복합 Comparator를 전달. `"NORMAL" > "URGENT"` (String 사전순)이라서 URGENT이 먼저 나옵니다. 등급이 3개 이상으로 늘어나면 이 방법이 확장에 유리합니다.

**자주 하는 실수와 주의점**:
- PriorityQueue의 for-each 순회는 정렬 순서를 보장하지 않습니다. 반드시 `poll()`로 하나씩 꺼내야 합니다.
- 방법 2에서 "URGENT"이 "NORMAL"보다 사전순으로 뒤에 오므로, `reversed()`를 쓸지 여부를 주의하세요. 실제로는 "N" < "U"이므로 NORMAL이 먼저 나옵니다. 따라서 priority 비교 순서를 반대로 해야 합니다.

**수정된 방법 2 Comparator** (URGENT을 먼저 처리하기 위해):

```java
Comparator.comparing(ProcessOrder::priority) // "NORMAL" < "URGENT" (사전순)
// → NORMAL이 먼저 나오므로 역순 필요:
Comparator.comparing(ProcessOrder::priority, Comparator.reverseOrder())
          .thenComparingLong(ProcessOrder::receivedAt)
```

**시간복잡도 분석**:
- 방법 1: 분류 O(n) + 두 큐 순회 O(n) = **O(n)**
- 방법 2: PQ에 n개 삽입 O(n log n) + n번 poll O(n log n) = **O(n log n)**
- 등급이 고정 개수면 방법 1이 더 효율적입니다.

---

## 범주 5: 복합 설계

---

### 문제 5-1: 카테고리별 월간 베스트 상품 리포트

**난이도**: Lv.3
**출제 빈도**: 높음
**핵심 스킬**: HashMap, computeIfAbsent, List.sort, Comparator
**예상 소요 시간**: 25분

**시나리오**:
이커머스 플랫폼에서 **카테고리별 월간 베스트 상품**을 선정합니다. 각 카테고리에서 해당 월 **판매 수량이 가장 많은 상위 2개 상품**을 추출하세요.

**입력 데이터**:

```java
record MonthlySale(String category, String productId, String productName,
                   String month, int quantitySold) {}

List<MonthlySale> sales = List.of(
    new MonthlySale("식품", "P001", "유기농 사과", "2024-01", 150),
    new MonthlySale("식품", "P002", "현미", "2024-01", 200),
    new MonthlySale("식품", "P003", "올리브유", "2024-01", 80),
    new MonthlySale("식품", "P001", "유기농 사과", "2024-01", 50),
    new MonthlySale("의류", "P010", "패딩", "2024-01", 300),
    new MonthlySale("의류", "P011", "니트", "2024-01", 250),
    new MonthlySale("의류", "P012", "코트", "2024-01", 180),
    new MonthlySale("전자", "P020", "이어폰", "2024-01", 500),
    new MonthlySale("전자", "P021", "충전기", "2024-01", 400)
);
```

**요구사항**:

```java
record BestProduct(String productId, String productName, int totalQuantity) {}

// 카테고리별 판매 수량 상위 topN개 상품을 반환
Map<String, List<BestProduct>> categoryBestProducts(List<MonthlySale> sales, int topN)
```

**예시 입출력**:
- Input: 위 sales, topN = 2
- Output:
  ```
  {
    식품=[BestProduct[P002, 현미, 200], BestProduct[P001, 유기농 사과, 200]],
    의류=[BestProduct[P010, 패딩, 300], BestProduct[P011, 니트, 250]],
    전자=[BestProduct[P020, 이어폰, 500], BestProduct[P021, 충전기, 400]]
  }
  ```
  - P001: 150 + 50 = 200 (같은 상품 합산)

**힌트**: 3단계로 나눠 생각하세요. ① 카테고리+상품별 판매 수량 합산 → ② 카테고리별로 그룹핑 → ③ 각 카테고리 내에서 정렬 후 Top-N 추출.

**모범 답안**:

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

Map<String, List<BestProduct>> categoryBestProducts(List<MonthlySale> sales, int topN) {
    // 1단계: (카테고리, 상품ID) → 판매 수량 합산
    // 복합 키로 "카테고리::상품ID" 문자열을 사용
    Map<String, Integer> quantityMap = new HashMap<>();
    Map<String, String> nameMap = new HashMap<>();
    Map<String, String> categoryMap = new HashMap<>();

    for (MonthlySale sale : sales) {
        String compositeKey = sale.category() + "::" + sale.productId();
        quantityMap.merge(compositeKey, sale.quantitySold(), Integer::sum);
        nameMap.putIfAbsent(compositeKey, sale.productName());
        categoryMap.putIfAbsent(compositeKey, sale.category());
    }

    // 2단계: 카테고리별 BestProduct 리스트 그룹핑
    Map<String, List<BestProduct>> grouped = new HashMap<>();
    for (var entry : quantityMap.entrySet()) {
        String key = entry.getKey();
        String category = categoryMap.get(key);
        String productId = key.split("::")[1];
        String productName = nameMap.get(key);
        int totalQty = entry.getValue();

        grouped.computeIfAbsent(category, k -> new ArrayList<>())
               .add(new BestProduct(productId, productName, totalQty));
    }

    // 3단계: 각 카테고리 내에서 판매 수량 내림차순 정렬 후 Top-N
    Map<String, List<BestProduct>> result = new HashMap<>();
    for (var entry : grouped.entrySet()) {
        List<BestProduct> products = entry.getValue();
        products.sort(Comparator.comparingInt(BestProduct::totalQuantity).reversed());

        result.put(entry.getKey(),
                products.subList(0, Math.min(topN, products.size())));
    }

    return result;
}
```

**핵심 포인트 해설**:
- **복합 키 설계**: `"카테고리::상품ID"` 형태의 문자열로 복합 키를 만들어 하나의 Map으로 관리. record를 키로 사용하는 것도 좋은 대안입니다(`record CompositeKey(String category, String productId) {}`).
- `merge`로 같은 카테고리-상품 조합의 판매 수량을 합산.
- `computeIfAbsent`로 카테고리별 리스트를 자동 생성.
- 각 카테고리 내에서 별도로 정렬 후 `subList`로 Top-N 추출.

**자주 하는 실수와 주의점**:
- 같은 상품이 여러 행으로 나뉘어 있을 때 **합산**을 빼먹는 실수. `merge`를 사용하면 자연스럽게 해결됩니다.
- 복합 키를 문자열 연결로 만들 때, 구분자(`::`)가 데이터에 포함되지 않는지 확인해야 합니다. record를 키로 사용하는 방식이 더 안전합니다.
- `subList()`가 뷰라는 점을 기억하세요. 원본 리스트가 변경되면 뷰도 영향을 받습니다.

**시간복잡도 분석**:
- 1단계 순회: O(n), 각 merge O(1) → O(n)
- 2단계 그룹핑: O(p) (p = 고유 카테고리-상품 조합 수)
- 3단계 정렬: 각 카테고리별 O(p_i log p_i), 전체 합산 O(p log p)
- **전체: O(n + p log p)** — 보통 p ≤ n이므로 O(n log n)

---

### 문제 5-2: 고객 재구매율 분석

**난이도**: Lv.3
**출제 빈도**: 보통
**핵심 스킬**: HashMap, HashSet, Iterator
**예상 소요 시간**: 25분

**시나리오**:
이커머스 플랫폼에서 **고객 재구매율**을 분석합니다. "재구매 고객"이란 **같은 상품을 2회 이상** 구매한 고객입니다. 전체 고객 중 재구매 고객의 비율과, 재구매 고객별 재구매 상품 목록을 구하세요.

**입력 데이터**:

```java
record Purchase(String customerId, String productId, String date) {}

List<Purchase> purchases = List.of(
    new Purchase("C001", "P001", "2024-01-05"),
    new Purchase("C001", "P002", "2024-01-10"),
    new Purchase("C002", "P001", "2024-01-12"),
    new Purchase("C001", "P001", "2024-01-20"),  // C001이 P001 재구매
    new Purchase("C003", "P003", "2024-01-22"),
    new Purchase("C002", "P002", "2024-01-25"),
    new Purchase("C002", "P001", "2024-02-01"),  // C002가 P001 재구매
    new Purchase("C003", "P004", "2024-02-05"),
    new Purchase("C001", "P002", "2024-02-10"),  // C001이 P002 재구매
    new Purchase("C004", "P001", "2024-02-15")
);
```

**요구사항**:

```java
record RepurchaseResult(
    int totalCustomers,
    int repurchaseCustomers,
    double repurchaseRate,  // 재구매 고객 수 / 전체 고객 수
    Map<String, List<String>> repurchaseDetails // 고객ID → 재구매한 상품ID 리스트
) {}

RepurchaseResult analyzeRepurchase(List<Purchase> purchases)
```

**예시 입출력**:
- Input: 위 purchases
- Output:
  ```
  RepurchaseResult[
    totalCustomers=4,
    repurchaseCustomers=2,
    repurchaseRate=0.5,
    repurchaseDetails={C001=[P001, P002], C002=[P001]}
  ]
  ```
  - C001: P001 2회, P002 2회 → 재구매 고객
  - C002: P001 2회 → 재구매 고객
  - C003: P003 1회, P004 1회 → 재구매 아님
  - C004: P001 1회 → 재구매 아님

**힌트**: 고객별 → 상품별 구매 횟수를 세는 2중 Map 구조를 생각해 보세요. 그 후 구매 횟수가 2 이상인 항목을 필터링합니다.

**모범 답안**:

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

RepurchaseResult analyzeRepurchase(List<Purchase> purchases) {
    // 1단계: 고객별 → 상품별 구매 횟수 집계
    Map<String, Map<String, Integer>> customerProductCount = new HashMap<>();
    Set<String> allCustomers = new HashSet<>();

    for (Purchase p : purchases) {
        allCustomers.add(p.customerId());
        customerProductCount
            .computeIfAbsent(p.customerId(), k -> new HashMap<>())
            .merge(p.productId(), 1, Integer::sum);
    }

    // 2단계: 재구매 고객 식별 (상품 구매 횟수 ≥ 2인 항목이 있는 고객)
    Map<String, List<String>> repurchaseDetails = new HashMap<>();

    for (var customerEntry : customerProductCount.entrySet()) {
        String customerId = customerEntry.getKey();
        Map<String, Integer> productCounts = customerEntry.getValue();

        List<String> repurchasedProducts = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> it = productCounts.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() >= 2) {
                repurchasedProducts.add(entry.getKey());
            }
        }

        if (!repurchasedProducts.isEmpty()) {
            repurchaseDetails.put(customerId, repurchasedProducts);
        }
    }

    // 3단계: 결과 조합
    int totalCustomers = allCustomers.size();
    int repurchaseCustomers = repurchaseDetails.size();
    double repurchaseRate = (double) repurchaseCustomers / totalCustomers;

    return new RepurchaseResult(totalCustomers, repurchaseCustomers,
                                repurchaseRate, repurchaseDetails);
}
```

**핵심 포인트 해설**:
- **2중 Map 구조**: `Map<고객ID, Map<상품ID, 구매횟수>>`. `computeIfAbsent`로 내부 Map을 자동 생성하고, `merge`로 구매 횟수를 합산합니다.
- `allCustomers`를 HashSet으로 관리하여 전체 고유 고객 수를 O(1)로 파악.
- Iterator를 사용한 순회로 2회 이상 구매한 상품을 필터링. (이 문제에서는 `removeIf`를 쓸 필요까지는 없지만, Iterator 패턴의 연습으로 포함했습니다.)

**자주 하는 실수와 주의점**:
- `(double)` 캐스팅을 빼먹으면 정수 나눗셈으로 `0`이 됩니다.
- `computeIfAbsent`의 체이닝: `.computeIfAbsent(key, k -> new HashMap<>()).merge(...)` — 내부 Map의 `merge`까지 한 줄로 가능합니다.
- 전체 고객 수를 구할 때 `customerProductCount.size()`와 `allCustomers.size()`는 동일하지만, 구매가 없는 고객이 있을 수 있는 실무에서는 별도 Set이 안전합니다.

**시간복잡도 분석**:
- 1단계 순회: O(n), 각 `computeIfAbsent` O(1) + `merge` O(1) → O(n)
- 2단계 순회: O(c × p_avg) (c = 고객 수, p_avg = 고객당 평균 상품 수)
  - 전체적으로 O(n) (모든 고객-상품 조합의 합 = 총 구매 건수)
- **전체: O(n)**

---

### 문제 5-3: 실시간 인기 검색어 순위

**난이도**: Lv.3
**출제 빈도**: 보통
**핵심 스킬**: HashMap, merge, TreeSet, Comparator
**예상 소요 시간**: 25분

**시나리오**:
이커머스 플랫폼에서 고객의 검색 로그를 분석하여, **검색 빈도 상위 N개 인기 검색어**를 실시간으로 추출합니다. 같은 빈도면 **사전순(가나다순)** 으로 정렬합니다.

**입력 데이터**:

```java
List<String> searchLogs = List.of(
    "운동화", "티셔츠", "백팩", "운동화", "모자",
    "운동화", "티셔츠", "백팩", "청바지", "티셔츠",
    "모자", "운동화", "벨트", "백팩", "모자"
);
```

**요구사항**:

```java
record SearchRank(String keyword, int count) {}

// 검색 빈도 상위 N개 검색어를 반환 (빈도 내림차순 → 사전순)
List<SearchRank> topSearchKeywords(List<String> searchLogs, int n)
```

**예시 입출력**:
- Input: 위 searchLogs, n = 3
- Output:
  ```
  [SearchRank[운동화, 4], SearchRank[모자, 3], SearchRank[티셔츠, 3]]
  ```
  - 운동화: 4회
  - 모자: 3회, 티셔츠: 3회 → 빈도 동점이면 사전순 (모자 < 티셔츠)
  - 백팩: 3회 → Top-3에서 밀림

**힌트**: HashMap으로 빈도를 세고, TreeSet에 커스텀 Comparator(빈도 내림차순 → 사전순)를 적용하여 정렬된 상태를 유지하세요. 또는 List로 변환 후 정렬해도 됩니다.

**모범 답안**:

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

List<SearchRank> topSearchKeywords(List<String> searchLogs, int n) {
    // 1단계: 검색어 빈도 집계
    Map<String, Integer> freqMap = new HashMap<>();
    for (String keyword : searchLogs) {
        freqMap.merge(keyword, 1, Integer::sum);
    }

    // 2단계: SearchRank 리스트 생성
    List<SearchRank> ranks = new ArrayList<>();
    for (var entry : freqMap.entrySet()) {
        ranks.add(new SearchRank(entry.getKey(), entry.getValue()));
    }

    // 3단계: 빈도 내림차순 → 사전순 정렬
    ranks.sort(Comparator.comparingInt(SearchRank::count).reversed()
            .thenComparing(SearchRank::keyword));

    // 4단계: 상위 N개 추출
    return ranks.subList(0, Math.min(n, ranks.size()));
}
```

**핵심 포인트 해설**:
- `merge(keyword, 1, Integer::sum)`: 빈도 세기의 정석 패턴.
- `comparingInt(...).reversed()`: 빈도 내림차순.
- `.thenComparing(SearchRank::keyword)`: 빈도가 같으면 검색어 사전순(String의 자연 순서).

**대안: TreeSet 사용 버전**:

```java
// TreeSet에 커스텀 Comparator 적용 — 삽입과 동시에 정렬 유지
TreeSet<SearchRank> sortedSet = new TreeSet<>(
    Comparator.comparingInt(SearchRank::count).reversed()
              .thenComparing(SearchRank::keyword)
);
for (var entry : freqMap.entrySet()) {
    sortedSet.add(new SearchRank(entry.getKey(), entry.getValue()));
}
// sortedSet에서 상위 N개를 Iterator로 추출
```

TreeSet 버전은 삽입 시 자동 정렬되므로 별도 `sort()` 호출이 불필요합니다. 다만 이 문제에서는 데이터를 한 번에 처리하므로 List + sort가 더 간결합니다.

**자주 하는 실수와 주의점**:
- TreeSet 사용 시, Comparator가 0을 반환하면 **같은 요소로 취급하여 무시**됩니다. 빈도와 키워드가 모두 같은 경우에만 0을 반환하도록 Comparator를 설계해야 합니다. (위 Comparator는 keyword까지 비교하므로 안전합니다.)
- `reversed()`를 체인 끝에 붙이면 keyword 순서도 역순이 됩니다. `comparingInt(...).reversed()`로 빈도에만 적용하세요.
- `subList()`는 뷰이므로, 독립 복사본이 필요하면 `new ArrayList<>(...)`로 감싸세요.

**시간복잡도 분석**:
- 1단계 빈도 집계: O(s) (s = 검색 로그 수), 각 merge O(1) → O(s)
- 2단계 리스트 생성: O(k) (k = 고유 검색어 수)
- 3단계 정렬: O(k log k)
- 4단계 subList: O(1)
- **전체: O(s + k log k)** — 보통 k ≤ s이므로 O(s log s)
- TreeSet 버전: O(s + k log k) — 삽입 시 O(log k) × k = O(k log k)
