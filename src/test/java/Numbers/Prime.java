package Numbers;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Администратор on 20.10.2014.
 */
public class Prime {
//    public static void main (String[] args) {
//
//        System.out.println(isPrime(3));
//    }

    @Test()
    public void isPrimeTest(){

        Assert.assertEquals(isPrime(11),true);
    }

    private static boolean isPrime (int n){
        if (n%2 == 0){
            return false;
        }
        for (int i = 3; i*i <=n ; i+=2) {
            if(n%i == 0){
                return false;
            }
        }
        return true;
        }
    }