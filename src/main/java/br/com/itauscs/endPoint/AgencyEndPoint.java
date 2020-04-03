package br.com.itauscs.endPoint;

import br.com.itauscs.error.ResourceNotFoundException;
import br.com.itauscs.model.Agency;
import br.com.itauscs.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Agencys")
public class AgencyEndPoint {

    private final AgencyRepository agencyDAO;

    @Autowired
    public AgencyEndPoint(AgencyRepository agencyDAO) {
        this.agencyDAO = agencyDAO;
    }

    @GetMapping
    public ResponseEntity<?> ListAll(){
        return new ResponseEntity<>(agencyDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> ListOne(@PathVariable("id") long id){
        verificaSeEstudanteExiste(id);
        Agency agency = agencyDAO.findById(id).get();
        return new ResponseEntity<>(agency, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Agency agency){
        return new ResponseEntity<>(agencyDAO.save(agency), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        verificaSeEstudanteExiste(id);
        agencyDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Agency agency){
        verificaSeEstudanteExiste(agency.getId());
        agencyDAO.save(agency);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verificaSeEstudanteExiste(Long id){
        if (!agencyDAO.findById(id).isPresent()){
            throw new ResourceNotFoundException("Estudante não encontrado pelo id: " + id);
        }
    }
}
