package remove_k_digits;

public class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()) {
            return "0";
        }

        StringBuffer buffer = new StringBuffer();

        buffer.append((char)num.charAt(0));
        int counter = 0;

        for(int j = 1 ; j < num.length(); j++) {
            char current = num.charAt(j);
            while(counter <k && buffer.length()>0 && current< buffer.charAt(buffer.length()-1)) {
                buffer.deleteCharAt(buffer.length()-1);
                counter++;
            }
            buffer.append((char)current);
        }

        if(counter < k) {
            buffer.delete(buffer.length() - (k-counter), buffer.length());
        }

        while(buffer.length()>0 && buffer.charAt(0) == '0') {
            buffer.deleteCharAt(0);
        }
        if(buffer.length()==0) {
            return "0";
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().removeKdigits("1234567890",9));
        System.out.println(new Solution().removeKdigits("10001",4));
    }
}
