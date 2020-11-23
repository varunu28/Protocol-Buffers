package org.github.protobuf;

import example.simple.Simple.SimpleMessage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {

  public static void main(String[] args) {
    System.out.println("Hello World");

    SimpleMessage.Builder builder = SimpleMessage.newBuilder();
    builder.setId(42)
        .setIsSimple(true)
        .setName("My simple message name");

    builder.addSampleList(1)
        .addSampleList(2)
        .addSampleList(3)
        .addAllSampleList(Arrays.asList(4, 5, 6));

    SimpleMessage message = builder.build();

    try {
      FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
      message.writeTo(outputStream);
      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Reading from file");
    try {
      FileInputStream fileInputStream = new FileInputStream("simple_message.bin");
      SimpleMessage messageFromFile = SimpleMessage.parseFrom(fileInputStream);
      System.out.println(messageFromFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
