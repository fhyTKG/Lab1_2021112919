import org.junit.*;
import code.*;



import static code.Main.readFileContent;
import static org.junit.Assert.*;

public class BlackWordGraphTest {
    private static WordGraph wordgraph;
    @BeforeClass
    public static void setUp() throws Exception {
        String filePath = "./src/test.txt";
        wordgraph = new WordGraph();
        String processedContent = readFileContent(filePath);
        wordgraph.buildGraph(processedContent);
        Graphviz.showDirectedGraph(wordgraph);
        System.out.println("setup successfully");
    }
    @AfterClass
    public static void tearDown()  {
        wordgraph = null;
        System.out.println("tear down successfully");
    }
    @Test
    public void test1() {
        String result=wordgraph.generateNewText("high into");
        System.out.println(result);
        assertEquals("high into",result);
    }
    @Test
    public void test2() {
        String result=wordgraph.generateNewText("deep the");
        System.out.println(result);
        assertEquals("deep into the",result);
    }
    @Test
    public void test3() {
        String result=wordgraph.generateNewText("creatures harmony");
        System.out.println(result);
        assertTrue(result.equals("creatures lived harmony")||result.equals("creatures in harmony"));
    }
    @Test
    public void test4() {
        String result = wordgraph.generateNewText("random deep");
        System.out.println(result);
        assertEquals("random deep", result);
    }
    @Test
    public void test5() {
        String result = wordgraph.generateNewText("random walk");
        System.out.println(result);
        assertEquals("random walk", result);
    }
}