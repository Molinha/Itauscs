package br.com.itauscs.repository;


import br.com.itauscs.model.Acaunt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AcauntRepository extends CrudRepository<Acaunt, Long> {
    //Criar comando que pega todas as informações da conta, assim como sua agencia e seu cliente
    //select * from acaunt INNER JOIN agency on acaunt.agency_id = agency.id INNER JOIN client on acaunt.client_id = client.id where acaunt.id = 25
}
