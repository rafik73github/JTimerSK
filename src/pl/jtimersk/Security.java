package pl.jtimersk;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Security {


    public Security() {
    }

    /**
     * It's encrypt string format to SHA-256 format
     * @param str string to be encrypted
     * @return encrypted string in SHA-256 format
     * @throws NoSuchAlgorithmException see manual
     */
    public String hashMeString(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));

        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder((number.toString(16)));
        while(hexString.length() < 32){
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }


}
