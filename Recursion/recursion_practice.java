public class recursion_practice {
    public static void main(String[] args) {
        System.out.println("Number of cat eyes: " + catEyes(6));
        System.out.println("Power: " + power(2, 8));
        System.out.println("Factorial: " + factorial(10));
        System.out.println("Number of Speakers: " + speakers(6));
        System.out.println("Sum of numbers: " + sum(123));
        System.out.println("Fibonacci: " + fibonacci(6));
        System.out.println("Number of 5's: " + countDigit(55511152));
    }// end main

    public static int catEyes(int n) {
        if (n == 0) {
            return 0;
        } else {
            return 2 + catEyes(n - 1);
        }
    }// end catEyes

    public static int power(int base, int power) {
        if (power < 1) {
            return 1;
        } else {
            return base * power(base, power - 1);
        }
    }// end power

    public static int factorial(int x) {
        if (x <= 1) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }// end factorial

    public static int speakers(int phone) {
        if (phone == 0) {
            return 0;
        } else if (phone % 2 == 1) {
            return 1 + speakers(phone - 1);
        } else {
            return 2 + speakers(phone - 1);
        }
    }// end speakers

    public static int sum(int x) {
        if (x <= 9) {
            return x;
        } else {
            return x % 10 + sum(x / 10);
        }
    }// end sum

    public static int fibonacci(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            //System.out.println(x);
            return fibonacci(x - 1) + fibonacci(x - 2);
        }
    }//end fiboncci

    public static int countDigit(int num) {
        if (num <= 9) {
            if (num == 5) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (num % 10 == 5) {
                return 1 + countDigit(num / 10);
            } else {
                return 0 + countDigit(num / 10);
            }
        }
    }
}// end class