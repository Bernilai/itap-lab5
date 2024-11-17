package dev.berilai;

import dev.berilai.exceptions.InvalidIpAddressException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class IpAddressValidator {

    public static boolean isValidIpAddress(String ipAddress) throws InvalidIpAddressException {

        Pattern pattern;
        try {
            pattern = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
        } catch (PatternSyntaxException e) {
            throw new InvalidIpAddressException("Invalid regular expression syntax: " + e.getMessage());
        }
        Matcher matcher = pattern.matcher(ipAddress);
        if (!matcher.matches()) {
            throw new InvalidIpAddressException("Invalid IP address format.");
        }
        return true;
    }

    public static void main(String[] args) {

        String ipAddress = "192.168.1.1";

        try {
            boolean isValid = isValidIpAddress(ipAddress);
            System.out.println(ipAddress + ": " + (isValid ? "Valid" : "Invalid"));
        } catch (InvalidIpAddressException e) {
            System.err.println(ipAddress + ": " + e.getMessage());
        }
    }
}