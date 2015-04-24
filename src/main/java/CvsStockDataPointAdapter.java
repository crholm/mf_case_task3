import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

/**
 * Created by raz on 2015-04-01.
 */
public class CvsStockDataPointAdapter implements Iterable<StockDataPoint> {

  private final List<CSVRecord> list;

  public CvsStockDataPointAdapter(final String fileName) throws IOException {
    final File file = new File(fileName);
    final Reader reader = new InputStreamReader(new FileInputStream(file));
    list = new CSVParser(reader, CSVFormat.DEFAULT.withHeader()).getRecords();

  }



  @Override
  public Iterator<StockDataPoint> iterator() {
    return new Iterator<StockDataPoint>() {
      final Iterator<CSVRecord> i = list.iterator();

      @Override
      public boolean hasNext() {
        return i.hasNext();
      }

      @Override
      public StockDataPoint next() {
        CSVRecord r = i.next();
        StockDataPoint p = new StockDataPoint();
        p.setDate(r.get("quote_date"));
        p.setLowPrice(Double.parseDouble(r.get("low")));
        p.setHighPrice(Double.parseDouble(r.get("high")));
        return p;
      }
    };
  }
}
