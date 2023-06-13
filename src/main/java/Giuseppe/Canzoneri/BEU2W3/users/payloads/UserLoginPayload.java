package Giuseppe.Canzoneri.BEU2W3.users.payloads;

import lombok.Getter;

@Getter
public class UserLoginPayload {
    String userName;
    String password;
}