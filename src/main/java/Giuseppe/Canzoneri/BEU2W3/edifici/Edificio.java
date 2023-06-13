package Giuseppe.Canzoneri.BEU2W3.edifici;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import Giuseppe.Canzoneri.BEU2W3.citta.Citta;
import Giuseppe.Canzoneri.BEU2W3.utils.CodeConverter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Convert;
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
@Table(name = "edifici")
@JsonIgnoreProperties({ "code" })
public class Edificio {
	@Id
	@GeneratedValue
	private UUID id;
	private String name;
	private String indirizzo;
	@Convert(converter = CodeConverter.class)
	private String code;

	@ManyToOne(cascade = CascadeType.ALL)
	private Citta citta;

	public Edificio(String name, String indirizzo, Citta citta, String code) {
		this.name = name;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.code = code;
	}
}