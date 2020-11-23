package org.github.protobuf;

import example.enumerations.EnumExample.DayOfTheWeek;
import example.enumerations.EnumExample.EnumMessage;

public class EnumMain {

  public static void main(String[] args) {
    System.out.println("Example for enums");

    EnumMessage.Builder builder = EnumMessage.newBuilder();
    builder.setId(345)
        .setDayOfTheWeek(DayOfTheWeek.MONDAY);

    EnumMessage message = builder.build();
    System.out.println(message);
  }
}
