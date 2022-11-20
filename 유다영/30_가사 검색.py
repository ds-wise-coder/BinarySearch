# https://school.programmers.co.kr/learn/courses/30/lessons/60060
# from bisect import bisect_left, bisect_right
#
#
# # 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
# def count_by_range(a, left_value, right_value):
#     right_index = bisect_right(a, right_value)
#     left_index = bisect_left(a, left_value)
#     return right_index - left_index
#
#
# # 모든 단어들을 길이마다 나누어서 저장하기 위한 리스트
# array = [[] for _ in range(10001)]
# # 모든 단어들을 길이마다 나누어서 뒤집어 저장하기 위한 리스트
# reversed_array = [[] for _ in range(10001)]
#
#
# def solution(words, queries):
#     answer = []
#     for word in words:  # 모든 단어를 접미사 와일드카드 배열, 접두사 와일드카드 배열에 각각 삽입
#         array[len(word)].append(word)  # 단어를 삽입
#         reversed_array[len(word)].append(word[::-1])  # 단어를 뒤집어서 삽입
#
#     for i in range(10001):  # 이진 탐색을 수행하기 위해 각 단어 리스트 정렬 수행
#         array[i].sort()
#         reversed_array[i].sort()
#
#     for q in queries:  # 쿼리를 하나씩 확인하며 처리
#         if q[0] != '?':  # 접미사에 와일드 카드가 붙은 경우
#             res = count_by_range(array[len(q)], q.replace('?', 'a'), q.replace('?', 'z'))
#         else:  # 접두사에 와일드 카드가 붙은 경우
#             res = count_by_range(reversed_array[len(q)], q[::-1].replace('?', 'a'), q[::-1].replace('?', 'z'))
#         # 검색된 단어의 개수를 저장
#         answer.append(res)
#     return answer

# 유튜브 해설 강의 풀이-Trie 자료구조 이용
class Trie:
    def __init__(self):
        self.child = dict()  # 문자: key, cnt: value
        self.count = 0

    def insert(self, str):
        curr = self
        for ch in str:
            curr.count += 1  # count 증가
            if ch not in curr.child:
                curr.child[ch] = Trie()
            curr = curr.child[ch]
        # leaf node
        curr.count += 1  # count 증가

    def search(self, str):
        curr = self
        for ch in str:
            if ch == '?':
                return curr.count
            if ch not in curr.child:
                return 0
            curr = curr.child[ch]
        return curr.count


def solution(words, queries):
    TrieRoot = [Trie() for _ in range(10000)]
    # ?로 시작하는경우 단어 뒤집기
    ReTrieRoot = [Trie() for _ in range(10000)]
    answer = []

    for str in words:
        TrieRoot[len(str) - 1].insert(str)  # 0~9999
        ReTrieRoot[len(str) - 1].insert(str[::-1])  # 문자열 뒤집어서 insert
    # search
    for str in queries:
        if str[0] != '?':
            answer.append(TrieRoot[len(str) - 1].search(str))
        else:  # 뒤집어서 처리 해야함.
            answer.append(ReTrieRoot[len(str) - 1].search(str[::-1]))
    return answer
