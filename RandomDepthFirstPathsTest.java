import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

class RandomDepthFirstPathsTest {

       @Test
       void testRandomDFS() {
               Graph g = new Graph(4);
               g.addEdge(0, 1);
               g.addEdge(1, 2);
               g.addEdge(2, 3);

               RandomDepthFirstPaths rdfs = new RandomDepthFirstPaths(g, 0);
               rdfs.randomDFS(g);

               assertTrue(rdfs.hasPathTo(3));
               assertEquals(List.of(0, 1, 2, 3), rdfs.pathTo(3));
       }

       @Test
       void testRandomNonrecursiveDFS() {
               Graph g = new Graph(4);
               g.addEdge(0, 1);
               g.addEdge(1, 2);
               g.addEdge(2, 3);

               RandomDepthFirstPaths rdfs = new RandomDepthFirstPaths(g, 0);
               rdfs.randomNonrecursiveDFS(g);

               assertTrue(rdfs.hasPathTo(3));
               assertEquals(List.of(0, 1, 2, 3), rdfs.pathTo(3));
       }

       @Test
       void testPathTo() {
               Graph g = new Graph(4);
               g.addEdge(0, 1);
               g.addEdge(2, 3);

               RandomDepthFirstPaths rdfs = new RandomDepthFirstPaths(g, 0);
               rdfs.randomDFS(g);

               assertFalse(rdfs.hasPathTo(3));
               assertNull(rdfs.pathTo(3));
       }

}

