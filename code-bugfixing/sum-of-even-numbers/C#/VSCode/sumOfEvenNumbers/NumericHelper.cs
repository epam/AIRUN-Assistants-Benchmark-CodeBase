public class NumericHelper {

    public static int SumOfEvenNumbers(int start, int end)
    {
        int sum = 0;
        for (int i = start; i <= end; i++)
        {
            if (i % 2 != 0)
            {
                sum += i;
            }
        }
        return sum;
    }
    //I expect a sum of even numbers but get an error. Please fix it.
 
}




