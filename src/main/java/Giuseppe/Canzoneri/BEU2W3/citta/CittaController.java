package Giuseppe.Canzoneri.BEU2W3.citta;

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

import Giuseppe.Canzoneri.BEU2W3.citta.payloads.CittaRegistrationPayload;

@RestController
@RequestMapping("/citta")
public class CittaController {
	@Autowired
	private CittaService cittaService;

	@GetMapping("")
	public Page<Citta> getCitta(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy) {
		return cittaService.find(page, size, sortBy);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Citta saveCitta(@RequestBody @Validated CittaRegistrationPayload body) {
		return cittaService.create(body);
	}

	@GetMapping("/{cittaId}")
	public Citta getCitta(@PathVariable UUID cittaId) throws Exception {
		return cittaService.findById(cittaId);
	}

	@PutMapping("/{cittaId}")
	public Citta updateCitta(@PathVariable UUID cittaId, @RequestBody Citta body) throws Exception {
		return cittaService.findByIdAndUpdate(cittaId, body);
	}

	@DeleteMapping("/{cittaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCitta(@PathVariable UUID cittaId) {
		cittaService.findByIdAndDelete(cittaId);
	}
}