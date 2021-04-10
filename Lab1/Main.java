package lab1;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Graph graph = new Graph(new File("src/lab1/lab1.txt"));
        Forest forest = new Forest();

        System.out.println("¬х≥дн≥ дан≥:");
        System.out.println(graph);
        System.out.println();
        for (int i = 0; i < graph.getPointList().size(); i++) {
            if (!forest.havePoint((char)graph.getPointList().get(i))){
                int minWeight = 100;
                Edge minEdge = new Edge();
                for (int j = 0; j < graph.edges.size(); j++) {
                    if (graph.edges.get(j).havePoint((char)graph.getPointList().get(i))){
                        if (graph.edges.get(j).getWeight() < minWeight){
                            minEdge = graph.edges.get(j);
                            minWeight = graph.edges.get(j).getWeight();
                        }
                    }
                }
                forest.addEdge(minEdge);
            }
        }

        Graph resultGraph = forest.toTree(graph);
        System.out.println("–езультат:");
        System.out.println(resultGraph);
        System.out.println("¬ага остового дерева = " + resultGraph.getWeight());

    }
}
