namespace src
{
    public static class PwdTools
    {
        public const string LowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        public const string UppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        public const string Digits = "0123456789";
        public const string SpecialCharacters = "!@#$%^&*()_-+=<>?";

        public static string GenerateRandomPassword(int length, bool includeLowercase, bool includeUppercase, bool includeDigits, bool includeSpecialCharacters)
        {
            var characterPool = string.Empty;
            if (includeLowercase)
                characterPool += LowercaseLetters;
            if (includeUppercase)
                characterPool += UppercaseLetters;
            if (includeDigits)
                characterPool += Digits;
            if (includeSpecialCharacters)
                characterPool += SpecialCharacters;

            var random = new Random();
            var password = new string(Enumerable.Repeat(characterPool, length)
                .Select(s => s[random.Next(s.Length)]).ToArray());

            return password;
        }
    }
}