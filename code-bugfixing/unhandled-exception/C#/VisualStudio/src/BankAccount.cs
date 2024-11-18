namespace src
{
    public class BankAccount
    {
        public static void CheckBalance(double initialAmount, List<double> credits, List<double> debits)
        {
            ValidateInputs(initialAmount, credits, debits);

            Console.WriteLine("Initial amount: " + initialAmount);
            Console.WriteLine("Credits: " + credits);
            Console.WriteLine("Debits: " + debits);
        }

        public static void ValidateInputs(double initialAmount, List<double> credits, List<double> debits)
        {
            if (credits == null)
            {
                throw new ArgumentNullException(nameof(credits), "Credits list cannot be null.");
            }

            if (debits == null)
            {
                throw new ArgumentNullException(nameof(debits), "Debits list cannot be null.");
            }
        }
    }
}