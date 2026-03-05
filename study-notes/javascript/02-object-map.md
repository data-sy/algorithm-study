# Object, Map, Set — Key-Value 저장과 중복 제거

> 코딩테스트에서 빈도 세기, 존재 여부 확인, 중복 제거에 핵심적으로 쓰이는 자료구조들.

**위치**: Object는 가장 기본적인 Key-Value 구조, Map/Set은 ES6에서 추가된 특화 구조

---

## Object vs Map 비교

| 관점 | Object | Map |
|---|---|---|
| 키 타입 | string/Symbol만 가능 | 어떤 타입이든 가능 (객체, 숫자 등) |
| 순서 | 부분적 보장 (정수키 → 삽입순) | 삽입 순서 완전 보장 |
| 크기 확인 | `Object.keys(obj).length` | `map.size` |
| 반복 | `for...in`, `Object.entries()` | `for...of`, `map.forEach()` |
| 코딩테스트 용도 | 빈도 세기 (가장 많이 사용) | 키 타입이 중요할 때 |

---

## Object 핵심 메서드

| 메서드/문법 | 설명 |
|---|---|
| `obj[key]` / `obj.key` | 값 접근 (없으면 undefined) |
| `obj[key] = value` | 값 설정 |
| `Object.keys(obj)` | 모든 키 배열 반환 |
| `Object.values(obj)` | 모든 값 배열 반환 |
| `Object.entries(obj)` | [키, 값] 쌍의 배열 반환 |
| `delete obj[key]` | 키-값 삭제 |
| `obj.hasOwnProperty(key)` | 키 존재 여부 |
| `key in obj` | 키 존재 여부 (프로토타입 체인 포함) |

---

## Map 핵심 메서드

| 메서드 | 설명 |
|---|---|
| `map.set(key, value)` | 키-값 저장 |
| `map.get(key)` | 키로 값 조회 (없으면 undefined) |
| `map.has(key)` | 키 존재 여부 |
| `map.size` | 저장된 쌍 개수 |
| `map.delete(key)` | 키-값 삭제 |
| `map.entries()` | [키, 값] 이터레이터 |
| `map.forEach(callback)` | 각 쌍에 대해 함수 실행 |

---

## Set — 중복 제거 특화

| 메서드 | 설명 |
|---|---|
| `set.add(value)` | 값 추가 (이미 있으면 무시) |
| `set.has(value)` | 값 존재 여부 |
| `set.size` | 요소 개수 |
| `set.delete(value)` | 값 삭제 |

핵심 패턴: **Array → Set → Array** 변환으로 중복 제거
```javascript
const arr = [1, 2, 2, 3, 3, 3];
const unique = [...new Set(arr)];
console.log(unique); // [1, 2, 3]
```

---

## 패턴 1: Object로 빈도 세기

### 언제 쓰는가
- 각 요소가 몇 번 등장하는지 카운트할 때
- 코딩테스트에서 가장 자주 나오는 Object 활용 패턴

### 실무에서는
- 로그 집계, 투표 결과 집계

```javascript
const fruits = ["apple", "banana", "apple", "cherry", "banana", "apple"];

// 빈도 세기: obj[key] = (obj[key] || 0) + 1
const count = {};
for (const fruit of fruits) {
    count[fruit] = (count[fruit] || 0) + 1;
}

console.log(count); // { apple: 3, banana: 2, cherry: 1 }

// 가장 많이 나온 과일 찾기
let maxFruit = "";
let maxCount = 0;
for (const [fruit, cnt] of Object.entries(count)) {
    if (cnt > maxCount) {
        maxCount = cnt;
        maxFruit = fruit;
    }
}
console.log(`${maxFruit}: ${maxCount}번`); // apple: 3번
```

---

## 패턴 2: Set으로 중복 제거 + 크기 확인

### 언제 쓰는가
- 서로 다른 종류가 몇 개인지 셀 때

### 실무에서는
- 고유 방문자 수, 태그 중복 제거

```javascript
const animals = ["cat", "dog", "cat", "bird", "dog", "fish"];

// 고유 종류 수
const uniqueSet = new Set(animals);
console.log("종류 수:", uniqueSet.size); // 종류 수: 4

// 중복 제거된 배열
const uniqueArr = [...uniqueSet];
console.log(uniqueArr); // ["cat", "dog", "bird", "fish"]

// 포켓몬 문제 패턴: N/2마리를 골라 가장 많은 종류를 고르기
function maxTypes(nums) {
    const types = new Set(nums).size;
    const pick = nums.length / 2;
    return Math.min(types, pick);
}

console.log(maxTypes([3, 1, 2, 3]));       // 2 (종류 3, 선택 2 → 2)
console.log(maxTypes([3, 3, 3, 2, 2, 4])); // 3 (종류 3, 선택 3 → 3)
console.log(maxTypes([3, 3, 3, 2, 2, 2])); // 2 (종류 2, 선택 3 → 2)
```

---

## 패턴 3: Object 키 조회로 접두사 검사

### 언제 쓰는가
- 한 문자열이 다른 문자열의 접두사인지 확인할 때

### 실무에서는
- 자동완성, URL 매칭

```javascript
// 전화번호부에서 접두사 관계 확인
const phoneBook = ["119", "97674223", "1195524421"];

const map = {};
for (const phone of phoneBook) {
    map[phone] = true;
}

let hasPrefix = false;
for (const phone of phoneBook) {
    // 한 글자씩 늘려가며 접두사 존재 확인
    for (let i = 1; i < phone.length; i++) {
        const prefix = phone.substring(0, i);
        if (map[prefix]) {
            console.log(`${prefix}는 ${phone}의 접두사입니다`);
            // 119는 1195524421의 접두사입니다
            hasPrefix = true;
        }
    }
}

console.log("접두사 존재:", hasPrefix); // 접두사 존재: true
```

---

## 패턴 4: entries 순회 + 조합 계산

### 언제 쓰는가
- 그룹별로 분류한 뒤 조합 수를 계산할 때

### 실무에서는
- 상품 옵션 조합, 필터 조합

```javascript
// 의상 조합 문제: 종류별로 1개씩 선택 (아무것도 안 입는 경우 제외)
const clothes = [
    ["yellow_hat", "headgear"],
    ["blue_sunglasses", "eyewear"],
    ["green_turban", "headgear"],
];

// 종류별 개수 세기
const typeCount = {};
for (const [name, type] of clothes) {
    typeCount[type] = (typeCount[type] || 0) + 1;
}

console.log(typeCount); // { headgear: 2, eyewear: 1 }

// 조합 수 계산: 각 종류별 (선택 수 + 안 입는 경우 1) 곱한 후 - 전부 안 입는 경우 1
let combinations = 1;
for (const [type, cnt] of Object.entries(typeCount)) {
    combinations *= (cnt + 1); // headgear: 3가지(2개 + 안입기), eyewear: 2가지(1개 + 안입기)
}
combinations -= 1; // 전부 안 입는 경우 제외

console.log("조합 수:", combinations); // 조합 수: 5
// yellow_hat, green_turban, blue_sunglasses,
// yellow_hat+blue_sunglasses, green_turban+blue_sunglasses
```
