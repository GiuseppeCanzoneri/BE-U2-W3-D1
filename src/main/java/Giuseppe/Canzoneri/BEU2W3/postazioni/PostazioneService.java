package Giuseppe.Canzoneri.BEU2W3.postazioni;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Giuseppe.Canzoneri.BEU2W3.exception.BadRequestException;
import Giuseppe.Canzoneri.BEU2W3.exception.NotFoundException;
import Giuseppe.Canzoneri.BEU2W3.postazioni.payloads.PostazioneRegistrationPayload;

@Service
public class PostazioneService {
	@Autowired
	private PostazioneRepository postazioneRepo;

	public Postazione create(PostazioneRegistrationPayload p) {
		postazioneRepo.findByTipoAndEdificio(p.getTipo(), p.getEdificio()).ifPresent(Postazione -> {
			throw new BadRequestException("Postazione " + Postazione + " già in presente!");
		});
		Postazione newPostazione = new Postazione();
		return postazioneRepo.save(newPostazione);
	}

	public Page<Postazione> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return postazioneRepo.findAll(pageable);
	}

	public Postazione findById(UUID id) throws NotFoundException {
		return postazioneRepo.findById(id).orElseThrow(() -> new NotFoundException("Postazione non trovato!"));
	}

	public Postazione findByIdAndUpdate(UUID id, Postazione p) throws NotFoundException {
		Postazione found = this.findById(id);

		found.setId(id);
		found.setDescrizione(p.getDescrizione());
		found.setTipo(p.getTipo());
		found.setEdificio(p.getEdificio());
		found.setOccupanti(p.getOccupanti());

		return postazioneRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Postazione found = this.findById(id);
		postazioneRepo.delete(found);
	}

}