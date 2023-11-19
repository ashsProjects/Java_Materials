import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BitwiseOperations {
    public static int stringToInt(String str) {
        int i = 0;
        int number = 0;

        while (i < str.length()) {
            number *= 10;
            number += str.charAt(i++) - '0';
        }
        return number;
    }

    public static void processDecimal(String decimal) {
        int decimalAsInt = stringToInt(decimal);
        String hex = "";
        String binary = decimalToBinary(decimal);

        // Decimal to Hex
        while (decimalAsInt > 0) {
            int remainder = decimalAsInt % 16;
            char hexChar = (remainder < 10) ? (char) ('0' + remainder) : (char) ('a' + remainder - 10);
            hex = hexChar + hex;
            decimalAsInt /= 16;
        }

        System.out.print(",Binary=0b" + binary);
        System.out.print(",Decimal=" + decimal);
        System.out.print(",Hexadecimal=0x" + hex);
        System.out.println();
    }

    public static void processBinary(String binary) {
        String binaryAfter0b = binary.substring(2);
        String hex = "";
        int decimal = 0;

        // Binary to Decimal
        for (int i = 1; i <= binaryAfter0b.length(); i++) {
            if (binaryAfter0b.charAt(binaryAfter0b.length() - i) == '1') {
                decimal += (int) Math.pow(2, i - 1);
            } else
                continue;
        }

        // Binary to Hex
        for (int i = 0; i < binaryAfter0b.length(); i += 4) {
            HashMap<Character, String> hexBinary = hexToBinaryMap();
            String fourBinary = binaryAfter0b.length() == 4 ? binaryAfter0b : binaryAfter0b.substring(i, i + 4);

            for (Map.Entry<Character, String> entry : hexBinary.entrySet()) {
                if (entry.getValue().equals(fourBinary)) {
                    hex += entry.getKey();
                    break;
                }
            }

        }

        System.out.print(",Binary=" + binary);
        System.out.print(",Decimal=" + decimal);
        System.out.print(",Hexadecimal=0x" + hex);
        System.out.println();
    }

    public static void processHex(String hex) {
        String hexAfter0x = hex.substring(2);
        int decimal = 0;
        String binary = hexToBinary(hex);

        // Hex to Decimal
        for (int i = 0; i < hexAfter0x.length(); i++) {
            HashMap<Character, Integer> hexInt = hexToDecimalMap();
            Character hexValue = hexAfter0x.charAt(hexAfter0x.length() - 1 - i);
            int hexInDecimal = hexInt.get(hexValue);
            decimal += hexInDecimal * Math.pow(16, i);
        }

        System.out.print(",Binary=0b" + binary);
        System.out.print(",Decimal=" + decimal);
        System.out.print(",Hexadecimal=" + hex);
        System.out.println();
    }

    public static String decimalToBinary(String decimal) {
        int decimalAsInt = stringToInt(decimal);
        String binary = "";

        while (decimalAsInt > 0) {
            int remainder = decimalAsInt % 2;
            binary = remainder + binary;
            decimalAsInt /= 2;
        }

        return binary;
    }

    public static String hexToBinary(String hex) {
        String hexAfter0x = hex.substring(2);
        String binary = "";

        for (int i = 0; i < hexAfter0x.length(); i++) {
            HashMap<Character, String> hexBinary = hexToBinaryMap();
            binary += hexBinary.get(hexAfter0x.charAt(i));
        }

        return binary;
    }

    public static HashMap<Character, String> hexToBinaryMap() {
        HashMap<Character, String> hexToBinaryMap = new HashMap<>();

        hexToBinaryMap.put('0', "0000");
        hexToBinaryMap.put('1', "0001");
        hexToBinaryMap.put('2', "0010");
        hexToBinaryMap.put('3', "0011");
        hexToBinaryMap.put('4', "0100");
        hexToBinaryMap.put('5', "0101");
        hexToBinaryMap.put('6', "0110");
        hexToBinaryMap.put('7', "0111");
        hexToBinaryMap.put('8', "1000");
        hexToBinaryMap.put('9', "1001");
        hexToBinaryMap.put('a', "1010");
        hexToBinaryMap.put('b', "1011");
        hexToBinaryMap.put('c', "1100");
        hexToBinaryMap.put('d', "1101");
        hexToBinaryMap.put('e', "1110");
        hexToBinaryMap.put('f', "1111");

        return hexToBinaryMap;
    }

    public static HashMap<Character, Integer> hexToDecimalMap() {
        HashMap<Character, Integer> hexToDecimalMap = new HashMap<>();

        hexToDecimalMap.put('0', 0);
        hexToDecimalMap.put('1', 1);
        hexToDecimalMap.put('2', 2);
        hexToDecimalMap.put('3', 3);
        hexToDecimalMap.put('4', 4);
        hexToDecimalMap.put('5', 5);
        hexToDecimalMap.put('6', 6);
        hexToDecimalMap.put('7', 7);
        hexToDecimalMap.put('8', 8);
        hexToDecimalMap.put('9', 9);
        hexToDecimalMap.put('a', 10);
        hexToDecimalMap.put('b', 11);
        hexToDecimalMap.put('c', 12);
        hexToDecimalMap.put('d', 13);
        hexToDecimalMap.put('e', 14);
        hexToDecimalMap.put('f', 15);

        return hexToDecimalMap;
    }

    public static String onesComplement(String binary) {
        String newBinary = "";

        for (int i = 0; i < binary.length(); i++) {
            char binaryValue = binary.charAt(i);
            if (binaryValue == '1')
                newBinary += 0;
            else
                newBinary += 1;
        }

        return newBinary;
    }

    public static String twosComplement(String complement) {
        int carry = 0;
        int i = 0;

        while (i < complement.length()) {
            char c = complement.charAt(complement.length() - 1 - i);
            if ((c == '0' && carry == 0) || (c == '0' && carry == 1)) {
                complement = complement.substring(0, complement.length() - 1 - i)
                        + 1 + complement.substring(complement.length() - i);
                break;
            } else {
                carry = 1;
                complement = complement.substring(0, complement.length() - 1 - i)
                        + 0 + complement.substring(complement.length() - i);
                i++;
            }
        }

        return complement;
    }

    public static String bitwiseOr(String one, String two, String three) {
        int longest = 0;
        String result = "";

        if (one.length() > two.length() && one.length() > three.length())
            longest = one.length();
        else if (two.length() > one.length() && two.length() > three.length())
            longest = two.length();
        else
            longest = three.length();

        String onePadded = String.join("", Collections.nCopies(longest - one.length(), "0")) + one;
        String twoPadded = String.join("", Collections.nCopies(longest - two.length(), "0")) + two;
        String threePadded = String.join("", Collections.nCopies(longest - three.length(), "0")) + three;

        for (int i = 0; i < longest; i++) {
            if (onePadded.charAt(i) == '1' || twoPadded.charAt(i) == '1' || threePadded.charAt(i) == '1')
                result += "1";
            else
                result += "0";
        }

        return result;
    }

    public static String bitwiseAnd(String one, String two, String three) {
        int longest = 0;
        String result = "";

        if (one.length() > two.length() && one.length() > three.length())
            longest = one.length();
        else if (two.length() > one.length() && two.length() > three.length())
            longest = two.length();
        else
            longest = three.length();

        String onePadded = String.join("", Collections.nCopies(longest - one.length(), "0")) + one;
        String twoPadded = String.join("", Collections.nCopies(longest - two.length(), "0")) + two;
        String threePadded = String.join("", Collections.nCopies(longest - three.length(), "0")) + three;

        for (int i = 0; i < longest; i++) {
            if (onePadded.charAt(i) == '1' && twoPadded.charAt(i) == '1' && threePadded.charAt(i) == '1')
                result += "1";
            else
                result += "0";
        }

        return result;
    }

    public static String bitwiseXor(String one, String two, String three) {
        // 1 when odd, 0 when even
        int longest = 0;
        String result = "";

        if (one.length() > two.length() && one.length() > three.length())
            longest = one.length();
        else if (two.length() > one.length() && two.length() > three.length())
            longest = two.length();
        else
            longest = three.length();

        String onePadded = String.join("", Collections.nCopies(longest - one.length(), "0")) + one;
        String twoPadded = String.join("", Collections.nCopies(longest - two.length(), "0")) + two;
        String threePadded = String.join("", Collections.nCopies(longest - three.length(), "0")) + three;

        for (int i = 0; i < longest; i++) {
            int oneCount = 0;

            if (onePadded.charAt(i) == '1')
                oneCount++;
            if (twoPadded.charAt(i) == '1')
                oneCount++;
            if (threePadded.charAt(i) == '1')
                oneCount++;

            if (oneCount % 2 == 1)
                result += 1;
            else
                result += 0;
        }

        return result;
    }

    public static String leftShift(String binary) {
        return binary + "00";
    }

    public static String rightShift(String binary) {
        return binary.substring(0, binary.length() - 2);
    }

}
