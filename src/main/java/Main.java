import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Created by raz on 2015-04-01.
 */
public class Main {

  public static final int N2_TYPE = 0;
  public static final int N_TYPE = 1;


  public static void main(String ... args) throws IOException {


    if(args.length == 0){
      System.err.println("No arguments was supplied");
      return;
    }

    int type = args.length == 2 && args[1].toLowerCase().equals("O(N)".toLowerCase()) ? N_TYPE : N2_TYPE;

    String fileName = args[0];

    StockDataPoint.Tuple tuple = null;
    if(type == N2_TYPE){
      tuple = StockAlgorithms.findSolutionN2(new CvsStockDataPointAdapter(fileName));
    }else{
      tuple = StockAlgorithms.findSolutionN(new CvsStockDataPointAdapter(fileName));
    }

    System.out.println(fileName);
    System.out.println("Buy\t\t" + tuple.buy.getDate() + " @ " + tuple.buy.getLowPrice());
    System.out.println("Sell\t" +  tuple.sell.getDate() +" @ " + tuple.sell.getHighPrice());
    System.out.println("Return\t" +
                       new DecimalFormat("#.##").format(
                        StockAlgorithms.getReturn(tuple.buy, tuple.sell)* 100
                       ) + "%");
    System.out.println();

  }

}
