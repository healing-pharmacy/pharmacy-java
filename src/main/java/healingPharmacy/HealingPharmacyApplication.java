package healingPharmacy;

import healingPharmacy.model.Agenda;
import healingPharmacy.model.Paciente;
import healingPharmacy.repository.IAgenda;
import healingPharmacy.repository.IPaciente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HealingPharmacyApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(HealingPharmacyApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(IPaciente dao, IAgenda agendaRepository){
		return args -> {
			dao.deleteAll();

			Paciente p = new Paciente();
			p.setNome_paciente("Samuel");
			p.setCpf("06343161171");
			p.setEmail("samuelcostta2306@gmail.com");
			p.setEndereco("Rua filsotro carneiro qd06 lt16");
			p.setTelefone("62 98582-4804");
			//p.setData_nascimento();

			Paciente f = new Paciente();
			f.setNome_paciente("Maria");
			f.setCpf("06343161171");
			f.setEmail("mariasilva@gmail.com");
			f.setEndereco("Rua das couves qd06 lt16");
			f.setTelefone("62 91231-9843");
			//p.setData_nascimento();

			Agenda g = new Agenda();
			g.setResponsavel("Samuel");
			g.setTarefa("Dar banho no moises");
			g.setConcluido(false);
			g.setAno(2023);
			g.setDia(23);
			g.setMes(06);
			g.setNome_paciente("Roberto nunes");

			Agenda h = new Agenda();
			h.setResponsavel("Carlos");
			h.setTarefa("Dar 1mg de cloroquina ao Gustavo");
			h.setConcluido(false);
			h.setAno(2023);
			h.setDia(23);
			h.setMes(06);
			h.setNome_paciente("Roberto nunes");

			Agenda j = new Agenda();
			j.setResponsavel("Carlos");
			j.setTarefa("Dar 1mg de cloroquina ao Gustavo");
			j.setConcluido(false);
			j.setAno(2023);
			j.setDia(23);
			j.setMes(06);
			j.setNome_paciente("Roberto nunes");

			Agenda k = new Agenda();
			k.setResponsavel("Carlos");
			k.setTarefa("Dar 1mg de cloroquina ao Gustavo");
			k.setConcluido(false);
			k.setAno(2023);
			k.setDia(23);
			k.setMes(06);
			k.setNome_paciente("Roberto nunes");

			Agenda l = new Agenda();
			l.setResponsavel("Carlos");
			l.setTarefa("Dar 1mg de cloroquina ao Gustavo");
			l.setConcluido(false);
			l.setAno(2023);
			l.setDia(23);
			l.setMes(06);
			l.setNome_paciente("Roberto nunes");

			Agenda m = new Agenda();
			m.setResponsavel("Carlos");
			m.setTarefa("Dar 1mg de cloroquina ao Gustavo");
			m.setConcluido(false);
			m.setAno(2023);
			m.setDia(23);
			m.setMes(06);
			m.setNome_paciente("Roberto nunes");

			agendaRepository.save(m);
			agendaRepository.save(j);
			agendaRepository.save(k);
			agendaRepository.save(l);
			agendaRepository.save(h);
			agendaRepository.save(g);
			dao.save(p);
			dao.save(f);

		};
	}
}
