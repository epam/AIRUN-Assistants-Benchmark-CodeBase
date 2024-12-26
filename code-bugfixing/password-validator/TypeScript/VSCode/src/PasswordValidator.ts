export class PasswordValidator {

    // Regular expression for a strong password
    private static readonly PASSWORD_REGEX: RegExp = new RegExp(
        "^(?=.*[0-9])" +
        "(?=.*[a-z])" +
        "(?=.*[A-Z])" +
        "(?=.*[@#$%^&+=!])" +
        "(?=\\S+$)" +
        ".{8,}$"
    );

    public static isValidPassword(password: string | null): boolean {
        if (password === null) {
            return false;
        }
        return PasswordValidator.PASSWORD_REGEX.test(password);
    }
}