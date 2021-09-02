package testData;
import models.User;
import static utils.InputsGenerator.*;
public class Users {
    public static final User user = User.builder().email("test_web_shop@mail.ru").password("Selenium123").build();

    public static User getUserRandomData(){
        User user = User.builder()
                .first_name(getShortLatinStr())
                .last_name(getShortLatinStr())
                .email(getRandomEmail())
                .build();
        return user;
    }
}
