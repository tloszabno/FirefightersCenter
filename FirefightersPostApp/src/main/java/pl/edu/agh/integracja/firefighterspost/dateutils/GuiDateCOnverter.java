package pl.edu.agh.integracja.firefighterspost.dateutils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class GuiDateCOnverter {
  public static Date fromStringToDate(String date) {
    return Date.from(LocalDateTime.parse(date).atZone(ZoneId.systemDefault()).toInstant());
  }

  public static String fromDateToGuiShortDisplay(Date date){
    return new SimpleDateFormat("yyyy-mm-dd hh:MM").format(date);
  }
}
