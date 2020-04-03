package br.com.itauscs.endPoint;

import br.com.itauscs.error.ResourceNotFoundException;
import br.com.itauscs.model.Client;
import br.com.itauscs.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Clients")
public class ClientEndPoint {

    private final ClientRepository clientDAO;

    @Autowired
    public ClientEndPoint(ClientRepository clientDAO) {
        this.clientDAO = clientDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(clientDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> listOne(@PathVariable("id") long id){
        verificaSeEstudanteExiste(id);
        Client client = clientDAO.findById(id).get();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Client client){
        return new ResponseEntity<>(clientDAO.save(client), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        verificaSeEstudanteExiste(id);
        clientDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Client client){
        verificaSeEstudanteExiste(client.getId());
        clientDAO.save(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private void verificaSeEstudanteExiste(long id) {
        if (!clientDAO.findById(id).isPresent()){
            throw new ResourceNotFoundException("Estudante não encontrado pelo id: " + id);
        }
    }
}
