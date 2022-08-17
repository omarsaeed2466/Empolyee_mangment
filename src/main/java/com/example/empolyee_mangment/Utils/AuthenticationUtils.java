package com.example.empolyee_mangment.Utils;

import com.example.empolyee_mangment.constants.ApplicationConstant;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class AuthenticationUtils {
    public String getHashValue(String password) throws Exception {
        String saltedPassword = ApplicationConstant.SALT + password;
        String hashedPassword = generateHash(saltedPassword);

        return hashedPassword;
    }

    /**
     * Method to generate Hash value for a given input String.
     *
     * @param input
     * @return
     * @throws Exception
     */
    public static String generateHash(String input) throws Exception {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    'a', 'b', 'c', 'd', 'e', 'f'};
            for (int idx = 0; idx < hashedBytes.length; ++idx) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }

        return hash.toString();
    }
}
