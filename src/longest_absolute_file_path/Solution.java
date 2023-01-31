package longest_absolute_file_path;

import java.util.Stack;

public class Solution {

    int maxlength = 0;
    int length = 0;
    Stack<Integer> tracker = new Stack<>();
    int depth = 0;
    StringBuilder token = new StringBuilder();
    boolean isDir = true;

    void process() {
        if (token.length() >= 4 && token.subSequence(0, 4) == "    ") {
            int flex = 0;
            int pointer = 0;
            while (token.length() >= pointer + 4 && token.subSequence(pointer, pointer + 4) == "    ") {
                flex++;
                pointer += 4;
            }
            int maxlength = -1;
            int midx = 0;
            int runlength = 0;
            for (int i = 0; i < depth; i++) {
                runlength += tracker.elementAt(i);
            }
            for (int i = depth; i < Math.min(flex + depth, tracker.size()); i++) {
                if (runlength + (flex + depth - i) * 4 > maxlength) {
                    maxlength = runlength + (flex + depth - i) * 4;
                    midx = i;
                }
                runlength += tracker.elementAt(i);
            }
            depth = midx;
        }
        while (tracker.size() > depth) {
            length -= tracker.pop();
        }
        if (!isDir) {
            length += token.length();
            if (length > maxlength) maxlength = length;
            length -= token.length();
        } else {
            length += token.length() + 1;
            tracker.push(token.length() + 1);
        }
        isDir = true;
        depth = 0;
        token.delete(0, token.length());
    }

    public int lengthLongestPath(String input) {
        for (int c : input.toCharArray()) {
            switch (c) {
                case '\n':
                    process();
                    break;
                case '\t':
                    depth++;
                    break;
                case '.':
                    isDir = false;
                    token.append('.');
                    break;
                default:
                    token.append((char) c);
                    break;
            }
        }
        process();
        return maxlength;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().lengthLongestPath("a\n\tb\n\t\tc.txt\n\taaaa.txt"));
        System.out.println(new Solution().lengthLongestPath("dir\n        a.tt"));
//        System.out.println(new Solution().lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
    }
}
