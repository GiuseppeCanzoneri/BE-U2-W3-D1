package Giuseppe.Canzoneri.BEU2W3.citta;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Giuseppe.Canzoneri.BEU2W3.citta.payloads.CittaRegistrationPayload;
import Giuseppe.Canzoneri.BEU2W3.exception.BadRequestException;
import Giuseppe.Canzoneri.BEU2W3.exception.NotFoundException;

@Service
public class CittaService {
	@Autowired
	private CittaRepository cittaRepo;

	public Citta create(CittaRegistrationPayload c) {
		cittaRepo.findByNomeIgnoreCase(c.getNome()).ifPresent(Citta -> {
			throw new BadRequestException("Citta" + Citta.getNome() + " presente!");
		});
		Citta newCitta = new Citta(c.getNome());
		return cittaRepo.save(newCitta);
	}

	public Page<Citta> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return cittaRepo.findAll(pageable);
	}

	public Citta findById(UUID id) throws NotFoundException {
		return cittaRepo.findById(id).orElseThrow(() -> new NotFoundException("Utente non trovato!"));
	}

	public Citta findByIdAndUpdate(UUID id, Citta c) throws NotFoundException {
		Citta found = this.findById(id);

		found.setId(id);
		found.setNome(c.getNome());

		return cittaRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Citta found = this.findById(id);
		cittaRepo.delete(found);
	}
}