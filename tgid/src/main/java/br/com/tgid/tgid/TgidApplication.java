package br.com.tgid.tgid;

import br.com.tgid.tgid.orm.Empresa;
import br.com.tgid.tgid.repository.EmpresaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TgidApplication implements CommandLineRunner {

		private EmpresaRepository repository;

		public TgidApplication(EmpresaRepository repository){
			this.repository = repository;
		}

	public static void main(String[] args) {

		SpringApplication.run(TgidApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Empresa emp = new Empresa(1223, "ad");
	}
}
