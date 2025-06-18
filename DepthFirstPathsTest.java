import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

class DepthFirstPathsTest {

       @Test
       void testDfs() {
               Graph g = new Graph(4);
               g.addEdge(0, 1);
               g.addEdge(1, 2);
               g.addEdge(2, 3);

               DepthFirstPaths dfs = new DepthFirstPaths(g, 0);
               dfs.dfs(g);

               assertTrue(dfs.hasPathTo(3));
               assertEquals(List.of(0, 1, 2, 3), dfs.pathTo(3));
       }

       @Test
       void testNonrecursiveDFS() {
               Graph g = new Graph(4);
               g.addEdge(0, 1);
               g.addEdge(1, 2);
               g.addEdge(2, 3);

               DepthFirstPaths dfs = new DepthFirstPaths(g, 0);
               dfs.nonrecursiveDFS(g);

               assertTrue(dfs.hasPathTo(3));
               assertEquals(List.of(0, 1, 2, 3), dfs.pathTo(3));
       }

       @Test
       void testPathTo() {
               Graph g = new Graph(4);
               g.addEdge(0, 1);
               g.addEdge(2, 3);

               DepthFirstPaths dfs = new DepthFirstPaths(g, 0);
               dfs.dfs(g);

               assertFalse(dfs.hasPathTo(3));
               assertNull(dfs.pathTo(3));
       }

}

