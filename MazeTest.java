import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

class MazeTest {

       @Test
       void testMazeIntInt() {
               Maze m = new Maze(2, 0);
               Graph g = m.M();
               assertEquals(4, g.V());
               assertEquals(3, g.E());
       }

       @Test
       void testAddEdge() {
               Maze m = new Maze(2, 0);
               Graph g = m.M();
               int before = g.E();
               boolean had = m.hasEdge(0, 3);
               m.addEdge(0, 3);
               if (had) {
                       assertEquals(before, g.E());
               } else {
                       assertEquals(before + 1, g.E());
               }
               assertTrue(m.hasEdge(0, 3));
       }

       @Test
       void testHasEdge() {
               Maze m = new Maze(2, 0);
               assertTrue(m.hasEdge(0, 0));
       }

       @Test
       void testMazegrid() {
               Maze m = new Maze(2, 0);
               Graph grid = m.mazegrid();
               assertEquals(4, grid.V());
               assertEquals(4, grid.E());
               assertTrue(grid.adj(0).contains(1));
               assertTrue(grid.adj(0).contains(2));
       }

       @Test
       void testFindWay() {
               Maze m = new Maze(2, 0);
               List<Integer> path = m.findWay(0, 3);
               assertNotNull(path);
               assertFalse(path.isEmpty());
               assertEquals(0, path.get(0));
               assertEquals(3, path.get(path.size() - 1));
       }

}

