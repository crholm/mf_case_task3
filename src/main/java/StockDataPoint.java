/**
 * Created by raz on 2015-04-01.
 */
public class StockDataPoint {

  public static class Tuple{
    StockDataPoint buy = new StockDataPoint();
    StockDataPoint sell = new StockDataPoint();
  }

  private String date;
  private double highPrice;
  private double lowPrice;


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public double getHighPrice() {
    return highPrice;
  }

  public void setHighPrice(double highPrice) {
    this.highPrice = highPrice;
  }

  public double getLowPrice() {
    return lowPrice;
  }

  public void setLowPrice(double lowPrice) {
    this.lowPrice = lowPrice;
  }

  public void set(StockDataPoint p) {
    date = p.getDate();
    highPrice = p.getHighPrice();
    lowPrice = p.getLowPrice();
  }
}
