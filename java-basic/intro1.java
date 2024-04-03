class Students {
  int rollNumber = 10;

  public Students(int rollNum){
    this.rollNumber = rollNum;
  }

  public void display() {
    System.out.println(
      "Roll Number: " + rollNumber + " and " + this.rollNumber
    );
  }

  public static void static_display() {
    System.out.println("calling static method");
  }
}



public class Main {
  public static void main(String[] args) {

    int[] arr1 = {1, 2, 3, 4, 5};
    int[] arr2 = new int[10];

    Students s1 = new Students(2000);
    

    System.out.println(arr1);
    System.out.println(arr2);
    System.out.println(arr1.length);
    s1.display();
    Students.static_display();
    System.out.println(s1.rollNumber);
  }
}
