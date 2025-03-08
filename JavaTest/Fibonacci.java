import java.util.Scanner;

public class Fibonacci
 {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Input: ");
        int num = sc.nextInt();
        FibonacciEx(num);

    }

    public static void FibonacciEx(int num) 
    {
        int p = 0, q = 1;
        for (int i = 0; i < num; i++) {
            System.out.print(p + " ");
            int next = p + q;
            p = q;
            q = next;
        }
    }
}