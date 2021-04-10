package lab2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        Graph graph = new Graph(new File("src/lab2/lab2.txt"));
        System.out.println("Алгоритм рішення задачі листоноші");
        System.out.println();
        System.out.println("Вхідний граф:");
        System.out.println(graph);
        System.out.println();
        EulerianPath path = new EulerianPath(graph);

        System.out.println("Результат:");
        System.out.println(path.getPath());
    }
}
