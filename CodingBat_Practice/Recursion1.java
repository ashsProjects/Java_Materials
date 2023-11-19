import java.sql.SQLIntegrityConstraintViolationException;

public class Recursion1 {
  public static void main(String[] args) {
    Recursion1 test = new Recursion1();
    int[] arr = new int[] { 1, 6, 5, 11, 11, 2, 20 };
    // System.out.println("________________________________________________________________");
    // System.out.println("Factorial: " + test.factorial(12));
    // System.out.println("Bunny Ears: " + test.bunnyEars(12));
    // System.out.println("Fibonacci: " + test.fibonacci(17));
    // System.out.println("Bunny Ears (odd or even): " + test.bunnyEars2(25));
    // System.out.println("Triangle: " + test.triangle(7));
    // System.out.println("Sum of Digits: " + test.sumDigits(235));
    // System.out.println("Count 7s in Num: " + test.count7(77121781));
    // System.out.println("Count of 8s in Num (with +1 for duplicates to the left: "
    // + test.count8(8818));
    // System.out.println("Power of num: " + test.powerN(2, 12));
    // System.out.println("Count of x chars: " + test.countX("xxhixx"));
    // System.out.println("Count of Hi's: " + test.countHi("ihihihihihi"));
    // System.out.println("Change Pi: " + test.changePi("xpixpizz"));
    // System.out.println("No X's: " + test.noX("axxbxx"));
    // System.out.println("Array contains 6: " + test.array6(arr,0));
    // System.out.println("Count of 11's: " + test.array11(arr, 0));
    // System.out.println("Count of nums * 10: " + test.array220(arr, 0));
    // System.out.println("With added stars: " + test.allStar("john is"));
    // System.out.println("With added starts between duplicates: " +
    // test.pairStar("noadjaccent"));
    // System.out.println("X's at the end: " + test.endX("aaxaxabxx"));
    // System.out.println("Count of Pairs: " + test.countPairs("axaxbjdfa"));
    // System.out.println("Count of abc's or aba's: " + test.countAbc("abcxxabc"));
    // System.out.println("Nums of 11's: " + test.count11("11ab1111111c11xx1"));
    // System.out.println("Cleaned String: " + test.stringClean("yyzzaahallo"));
    // System.out.println("String within Parentheses: " + test.parenBit("ay(possibilities)"));
    // System.out.println("Same amount of open and close Parenthesis's: " + test.nestParen("(())()())))"));
    // System.out.println("Num of subtring in String: " + test.strCount("ijkiihjoiih", "ii"));
    // System.out.println("Contains num of sub in String: " + test.strCopies("catcowcat", "cat", 2));
    

  }

  public int factorial(int n) {
    /*
     * Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2)
     * ... 1.
     * Compute the result recursively (without loops).
     */
    if (n == 1) {
      return 1;
    }
    return n * factorial(n - 1);
  }

  public int bunnyEars(int bunnies) {
    /*
     * We have a number of bunnies and each bunny has two big floppy ears. We want
     * to compute
     * the total number of ears across all the bunnies recursively (without loops or
     * multiplication).
     */
    if (bunnies == 0) {
      return 0;
    }
    return 2 + bunnyEars(bunnies - 1);
  }

  public int fibonacci(int n) {
    /*
     * The fibonacci sequence is a famous bit of mathematics, and it happens to have
     * a recursive definition. The first two values in the sequence are 0 and 1
     * (essentially 2 base cases). Each subsequent value is the sum of the previous
     * two values,
     * so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. Define a
     * recursive
     * fibonacci(n) method that returns the nth fibonacci number, with n=0
     * representing the
     * start of the sequence.
     */
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public int bunnyEars2(int bunnies) {
    /*
     * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3,
     * ..)
     * have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears,
     * because
     * they each have a raised foot. Recursively return the number of "ears" in the
     * bunny
     * line 1, 2, ... n (without loops or multiplication).
     */
    if (bunnies == 0) {
      return 0;
    } else if (bunnies % 2 == 1) {// odd numbered bunnies with 2 ears
      return 2 + bunnyEars2(bunnies - 1);
    } else {
      return 3 + bunnyEars2(bunnies - 1);
    }
  }

  public int triangle(int rows) {
    /*
     * We have triangle made of blocks. The topmost row has 1 block,
     * the next row down has 2 blocks, the next row has 3 blocks, and so on.
     * Compute recursively (no loops or multiplication) the total number of blocks
     * in such a triangle with the given number of rows.
     */
    if (rows == 0) {
      return 0;
    }
    if (rows == 1) {
      return 1;
    } else {
      return rows + triangle(rows - 1);
    }
  }

  public int sumDigits(int n) {
    /*
     * Given a non-negative int n, return the sum of its digits recursively (no
     * loops).
     * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while
     * divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     */
    if (n <= 9) {
      return n;
    } else {
      return n % 10 + sumDigits(n / 10);
    }
  }

  public int count7(int n) {
    /*
     * Given a non-negative int n, return the count of the occurrences of 7 as a
     * digit,
     * so for example 717 yields 2. (no loops). Note that mod (%) by 10 yields the
     * rightmost
     * digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit
     * (126 / 10 is 12).
     */
    if (n <= 9) {
      if (n == 7) {
        return 1;
      } else {
        return 0;
      }
    } else if (n % 10 == 7) {
      return 1 + count7(n / 10);
    }
    return 0 + count7(n / 10);
  }

  public int count8(int n) {
    /*
     * Given a non-negative int n, compute recursively (no loops) the count of the
     * occurrences of 8
     * as a digit, except that an 8 with another 8 immediately to its left counts
     * double, so 8818 yields 4.
     * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while
     * divide (/) by 10 removes the
     * rightmost digit (126 / 10 is 12).
     */
    if (n <= 9) {
      if (n == 8) {
        return 1;
      } else {
        return 0;
      }
    }
    if (n % 10 == 8) {
      if (count8Bool(n / 10)) {
        return 2 + count8(n / 10);
      } else {
        return 1 + count8(n / 10);
      }
    }
    return 0 + count8(n / 10);
  }

  public static boolean count8Bool(int n) {// helper method for count8()
    if (n % 10 == 8) {
      return true;
    }
    return false;
  }

  public int powerN(int base, int n) {
    /*
     * Given base and n that are both 1 or more, compute recursively (no loops) the
     * value of base to the n power, so powerN(3, 2) is 9 (3 squared).
     */
    if (n == 0) {
      return 1;
    }
    return base * powerN(base, n - 1);
  }

  public int countX(String str) {
    /*
     * Given a string, compute recursively (no loops) the number of lowercase 'x'
     * chars in the string.
     */
    if (!str.contains("x"))
      return 0;
    if (str.length() <= 1) {
      if (!str.equals("x"))
        return 0;
      else
        return 1;
    }

    if (str.charAt(str.length() - 1) == 'x') {
      return 1 + countX(str.substring(0, str.length() - 1));
    }
    return 0 + countX(str.substring(0, str.length() - 1));
  }

  public int countHi(String str) {
    if (str.length() == 0) {
      return 0;
    }
    if (str.length() == 1 && str.charAt(0) == 'i') {
      return 0;
    }
    if (str.charAt(str.length() - 1) == 'i' &&
        str.charAt(str.length() - 2) == 'h') {
      return 1 + countHi(str.substring(0, str.length() - 1));
    }
    return 0 + countHi(str.substring(0, str.length() - 1));
  }

  public String changePi(String str) {
    /*
     * Given a string, compute recursively (no loops)
     * a new string where all appearances of "pi" have been replaced by "3.14".
     */
    if (!str.contains("pi")) {
      return str;
    }
    if (str.length() == 1) {
      return str;
    }
    if (str.length() == 2 && str.charAt(0) != 'p') {
      return str;
    }
    if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {
      return "" + "3.14" + changePi(str.substring(2, str.length()));
    }
    return str.charAt(0) + changePi(str.substring(1, str.length()));
  }

  public String noX(String str) {
    /*
     * Given a string, compute recursively a new string
     * where all the 'x' chars have been removed.
     */
    if (!str.contains("x"))
      return str;
    if (str.length() == 1 && str.charAt(0) != 'x')
      return str;
    if (str.length() == 1 && str.charAt(0) == 'x')
      return "";
    if (str.charAt(0) == 'x')
      return noX(str.substring(1, str.length()));
    return str.charAt(0) + noX(str.substring(1, str.length()));

  }

  public boolean array6(int[] nums, int index) {
    /*
     * Given an array of ints, compute recursively if the array contains a 6.
     * We'll use the convention of considering only the part of the array that
     * begins at the given index. In this way, a recursive call can pass index+1 to
     * move down the array. The initial call will pass in index as 0.
     */
    if (nums.length == 0)
      return false;
    if (index >= nums.length - 1 && nums[index] != 6) {
      return false;
    }
    if (nums[index] == 6) {
      return true;
    } else {
      return array6(nums, index + 1);
    }

  }

  public int array11(int[] nums, int index) {
    /*
     * Given an array of ints, compute recursively the number of times that
     * the value 11 appears in the array. We'll use the convention of considering
     * only the part of the array that begins at the given index. In this way,
     * a recursive call can pass index+1 to move down the array. The initial call
     * will pass in index as 0.
     */
    if (nums.length == 0) {
      return 0;
    }
    if (index >= nums.length - 1) {
      if (nums[index] == 11)
        return 1;
      else
        return 0;
    }
    if (nums[index] == 11) {
      return 1 + array11(nums, index + 1);
    }
    return array11(nums, index + 1);
  }

  public boolean array220(int[] nums, int index) {
    /*
     * Given an array of ints, compute recursively if the array contains somewhere a
     * value
     * followed in the array by that value times 10. We'll use the convention of
     * considering only
     * the part of the array that begins at the given index. In this way, a
     * recursive call can pass
     * index+1 to move down the array. The initial call will pass in index as 0.
     */
    if (nums.length <= 1) {
      return false;
    }
    if (index >= nums.length - 2) {
      if (nums[index + 1] == nums[index] * 10)
        return true;
      else
        return false;
    }
    if (nums[index + 1] == nums[index] * 10) {
      return true;
    }
    return array220(nums, index + 1);
  }

  public String allStar(String str) {
    /*
     * Given a string, compute recursively a new string where all
     * the adjacent chars are now separated by a "*".
     */
    if (str.length() == 0) {
      return "";
    }
    if (str.length() == 1) {
      return str;
    }
    return str.charAt(0) + "*" + allStar(str.substring(1, str.length()));
  }

  public String pairStar(String str) {
    /*
     * Given a string, compute recursively a new string where identical chars
     * that are adjacent in the original string are separated from each other by a
     * "*".
     */
    if (str.length() == 0)
      return "";
    if (str.length() == 1)
      return str;

    if (str.length() == 2) {
      if (str.charAt(0) == str.charAt(1))
        return str.charAt(0) + "*" + str.charAt(1);
      else
        return str;
    }

    if (str.charAt(0) == str.charAt(1)) {
      return str.charAt(0) + "*" + pairStar(str.substring(1, str.length()));
    }

    return str.charAt(0) + pairStar(str.substring(1, str.length()));
  }

  public String endX(String str) {
    /*
     * Given a string, compute recursively a new string where all the lowercase 'x'
     * chars have been moved to the end of the string.
     */
    if (str.length() <= 0) {
      return str;
    }
    if (!str.contains("x")) {
      return str;
    }
    if (str.charAt(0) == 'x') {
      return endX(str.substring(1, str.length())) + "x";
    } else
      return str.charAt(0) + endX(str.substring(1, str.length()));
  }

  public int countPairs(String str) {
    /*
     * We'll say that a "pair" in a string is two instances of a char separated by a
     * char.
     * So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs
     * -- 2 for A and 1 for x.
     * Recursively compute the number of pairs in the given string.
     */
    if (str.length() <= 2) {
      return 0;
    }
    if (str.charAt(0) == str.charAt(2)) {
      return 1 + countPairs(str.substring(1, str.length()));
    } else
      return countPairs(str.substring(1, str.length()));
  }

  public int countAbc(String str) {
    /*
     * Count recursively the total number of "abc" and "aba" substrings that appear
     * in the given string.
     */
    if (str.length() <= 2) {
      return 0;
    }
    if (!str.contains("abc") && !str.contains("aba")) {
      return 0;
    }
    if ((str.charAt(0) == 'a' && str.charAt(1) == 'b' && str.charAt(2) == 'c') ||
        (str.charAt(0) == 'a' && str.charAt(1) == 'b' && str.charAt(2) == 'a')) {
      return 1 + countAbc(str.substring(1, str.length()));
    } else
      return countAbc(str.substring(1, str.length()));
  }

  public int count11(String str) {
    /*
     * Given a string, compute recursively (no loops) the number of "11"
     * substrings in the string. The "11" substrings should not overlap.
     */
    if (!str.contains("11"))
      return 0;
    if (str.length() <= 2)
      return 1;
    if (str.charAt(0) == str.charAt(1)) {
      return 1 + count11(str.substring(2, str.length()));
    } else
      return count11(str.substring(1, str.length()));
  }

  public String stringClean(String str) {
    /*
     * Given a string, return recursively a "cleaned" string where adjacent chars
     * that are the same have been reduced to a single char. So "yyzzza" yields
     * "yza".
     */
    if (str.length() <= 1) {
      return str;
    }
    if (str.charAt(0) == str.charAt(1)) {
      return stringClean(str.substring(1, str.length()));
    } else
      return str.charAt(0) + stringClean(str.substring(1, str.length()));
  }

  public String parenBit(String str) {
    /*Given a string that contains a single pair of parenthesis, compute recursively 
    a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)". */
    if (!str.contains("(")) return "";
    if (str.charAt(0) == '(') {
      return str.substring(0, str.indexOf(")") + 1);
    }
    return parenBit(str.substring(1, str.length()));
  }

  public boolean nestParen(String str) {
  /*Given a string, return true if it is a nesting of zero or more pairs of parenthesis,
   like "(())" or "((()))". Suggestion: check the first and last chars, and then recur 
   on what's inside them. */
  if (str.isEmpty()) return true;
  
  if (str.charAt(0) =='(' && str.charAt(str.length() - 1) == ')') {
    return nestParen(str.substring(1, str.length() - 1));
  }
  return false;
}

  public int strCount(String str, String sub) {
  /*Given a string and a non-empty substring sub, compute recursively the 
  number of times that sub appears in the string, without the sub strings overlapping. */
  if (str.length() <= sub.length() - 1) return 0;
  if (!str.contains(sub)) return 0;
  if (str.substring(0, sub.length()).equals(sub)) {
    return 1 + strCount(str.substring(sub.length(), str.length()), sub);
  }
  return strCount(str.substring(1, str.length()), sub);
}

  public boolean strCopies(String str, String sub, int n) {
    if (n == 0) return true;
    if (!str.contains(sub)) return false;
    if (str.length() <= sub.length() - 1) return false;
  
    if (str.substring(0, sub.length()).equals(sub)) {
      return strCopies(str.substring(1, str.length()), sub, n - 1);
    }
    return strCopies(str.substring(1, str.length()), sub, n);
  }













}// end class