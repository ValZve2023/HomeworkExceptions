import exception.WrongLoginException;
import exception.WrongPasswordException;

import javax.security.auth.login.LoginException;

public class Validator {
    private static final String LEGAL_CHARACTERS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789_";
    private static final int MAX_LENGTH = 20;
    private static String login;
    private static String password;
    private static String confirmPassword;

    public static void validate(
            String login,
            String password,
            String confirmPassword
    ) {
        validateLogin(login);
        validatePassword(password, confirmPassword);
    }

    public static void validateLogin(String login) {
        for (int i = 0; i < login.length(); i++) {
            if (LEGAL_CHARACTERS.indexOf(login.charAt(i)) == -1) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            }
            if (login.length() > MAX_LENGTH) {
                throw new WrongLoginException("Слишком длинный логин. Допустимое количество символов = " + MAX_LENGTH);
            }
        }
    }

    public static void validatePassword(String password, String confirmPassword) {
        for (int i = 0; i < password.length(); i++) {
            if (LEGAL_CHARACTERS.indexOf(password.charAt(i)) == -1) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            }
            if (password.length() > MAX_LENGTH) {
                throw new WrongPasswordException("Слишком длинный пароль. Допустимое количество символов = " + MAX_LENGTH);
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пaроли не совпадают!");
            }
        }
    }
}

