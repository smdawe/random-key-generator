package com.smdawe.random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.util.Random;

public class Main {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String LOWER = UPPER.toLowerCase();

    private static final String DIGITS = "0123456789";

    private static final String ALPHANUM = UPPER + LOWER + DIGITS;

    private static final Charset UTF8 = Charset.forName("UTF-8");

    public static void main(String[] args) {
        int length = 16;
        try {
            byte[] bytes = randomString(length).getBytes(UTF8);
            String s = new String(bytes, UTF8);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(s.getBytes(UTF8), "AES"));
            System.out.println("Your 128bit key " + s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String randomString(int length) {
        Random random = new Random();
        char[] c = new char[length];
        for (int i = 0; i < length; i++) {
            c[i] = ALPHANUM.charAt(random.nextInt(ALPHANUM.length()));
        }
        return new String(c);
    }
}
