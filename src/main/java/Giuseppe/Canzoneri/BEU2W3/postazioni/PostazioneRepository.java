package Giuseppe.Canzoneri.BEU2W3.postazioni;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Giuseppe.Canzoneri.BEU2W3.edifici.Edificio;
import Giuseppe.Canzoneri.BEU2W3.utils.TipoPostazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {
	Optional<Postazione> findByTipoAndEdificio(TipoPostazione tipo, Edificio edificio);

//    List<Postazione> findByTipoAndEdificio_Citta_NameIgnoreCase(TipoPostazione tipo, String name);
//
//    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, Citta citta);

}