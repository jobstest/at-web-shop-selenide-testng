package models;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {

    public static final String endpoint = "/user";

    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String conf_password;

    private boolean male;
    private boolean female;
}
