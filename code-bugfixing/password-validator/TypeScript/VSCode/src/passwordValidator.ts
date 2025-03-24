export class passwordValidator {

    // The password must contain at least 8 characters, including one uppercase letter, one lowercase letter, one number,
    // and one special character. Whitespace is not allowed
    private static readonly PASSWORD_REGEX: RegExp = new RegExp(
        "^(?=[0-9])" +
        "(?=.*[a-z])" +
        "(?=.*[A-Z])" +
        "(?=.*[@#$%^&+=])" +
        "(?=\\S+$)" +
        ".{8}$"
    );

    public static isValidPassword(password: string | null): boolean {
        if (password === null) {
            return false;
        }
        return passwordValidator.PASSWORD_REGEX.test(password);
    }
}