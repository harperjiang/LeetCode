package verify_preorder_serialization_of_binary_tree;

public class Solution {

    int readTree(String input, int pointer) {
        if(pointer>=input.length()) {
            throw new IllegalStateException();
        }
        int p = pointer;
        int[] next = token(input, pointer);
        if (next[0] == -1) { // Empty
            return next[1];
        } else {
            p += next[1];
            int leftlength = readTree(input, p);
            p += leftlength;
            int rightlength = readTree(input, p);
            p += rightlength;
        }
        return p - pointer;
    }

    public boolean isValidSerialization(String preorder) {
        int pointer = 0;
        try {
            int length = readTree(preorder, 0);
            return length == preorder.length();
        } catch (Exception e) {
            return false;
        }
    }

    int[] NULL_TOKEN1 = new int[]{-1, 2};
    int[] NULL_TOKEN2 = new int[]{-1, 1};

    int[] token(String input, int pointer) {
        if (input.charAt(pointer) == '#') {
            return pointer == input.length() - 1 ? NULL_TOKEN2 : NULL_TOKEN1;
        }
        int sum = 0;
        int p = pointer;
        while (input.charAt(p) != ',') {
            sum *= 10;
            sum += (input.charAt(p++) - '0');
        }
        return new int[]{sum, p == input.length() ? p - pointer : p - pointer + 1};
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new Solution().isValidSerialization("1,#"));
        System.out.println(new Solution().isValidSerialization("9,#,#,1"));
    }
}
