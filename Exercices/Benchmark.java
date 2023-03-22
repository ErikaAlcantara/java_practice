import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Benchmark {
    public static long fibonacci(int n) {
        int f0 = 0, f1 = 1;
        for (int i = 1; i <= n; ++i) {
            // System.out.println(f0);
            int fNew = f0 + f1;
            f0 = f1;
            f1 = fNew;
        }
        return f0;
    }

    public static long fibRecursive(int n) {
        if (n <= 1) return n;
        // System.out.println(fibRecursive(n - 1) + fibRecursive(n - 2));
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static BigInteger factorialBig(int n) {
        BigInteger result = BigInteger.ONE;
    
        for (int i = 2; i <= n; ++i) {
            result = result.multiply(BigInteger.valueOf(i));
            System.out.println(result);
        }
        return result;
    }

    public static BigInteger facRecursiveBig(int n){
    BigInteger one = BigInteger.ONE;
    BigInteger factorial = BigInteger.valueOf(n);

    if(n == 0)
    return one;
    System.out.println(factorial.multiply(facRecursiveBig(n-1)));
    return factorial.multiply(facRecursiveBig(n-1));
    }

    public static List calculateNanoTime (){
        List<Long> benchmarkList = new ArrayList<>();
        for (int i = 0; i <= 100; i++){
            long start = System.nanoTime();
            facRecursiveBig(20);
            long elapsedTime = System.nanoTime() - start;
            benchmarkList.add(elapsedTime);
        }
        System.out.println(benchmarkList);
        benchmarkList.sort(null);
        return benchmarkList;
    }

    public static List calculateTimeMillis (){
        List<Long> benchmarkList = new ArrayList<>();
        for (int i = 0; i <= 100; i++){
            long start = System.currentTimeMillis();
            facRecursiveBig(20);
            long elapsedTime = System.currentTimeMillis() - start;
            benchmarkList.add(elapsedTime);
        }
        System.out.println(benchmarkList);
        benchmarkList.sort(null);
        return benchmarkList;
    }


    public static void main(String[] args) {
        System.out.println(calculateNanoTime()); 
    
        System.out.println(calculateTimeMillis());
        
    }
}
