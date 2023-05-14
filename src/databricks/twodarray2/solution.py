array = [[35, 17, 21, 36, 12], [22, 9, 8, 10, 7], [11, 65, 37, 22, 18]]

m = len(array)
n = len(array[0])

flatten = sorted([(j, i) for i in range(m) for j in array[i]])

limit = (m + 1) // 2

counter = [0] * m
start = 0
total = 0
mink = float('inf')
maxprod = -float('inf')

for i in range(len(flatten)):
    pair = flatten[i]
    counter[pair[1]] += 1
    total += (1 if counter[pair[1]] == limit else 0)
    while counter[flatten[start][1]] > limit:
        counter[flatten[start][1]] -= 1
        start += 1
    if total == m:
        currentk = pair[0] - flatten[start][0]
        if currentk < mink:
            mink = currentk
            currentprod = (i - start + 1) * mink
            maxprod = max(maxprod, currentprod)

print(maxprod)
