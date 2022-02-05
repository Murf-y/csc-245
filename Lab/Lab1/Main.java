package Lab1;
public class Main{
    public static void main(String[] args) {

        // Using our function
        System.out.println(decimalToBinary(20)); // should give 10100
        System.out.println(binaryToDecimal("10100")); // should give 20
        printDivisibility();
    }

    // Write a function that convert from decimal to binary
    public static String decimalToBinary(int number){
        // Takes a integer number and 
        // return a binary string representing that number in base 2

        String binary = "";
        while(number > 0){
            binary = number % 2 + binary;
            number = number / 2;
        }
        return binary;
    }
    // Write a function that convert from binary to decimal
    public static int binaryToDecimal(String binary){
        // Takes a binary string and 
        // return a decimal number representing that number in base 10

        int decimal = 0;
        int power = binary.length() - 1;
        // 101110 
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '1'){
                decimal += Math.pow(2, power);
            }
            power--;
        }
        return decimal;
    }

    // Write a function that print number from 0 to 100 that are
    // divisible by 3
    // divisible by 5
    // divisibile by 3 and 5
    // using 3 different loops
    public static void printDivisibility(){

        System.out.println("Divisible By 3");
        for(int i = 0; i<= 100; i++){
            if(i%3 == 0){
                System.out.print(i+",");
            }
        }
        System.out.println("\nDivisible By 5");
        int j =0;
        while(j <=100){
            if(j%5==0){
                System.out.print(j+",");
            }
            j++;
        }

        System.out.println("\nDivisible By 3 and 5");
        int k =0;
        do{
            if((k%3==0) && (k%5==0)){
                System.out.print(k+",");
            }
            k++;
        }while(k < 100);
        
    }
}