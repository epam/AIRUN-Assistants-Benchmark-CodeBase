public class NumberHelper {

    public static int FindLargestEvenNumber(List<int> numbers)
    {
        return numbers.Where(n => n % 2 == 0)
            .OrderByDescending(n => n)
            .First();
    }
}
