import java.util.Iterator;

/**
 * Created by raz on 2015-04-01.
 */
public class StockAlgorithms {


  public static double getReturn(StockDataPoint.Tuple t){
    return getReturn(t.buy, t.sell);
  }

  public static double getReturn(StockDataPoint buy, StockDataPoint sell){
    if(buy.getLowPrice() == 0){
      return -2;
    }
    return (sell.getHighPrice() - buy.getLowPrice())/buy.getLowPrice();
  }

  public static StockDataPoint.Tuple findSolutionN2(final Iterable<StockDataPoint> iterable){

    final StockDataPoint.Tuple best = new StockDataPoint.Tuple();
    best.sell = iterable.iterator().next();
    best.buy = best.sell;

    iterable.forEach(sell -> {
      iterable.forEach(buy -> {
        if(buy.getDate().compareTo(sell.getDate()) < 0) {
          if(getReturn(buy, sell) > getReturn(best)){
            best.sell = sell;
            best.buy = buy;
          }
        }
      });
    });

    return best;

  }


  public static StockDataPoint.Tuple findSolutionN(final Iterable<StockDataPoint> iterable) {

    final StockDataPoint.Tuple best = new StockDataPoint.Tuple();
    best.sell = iterable.iterator().next();
    best.buy = best.sell;

    final StockDataPoint.Tuple current = new StockDataPoint.Tuple();
    current.sell = best.sell;
    current.buy = best.sell;

    iterable.forEach(p -> {
      if(getReturn(p, current.sell) > getReturn(current)) {
        current.buy = p;
      }
      if(p.getHighPrice() > current.sell.getHighPrice()) {
        current.sell = p;
        current.buy = p;
      }
      if(getReturn(current) > getReturn(best)) {
        best.sell = current.sell;
        best.buy = current.buy;
      }
    });

    return best;
  }
}
