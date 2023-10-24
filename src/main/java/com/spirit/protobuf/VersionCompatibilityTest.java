package com.spirit.protobuf;

import com.spirit.models.Television;
import com.spirit.models.Type;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.spirit.models.Type.OLED;

public class VersionCompatibilityTest {
    public static void main(String[] args) throws IOException {

        Path pathV1 = Paths.get("tv-v1");
        Path pathV2 = Paths.get("tv-v2");
//        Television television = Television.newBuilder()
//                .setBrand("sony")
//                .setModel(2016)
//                .setType(OLED)
//                .build();
//
//        Files.write(pathV2, television.toByteArray());

        // V1
        byte[] bytesV1 = Files.readAllBytes(pathV1);
        System.out.println(Television.parseFrom(bytesV1));

        byte[] bytesV2 = Files.readAllBytes(pathV2);
        System.out.println(Television.parseFrom(bytesV2));
    }
}
