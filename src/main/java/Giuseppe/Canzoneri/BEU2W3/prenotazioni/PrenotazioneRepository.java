package Giuseppe.Canzoneri.BEU2W3.prenotazioni;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
	Optional<Prenotazione> findByUtente_IdAndData(UUID id, LocalDate data);

	Optional<Prenotazione> findByDataAndPostazione_Id(LocalDate data, UUID id);

}