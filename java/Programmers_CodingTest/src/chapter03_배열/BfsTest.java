package chapter03_배열;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BfsTest {

	public static void main(String[] args) {
		
//		List<Integer> testList = List.of(4979, 4975, 4979, 4961, 4975, 4979, 9184, 4961, 4975, 4979, 4786, 4979, 2666, 4786, 4979, 6795, 2666, 4786, 4979);
//		Map<Integer, List<Integer>> resultMap = buildGraph(4979, testList); 
////		for (Map.Entry<Integer, List<Integer>> entry : resultMap.entrySet()) {
////		    System.out.print(entry.getKey() + ": ");
////		    for (Integer value : entry.getValue()) {
////		        System.out.print(value + " ");
////		    }
////		    System.out.println(); // 다음 줄로 넘어감
////		}
//		Map<Integer, Integer> result = bfs(4979, testList);
//		for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
//		    System.out.println(entry.getKey() + ": " + entry.getValue());
//		}
		
		List<Integer> testList = List.of(3859, 4042, 3859, 10590, 4042, 3859, 996, 10590, 4042, 3859, 994, 10590, 4042, 3859, 9811, 10590, 4042, 3859, 9812, 10590, 4042, 3859, 9812, 4042, 3859, 10169, 9812, 4042, 3859, 3396, 3859, 3378, 3396, 3859, 10169, 3378, 3396, 3859, 2842, 3396, 3859, 2841, 2842, 3396, 3859, 3963, 2842, 3396, 3859, 4023, 2842, 3396, 3859, 3380, 3859, 9829, 3380, 3859, 994, 9829, 3380, 3859, 9811, 9829, 3380, 3859, 995, 9829, 3380, 3859, 9812, 9829, 3380, 3859, 996, 9829, 3380, 3859, 10745, 3380, 3859, 972, 10745, 3380, 3859, 10170, 3380, 3859, 10745, 10170, 3380, 3859, 3378, 3380, 3859, 10169, 3378, 3380, 3859, 9832, 3859, 1001, 3859, 10169, 1001, 3859, 971, 10169, 1001, 3859, 6784, 1001, 3859, 3381, 3859, 9812, 3381, 3859, 10169, 9812, 3381, 3859, 3380, 3381, 3859, 9829, 3380, 3381, 3859, 10745, 3380, 3381, 3859, 10170, 3380, 3381, 3859, 3378, 3380, 3381, 3859, 4047, 3859);
		Map<Integer, Integer> result = bfs(3859, testList);
		for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		}


	}
	
	private static Map<Integer, List<Integer>> buildGraph(int targetId, List<Integer> integerList) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // 중복 엣지 방지
        Set<String> addedEdges = new HashSet<>();

        for (int i = 1; i < integerList.size() - 1; i++) {
            int current = integerList.get(i);
            // 해당 id가 나오면 그래프 만들지 않고 다음 루프로
            if (targetId == current) continue;
            int next = integerList.get(i + 1);

            String edge = current + "->" + next;
            String reverseEdge = next + "->" + current;

            if (!addedEdges.contains(edge) && !addedEdges.contains(reverseEdge)) {
                graph.computeIfAbsent(current, k -> new ArrayList<>()).add(next);
                graph.computeIfAbsent(next, k -> new ArrayList<>()).add(current);
                addedEdges.add(edge);
                addedEdges.add(reverseEdge);
            }
        }
        return graph;
    }

    public static Map<Integer, Integer> bfs(int start, List<Integer> integerList) {
        Map<Integer, List<Integer>> graph = buildGraph(start, integerList);
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        distances.put(start, 0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int distance = distances.get(current);

            for (int neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    distances.put(neighbor, distance + 1);
                }
            }
        }
        return distances;
    }

}
