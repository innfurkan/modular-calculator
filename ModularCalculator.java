import java.util.Scanner;
import java.util.ArrayList;

public class Modula {
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);

        System.out.println("Modular Calculator");

        int convertA = 0;

        String userAnswer = "";
        String a; // dividend
        int c; // divisor

        int b = 0; // base
        int e = 0; // exponent
        int calExpo = 0; // it will use instead of e, to not lose real e
        int result = 1; // remainder
        int resultTwo = 1;

        int i; // variable for 'for' method
        int f = 1;

        int twoExponent = 0; // Convert to the exponent in the form of a power of two

        boolean checkStatement = false; // check the dividend types
        boolean statement = true;

        while(statement){
            System.out.print("Enter the values in a mod(c) type or b^e mod(c) type");
            System.out.println(" (Must be in same line)");
            System.out.print("Enter dividend value (a): ");
            a = scnr.nextLine(); // dividend
            System.out.print("Enter divisor value (c): ");
            c = scnr.nextInt(); // divisor

            twoExponent = 0;
            b = 0; // base
            e = 0; // exponent
            calExpo = 0; // it will use instead of e, to not lose real e
            result = 1; // remainder
            resultTwo = 1;

            // check is the dividend in basic or complex form
            if(a.contains("^")){
                for(i = 0; i< a.length(); ++i){
                    if(a.charAt(i) == '^'){
                        e = Integer.parseInt(a.substring(i+1, a.length()));
                        b = Integer.parseInt(a.substring(0, i));
                        calExpo = e;
                        checkStatement = true;
                        //System.out.println("Base: " + b + "\nExponent: " + e);
                    }
                }
            }
            else {
                convertA = Integer.parseInt(a);
                if (c > convertA){
                    System.out.println("Divisor less than dividend -> " + a + " mod(" + c + ") = " + a);
                }
                else if (c==convertA){System.out.println("Divisor equal to dividend -> " + a +
                        " mod(" + c + ") = 0");}
                else{
                    result = convertA % c;
                    System.out.println("Divisor greater than dividend -> " + a +
                            " mod(" + c + ") = " + result);
                }
            }

            if(checkStatement){
                //System.out.println("Complete task 1");
                while(e>Math.pow(2,twoExponent+1)){
                    twoExponent++;
                }
                for(i=twoExponent; i>=0; --i){
                    System.out.println("Task 5 Completed || i = " + i);
                    if(Math.pow(2,i) <= calExpo){
                        resultTwo = (int) (Math.pow(b,Math.pow(2,1)) % c);
                        for(f=1; f<=i; ++f){
                            resultTwo %= c;
                            resultTwo = (int) Math.pow(resultTwo,2);
                            System.out.println("Process: " + Math.sqrt(resultTwo));
                        }
                        calExpo -= Math.pow(2,i);
                        resultTwo = (int)Math.sqrt(resultTwo);
                        result *= resultTwo % c;
                        result %= c;
                        System.out.println("Task 6 Completed (" + (twoExponent - i) + ") || Result: " + result);
                    }
                }
                //System.out.println("Result: " + result);
                //result = result % c;
            }

            System.out.println("Remainder: " + result);
            //System.out.println("Result 2: " + (Math.pow(b,Math.pow(2,1)) % c));
            scnr.nextLine();
            System.out.println("Do you want to continue? Y/N");
            userAnswer = scnr.nextLine();

            if(userAnswer.equalsIgnoreCase("Y") || userAnswer.equalsIgnoreCase("Yes")){
                statement = true;
                System.out.println("");
            }
            else if(userAnswer.equalsIgnoreCase("N") || userAnswer.equalsIgnoreCase("No")){
                statement = false;
            }
            else{
                System.out.println("");
                System.out.println("Invalid input");
                System.out.println("Do you want to continue? Y/N");
                userAnswer = scnr.nextLine();
            }
        }


    }
}
