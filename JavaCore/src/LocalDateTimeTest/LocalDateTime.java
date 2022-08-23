package LocalDateTimeTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class LocalDateTime {
  public static void main(String[] args) {
    LocalDate localDate = LocalDate.now();
    System.out.println(localDate);
    LocalDate localDate1 = LocalDate.of(2022, 8, 23);
    LocalDate localDate2 = LocalDate.of(2022, Month.AUGUST, 23);
      LocalTime t = LocalTime.now();
      LocalTime t1 = LocalTime.of(12,35,10);
      Set<String> zoneID = ZoneId.getAvailableZoneIds();

//    Iterator<String> iterator = zoneID.iterator();
//    while (iterator.hasNext()){
//      System.out.println(iterator.next());
//    }
      LocalTime t3 = LocalTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddYYMM");
    System.out.println(localDate1.format(dtf));
  }
}
