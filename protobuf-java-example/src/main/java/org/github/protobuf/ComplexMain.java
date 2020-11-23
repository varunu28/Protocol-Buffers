package org.github.protobuf;

import example.complex.Complex.ComplexMessage;
import example.complex.Complex.DummyMessage;
import java.util.Arrays;

public class ComplexMain {

  public static void main(String[] args) {
    System.out.println("Complex message");

    DummyMessage oneDummy = createNewDummyMessage(55, "one dummy message");

    ComplexMessage.Builder complexMessageBuilder = ComplexMessage.newBuilder();

    // Singular field
    complexMessageBuilder.setOneDummy(oneDummy);

    // Repeated field
    complexMessageBuilder.addAllMultipleDummy(Arrays.asList(
        createNewDummyMessage(66, "second dummy"),
        createNewDummyMessage(77, "third dummy"),
        createNewDummyMessage(88, "forth dummy")
    ));

    ComplexMessage complexMessage = complexMessageBuilder.build();
    System.out.println(complexMessage);
  }

  private static DummyMessage createNewDummyMessage(Integer id, String name) {
    DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();
    return dummyMessageBuilder.setName(name)
        .setId(id)
        .build();
  }
}
