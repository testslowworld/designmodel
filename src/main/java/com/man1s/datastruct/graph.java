package com.man1s.datastruct;

import java.util.LinkedList;
import java.util.List;

/**
 * Title:graph
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2019/3/25 15:07
 */
public class graph {

    private static class Vertex {
        int data;

        public Vertex(int data) {
            this.data = data;
        }
    }

    private static class Graph {
        private int size;
        private Vertex[] vertices;
        private List<Integer> link[];

        public Graph(int size) {
            this.size = size;
            vertices = new Vertex[size];
            link = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                vertices[i] = new Vertex(i);
                link[i] = new LinkedList<>();

            }
        }

        public static void dfs(Graph graph, int start, boolean[] visited) {

            System.out.println(graph.vertices[start].data);
            visited[start] = true;
            for (int index : graph.link[start]) {
                if (!visited[index]) {
                    dfs(graph, index, visited);
                }
            }
        }

        public static void main(String[] args) {
            Graph graph = new Graph(6);
            graph.link[0].add(1);
            graph.link[0].add(2);
            graph.link[0].add(3);

            graph.link[1].add(0);
            graph.link[1].add(3);
            graph.link[1].add(4);

            graph.link[2].add(0);

            graph.link[3].add(0);
            graph.link[3].add(1);
            graph.link[3].add(4);
            graph.link[3].add(5);

            graph.link[4].add(1);
            graph.link[4].add(3);

            graph.link[5].add(3);
            graph.link[5].add(4);

            dfs(graph, 0, new boolean[graph.size]);
        }

    }

}
