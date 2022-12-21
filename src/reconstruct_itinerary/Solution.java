package reconstruct_itinerary;

import java.util.*;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Integer> portIndex = new HashMap<>();
        List<String> portNames = new ArrayList<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!portIndex.containsKey(from)) {
                portIndex.put(from, portIndex.size());
                portNames.add(from);
            }
            if (!portIndex.containsKey(to)) {
                portIndex.put(to, portIndex.size());
                portNames.add(to);
            }
        }
        Collections.sort(portNames);
        for (int i = 0; i < portNames.size(); i++) {
            portIndex.put(portNames.get(i), i);
        }

        int[][] adjmatrix = new int[portNames.size()][portNames.size()];
        int[] indegrees = new int[portNames.size()];
        int[] outdegrees = new int[portNames.size()];

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            int fromIndex = portIndex.get(from);
            int toIndex = portIndex.get(to);
            adjmatrix[fromIndex][toIndex]++;
            outdegrees[fromIndex]++;
            indegrees[toIndex]++;
        }

        buffer = new ArrayList<>();
        int pointer = portIndex.get("JFK");
        buffer.add(pointer);
        dfs(adjmatrix, indegrees, outdegrees, pointer);
        List<String> ports = new ArrayList<>();
        for (int r : result) {
            ports.add(portNames.get(r));
        }
        return ports;
    }

    boolean done;

    List<Integer> buffer = new ArrayList<>();
    List<Integer> result;
    void dfs(int[][] adjmatrix, int[] indegrees, int[] outdegrees, int pointer) {
        if (done) {
            return;
        }
        if (outdegrees[pointer] == 0) {
            // if all edges are used up
            int sum = 0;
            for (int i = 0; i < indegrees.length; i++) {
                sum += indegrees[i];
                sum += outdegrees[i];
            }
            done = (sum == 0);
            if(done) {
                result = List.copyOf(buffer);
            }
            return;
        }
        for (int i = 0; i < adjmatrix.length; i++) {
            if(done)
                break;
            if (adjmatrix[pointer][i] > 0) {
                int e = i;
                adjmatrix[pointer][i]--;
                outdegrees[pointer]--;
                indegrees[e]--;
                buffer.add(e);
                dfs(adjmatrix, indegrees, outdegrees, e);
                buffer.remove(buffer.size() - 1);
                adjmatrix[pointer][i]++;
                outdegrees[pointer]++;
                indegrees[e]++;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().findItinerary(List.of(List.of("MUC", "LHR"), List.of("JFK", "MUC"),
//                List.of("SFO", "SJC"), List.of("LHR", "SFO"))));
//        System.out.println(new Solution().findItinerary(List.of(List.of("JFK", "SFO"), List.of("JFK", "ATL"),
//                List.of("SFO", "ATL"), List.of("ATL", "JFK"), List.of("ATL", "SFO"))));
//        System.out.println(new Solution().findItinerary(List.of(List.of("JFK", "ATL"), List.of("ATL", "JFK"))));
//        System.out.println(new Solution().findItinerary(List.of(List.of("JFK", "KUL"), List.of("JFK", "NRT"),
//                List.of("NRT", "JFK"))));
//        System.out.println(new Solution().findItinerary(List.of(List.of("EZE", "AXA"), List.of("TIA", "ANU"),
//                List.of("ANU", "JFK"), List.of("JFK", "ANU"), List.of("ANU", "EZE"), List.of("TIA", "ANU"),
//                List.of("AXA", "TIA"), List.of("TIA", "JFK"), List.of("ANU", "TIA"), List.of("JFK", "TIA"))));
        System.out.println(new Solution().findItinerary(List.of(List.of("AXA", "EZE"), List.of("EZE", "AUA"),
                List.of("ADL", "JFK"), List.of("ADL", "TIA"), List.of("AUA", "AXA"), List.of("EZE", "TIA"),
                List.of("EZE", "TIA"), List.of("AXA", "EZE"), List.of("EZE", "ADL"), List.of("ANU", "EZE"),
                List.of("TIA", "EZE"), List.of("JFK", "ADL"), List.of("AUA", "JFK"), List.of("JFK", "EZE"),
                List.of("EZE", "ANU"), List.of("ADL", "AUA"), List.of("ANU", "AXA"), List.of("AXA", "ADL"),
                List.of("AUA", "JFK"), List.of("EZE", "ADL"), List.of("ANU", "TIA"), List.of("AUA", "JFK"),
                List.of("TIA", "JFK"), List.of("EZE", "AUA"), List.of("AXA", "EZE"), List.of("AUA", "ANU"),
                List.of("ADL", "AXA"), List.of("EZE", "ADL"), List.of("AUA", "ANU"), List.of("AXA", "EZE"),
                List.of("TIA", "AUA"), List.of("AXA", "EZE"), List.of("AUA", "SYD"), List.of("ADL", "JFK"),
                List.of("EZE", "AUA"), List.of("ADL", "ANU"), List.of("AUA", "TIA"), List.of("ADL", "EZE"),
                List.of("TIA", "JFK"), List.of("AXA", "ANU"), List.of("JFK", "AXA"), List.of("JFK", "ADL"),
                List.of("ADL", "EZE"), List.of("AXA", "TIA"), List.of("JFK", "AUA"), List.of("ADL", "EZE"),
                List.of("JFK", "ADL"), List.of("ADL", "AXA"), List.of("TIA", "AUA"), List.of("AXA", "JFK"),
                List.of("ADL", "AUA"), List.of("TIA", "JFK"), List.of("JFK", "ADL"), List.of("JFK", "ADL"),
                List.of("ANU", "AXA"), List.of("TIA", "AXA"), List.of("EZE", "JFK"), List.of("EZE", "AXA"),
                List.of("ADL", "TIA"), List.of("JFK", "AUA"), List.of("TIA", "EZE"), List.of("EZE", "ADL"),
                List.of("JFK", "ANU"), List.of("TIA", "AUA"), List.of("EZE", "ADL"), List.of("ADL", "JFK"),
                List.of("ANU", "AXA"), List.of("AUA", "AXA"), List.of("ANU", "EZE"), List.of("ADL", "AXA"),
                List.of("ANU", "AXA"), List.of("TIA", "ADL"), List.of("JFK", "ADL"), List.of("JFK", "TIA"),
                List.of("AUA", "ADL"), List.of("AUA", "TIA"), List.of("TIA", "JFK"), List.of("EZE", "JFK"),
                List.of("AUA", "ADL"), List.of("ADL", "AUA"), List.of("EZE", "ANU"), List.of("ADL", "ANU"),
                List.of("AUA", "AXA"), List.of("AXA", "TIA"), List.of("AXA", "TIA"), List.of("ADL", "AXA"),
                List.of("EZE", "AXA"), List.of("AXA", "JFK"), List.of("JFK", "AUA"), List.of("ANU", "ADL"),
                List.of("AXA", "TIA"), List.of("ANU", "AUA"), List.of("JFK", "EZE"), List.of("AXA", "ADL"),
                List.of("TIA", "EZE"), List.of("JFK", "AXA"), List.of("AXA", "ADL"), List.of("EZE", "AUA"),
                List.of("AXA", "ANU"), List.of("ADL", "EZE"), List.of("AUA", "EZE")
        )));
    }

}
