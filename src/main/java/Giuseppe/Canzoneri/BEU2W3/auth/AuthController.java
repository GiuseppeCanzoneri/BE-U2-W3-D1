package Giuseppe.Canzoneri.BEU2W3.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Giuseppe.Canzoneri.BEU2W3.auth.payloads.AuthenticationSuccessfullPayload;
import Giuseppe.Canzoneri.BEU2W3.exception.NotFoundException;
import Giuseppe.Canzoneri.BEU2W3.exception.UnauthorizedException;
import Giuseppe.Canzoneri.BEU2W3.users.User;
import Giuseppe.Canzoneri.BEU2W3.users.UsersService;
import Giuseppe.Canzoneri.BEU2W3.users.payloads.UserCreatePayload;
import Giuseppe.Canzoneri.BEU2W3.users.payloads.UserLoginPayload;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UsersService usersService;
	@Autowired
	private PasswordEncoder bcrypt;

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody @Validated UserCreatePayload body) {

		body.setPassword(bcrypt.encode(body.getPassword()));
		User createdUser = usersService.create(body);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationSuccessfullPayload> login(@RequestBody UserLoginPayload body)
			throws NotFoundException {

		User user = usersService.findByUserName(body.getUserName());

		String plainPW = body.getPassword();
		String hashedPW = user.getPassword();

		if (!bcrypt.matches(plainPW, hashedPW))
			throw new UnauthorizedException("Credenziali non valide");

		String token = JWTTools.createToken(user);
		return new ResponseEntity<>(new AuthenticationSuccessfullPayload(token), HttpStatus.OK);
	}

}