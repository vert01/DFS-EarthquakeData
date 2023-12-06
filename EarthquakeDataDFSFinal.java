//Project Created by John Alexander
//12/5/2023
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.EarthquakeUSGS;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EarthquakeDataDFSFinal {

    public static void main(String[] args) throws Exception {
       //Bridges API object
        Bridges bridges = new Bridges(0, "1", "1");
        bridges.setTitle("Earthquake Data DFS");

        //Scanner input for number of Earthquakes they want to analyze
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of earthquake records to analyze: ");
        int numRecords = scanner.nextInt();

        //Build graph
        DataSource ds = bridges.getDataSource();
        List<EarthquakeUSGS> eqList = ds.getEarthquakeUSGSData(numRecords);

        //Nodes = earthquakes and edges = magnitude relationships
        Map<Integer, List<Integer>> graph = buildMagnitudeGraph(eqList);

        //DFS earthquakes by magnitude
        List<Integer> visited = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (Integer node : graph.keySet()) {
            if (!visited.contains(node)) {
                dfsSortByMagnitude(graph, visited, node, result);
            }
        }

        //Print output
        System.out.println("Sorted Earthquake Data by Magnitude:");
        for (Integer index : result) {
            EarthquakeUSGS earthquake = eqList.get(index);
            System.out.println("Magnitude: " + earthquake.getMagnitude() + ", Date: " +
                    earthquake.getTime() + ", Location: " + earthquake.getLocation());
        }

        scanner.close();
    }

    private static Map<Integer, List<Integer>> buildMagnitudeGraph(List<EarthquakeUSGS> eqList) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < eqList.size() - 1; i++) {
            for (int j = i + 1; j < eqList.size(); j++) {
                double magnitude_i = eqList.get(i).getMagnitude();
                double magnitude_j = eqList.get(j).getMagnitude();

                if (magnitude_i > magnitude_j) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }

        return graph;
    }

    private static void dfsSortByMagnitude(Map<Integer, List<Integer>> graph, List<Integer> visited, int node, List<Integer> result) {
        if (!visited.contains(node)) {
            visited.add(node);
            List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
            for (Integer neighbor : neighbors) {
                dfsSortByMagnitude(graph, visited, neighbor, result);
            }
            result.add(node);
        }
    }
}
