# Coding Test Study Notes Generation Spec

## Overview

Generate study note markdown files for coding test preparation (Java + JavaScript).
All generated md files must be written in **Korean** (explanations and code comments).
Code examples use **Java 17** and **ES6+** respectively.

---

## Directory Structure

Create inside the existing `algorithm-study` repo:

```
algorithm-study/
├── java/                  ← (existing) Java coding test solutions
├── javascript/            ← (new) JS coding test solutions
└── study-notes/           ← (new) concept study notes
    ├── java/
    │   ├── 00-java-overview.md
    │   ├── 01-arraylist.md
    │   ├── 02-hashmap.md
    │   ├── 03-comparator.md
    │   └── 04-stream.md
    ├── javascript/
    │   ├── 00-javascript-overview.md
    │   ├── 01-array.md
    │   ├── 02-object-map.md
    │   ├── 03-sort-callback.md
    │   └── 04-higher-order-functions.md
    └── comparison/
        └── java-vs-javascript.md
```

---

## Execution Order

Process files **one at a time**, in this exact order:
1. Create folder structure (no files yet)
2. `00-java-overview.md`
3. `01-arraylist.md`
4. `02-hashmap.md`
5. `03-comparator.md`
6. `04-stream.md`
7. `00-javascript-overview.md`
8. `01-array.md`
9. `02-object-map.md`
10. `03-sort-callback.md`
11. `04-higher-order-functions.md`
12. `java-vs-javascript.md`

After completing each file, briefly confirm what was created, then move to the next.

---

## Global Rules (apply to ALL files)

- All explanations and code comments in **Korean**
- Every code example must be **complete and runnable**
- Exclude methods rarely used in coding tests
- Each file starts with a **one-line purpose summary**
- Code examples include **input values and expected output as comments**
- Each pattern includes three sections:
  - "언제 쓰는가" (when to use — coding test context)
  - "실무에서는" (real-world usage — practical dev context)
  - Runnable code example

---

## Step 2-0: `study-notes/java/00-java-overview.md`

### Section 1: Java Collections Framework & Stream API — Full Hierarchy

Show as a tree with one-line descriptions per layer:

```
Java Collections Framework & Stream API
│
├── Iterable (interface) — enables enhanced for-loop
│   └── Collection (interface) — common blueprint for data groups
│       ├── List (interface) — ordered, duplicates allowed
│       │   └── ArrayList (class) — array-based implementation
│       └── Set / Queue ... (out of scope, mention existence only)
│
├── Map (interface) — separate from Collection hierarchy, Key-Value pairs
│   └── HashMap (class) — hash table implementation
│
├── Comparator (interface) — functional interface defining sort criteria
│
├── Functional Interfaces (java.util.function)
│   ├── Predicate<T>    — T → boolean
│   ├── Function<T, R>  — T → R
│   ├── Consumer<T>     — T → void
│   ├── Supplier<T>     — () → T
│   └── Comparator (in java.util, but also functional)
│
├── Iterator (interface) — collection traversal mechanism
│   └── hasNext() / next() / remove()
│
└── Stream API (java.util.stream, Java 8+)
    └── collection.stream()
        ├── Intermediate: filter / map / sorted / distinct / limit ...
        └── Terminal: collect / forEach / count / findFirst / reduce ...
```

### Section 2: Interface Classification by Role

Re-classify the hierarchy by role:
- Data structure blueprints: Iterable → Collection → List / Set / Queue, Map
- Behavior blueprints (functional interfaces): Comparator, Predicate, Function, Consumer, Supplier
- Traversal mechanism: Iterator, relationship with Iterable
- Processing pipeline: Stream API

### Section 3: Historical Context — Java 8 Before vs After

Explain why Java 8 matters from a **coding test + practical dev** perspective:

- **Before Java 8**: anonymous classes for Comparator, external iteration (for-loops)
- **What Java 8 added**:
  - Lambda expressions — why needed (anonymous class boilerplate problem)
  - Functional interfaces (Predicate, Function, etc.) — why standardized
  - Stream API — why needed (external → internal iteration, declarative processing)
  - Default methods — how `stream()` was added to existing Collection interface
  - Optional — improved null handling
- **3 side-by-side before/after code comparisons**:
  1. List sorting (anonymous class vs lambda)
  2. List filtering (for-loop vs Stream)
  3. Map value update (if-else vs getOrDefault/merge)

### Section 4: Iterator Deep Dive

- Iterator interface methods: hasNext(), next(), remove()
- Relationship with Iterable: implementing Iterable enables enhanced for-loop
- Show how enhanced for-loop internally uses Iterator (code example)
- ConcurrentModificationException: why it happens when modifying during iteration, and solutions
- Coding test relevance: rarely use Iterator directly, but explains "why does remove inside for-each throw an error"

### Section 5: Functional Interfaces Deep Dive

- @FunctionalInterface annotation meaning
- Core 4: Predicate, Function, Consumer, Supplier
  - Each: abstract method, purpose, where used in Stream API
  - e.g., Predicate → stream.filter() argument, Function → stream.map() argument
- Why Comparator is a functional interface (1 abstract method: compare)
- Practical usage: one-line real-world scenario per functional interface

---

## Step 2-1: `study-notes/java/01-arraylist.md`

**Top**: one-line summary + position in hierarchy (`Iterable → Collection → List → ArrayList`)

### Core Methods
add, remove, get, set, size, subList, sort, indexOf, contains, isEmpty

### Patterns (each with code + "언제 쓰는가" + "실무에서는")

1. **Stack-like usage**: add / get(size()-1) for dedup
   - When: compare current with previous value
   - Practical: Undo/Redo, browser back button

2. **subList for sub-array extraction**
   - When: slice a range for sorting/processing
   - Practical: pagination, batch processing

3. **contains/indexOf for order-based condition check**
   - When: need existence check + position
   - Practical: search result positioning, whitelist check

4. **Nested loop for pairwise comparison**
   - When: must compare all pairs (O(n²) acceptable)
   - Practical: duplicate detection, similarity comparison

### Gotchas
- subList returns a view (not a copy) — original changes affect it
- remove(int index) vs remove(Object o) confusion
- ArrayList vs LinkedList selection criteria (one line)

---

## Step 2-2: `study-notes/java/02-hashmap.md`

**Top**: one-line summary + position (`Map (interface) → HashMap (class)`, separate from Collection)

### Core Methods
put, get, getOrDefault, merge, containsKey, containsValue, keySet, values, entrySet, size, isEmpty, remove

### Patterns (each with code + "언제 쓰는가" + "실무에서는")

1. **Frequency counting (getOrDefault vs merge)**
   - Show both approaches side-by-side with explanation
   - When: count occurrences of each element
   - Practical: log analysis (error code frequency), vote tallying, cart item quantities

2. **keySet/Set size for unique count**
   - When: need number of distinct types
   - Practical: unique user count, category enumeration

3. **containsKey + startsWith for prefix check**
   - When: check if one string is a prefix of another
   - Practical: phone number autocomplete, URL route matching

4. **entrySet iteration + combinatorics**
   - When: classify into groups then calculate combinations
   - Practical: product option combos, A/B test group assignment

### Gotchas
- HashMap has no order guarantee (use LinkedHashMap if needed)
- Key's equals/hashCode relationship
- null key allowed (one only), null values allowed

---

## Step 2-3: `study-notes/java/03-comparator.md`

**Top**: one-line summary + position (functional interface, independent of collection hierarchy, connects via `list.sort(comparator)`)

### Comparable vs Comparator
- Comparable: default sort built into the object (compareTo)
- Comparator: external sort criteria injection (compare)
- Why Comparator is used far more in coding tests — explain

### Core Methods
compare, comparingInt, comparingLong, comparing, thenComparing, reversed, lambda syntax

### Patterns (each with code + "언제 쓰는가" + "실무에서는")

1. **Basic ascending/descending**
   - When: simple sorting
   - Practical: search result ordering, chronological sort

2. **Lambda custom sort by string concatenation**
   - "Largest number" problem pattern
   - When: default sort criteria insufficient
   - Practical: version number sorting, natural filename sorting

3. **reversed() descending + index condition search**
   - When: check conditions starting from largest value
   - Practical: top-N extraction, ranking system

4. **thenComparing for multi-level sort**
   - When: need secondary sort when primary keys are equal
   - Practical: post sorting (likes → recency), grade report (total → name)

### Gotchas
- sort() modifies original (in-place)
- comparingInt vs raw lambda — readability difference
- Stable sort: elements with equal keys preserve original order

---

## Step 2-4: `study-notes/java/04-stream.md`

**Top**: one-line summary + position (`collection.stream()` → intermediate → terminal)

### Stream Characteristics
- Does not modify original
- Single-use (cannot reuse after terminal operation)
- Lazy evaluation: intermediate ops don't execute until terminal op is called

### Core Methods
- Intermediate: filter, map, sorted, distinct, limit, flatMap
- Terminal: collect, forEach, count, findFirst, reduce, toList()
- `collect(Collectors.toList())` vs `toList()` difference (Java 16+)

### Patterns (each with code + "언제 쓰는가" + "실무에서는")

1. **sorted + distinct + collect pipeline**
   - When: need deduplicated, sorted result
   - Practical: tag list cleanup, deduplicated search suggestions

2. **filter for conditional filtering**
   - When: extract only matching elements
   - Practical: active user filtering, order status filtering

3. **map transform + collect**
   - When: convert elements to different form into new list
   - Practical: Entity → DTO conversion, response object mapping

4. **reduce for accumulation**
   - When: combine all elements into single result
   - Practical: total revenue sum, min/max calculation

### Gotchas
- Stream is a processing pipeline, not a data store
- for-loop vs Stream performance: negligible difference in coding tests
- Debugging tip: peek() to inspect intermediate results

---

## Step 3-0: `study-notes/javascript/00-javascript-overview.md`

### Section 1: JavaScript Data Processing Tools — Full Structure

Show as a tree (role-based, not class hierarchy):

```
JavaScript Data Processing Tools
│
├── Array — serves as both ArrayList AND Stream from Java
│   ├── Data storage/manipulation: push, pop, splice, slice, indexOf, includes ...
│   ├── Sorting: sort(callback) — callback serves as Java Comparator
│   └── Higher-order functions: filter, map, reduce, find, some, every ... — serves as Java Stream
│
├── Object — Key-Value storage similar to Java HashMap (simple version)
│   └── Object.keys / values / entries, obj[key] access
│
├── Map — closer to Java HashMap (order guaranteed, any key type)
│   └── set, get, has, size, entries
│
├── Set — corresponds to Java HashSet (deduplication)
│   └── add, has, size, delete
│
└── Promise / async-await — async processing (JS-specific, no Java equivalent)
    └── May appear in coding tests as async callback patterns
```

### Section 2: Core Structural Differences from Java
- Java: strict interface hierarchy (Collection → List → ArrayList)
- JS: Array handles almost everything, prototype-based
- Java: Stream is a separate API from collections
- JS: Array methods themselves serve as Stream (chainable)

### Section 3: Historical Context — ES5 → ES6(ES2015) and Beyond

Explain why ES6 matters, parallel to Java 8:

- **Before ES5**: only var, callback hell, function declarations only
- **ES6 (2015) additions**:
  - let/const — why needed (var hoisting/scope issues)
  - Arrow functions — why needed (this binding problem + concise callbacks)
  - Map/Set — why needed (Object limitation: keys are strings only)
  - Promise — why needed (callback hell resolution)
  - Destructuring, spread operator, template literals
- **ES2017**: async/await — improved Promise chaining readability
- **3 side-by-side before/after code comparisons**:
  1. Callback functions (function vs arrow function)
  2. Iteration (for-loop vs forEach/map)
  3. Async (callback hell vs Promise vs async/await)

### Section 4: Async Basics (potential coding test topic)
- What is a callback function
- Promise 3 states: pending, fulfilled, rejected
- Basic async/await pattern
- Promise.all / Promise.race
- 1-2 async pattern examples that could appear in coding tests

---

## Step 3-1: `study-notes/javascript/01-array.md`

**Top**: one-line summary ("Array handles both data storage + processing in JS — serves as Java's ArrayList + Stream") + position

### Core Methods
push, pop, shift, unshift, splice, slice, includes, indexOf, join, length, concat, fill

### Patterns (each with code + "언제 쓰는가" + "실무에서는")

1. **push/pop as stack**
   - When: bracket validation, compare with previous value
   - Practical: Undo/Redo, navigation history

2. **slice for sub-array (preserves original)**
   - When: extract portion without modifying original
   - Practical: pagination, infinite scroll data slicing

3. **indexOf + splice to find and remove**
   - When: find specific value and remove it
   - Practical: cart item removal, tag deletion

4. **2D array index traversal**
   - When: matrix/grid data
   - Practical: spreadsheet data processing, game board

### Gotchas
- splice mutates original, slice does not — must distinguish
- Modifying length directly truncates the array
- Empty array comparison: `[] === []` is false (reference comparison)

---

## Step 3-2: `study-notes/javascript/02-object-map.md`

**Top**: one-line summary + position

### Object vs Map Comparison Table

| Aspect | Object | Map |
|---|---|---|
| Key types | string/Symbol only | any type |
| Order | partial | insertion order guaranteed |
| Size check | Object.keys().length | map.size |
| Coding test use | primarily for frequency counting | when key type matters |

### Object Core Methods
obj[key], Object.keys, Object.values, Object.entries, delete, hasOwnProperty, in operator

### Map Core Methods
set, get, has, size, delete, entries, forEach

### Also Cover Set
- add, has, size, delete
- Array → Set → Array pattern: `[...new Set(arr)]`

### Patterns (each with code + "언제 쓰는가" + "실무에서는")

1. **Object frequency counting** — `obj[key] = (obj[key] || 0) + 1`
   - When: count occurrences per element
   - Practical: log aggregation, vote counting

2. **Set for dedup + size**
   - When: need count of unique types
   - Practical: unique visitors, tag dedup

3. **Object key lookup for prefix check**
   - When: check if string is prefix of another
   - Practical: autocomplete, URL matching

4. **entries iteration + combinatorics**
   - When: group classification then calculate combos
   - Practical: product option combos, filter combinations

---

## Step 3-3: `study-notes/javascript/03-sort-callback.md`

**Top**: one-line summary + position

### sort() Default Behavior — THE TRAP (critical)
- `[10, 9, 1, 2].sort()` → `[1, 10, 2, 9]` (string-based sort!)
- Must provide callback for correct numeric sorting
- Not knowing this = wrong answers in coding tests

### Core Patterns
- `(a, b) => a - b`: ascending
- `(a, b) => b - a`: descending
- `(a, b) => a.localeCompare(b)`: string sort

### Patterns (each with code + "언제 쓰는가" + "실무에서는")

1. **Basic ascending/descending**
   - When: simple sort
   - Practical: price sort, date sort

2. **String concatenation custom sort**
   - "Largest number" pattern: `(a,b) => (b+a) - (a+b)`
   - When: special criteria beyond default sort
   - Practical: version number sorting

3. **Descending + index condition search**
   - When: check conditions from largest
   - Practical: top-N extraction

4. **Multi-level sort**
   - `(a, b) => a.score - b.score || a.name.localeCompare(b.name)`
   - When: need secondary sort when primary keys are equal
   - Practical: multi-column table sort

### Gotchas
- sort() mutates original — use `[...arr].sort()` to preserve
- Stable sort: guaranteed since ES2019 (varied by browser before)
- toSorted() (ES2023): non-mutating sort — modern environments only

---

## Step 3-4: `study-notes/javascript/04-higher-order-functions.md`

**Top**: one-line summary ("JS higher-order functions serve the same role as Java Stream API") + position

### Key Differences from Java Stream
- JS: methods attached directly to Array (no separate stream() entry)
- JS: chaining result is directly an array (no collect needed)
- JS: arrays are reusable (Java Stream is single-use)

### Core Methods
filter, map, reduce, find, findIndex, some, every, flat, flatMap, forEach

### Patterns (each with code + "언제 쓰는가" + "실무에서는")

1. **filter for conditional filtering**
   - When: extract matching elements
   - Practical: search filters, permission-based menu display

2. **map for transformation**
   - When: convert elements to different form
   - Practical: API response → UI component data

3. **reduce for accumulation** (sum, object building, grouping)
   - When: combine array into single value
   - Practical: cart total, statistics aggregation

4. **find/findIndex for search**
   - When: need first matching element
   - Practical: find user by specific ID

5. **some/every for condition check**
   - When: "any match?" vs "all match?"
   - Practical: form validation, select-all checkbox state

6. **Method chaining** — `arr.filter().map().reduce()`
   - Show composite example side-by-side with Java Stream pipeline
   - Practical: data transformation pipelines

### Gotchas
- forEach returns undefined — cannot chain
- Forgetting return in map creates array of undefined
- Omitting reduce initial value: first element becomes initial — empty array throws error

---

## Step 4: `study-notes/comparison/java-vs-javascript.md`

### Section 1: Correspondence Table

| Java | JavaScript | Role |
|---|---|---|
| ArrayList | Array | ordered dynamic array |
| HashMap | Object / Map | Key-Value storage |
| Comparator | sort callback | sort criteria definition |
| Stream | higher-order functions | array processing pipeline |
| HashSet | Set | deduplication |
| Iterator | for...of / Symbol.iterator | traversal mechanism |
| Optional | ?. / ?? / undefined check | null-safe handling |

### Section 2: Key Differences (common coding test mistakes)
- JS Array = ArrayList + Stream (one does both roles)
- JS sort() defaults to string comparison (Java uses Comparable)
- Java needs collect() vs JS returns array directly
- Java Stream is single-use vs JS arrays are reusable
- Java requires type declarations vs JS is dynamically typed

### Section 3: Same Problem, Two Languages — Side-by-Side Code
3 patterns with Java code and JS code shown side by side:
1. **Frequency counting**: HashMap getOrDefault vs Object[key] pattern
2. **Custom sort**: Comparator lambda vs sort callback
3. **Filter + transform pipeline**: Stream filter/map/collect vs filter/map chaining

### Section 4: Practical Perspective
- Java: type safety, advantages in large-scale services
- JS: prototyping speed, advantages in full-stack
- Why knowing both is a strength (backend + frontend communication)
