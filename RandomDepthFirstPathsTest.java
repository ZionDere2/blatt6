import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class RandomDepthFirstPathsTest {

        @Test
        void testRandomDFS() {
                Graph g = new Graph(4);
                g.addEdge(0, 1);
                g.addEdge(0, 2);
                g.addEdge(1, 3);
                g.addEdge(2, 3);

                RandomDepthFirstPaths rdfs = new RandomDepthFirstPaths(g, 0);
                rdfs.randomDFS(g);

                for (int v = 0; v < g.V(); v++) {
                        assertTrue(rdfs.hasPathTo(v));
                }

                List<Integer> path = rdfs.pathTo(3);
                assertEquals(0, path.get(0));
                assertEquals(3, path.get(path.size() - 1));
                assertTrue(validPath(path, g));
        }

        @Test
        void testRandomNonrecursiveDFS() {
                Graph g = new Graph(4);
                g.addEdge(0, 1);
                g.addEdge(0, 2);
                g.addEdge(1, 3);
                g.addEdge(2, 3);

                RandomDepthFirstPaths rdfs = new RandomDepthFirstPaths(g, 0);
                rdfs.randomNonrecursiveDFS(g);

                for (int v = 0; v < g.V(); v++) {
                        assertTrue(rdfs.hasPathTo(v));
                }

                List<Integer> path = rdfs.pathTo(3);
                assertEquals(0, path.get(0));
                assertEquals(3, path.get(path.size() - 1));
                assertTrue(validPath(path, g));
        }

        @Test
        void testPathTo() {
                Graph g = new Graph(4);
                g.addEdge(0, 1);
                g.addEdge(0, 2);
                g.addEdge(1, 3);
                g.addEdge(2, 3);

                RandomDepthFirstPaths rdfs = new RandomDepthFirstPaths(g, 0);
                rdfs.randomDFS(g);

                List<Integer> path = rdfs.pathTo(3);
                assertEquals(0, path.get(0));
                assertEquals(3, path.get(path.size() - 1));
                assertTrue(validPath(path, g));
        }

        private boolean validPath(List<Integer> path, Graph g) {
                for (int i = 0; i < path.size() - 1; i++) {
                        int v = path.get(i);
                        int w = path.get(i + 1);
                        if (!g.adj(v).contains(w)) {
                                return false;
                        }
                }
                return true;
        }

}

