# 백준 → 프로그래머스 대체 문제 매핑 (콜럼버스 스터디 상반 53문제)

> 배경: acmicpc.net 문제 페이지가 응답하지 않아(404) 노션 "콜럼버스 (1)상반 문제 목록"의 백준 링크가 모두 무효화됨.
> 이 문서는 그 53문제를 **프로그래머스 문제로 대체**한 표다.
> 노션 DB: `📢 문제 공지` → `콜럼버스 (1)상반 문제 목록`
>
> - 프로그래머스 ID/제목/레벨은 2026-08-19에 실제 페이지 제목을 조회해 검증함 (추측 없음).
> - `Lv0` = 코딩테스트 입문 / 코딩 기초 트레이닝 코스.
> - 유사도: `◎` 사실상 같은 유형 · `○` 핵심 알고리즘 동일, 살은 다름 · `△` 부분만 겹침(보완 필요)
> - `★` = 이번에 새로 채운 칸 (노션에 링크가 비어 있던 15문제)

---

## 1주차 — 문자열 · 수학

| 백준 | 문제 | 난이도 | 프로그래머스 대체 | Lv | 유사 |
|---|---|---|---|---|---|
| 10798 | 세로 읽기 | 브1 | ★ [세로 읽기](https://school.programmers.co.kr/learn/courses/30/lessons/181904) | Lv0 | ◎ |
| 9046 | 알파벳 개수 세기 | 브2 | ★ [최빈값 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/120812) | Lv0 | ◎ |
| 11720 | 숫자의 합 | 브4 | ★ [자릿수 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/12931) | Lv1 | ◎ |
| 9996 | 패턴 일치 확인 | 실3 | ★ [접미사인지 확인하기](https://school.programmers.co.kr/learn/courses/30/lessons/181908) | Lv0 | ○ |
| 1157 | 알파벳 개수(대소 무시) | 브1 | [문자열 내 p와 y의 개수](https://school.programmers.co.kr/learn/courses/30/lessons/12916) | Lv1 | ○ |
| 17413 | 단어 뒤집기 2 | 실3 | ★ [JadenCase 문자열 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12951) | Lv2 | ○ |
| 3613 | Java ↔ C++ | 실3 | [신규 아이디 추천](https://school.programmers.co.kr/learn/courses/30/lessons/72410) | Lv1 | ◎ |
| 2609 | 최대공약수·최소공배수 | 브1 | [최대공약수와 최소공배수](https://school.programmers.co.kr/learn/courses/30/lessons/12940) | Lv1 | ◎ |
| 1929 | 소수 구하기 | 실3 | [소수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/12921) | Lv1 | ◎ |
| 9342 | 염색체 | 실3 | ★ [문자열 다루기 기본](https://school.programmers.co.kr/learn/courses/30/lessons/12918) | Lv1 | △ |
| 20291 | 확장자 개수 세기 | 실3 | [완주하지 못한 선수](https://school.programmers.co.kr/learn/courses/30/lessons/42576) | Lv1 | ○ |
| 1373 | 2진수 → 8진수 | 브1 | ★ [3진법 뒤집기](https://school.programmers.co.kr/learn/courses/30/lessons/68935) | Lv1 | ○ |
| 2004 | 조합 0의 개수 | 실2 | ★ [소인수분해](https://school.programmers.co.kr/learn/courses/30/lessons/120852) | Lv0 | △ |

**보강 문제**
- 9996 → 프로그래머스는 접두/접미가 두 문제로 쪼개져 있음. [접두사인지 확인하기](https://school.programmers.co.kr/learn/courses/30/lessons/181906) + 접미사 문제를 **둘 다** 풀면 9996 한 문제와 같다.
- 9046 → 보조 [문자 개수 세기](https://school.programmers.co.kr/learn/courses/30/lessons/181902). 최빈값 동점 처리(`?` ↔ `-1`) 구조가 9046과 동일한 건 120812 쪽.
- 11720 → 보조 [문자열 정수의 합](https://school.programmers.co.kr/learn/courses/30/lessons/181849).
- 17413 → 구간 뒤집기 감각은 [문자열 여러 번 뒤집기](https://school.programmers.co.kr/learn/courses/30/lessons/181913).
- 9342 → 정규식 검증 심화는 신규 아이디 추천(72410).
- 1373 → 워밍업 [이진수 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/120885), 심화 [k진수에서 소수 개수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/92335).
- **2004는 정직하게 대체 불가**: 팩토리얼/조합의 뒤쪽 0 개수(르장드르 공식) 유형이 프로그래머스에 없다. 120852로 "소인수 지수 세기" 감각만 잡고, 개념은 별도 학습 권장.

---

## 2주차 — 스택 · 큐 · 덱 · 링크드리스트

| 백준 | 문제 | 난이도 | 프로그래머스 대체 | Lv | 유사 |
|---|---|---|---|---|---|
| 3986 | 좋은 단어 | 실4 | [짝지어 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12973) | Lv2 | ◎ |
| 9012 | VPS | 실4 | [올바른 괄호](https://school.programmers.co.kr/learn/courses/30/lessons/12909) | Lv2 | ◎ |
| 10799 | 쇠막대기 | 실2 | [괄호 변환](https://school.programmers.co.kr/learn/courses/30/lessons/60058) | Lv2 | ○ |
| 18258 | 큐 2 | 실4 | [다리를 지나는 트럭](https://school.programmers.co.kr/learn/courses/30/lessons/42583) | Lv2 | ○ |
| 1874 | 스택 수열 | 실2 | [카드 뭉치](https://school.programmers.co.kr/learn/courses/30/lessons/159994) | Lv1 | ○ |
| 1918 | 중위 → 후위 표기식 | 골2 | ★ [수식 최대화](https://school.programmers.co.kr/learn/courses/30/lessons/67257) | Lv2 | ○ |
| 1935 | 후위표기식 계산 | 실3 | ★ [문자열 계산하기](https://school.programmers.co.kr/learn/courses/30/lessons/120902) | Lv0 | △ |
| 2840 | 행운의 바퀴 | 실4 | ★ [문자열 밀기](https://school.programmers.co.kr/learn/courses/30/lessons/120921) | Lv0 | ○ |
| 1966 | 프린터 큐 | 실3 | [프로세스](https://school.programmers.co.kr/learn/courses/30/lessons/42587) | Lv2 | ◎ |
| 5397 | 키로거 | 실2 | ★ [표 편집](https://school.programmers.co.kr/learn/courses/30/lessons/81303) | Lv3 | ○ |
| 1406 | 에디터 | 실2 | ★ [표 편집](https://school.programmers.co.kr/learn/courses/30/lessons/81303) | Lv3 | ◎ |

**보강 문제**
- 1918/1935는 "연산자 우선순위 + 스택 파싱"이 핵심이라 프로그래머스에선 67257 한 문제가 둘을 합친 형태다. 1935는 [간단한 식 계산하기](https://school.programmers.co.kr/learn/courses/30/lessons/181865) → 120902 → 67257 순서로 오르면 된다.
- 2840 심화: [괄호 회전하기](https://school.programmers.co.kr/learn/courses/30/lessons/76502)(회전 시뮬레이션).
- 5397·1406은 **같은 유형(커서 = 스택 2개 / 연결 리스트)** 이라 대체 문제도 같다. 다만 81303은 Lv3이라 난이도 점프가 크다 — 먼저 1406 성격의 커서 구현을 손으로 짜본 뒤 81303으로.

---

## 중간고사 (2024-05-06) · 해시 · 덱

| 백준 | 문제 | 프로그래머스 대체 | Lv | 유사 |
|---|---|---|---|---|
| 10773 | 틀렸을 때 삭제 | [같은 숫자는 싫어](https://school.programmers.co.kr/learn/courses/30/lessons/12906) | Lv1 | ○ |
| 2870 | 문자열에서 숫자만 뽑기 | ★ [문자열 정렬하기 (1)](https://school.programmers.co.kr/learn/courses/30/lessons/120850) | Lv0 | ◎ |
| 2960 | 에라토스테네스 K번째 | [소수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/12921) | Lv1 | ○ |
| 2504 | 괄호 2종 VPS | [괄호 회전하기](https://school.programmers.co.kr/learn/courses/30/lessons/76502) | Lv2 | ○ |
| 1620 | 포켓몬 도감 | [오픈채팅방](https://school.programmers.co.kr/learn/courses/30/lessons/42888) | Lv2 | ○ |
| 4358 | 생태학 | [베스트앨범](https://school.programmers.co.kr/learn/courses/30/lessons/42579) | Lv3 | ○ |
| 9375 | 패션왕 | [의상](https://school.programmers.co.kr/learn/courses/30/lessons/42578) | Lv2 | ◎ |
| 10816 | 숫자 개수 세기 | [완주하지 못한 선수](https://school.programmers.co.kr/learn/courses/30/lessons/42576) | Lv1 | ◎ |
| 2164 | 카드 2 | [다리를 지나는 트럭](https://school.programmers.co.kr/learn/courses/30/lessons/42583) | Lv2 | ○ |
| 1158 | 요세푸스 | [프로세스](https://school.programmers.co.kr/learn/courses/30/lessons/42587) | Lv2 | ○ |
| 14425 | 문자열 집합 | [전화번호 목록](https://school.programmers.co.kr/learn/courses/30/lessons/42577) | Lv2 | ○ |
| 19583 | 문자열 집합(중복 O) | [오픈채팅방](https://school.programmers.co.kr/learn/courses/30/lessons/42888) | Lv2 | ○ |
| 18115 | 카드 놓기 | ★ [카드 뭉치](https://school.programmers.co.kr/learn/courses/30/lessons/159994) | Lv1 | ○ |

**보강 문제**
- 2870은 세 조각짜리다: 숫자 추출·정렬(120850) + 선행 0 제거([0 떼기](https://school.programmers.co.kr/learn/courses/30/lessons/181847)) + 큰 수 문자열 비교([가장 큰 수](https://school.programmers.co.kr/learn/courses/30/lessons/42746), Lv2). 셋을 순서대로.
- 18115의 "역방향 되감기" 감각은 표 편집(81303)의 복구 파트가 가장 가깝다.

---

## 4주차 — 투 포인터 · 슬라이딩 윈도우 · 그리디

| 백준 | 문제 | 난이도 | 프로그래머스 대체 | Lv | 유사 |
|---|---|---|---|---|---|
| 2531 | 회전초밥 | 실1 | [할인 행사](https://school.programmers.co.kr/learn/courses/30/lessons/131127) | Lv2 | ◎ |
| 2559 | n일 연속 온도 합 | 실3 | [연속 부분 수열 합의 개수](https://school.programmers.co.kr/learn/courses/30/lessons/131701) | Lv2 | ○ |
| 1940 | 주몽 | 실4 | [구명보트](https://school.programmers.co.kr/learn/courses/30/lessons/42885) | Lv2 | ◎ |
| 11047 | 동전 개수 최소 | 실4 | [체육복](https://school.programmers.co.kr/learn/courses/30/lessons/42862) | Lv1 | △ |
| 14916 | 거스름돈 | 실5 | [체육복](https://school.programmers.co.kr/learn/courses/30/lessons/42862) | Lv1 | △ |
| 1758 | 알바생 강호 | 실4 | [예산](https://school.programmers.co.kr/learn/courses/30/lessons/12982) | Lv1 | ○ |
| 21921 | X일간 최대 방문자 | 실3 | [할인 행사](https://school.programmers.co.kr/learn/courses/30/lessons/131127) | Lv2 | ○ |
| 2141 | 우체국 | 골4 | [구명보트](https://school.programmers.co.kr/learn/courses/30/lessons/42885) | Lv2 | △ |
| 1343 | 폴리오미노 | 실5 | [예산](https://school.programmers.co.kr/learn/courses/30/lessons/12982) | Lv1 | △ |
| 2217 | 로프 | 실4 | [큰 수 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/42883) | Lv2 | △ |
| 13305 | 주유소 | 실3 | [조이스틱](https://school.programmers.co.kr/learn/courses/30/lessons/42860) | Lv2 | △ |
| 1541 | 최소가 되게 하는 +- | 실2 | [큰 수 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/42883) | Lv2 | ○ |

---

## 기말고사 (2024-05-17)

| 백준 | 문제 | 프로그래머스 대체 | Lv | 유사 |
|---|---|---|---|---|
| 72410 | 신규 아이디 (원래 PGS) | [신규 아이디 추천](https://school.programmers.co.kr/learn/courses/30/lessons/72410) | Lv1 | ◎ |
| 17276 | 이차원 배열 회전 | [행렬 테두리 회전하기](https://school.programmers.co.kr/learn/courses/30/lessons/77485) | Lv2 | ○ |
| 92335 | k진수 소수 (원래 PGS) | [k진수에서 소수 개수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/92335) | Lv2 | ◎ |
| 16165 | 걸그룹 이름/멤버 | [오픈채팅방](https://school.programmers.co.kr/learn/courses/30/lessons/42888) | Lv2 | ○ |

---

## 기존 매핑 교체 기록 (2026-08-20 반영 완료)

노션에 원래 들어 있던 링크 중 알고리즘이 어긋나던 7건을 재검토했다.
**6건은 아래 대안으로 교체 완료**(노션 DB + `java/mapping.csv` 동시 반영), 2141은 대체 문제가 없어 원래 링크를 유지했다.

| 백준 | 교체 전 | 문제점 | 교체 후 |
|---|---|---|---|
| 1620 포켓몬 도감 | 폰켓몬(1845) | **이름만 유사**. 1845는 "집합 크기 세기", 1620은 이름↔번호 양방향 Map 조회 | [오픈채팅방](https://school.programmers.co.kr/learn/courses/30/lessons/42888) Lv2 |
| 16165 걸그룹 | 전화번호 목록(42577) | 42577은 접두사 검사. 16165는 1620과 같은 양방향 조회 | 오픈채팅방(42888) |
| 19583 문자열 집합(중복 O) | 완주하지 못한 선수(42576) | 19583은 시각 파싱 + 상태 집계 | 오픈채팅방(42888) |
| 10799 쇠막대기 | 짝지어 제거하기(12973) | 3986과 링크가 **중복**. 쇠막대기는 괄호 파싱 + 누적 계산 | [괄호 변환](https://school.programmers.co.kr/learn/courses/30/lessons/60058) Lv2 |
| 1874 스택 수열 | 같은 숫자는 싫어(12906) | 12906은 중복 제거. 1874는 "가능/불가능 판정 시뮬레이션" | [카드 뭉치](https://school.programmers.co.kr/learn/courses/30/lessons/159994) Lv1 |
| 1758 알바생 강호 | 구명보트(42885) | 42885는 투 포인터. 1758은 정렬 후 누적 그리디 | [예산](https://school.programmers.co.kr/learn/courses/30/lessons/12982) Lv1 |
| 2141 우체국 | 구명보트(42885) | 가중치 중앙값 유형 — **프로그래머스에 대응 문제 없음** | **교체 안 함**(구명보트 유지, 개념 학습 권장) |

> 11047·14916(동전 그리디), 2217(로프), 13305(주유소)도 `△`다. 프로그래머스 그리디 문제군(체육복·큰 수 만들기·조이스틱·구명보트·예산)은 백준 그리디와 1:1 대응이 되지 않는다 — "그리디 감각 훈련"으로만 쓰고, 유형별 정답 대응을 기대하지 말 것.

---

## 커버리지 요약

- 총 53문제 중 프로그래머스 링크 **53건 확보** (기존 38 + 신규 15).
- 유사도 분포: ◎ 15 · ○ 28 · △ 10 (재검토 6건 교체 반영 후).
- 반영 위치: 노션 `콜럼버스 (1)상반 문제 목록` DB(공란 0/53) + `java/mapping.csv`.
- 대체 불가로 판정한 유형: 팩토리얼 뒤 0의 개수(2004), 가중치 중앙값(2141).
