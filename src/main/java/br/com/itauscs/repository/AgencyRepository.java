package br.com.itauscs.repository;

import br.com.itauscs.model.Agency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends CrudRepository<Agency, Long> {
    //Criar comando com todas as contas existentes na agencia assim como suas informações
}
