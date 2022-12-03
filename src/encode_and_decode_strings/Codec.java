package encode_and_decode_strings;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            builder.append((char) s.length());
            builder.append(s);
        }
        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        if (s != null && s.length() > 0) {
            int pointer = 0;
            while (pointer < s.length()) {
                int length = s.charAt(pointer);
                result.add(s.substring(pointer + 1, pointer + 1 + length));
                pointer += 1 + length;
            }
        }
        return result;
    }
}
