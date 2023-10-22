package com.spirit.protobuf;

import com.spirit.models.Car;
import com.spirit.models.Dealer;

import static com.spirit.models.BodyStyle.SEDAN;

public class MapDemo {
    public static void main(String[] args) {

        Car honda = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .build();

        Car audi = Car.newBuilder()
                .setMake("Audi")
                .setModel("A3")
                .setYear(20)
                .setBodyStyle(SEDAN)
                .build();

        Dealer dealer = Dealer.newBuilder()
                .putModel(2005, honda)
                .putModel(2012, audi)
                .build();

        System.out.println(dealer.getModelOrThrow(2005).getBodyStyle());
    }
}
