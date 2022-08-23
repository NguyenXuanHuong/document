import java.time.*;
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

//      LocalTime t3 = LocalTime.now(Zon)


  }
}
