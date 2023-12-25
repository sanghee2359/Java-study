package ps.recursive;


import java.util.Scanner;

public class BinaryNumber {
    private void BinaryTransform(int decimalNum) {
        if(decimalNum == 0) return;
        else {
            BinaryTransform(decimalNum/2);
            System.out.print(decimalNum%2);

        }
    }
    public static void main(String[] args) {
        BinaryNumber O = new BinaryNumber();
        Scanner in = new Scanner(System.in);
        int decimalNum = in.nextInt();
        O.BinaryTransform(decimalNum);
    }

}
