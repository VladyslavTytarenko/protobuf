package com.spirit.protobuf;

import com.spirit.models.Address;
import com.spirit.models.Car;
import com.spirit.models.Person;

import java.util.Arrays;

public class CompositionDemo {
    public static void main(String[] args) {
        Address address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("main street")
                .setCity("Atlanta")
                .build();

        Car honda = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .build();

        Car audi = Car.newBuilder()
                .setMake("Audi")
                .setModel("A3")
                .setYear(2022)
                .build();

        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(25)
                .addAllCar(Arrays.asList(honda, audi))
                .setAddress(address)
                .build();

        System.out.println(sam);
    }
}
