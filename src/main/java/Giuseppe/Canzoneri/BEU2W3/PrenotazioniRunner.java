package Giuseppe.Canzoneri.BEU2W3;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import Giuseppe.Canzoneri.BEU2W3.citta.CittaService;
import Giuseppe.Canzoneri.BEU2W3.edifici.EdificioSrv;
import Giuseppe.Canzoneri.BEU2W3.postazioni.PostazioneService;
import Giuseppe.Canzoneri.BEU2W3.prenotazioni.PrenotazioneService;
import Giuseppe.Canzoneri.BEU2W3.users.UsersService;
import Giuseppe.Canzoneri.BEU2W3.users.payloads.UserCreatePayload;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PrenotazioniRunner implements CommandLineRunner {
	@Autowired
	UsersService utenteSrv;
	@Autowired
	CittaService cittaSrv;
	@Autowired
	EdificioSrv edificioSrv;
	@Autowired
	PostazioneService postazioneSrv;
	@Autowired
	PrenotazioneService prenotazioneSrv;

//    @Autowired
//    CodeConverter codeConverter;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		for (int i = 0; i < 3; i++) {
			try {
				String username = faker.name().username();
				String name = faker.name().firstName();
				String surname = faker.name().lastName();
				String email = faker.internet().emailAddress();
				String password = "1234";
				UserCreatePayload user = new UserCreatePayload(username, name, surname, email, password);
				utenteSrv.create(user);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
//
//	private Boolean auto = false;

//	@Override
//	public void run(String... args) throws Exception {
//
//		if (auto) {
//			createUsers();
//		}
//
//		List<Edificio> edifici = edificioSrv.findAll();
//		edifici.forEach(e -> {
//			edificioSrv.findByIdAndUpdate(e.getId(), e);
//		});
//
//	}

//	public void createUsers() {
//		for (int i = 0; i < 3; i++) {
//			try {
//
//				String name = faker.name().firstName();
//				String surname = faker.name().lastName();
//				String username = faker.name().username();
//				String email = faker.internet().emailAddress();
//				String password = "1234";
//				UserCreatePayload user = new UserCreatePayload(name, surname, username, email, password);
//				utenteSrv.create(user);
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//		}
}

//}