import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class DepthFirstPathsTest {

        @Test
        void testDfs() {
                Graph g = new Graph(5);
                g.addEdge(0, 1);
                g.addEdge(0, 2);
                g.addEdge(1, 3);
                g.addEdge(2, 3);

                DepthFirstPaths dfs = new DepthFirstPaths(g, 0);
                dfs.dfs(g);

                assertEquals(4, dfs.pre().size());
                assertEquals(4, dfs.post().size());

                int[] expectedPre = {0, 1, 3, 2};
                int[] expectedPost = {2, 3, 1, 0};

                int idx = 0;
                for (int v : dfs.pre()) {
                        assertEquals(expectedPre[idx++], v);
                }
                idx = 0;
                for (int v : dfs.post()) {
                        assertEquals(expectedPost[idx++], v);
                }

                int[] dist = dfs.dist();
                assertEquals(0, dist[0]);
                assertEquals(1, dist[1]);
                assertEquals(2, dist[3]);
                assertEquals(3, dist[2]);

        }

        @Test
        void testNonrecursiveDFS() {
                Graph g = new Graph(5);
                g.addEdge(0, 1);
                g.addEdge(0, 2);
                g.addEdge(1, 3);
                g.addEdge(2, 3);

                DepthFirstPaths dfs = new DepthFirstPaths(g, 0);
                dfs.nonrecursiveDFS(g);

                int[] expectedPre = {0, 1, 3, 2};
                int[] expectedPost = {2, 3, 1, 0};

                int idx = 0;
                for (int v : dfs.pre()) {
                        assertEquals(expectedPre[idx++], v);
                }
                idx = 0;
                for (int v : dfs.post()) {
                        assertEquals(expectedPost[idx++], v);
                }
        }

        @Test
        void testPathTo() {
                Graph g = new Graph(5);
                g.addEdge(0, 1);
                g.addEdge(0, 2);
                g.addEdge(1, 3);
                g.addEdge(2, 3);

                DepthFirstPaths dfs = new DepthFirstPaths(g, 0);
                dfs.nonrecursiveDFS(g);

                List<Integer> path = dfs.pathTo(2);
                assertEquals(List.of(0, 1, 3, 2), path);

                assertNull(dfs.pathTo(4));
        }

}

