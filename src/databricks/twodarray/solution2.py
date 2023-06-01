import heapq

arr = [[61, 90, 60], [59, 61], [58, 62, 92]]

arr, res, n = list(map(sorted, arr)), float('inf'), len(arr)
l = [(arr[i][0], i, 0) for i in range(n)]
h = max(arr[i][0] for i in range(n))
heapq.heapify(l)

while True:

    val, r, c = heapq.heappop(l)
    res = min(res, h - val)
    if c + 1 == len(arr[r]):
        break
    heapq.heappush(l, (arr[r][c + 1], r, c + 1))
    h = max(h, arr[r][c + 1])

print(res)
