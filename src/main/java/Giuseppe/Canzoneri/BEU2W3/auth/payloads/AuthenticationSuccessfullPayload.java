package Giuseppe.Canzoneri.BEU2W3.auth.payloads;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationSuccessfullPayload {
    private String accessToken;
}