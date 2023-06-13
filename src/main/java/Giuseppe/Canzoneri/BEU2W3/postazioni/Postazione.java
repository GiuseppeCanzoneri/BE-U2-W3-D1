package Giuseppe.Canzoneri.BEU2W3.postazioni;

import java.util.UUID;

import Giuseppe.Canzoneri.BEU2W3.edifici.Edificio;
import Giuseppe.Canzoneri.BEU2W3.utils.TipoPostazione;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "postazioni")
public class Postazione {
	@Id
	@GeneratedValue
	private UUID id;
	private String descrizione;
	private TipoPostazione tipo;
	private Integer occupanti;
	@ManyToOne
	private Edificio edificio;

	public Postazione(String descrizione, TipoPostazione tipo, Integer occupanti, Edificio edificio) {
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.occupanti = occupanti;
		this.edificio = edificio;
	}
}