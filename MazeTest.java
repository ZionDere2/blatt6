import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class MazeTest {

        @Test
        void testMazeIntInt() {
                Maze m = new Maze(2, 0);
                Graph g = m.M();
                assertEquals(4, g.V());
                assertEquals(3, g.E());
                assertEquals(0, m.startnode);
        }

	@Test
        void testAddEdge() {
                Maze m = new Maze(1, 0);
                Graph g = m.M();
                assertEquals(0, g.E());
                m.addEdge(0, 0);
                assertEquals(0, g.E());
        }

	@Test
        void testHasEdge() {
                Maze m = new Maze(2, 0);
                Graph g = m.M();
                for (int v = 0; v < g.V(); v++) {
                        for (int w : g.adj(v)) {
                                assertTrue(m.hasEdge(v, w));
                        }
                }
        }

	@Test
        void testMazegrid() {
                Maze m = new Maze(3, 0);
                Graph g = m.mazegrid();
                assertEquals(9, g.V());
                assertEquals(2 * 3 * (3 - 1), g.E());
                assertTrue(g.adj(0).contains(1));
                assertTrue(g.adj(0).contains(3));
        }

	@Test
        void testFindWay() {
                Maze m = new Maze(3, 0);
                List<Integer> path = m.findWay(0, 8);
                assertNotNull(path);
                assertEquals(0, (int) path.get(0));
                assertEquals(8, (int) path.get(path.size() - 1));
                // verify consecutive edges exist
                Graph g = m.M();
                for (int i = 0; i < path.size() - 1; i++) {
                        assertTrue(g.adj(path.get(i)).contains(path.get(i + 1)));
                }
        }

}

