import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "abcd";
        String password = "123";
        String confirmPassword = "1023";
        try {
            Validator.validate(login, password, confirmPassword);
            System.out.println("Валидация прошла успешно");
        } catch (WrongLoginException | WrongPasswordException exception) {
            exception.printStackTrace();
        }
        System.out.println("Валидация завершена");
    }
}
