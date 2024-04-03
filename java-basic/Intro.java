// to run this
// 1. compile this file using `java Intro.java`
// 2. run the compiled file `.class` using `java Intro`
import java.lang.*;


public class Intro {
  public static void main(String[] args) {
    
    // <data_type> <identifier> = <literal>;
    char c = 's';

    boolean isAdult = false;
    short si = 1;
    int x = 10;
    int y = 20;
    long long_x = 100_000000;

    float f_x = 10.33f;
    double d_x = 10;  // by default decimal number is double

    String ss = "hello Deepanshu";

    String pyramid = "* \n* * \n* * * \n* * * *\n* * * * *";

    System.out.println(isAdult);
    System.out.println(si);
    System.out.println(f_x);
    System.out.println(d_x);
    System.out.println(ss);

    System.out.println(pyramid);
  }
}
