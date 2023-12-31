package Giuseppe.Canzoneri.BEU2W3.users;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Giuseppe.Canzoneri.BEU2W3.exception.NotFoundException;
import Giuseppe.Canzoneri.BEU2W3.users.payloads.UserCreatePayload;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;

	// testata OK
	@GetMapping("")
	public Page<User> getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy) {
		return usersService.find(page, size, sortBy);
	}

	// testata OK
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public User saveUser(@RequestBody @Validated UserCreatePayload body) {
		return usersService.create(body);
	}

	// testata OK
	@GetMapping("/{userId}")
	public User getUser(@PathVariable UUID userId) throws Exception {
		return usersService.findById(userId);
	}

	// Request method 'PUT' is not supported --> testata
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable UUID userId, @RequestBody User body) throws Exception {
		return usersService.findByIdAndUpdate(userId, body);
	}

	// testata OK
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable UUID userId) throws NotFoundException {
		usersService.findByIdAndDelete(userId);
	}

}