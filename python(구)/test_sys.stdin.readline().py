import sys

# #문자로 담김
# a = sys.stdin.readline()
# print('a :', a)
# print('a의 자료형 :', type(a))

# #rstrip 필요한지 테스트
# b = sys.stdin.readline()
# print('b 오른쪽 엔터 기호 확인 :', b)    #엔터 기호 없는데? 버전업글 되면서 바꼈나? => print함수 써서 안 보이는 거지
# b2 = sys.stdin.readline().rstrip()                                                #이스케이프 문자열로 \n 줄바꿈이 실행 된 것
# print('b2 rstrip로 없앰 :', b2)
# 리스트로 보니까 확실히 알겠어
# str = [sys.stdin.readline()]
# print('str 오른쪽 엔터 기호 확인 :', str)
# str2 = [sys.stdin.readline().rstrip()]
# print('str2 rstrip로 없앰 :', str2)
# #int로 변환하는 건 rstrip 필요 없네?
# c = int(sys.stdin.readline())
# print('c의 자료형 :', type(c)) #rstrip하지 않아도 그냥 사용 가능한 듯!

# #list로 받을 때는
# arr_str = sys.stdin.readline().split()
# print('arr_str :', arr_str)
# # 아!! 스플릿을 사용하니까 엔터가 스플릿에 사용되나봐.

# #int로 변환까지
# # arr_num = int(sys.stdin.readline().split()) 이거는 쪼개서 담은 리스트를 int로 바꾸겠다는 거니까 오류
# # map까지만 하면 <map object at 0x0000023ABE20E0E0> 이런 게 출력 돼
# arr_num = list(map(int,sys.stdin.readline().split()))
# print(arr_num)

# # 데이터가 줄바꿈으로 입력되면 - 그 때 strip() 사용\
# # 예) 데이터 개수 n개, 실제 데이터 n개가 줄바꿈으로 주어질 때
# n = int(sys.stdin.readline())
# # 숫자. 스트라잎 없이
# data1 = [sys.stdin.readline() for _ in range(n) ]
# print(data1)                                      #['1\n', '2\n', '3\n', '4\n']
# # 숫자. 스트라잎
# data2 = [sys.stdin.readline().strip() for _ in range(n) ]
# print(data2)                                      #['1', '2', '3', '4']
# # 문자. 스트라잎 없이
# data3 = [sys.stdin.readline() for _ in range(n) ]
# print(data3)                                      #['a\n', 'b\n', 'c\n', 'd\n']
# # 문자.  스트라잎
# data4 = [sys.stdin.readline().strip() for _ in range(n) ]
# print(data4)                                      #['a', 'b', 'c', 'd']

# # 즉, 숫자 뒤에 \n 붙은 건 int로 바꾸는 데 영향 안 미침 (그래서 숫자 입력 시엔 strip() 필요 없어)
# for i in data1:   #['1\n', '2\n', '3\n', '4\n']
#     print(type(i))
#     print(int(i))
# for문 안 돌리고 map으로 한번에 바꿀 수도 있음
# data5 = ['1\n', '2\n', '3\n', '4\n']
# data5_num = list(map(int, data5))
# print(data5_num)

# 결론
# 공백은 split(), 줄바꿈은 rstrip() 처리
# 1 문자
# 1-1 : 공백일 때 : split()
arr_str1 = sys.stdin.readline().split()                        # test is good
print('arr_str1 :', arr_str1)
# 1-2 : 줄바꿈일 때 : strip() (입력 개수도 같이 정해주겠지)
n = int(sys.stdin.readline())                                  # 3
arr_str2 = [sys.stdin.readline().rstrip() for _ in range(n)]   # test 엔터 is 엔터 good
print('arr_str2 :', arr_str2)
# 2 숫자
# 2-1 : 공백일 때 : split() -> map함수로 int 변환 -> 그걸 list로        # 가장 자주 사용될 상황
a,b,c = map(int,sys.stdin.readline().split())                  # 1 2 3
print(f'a : {a}, b : {b}, c : {c}')
arr_num1 = list(map(int,sys.stdin.readline().split()))         # 1 2 3 4
print('arr_num1 :', arr_num1)
# 2-2 : 줄바꿈일 때 : strip 안 써도 돼
#arr_num2 = list(map(int, sys.stdin.readline())) 하려 했는데 줄바꿈은 입력 개수 정해줘야 해
arr_num2 = list(map(int, [sys.stdin.readline() for _ in range(4)]))             # 1 엔터 2 엔터 3 엔터 4 엔터
print('arr_num2 :', arr_num2)

