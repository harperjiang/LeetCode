
class Solution:
    def search(self, full: str, n: int, pos: int, trace, result):
        if pos >= n:
            result.append([x for x in trace])
            return
        for i in range(pos+1, n+1):
            if full[pos: i] == full[2*n+1-i:2*n+1-pos]:
                trace.append(full[pos:i])
                self.search(full,n,i,trace,result)
                del trace[-1]

    def partition(self, s: str):
        full = s + '#' + s[::-1]
        n = len(s)
        result = []
        self.search(full, n, 0, [], result)

        return result

Solution().partition("aab")

