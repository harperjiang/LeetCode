arr=[[61,90,60], [59,61],[58,62,92]]
n=len(arr)
arr=sorted((j,i) for i in range(n) for j in arr[i])
ct, tot, res, i=[0]*n, 0, float('inf'),0

for val,r in arr:

    tot+=not ct[r]
    ct[r]+=1

    while ct[arr[i][1]]>1:
        ct[arr[i][1]]-=1
        i+=1

    if tot==n:
        res=min(res,val-arr[i][0])

print(res)