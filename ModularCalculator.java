import java.util.ArrayList;
import java.util.Scanner;

public class ModularCalculator {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("============================");
        System.out.println("     Modular Calculator");
        System.out.println("============================");

        boolean running = true;

        while (running) {
            ArrayList<Integer> savedValues = new ArrayList<>();
            boolean calculationSuccessful = false;

            System.out.print("\nEnter a number or exponential expression ");
            System.out.print("(examples: 17 or 5^13): ");

            String expression = scnr.nextLine().trim();

            System.out.print("Enter modulus c: ");
            String modulusInput = scnr.nextLine().trim();

            try {
                int c = Integer.parseInt(modulusInput);
                if (c <= 0) {
                    System.out.println("Error: modulus must be greater than 0.");
                    continue;
                }
                // Exponential modular calculation
                if (expression.contains("^")) {
                    String[] parts = expression.split("\\^");
                    if (parts.length != 2) {
                        System.out.println("Invalid exponential expression.");
                        continue;
                    }
                    int b = Integer.parseInt(parts[0].trim());
                    int e = Integer.parseInt(parts[1].trim());
                    if (e < 0) {
                        System.out.println("Negative exponents are not supported yet.");
                        continue;
                    }

                    int result = modularExponentiation(b, e, c);
                    savedValues = learnSave(b, e, c, result);
                    calculationSuccessful = true;
                    System.out.println(b + "^" + e + " mod(" + c + ") = " + result);
                }

                // Normal modulo calculation
                else {
                    int a = Integer.parseInt(expression);
                    int result = Math.floorMod(a, c);
                    savedValues = learnSave(a, -1, c, result);
                    calculationSuccessful = true;
                    System.out.println(a + " mod(" + c + ") = " + result);
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integer values.");
            }

            if(calculationSuccessful) {
                System.out.println("Would you like to learn how to solve this problem? Y/N");
                boolean learningShow = checkingAnswer(scnr);
                if (learningShow) {
                    if (savedValues.get(1) < 0) {
                        learningSimulationBasic(savedValues);
                    }
                    else {
                        learningSimulationComplex(savedValues);
                    }
                }
            }
            System.out.print("\nDo you want to continue? Y/N: ");
            running = checkingAnswer(scnr);

        }
        System.out.println("\nModular Calculator closed.");
        scnr.close();
    }

    public static int modularExponentiation(int base, int exponent, int modulus) {

        long result = 1 % modulus;
        long currentBase = Math.floorMod(base, modulus);

        int currentExponent = exponent;

        while (currentExponent > 0) {
            // If exponent is odd
            if (currentExponent % 2 == 1) {result = (result * currentBase) % modulus;}
            // Square the base
            currentBase = (currentBase * currentBase) % modulus;
            // Divide exponent by 2
            currentExponent /= 2;
        }
        return (int) result;
    }

    public static boolean checkingAnswer(Scanner scnr) {

        for (int attempt = 0; attempt < 2; attempt++) {
            String answer = scnr.nextLine().trim();
            if (answer.equalsIgnoreCase("Y") ||
                    answer.equalsIgnoreCase("Yes")) {return true;}
            if (answer.equalsIgnoreCase("N") ||
                    answer.equalsIgnoreCase("No")) {return false;}
            if (attempt == 0) {System.out.println("Invalid input. Please enter Y or N:");}
        }
        System.out.println("Invalid response.");
        return false;
    }

    public static ArrayList<Integer> learnSave(int b, int e, int c, int result) {
        ArrayList<Integer> savedValues = new ArrayList<>();
        savedValues.add(b);
        savedValues.add(e);
        savedValues.add(c);
        savedValues.add(result);
        return savedValues;
    }

    public static void learningSimulationBasic(ArrayList<Integer> savedValues) {
        int a = savedValues.get(0);
        int c = savedValues.get(2);
        int result = savedValues.get(3);

        int quotient = Math.floorDiv(a, c);

        System.out.println("\n============================");
        System.out.println("       LEARNING MODE");
        System.out.println("============================");

        System.out.println("\nProblem: (Basic)");
        System.out.println(a + " mod(" + c + ")");

        System.out.println("\nStep 1: Divide " + a + " by " + c + ".");

        System.out.println(
                a + " = (" + c + " * " + quotient + ") + " + result
        );

        System.out.println("\nStep 2: Find the remainder.");

        System.out.println(
                "The remainder after dividing " + a +
                        " by " + c + " is " + result + "."
        );

        System.out.println("\nTherefore:");
        System.out.println(a + " mod(" + c + ") = " + result);
        System.out.println("============================");
    }

    public static void learningSimulationComplex(ArrayList<Integer> savedValues) {

        int b = savedValues.get(0);
        int e = savedValues.get(1);
        int c = savedValues.get(2);
        int finalResult = savedValues.get(3);

        long result = 1 % c;
        long currentBase = Math.floorMod(b, c);
        int currentExponent = e;

        int step = 1;

        System.out.println("\n============================");
        System.out.println("       LEARNING MODE");
        System.out.println("============================");

        System.out.println("\nProblem:");
        System.out.println(
                b + "^" + e + " mod(" + c + ")"
        );

        System.out.println(
                "\nExponent " + e + " in binary is " +
                        Integer.toBinaryString(e)
        );

        System.out.println(
                "\nWe will use binary modular exponentiation."
        );

        System.out.println(
                "Starting result = " + result
        );

        System.out.println(
                "Starting base = " + b +
                        " mod(" + c + ") = " + currentBase
        );

        while (currentExponent > 0) {

            System.out.println("\n----------------------------");
            System.out.println("Step " + step);
            System.out.println("----------------------------");

            System.out.println(
                    "Current exponent = " + currentExponent
            );

            System.out.println(
                    "Current base = " + currentBase
            );

            System.out.println(
                    "Current result = " + result
            );

            if (currentExponent % 2 == 1) {

                System.out.println(
                        "\n" + currentExponent +
                                " is odd, so multiply the result by the current base."
                );

                long oldResult = result;

                result = (result * currentBase) % c;

                System.out.println(
                        "result = (" +
                                oldResult + " * " +
                                currentBase + ") mod(" +
                                c + ")"
                );

                System.out.println(
                        "result = " + result
                );
            }

            else {

                System.out.println(
                        "\n" + currentExponent +
                                " is even, so we do not multiply it into the result."
                );
            }

            long oldBase = currentBase;

            currentBase =
                    (currentBase * currentBase) % c;

            System.out.println(
                    "\nSquare the current base:"
            );

            System.out.println(
                    "base = (" +
                            oldBase + " * " +
                            oldBase + ") mod(" +
                            c + ")"
            );

            System.out.println(
                    "base = " + currentBase
            );

            int oldExponent = currentExponent;

            currentExponent /= 2;

            System.out.println(
                    "\nDivide the exponent by 2:"
            );

            System.out.println(
                    oldExponent + " / 2 = " +
                            currentExponent
            );

            step++;
        }
        System.out.println("\n============================");
        System.out.println("Final Answer:");
        System.out.println(b + "^" + e + " mod(" + c + ") = " + finalResult);
        System.out.println("============================");
    }
}