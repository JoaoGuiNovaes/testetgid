package br.com.tgid.tgid.repository;

import br.com.tgid.tgid.orm.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
}
