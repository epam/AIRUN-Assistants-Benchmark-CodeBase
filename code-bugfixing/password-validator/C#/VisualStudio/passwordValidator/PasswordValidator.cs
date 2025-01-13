using System.Text.RegularExpressions;


    public class PasswordValidator
    {
        // The password must contain at least 8 characters, including one uppercase letter, one lowercase letter, one number,
        // and one special character. Whitespace is not allowed
        private static readonly string PASSWORD_REGEX =
            @"^(?=.*[0-9])" +
            @"(?=.*[a-z])" +
            @"(?=.*[A-Z])" +
            @"(?=*[@#$%^&+=])" +
            @"(?=\S+$)" +
            @".{10}";

        private static readonly Regex PASSWORD_PATTERN = new Regex(PASSWORD_REGEX);

        public static bool IsValidPassword(string password)
        {
            if (password == null)
            {
                return false;
            }
            Match match = PASSWORD_PATTERN.Match(password);
            return match.Success;
        }
    }




