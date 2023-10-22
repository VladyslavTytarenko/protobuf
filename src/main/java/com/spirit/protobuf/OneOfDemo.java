package com.spirit.protobuf;

import com.spirit.models.Credentials;
import com.spirit.models.EmailCredential;
import com.spirit.models.PhoneOTP;

public class OneOfDemo {
    public static void main(String[] args) {
        EmailCredential emailCredential = EmailCredential.newBuilder()
                .setEmail("test@gmail.com")
                .setPassword("12345")
                .build();

        PhoneOTP phoneOTP = PhoneOTP.newBuilder()
                .setCode(380)
                .setNumber(123454645)
                .build();

        Credentials credentials = Credentials.newBuilder()
                .setEmailMode(emailCredential)
                .build();

        login(credentials );
    }

    public static void login(Credentials credentials) {
        switch (credentials.getModeCase()) {
            case EMAILMODE -> System.out.println(credentials.getEmailMode());
            case PHONEMODE -> System.out.println(credentials.getPhoneMode());
        }
    }
}
