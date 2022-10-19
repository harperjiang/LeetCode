package text_justification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harper on 10/14/17.
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        List<String> buffer = new ArrayList<>();
        int lineWidth = 0;
        for (String word : words) {
            if (lineWidth + (buffer.isEmpty() ? word.length() : (word.length() + 1)) > maxWidth) {
                // Dispatch the line
                result.add(formLine(buffer, maxWidth - lineWidth, false));
                buffer.clear();
                lineWidth = 0;
            }
            if (lineWidth == 0) {
                lineWidth += word.length();
            } else {
                lineWidth += word.length() + 1;
            }
            buffer.add(word);
        }

        result.add(formLine(buffer, maxWidth - lineWidth, true));

        return result;
    }

    protected String formLine(List<String> buffer, int extraSpace, boolean last) {
        int slots = buffer.size() - 1;
        StringBuilder sb = new StringBuilder();
        if (slots == 0) {
            sb.append(buffer.get(0));
            for (int idx = 0; idx < extraSpace; idx++)
                sb.append(" ");
        } else {
            int split = extraSpace % slots;
            if (!last) {
                for (int i = 0; i < buffer.size(); i++) {
                    sb.append(buffer.get(i));
                    if (i != buffer.size() - 1) {
                        int numspace = (extraSpace / slots) + (i < split ? 2 : 1);
                        for (int idx = 0; idx < numspace; idx++)
                            sb.append(" ");
                    }
                }
            } else {
                for (int i = 0; i < buffer.size(); i++) {
                    sb.append(buffer.get(i));
                    if (i != buffer.size() - 1) {
                        sb.append(" ");
                    }
                }
                for (int idx = 0; idx < extraSpace; idx++) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
