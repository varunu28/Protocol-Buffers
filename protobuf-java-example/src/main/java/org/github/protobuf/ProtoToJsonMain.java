package org.github.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple.SimpleMessage;
import java.util.Arrays;

public class ProtoToJsonMain {

  public static void main(String[] args) throws InvalidProtocolBufferException {
    System.out.println("PrototoJson started");

    SimpleMessage.Builder builder = SimpleMessage.newBuilder();
    builder.setId(42)
        .setIsSimple(true)
        .setName("My simple message name");

    builder.addSampleList(1)
        .addSampleList(2)
        .addSampleList(3)
        .addAllSampleList(Arrays.asList(4, 5, 6));

    // Print as JSON
    String jsonString = JsonFormat.printer().print(builder);
    System.out.println(jsonString);

    // Parse JSON to Protocol buffer
    SimpleMessage.Builder builderTwo = SimpleMessage.newBuilder();
    JsonFormat.parser()
        .ignoringUnknownFields()
        .merge(jsonString, builderTwo);

    System.out.println(builderTwo.build());
  }
}
