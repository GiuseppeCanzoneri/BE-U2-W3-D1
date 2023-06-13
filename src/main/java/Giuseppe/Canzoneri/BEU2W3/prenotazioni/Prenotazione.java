package Giuseppe.Canzoneri.BEU2W3.prenotazioni;

import java.time.LocalDate;
import java.util.UUID;

import Giuseppe.Canzoneri.BEU2W3.postazioni.Postazione;
import Giuseppe.Canzoneri.BEU2W3.users.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
	@Id
	@GeneratedValue
	private UUID id;
	private LocalDate data;
	@ManyToOne(cascade = CascadeType.ALL)
	private Postazione postazione;
	@ManyToOne(cascade = CascadeType.ALL)
	private User utente;

	public Prenotazione(LocalDate data, Postazione postazione, User utente) {
		this.data = data;
		this.postazione = postazione;
		this.utente = utente;
	}
}