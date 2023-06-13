package Giuseppe.Canzoneri.BEU2W3.citta;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CittaRepository extends JpaRepository<Citta, UUID> {
	Optional<Citta> findByNomeIgnoreCase(String nome);

}