package reconstruct_itinerary;

import java.util.*;

public class HierholzerSolution {
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


        result = new LinkedList<>();
        int pointer = portIndex.get("JFK");
        dfs(adjmatrix, indegrees, outdegrees, pointer);
        List<String> ports = new ArrayList<>();
        for (int r : result) {
            ports.add(portNames.get(r));
        }
        return ports;
    }

    List<Integer> result;

    void dfs(int[][] adjmatrix, int[] indegrees, int[] outdegrees, int pointer) {
        for (int i = 0; i < adjmatrix.length; i++) {
            while (adjmatrix[pointer][i] > 0) {
                int e = i;
                adjmatrix[pointer][i]--;
                outdegrees[pointer]--;
                indegrees[e]--;
                dfs(adjmatrix, indegrees, outdegrees, e);
            }
        }
        result.add(0, pointer);
    }

    public static void main(String[] args) {
                System.out.println(new HierholzerSolution().findItinerary(List.of(List.of("MUC", "LHR"), List.of("JFK", "MUC"),
                List.of("SFO", "SJC"), List.of("LHR", "SFO"))));
        System.out.println(new HierholzerSolution().findItinerary(List.of(List.of("JFK", "SFO"), List.of("JFK", "ATL"),
                List.of("SFO", "ATL"), List.of("ATL", "JFK"), List.of("ATL", "SFO"))));
        System.out.println(new HierholzerSolution().findItinerary(List.of(List.of("JFK", "ATL"), List.of("ATL", "JFK"))));
        System.out.println(new HierholzerSolution().findItinerary(List.of(List.of("JFK", "KUL"), List.of("JFK", "NRT"),
                List.of("NRT", "JFK"))));
        System.out.println(new HierholzerSolution().findItinerary(List.of(List.of("EZE", "AXA"), List.of("TIA", "ANU"),
                List.of("ANU", "JFK"), List.of("JFK", "ANU"), List.of("ANU", "EZE"), List.of("TIA", "ANU"),
                List.of("AXA", "TIA"), List.of("TIA", "JFK"), List.of("ANU", "TIA"), List.of("JFK", "TIA"))));
    }
}
