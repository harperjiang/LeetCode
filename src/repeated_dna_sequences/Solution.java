package repeated_dna_sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    int encode(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'T':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            default:
                throw new IllegalArgumentException();
        }
    }

    String decode(int num) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int res = (num >> (i * 2)) & 0x3;
            switch (res) {
                case 0:
                    buffer.append('A');
                    break;
                case 1:
                    buffer.append('T');
                    break;
                case 2:
                    buffer.append('C');
                    break;
                case 3:
                    buffer.append('G');
                    break;
            }
        }
        return buffer.toString();
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> exists = new HashSet<>();

        int first = 0;
        for (int i = 0; i < 10; ++i) {
            first <<= 2;
            first += encode(s.charAt(i));
        }
        exists.add(first);

        int slide = first;

        Set<String> result = new HashSet<>();
        for (int i = 10; i < s.length(); ++i) {
            int next = encode(s.charAt(i));
            slide <<= 2;
            slide += next;
            slide &= 0xFFFFF;
            if (exists.contains(slide)) {
                result.add(s.substring(i-9,i+1));
            } else {
                exists.add(slide);
            }
        }
        return new ArrayList<>(result);
    }
}
