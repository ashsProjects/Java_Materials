public class MediumString {
  public static void main(String[] args) {
    MediumString test = new MediumString();

    // System.out.println("countCode: " + test.countCode("aaacodecosecideaa"));
    // System.out.println("endOther: " + test.endOther("Hiabc", "abc"));
    // System.out.println("xyzThere: " + test.xyzThere("abc.xyzabcxyz"));
    // System.out.println("bobThere: " + test.bobThere("abcbob"));
    // System.out.println("xyBalance: " + test.xyBalance("xaxxbyadf"));
    // System.out.println("mixString: " + test.mixString("2/", "27 around"));
    // System.out.println("repeatEnd: " + test.repeatEnd("abcabc3434", 4));
    // System.out.println("repeatFront: " + test.repeatFront("Chocolate", 4));
    // System.out.println("repeatSeperator: " + test.repeatSeparator("abc", "XX",
    // 3));
    // System.out.println("prefixAgain: " + test.prefixAgain("xyxxyxhkjfdaxyx", 2));
    // System.out.println("getSandwich: " + test.getSandwich("breadjambread"));
    // System.out.println("sameStarChar: " + test.sameStarChar("XY**aads*s*"));

  }// end main

  public int countCode(String str) {
    /*
     * Return the number of times that the string "code" appears anywhere in the
     * given string,
     * except we'll accept any letter for the 'd', so "cope" and "cooe" count.
     */
    int count = 0;
    for (int i = 0; i < str.length() - 3; i++) {
      if (str.substring(i, i + 4).startsWith("co") &&
          str.substring(i, i + 4).endsWith("e")) {
        count++;
      }
    }
    return count;
  }// end countCode

  public boolean endOther(String a, String b) {
    /*
     * Given two strings, return true if either of the strings appears at the
     * very end of the other string, ignoring upper/lower case differences
     * (in other words, the computation should not be "case sensitive").
     * Note: str.toLowerCase() returns the lowercase version of a string.
     */
    if (a.toLowerCase().endsWith(b.toLowerCase()) ||
        b.toLowerCase().endsWith(a.toLowerCase())) {
      return true;
    }
    return false;
  }

  public boolean xyzThere(String str) {
    /*
     * Return true if the given string contains an appearance of "xyz" where
     * the xyz is not directly preceeded by a period (.). So "xxyz" counts but
     * "x.xyz" does not.
     */
    if (!str.contains("xyz")) {
      return false;
    } else if (!str.startsWith("xyz") &&
        str.charAt(str.lastIndexOf("xyz") - 1) != '.') {
      return true;
    }

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '.') {
        if (str.substring(i + 1, i + 4).equals("xyz")) {
          return false;
        }
      }
    }

    return true;
  }

  public boolean bobThere(String str) {
    /*
     * Return true if the given string contains a "bob" string,
     * but where the middle 'o' char can be any char.
     */
    for (int i = 0; i < str.length() - 2; i++) {
      if (str.substring(i, i + 3).startsWith("b") &&
          str.substring(i, i + 3).endsWith("b")) {
        return true;
      }
    }
    return false;
  }

  public boolean xyBalance(String str) {
    /*
     * We'll say that a String is xy-balanced if for all the 'x' chars in the
     * string,
     * there exists a 'y' char somewhere later in the string. So "xxy" is balanced,
     * but "xyx" is not. One 'y' can balance multiple 'x's.
     * Return true if the given string is xy-balanced.
     */
    if (str.contains("x") && !str.contains("y")) {
      return false;
    } else if (!str.contains("x") && str.contains("y")) {
      return true;
    } else if (str.lastIndexOf("x") > str.lastIndexOf("y")) {
      return false;
    }
    return true;
  }

  public String mixString(String a, String b) {
    /*
     * Given two strings, a and b, create a bigger string made of the first char of
     * a,
     * the first char of b, the second char of a, the second char of b, and so on.
     * Any leftover chars go at the end of the result.
     */
    String newString = "";
    int diff = a.length() - b.length();
    if (diff == 0) {
      for (int i = 0; i < a.length(); i++) {
        newString = newString + a.charAt(i) + b.charAt(i);
      } // end for
    } else if (diff > 0) {// a gretaer than b
      for (int i = 0; i < b.length(); i++) {
        newString = newString + a.charAt(i) + b.charAt(i);
      } // end for
      newString = newString + a.substring(b.length(), a.length());
    } else if (diff < 0) {// a less than b
      for (int i = 0; i < a.length(); i++) {
        newString = newString + a.charAt(i) + b.charAt(i);
      } // end for
      newString = newString + b.substring(a.length(), b.length());
    }
    return newString;
  }

  public String repeatEnd(String str, int n) {
    /*
     * Given a string and an int n, return a string made of n repetitions of
     * the last n characters of the string. You may assume that n is between 0
     * and the length of the string, inclusive.
     */
    String temp = "";
    for (int i = 0; i < n; i++) {
      temp = temp + str.substring(str.length() - n, str.length());
    }
    return temp;
  }

  public String repeatFront(String str, int n) {
    /*
     * Given a string and an int n, return a string made of the first n characters
     * of the string, followed by the first n-1 characters of the string, and so on.
     * You may assume that n is between 0 and the length of the string, inclusive
     * (i.e. n >= 0 and n <= str.length()).
     */
    String temp = "";
    for (int i = 0; i < n; i++) {
      temp = temp + str.substring(0, n - i);
    }
    return temp;
  }

  public String repeatSeparator(String word, String sep, int count) {
    /*
     * Given two strings, word and a separator sep, return a big
     * string made of count occurrences of the word, separated by the separator
     * string.
     */
    String temp = word;
    if (count == 0) {
      return "";
    }

    for (int i = 0; i < count - 1; i++) {
      temp = temp + sep + word;
    }
    return temp;
  }

  public boolean prefixAgain(String str, int n) {
    /*
     * Given a string, consider the prefix string made of the first N chars of the
     * string.
     * Does that prefix string appear somewhere else in the string? Assume that the
     * string
     * is not empty and that N is in the range 1..str.length().
     */
    String prefix = str.substring(0, n);
    if (str.lastIndexOf(prefix) < n) {
      return false;
    }
    return true;
  }

  public String getSandwich(String str) {
    /*
     * A sandwich is two pieces of bread with something in between. Return the
     * string
     * that is between the first and last appearance of "bread" in the given string,
     * or return
     * the empty string "" if there are not two pieces of bread.
     */
    if (!str.contains("bread"))
      return "";
    else if (str.indexOf("bread") == str.lastIndexOf("bread"))
      return "";
    return str.substring(str.indexOf("bread") + 5, str.lastIndexOf("bread"));
  }

  public boolean sameStarChar(String str) {
    /*
     * Returns true if for every '*' (star) in the string,
     * if there are chars both immediately before and after the star, they are the
     * same.
     */
    boolean bool = false;
    if (!str.contains("*") || str.replace('*', ' ').trim().isEmpty()) {
      return true;
    }

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '*') {
        if (i == 0 || i == str.length() - 1) {
          continue;
        } else if (str.charAt(i - 1) == str.charAt(i + 1)) {
          bool = true;
        } else
          bool = false;
      }
    }
    return bool;
  }

}// end class
