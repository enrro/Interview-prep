import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1 {

    static int MAX = 100000005;
    static List<Integer> primes = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        int noTests  = Integer.parseInt(br.readLine());
        int i = 1;

        while(i <= noTests){
            int adaNumber = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("Case #"+ i + ": ");
            Sieve();
            // System.out.println(primeNumber.get(primeNumber.size()-2));
            // System.out.println(primeNumber.get(primeNumber.size()-1));
            
            int closestMultiple = moreThanBinarySearch(0, primes.size() - 1, (int)Math.sqrt(adaNumber) + 1);
            int closestMultiple1 = lessThanBinarySearch(0, primes.size() - 1, closestMultiple);
            
            int mult = closestMultiple * closestMultiple1;

            if(mult > adaNumber){
                mult = closestMultiple1 * lessThanBinarySearch(0, primes.size() - 1, closestMultiple1);
            }
            sb.append(mult);

            System.out.println(sb.toString());

            i++;
        }
    }

    static int moreThanBinarySearch(int left,int right,int n)
    {
        if (left <= right)
        {
            int mid = (left + right) / 2;
    
            // base condition is, if we are reaching at left
            // corner or right corner of primes[] array then
            // return that corner element because before or
            // after that we don't have any prime number in
            // primes array
            if (mid == 0 || mid == primes.size() - 1)
                return primes.get(mid);
    
            // now if n is itself a prime so it will be present
            // in primes array and here we have to find nearest
            // prime less than n so we will return primes[mid-1]
            if (primes.get(mid) == n)
                return primes.get(mid + 1);
    
            // now if primes[mid]<n and primes[mid+1]>n that
            // mean we reached at nearest prime
            if (primes.get(mid) > n && primes.get(mid - 1) < n)
                return primes.get(mid);
            if (n < primes.get(mid))
                return moreThanBinarySearch(left, mid - 1, n);
            else
                return moreThanBinarySearch(mid + 1, right, n);
        }
        return 0;
    }
    
    static int lessThanBinarySearch(int left,int right,int n)
    {
        if (left <= right)
        {
            int mid = (left + right) / 2;
      
            // base condition is, if we are reaching at left
            // corner or right corner of primes[] array then
            // return that corner element because before or
            // after that we don't have any prime number in
            // primes array
            if (mid == 0 || mid == primes.size() - 1)
                return primes.get(mid);
      
            // now if n is itself a prime so it will be present
            // in primes array and here we have to find nearest
            // prime less than n so we will return primes[mid-1]
            if (primes.get(mid) == n)
                return primes.get(mid - 1);
      
            // now if primes[mid]<n and primes[mid+1]>n that
            // mean we reached at nearest prime
            if (primes.get(mid) < n && primes.get(mid + 1) > n)
                return primes.get(mid);
            if (n < primes.get(mid))
                return lessThanBinarySearch(left, mid - 1, n);
            else
                return lessThanBinarySearch(mid + 1, right, n);
        }
        return 0;
    }

// Utility function of Sieve of Sundaram
    static void Sieve()
    {
        int n = MAX;
    
        // In general Sieve of Sundaram, produces primes
        // smaller than (2*x + 2) for a number given
        // number x
        int nNew = (int)Math.sqrt(n);
    
        // This array is used to separate numbers of the
        // form i+j+2ij from others where 1 <= i <= j
        int[] marked = new int[n / 2 + 500];
    
        // eliminate indexes which does not produce primes
        for (int i = 1; i <= (nNew - 1) / 2; i++)
            for (int j = (i * (i + 1)) << 1; 
                    j <= n / 2; j = j + 2 * i + 1)
                marked[j] = 1;
    
        // Since 2 is a prime number
        primes.add(2);
    
        // Remaining primes are of the form 2*i + 1 such
        // that marked[i] is false.
        for (int i = 1; i <= n / 2; i++)
            if (marked[i] == 0)
                primes.add(2 * i + 1);
    }
}
