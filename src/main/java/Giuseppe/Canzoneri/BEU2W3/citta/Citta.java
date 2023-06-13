package Giuseppe.Canzoneri.BEU2W3.citta;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Citta {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;

	public Citta(String nome) {
		this.nome = nome;
	}
}