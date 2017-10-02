package word_search_2;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by harper on 10/1/17.
 */
public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        List<String> result;

//        result = sol.findWords(new char[][]{
//                        new char[]{'o', 'a', 'a', 'n'},
//                        new char[]{'e', 't', 'a', 'e'},
//                        new char[]{'i', 'h', 'k', 'r'},
//                        new char[]{'i', 'f', 'l', 'v'}},
//                new String[]{"oath", "pea", "eat", "rain"});
//
//        assertEquals(2, result.size());
//        assertTrue(result.contains("oath"));
//        assertTrue(result.contains("eat"));
//
//        result = sol.findWords(new char[][]{
//                        new char[]{'b'},
//                        new char[]{'a'},
//                        new char[]{'b'},
//                        new char[]{'b'},
//                        new char[]{'a'}},
//                new String[]{"baa", "abba", "baab", "aba"});
//
//        assertEquals(1, result.size());
//        assertTrue(result.contains("abba"));

        result = sol.findWords(new char[][]{
                new char[]{'a', 'b'}, new char[]{'a', 'a'}
        }, new String[]{"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"});

        assertEquals(5, result.size());
    }
}
