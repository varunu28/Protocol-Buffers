package org.github.protobuf;

import com.example.options.OptionMessageOther;

public class OptionsMain {

  public static void main(String[] args) {
    OptionMessageOther other = OptionMessageOther.newBuilder().build();
    System.out.println(other);
  }
}
