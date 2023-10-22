package com.spirit.protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.spirit.json.JPerson;
import com.spirit.models.Person;

import java.io.IOException;

public class PerformanceTest {
    public static void main(String[] args) {

        // JSON
        JPerson personJson = new JPerson();
        personJson.setName("sam");
        personJson.setAge(10);
        ObjectMapper mapper = new ObjectMapper();

        Runnable runnableJson = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(personJson);
                JPerson deserializedPersonJson = mapper.readValue(bytes, JPerson.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        // protobuf
        Person personProtobuf = Person.newBuilder()
                .setName("sam")
                .setAge(10)
                .build();
        
        Runnable runnableProtobuf = () -> {
            try {
                byte[] protobufBytes = personProtobuf.toByteArray();
                Person deserializedPersonProtobuf = Person.parseFrom(protobufBytes);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        };

        for (int i = 0; i < 5; i++) {
            runPerformanceTest(runnableJson, "JSON");
            runPerformanceTest(runnableProtobuf, "PROTOBUF");
        }
    }

    private static void runPerformanceTest(Runnable runnable, String method) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            runnable.run();
        }
        long endTime = System.currentTimeMillis();

        System.out.println(method + " : " + (endTime - startTime) + " ms");
    }
}
