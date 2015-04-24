import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

  @Test
  public void integrationTestN2() throws Exception {
    System.out.println("-------------------------");
    System.out.println("----------O(n2)----------");
    Main.main("KLED.cvs", "O(n2)");
    System.out.println("----------O(n)-----------");
    Main.main("KLED.cvs", "O(n)");

    System.out.println("-------------------------");
    System.out.println("----------O(n2)----------");
    Main.main("HEXA-B.cvs", "O(n2)");
    System.out.println("----------O(n)-----------");
    Main.main("HEXA-B.cvs", "O(n)");

    System.out.println("-------------------------");
    System.out.println("----------O(n2)----------");
    Main.main("MROX-B.cvs", "O(n2)");
    System.out.println("----------O(n)-----------");
    Main.main("MROX-B.cvs", "O(n)");


  }
}