package br.com.itauscs.repository;

import br.com.itauscs.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    //criar comando que pega as informações do cliente e suas contas existentes
}
