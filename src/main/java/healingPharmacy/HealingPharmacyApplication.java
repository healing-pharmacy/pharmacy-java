package healingPharmacy;

import healingPharmacy.model.Agenda;
import healingPharmacy.model.Funcionario;
import healingPharmacy.model.Paciente;
import healingPharmacy.repository.IAgenda;
import healingPharmacy.repository.IFuncionario;
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
	CommandLineRunner initDatabase(IPaciente dao, IAgenda agendaRepository, IFuncionario dao2){
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
			g.setTarefa("Auxiliar no banho");
			g.setConcluido(false);
			g.setAno(2023);
			g.setDia(23);
			g.setMes(06);
			g.setNome_paciente("Roberto Nunes");

			Agenda h = new Agenda();
			h.setResponsavel("Carlos Alberto");
			h.setTarefa("Dar 1mg de cloroquina ao Gustavo");
			h.setConcluido(false);
			h.setAno(2023);
			h.setDia(23);
			h.setMes(06);
			h.setNome_paciente("Danubio Costa");

			Agenda j = new Agenda();
			j.setResponsavel("Maria Clara");
			j.setTarefa("Dar 1mg de dorflex");
			j.setConcluido(false);
			j.setAno(2023);
			j.setDia(23);
			j.setMes(06);
			j.setNome_paciente("Gustavo Henrique");

			Agenda k = new Agenda();
			k.setResponsavel("Virginia");
			k.setTarefa("Tocar a fralda");
			k.setConcluido(false);
			k.setAno(2023);
			k.setDia(23);
			k.setMes(06);
			k.setNome_paciente("Dagoberto Dolores");

			Agenda l = new Agenda();
			l.setResponsavel("Jade");
			l.setTarefa("Aplicar insulina");
			l.setConcluido(false);
			l.setAno(2023);
			l.setDia(23);
			l.setMes(06);
			l.setNome_paciente("Jackson Michael");

			Agenda m = new Agenda();
			m.setResponsavel("Fred");
			m.setTarefa("Auxiliar no almoço");
			m.setConcluido(false);
			m.setAno(2023);
			m.setDia(23);
			m.setMes(06);
			m.setNome_paciente("Roberto Henrique");

			Funcionario q = new Funcionario();
			q.setNome_funcionario("Samuel");
			q.setCpf("06343161171");
			q.setEndereco("Rua filsotro carneiro qd06 lt16");
			q.setTelefone("62 98582-4804");


			Funcionario t = new Funcionario();
			t.setNome_funcionario("Jade");
			t.setCpf("06343161171");
			t.setEndereco("Rua das dores qd.06 lt.18");
			t.setTelefone("62 98578-4603");

			Funcionario u = new Funcionario();
			u.setNome_funcionario("Virginia");
			u.setCpf("06343161171");
			u.setEndereco("Rua das couves qd.18 lt.18");
			u.setTelefone("62 99756 9012");

			agendaRepository.save(m);
			agendaRepository.save(j);
			agendaRepository.save(k);
			agendaRepository.save(l);
			agendaRepository.save(h);
			agendaRepository.save(g);
			dao.save(p);
			dao.save(f);
			dao2.save(q);
			dao2.save(t);
			dao2.save(u);
		};
	}
}
