import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> findArmstrong(int number) {

            int originalNumber, remainder, a = 1;
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            ArrayList<Integer> armstrongNumber = new ArrayList<Integer>();

            for (int i = 1; i <= number; i++) {
                numbers.add(i);
            }
            while (a <= numbers.size()) {
                int result = 0, n = 0;
                number = numbers.get((a - 1));
                originalNumber = number;
                if (originalNumber >= 10) {
                    while (originalNumber != 0) {
                        originalNumber /= 10;
                        n++;
                    }
                }
                originalNumber = number;

                if (originalNumber >= 10) {
                    while (originalNumber != 0) {
                        remainder = originalNumber % 10;
                        result += Math.pow(remainder, n);
                        originalNumber /= 10;
                    }
                }
                if (result == number) {
                    armstrongNumber.add(number);
                }
                a++;
            }return armstrongNumber;
    }
    public static ArrayList<Integer> findEmirp(int number) {

            int originalNumber, remainder, a = 1;

            ArrayList<Integer> numbers = new ArrayList<Integer>();
            ArrayList<Integer> emirpNumbers = new ArrayList<Integer>();
            for (int i = 1; i <= number; i++) {
                numbers.add(i);
            }
            while (a <= numbers.size()) {
                String tempReverseNumber = "";
                number = numbers.get(a-1);
                originalNumber = number;

                while (originalNumber != 0) {
                    remainder = originalNumber % 10;
                    tempReverseNumber += String.valueOf(remainder);
                    originalNumber /= 10;
                }
                a++;

                int reverseNumber = Integer.parseInt(tempReverseNumber);
                if(number >= 13 && isPrime(number) && isPrime(reverseNumber) && number != reverseNumber){
                    emirpNumbers.add(number);
                }
            }return emirpNumbers;
    }
    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
    public static ArrayList<Integer> findAbundant(int number)  {

            int a = 1;
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();

            for (int i = 1; i <= number; i++) {
                numbers.add(i);
            }
            while(a<=numbers.size()){
                int sum = 0;
                number = numbers.get(a-1);
                for (int i = 1; i < number ; i++) {
                    if (number % i == 0)
                        sum += i;
                }
                if (sum > number)
                    abundantNumbers.add(number);
                a++;
                sum = 0; // We reset the total value to be able to calculate the total for each value
            }return abundantNumbers;
    }

    public static void main(String[] args) {
      //Scanner input = new Scanner(System.in);
      //String Dosya = input.nextLine();
      try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt",true))){
          try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(args[0])))){
              while(scanner.hasNextLine()){
                  String Line = scanner.nextLine();
                  if(Line.startsWith("Exit")){
                      writer.write("Finished...\n");
                  }
                  if(Line.startsWith("Armstrong")){
                      String stringNumber = scanner.nextLine();
                      int number = Integer.parseInt(stringNumber);
                      ArrayList <Integer> armstrongNumber = findArmstrong(number);

                      writer.write("Armstrong numbers up to "+ number +":\n");
                      for(int i=0; i<armstrongNumber.size();i++){
                          writer.write(armstrongNumber.get(i)+" ");
                      }
                      writer.write("\n"+"\n");
                  }
                  if(Line.startsWith("Emirp")){
                      String stringNumber = scanner.nextLine();
                      int number = Integer.parseInt(stringNumber);
                      ArrayList<Integer> emirpNumbers = findEmirp(number);
                      writer.write("Emirp numbers up to "+ number +":\n");
                      for(int i=0; i<emirpNumbers.size();i++){
                          writer.write(emirpNumbers.get(i)+" ");
                      }
                      writer.write("\n"+"\n");
                  }
                  if(Line.startsWith("Abundant")){
                      String stringNumber = scanner.nextLine();
                      int number = Integer.parseInt(stringNumber);
                      ArrayList<Integer> abundantNumbers = findAbundant(number);
                      writer.write("Abundant numbers up to "+ number +":\n");
                      for(int i=0; i<abundantNumbers.size();i++){
                          writer.write(abundantNumbers.get(i)+" ");
                      }
                      writer.write("\n"+"\n");
                  }
                  if(Line.startsWith("Ascending")){
                      ArrayList<Integer> ascendingNumbers = new ArrayList<Integer>();
                      writer.write("Ascending order sorting: \n");
                      while(true){
                          String stringNumber = scanner.nextLine();
                          int number = Integer.parseInt(stringNumber);
                          if (number != -1){
                              ascendingNumbers.add(number);
                              ascendingNumbers.sort(Comparator.naturalOrder());
                              for(int i = 0;i < ascendingNumbers.size();i++){
                                  writer.write(ascendingNumbers.get(i)+" ");
                              }
                              writer.write("\n");
                          }
                          else{
                              break;
                          }
                      }
                      writer.write("\n");
                  }
                  if(Line.startsWith("Descending")){
                      ArrayList<Integer> descendingNumbers = new ArrayList<Integer>();
                      writer.write("Descending order sorting: \n");
                      while(true){
                          String stringNumber = scanner.nextLine();
                          int number = Integer.parseInt(stringNumber);

                          if (number != -1){
                              descendingNumbers.add(number);
                              descendingNumbers.sort(Comparator.reverseOrder());
                              for(int i = 0;i < descendingNumbers.size();i++){
                                  writer.write(descendingNumbers.get(i)+" ");
                              }
                              writer.write("\n");
                          }
                          else{
                              break;
                          }
                      }
                      writer.write("\n");
                  }
              }
          } catch (FileNotFoundException e) {
              throw new RuntimeException(e);
          }
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
    }
}