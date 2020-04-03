package br.com.itauscs.endPoint;

import br.com.itauscs.error.ResourceNotFoundException;
import br.com.itauscs.model.Acaunt;
import br.com.itauscs.repository.AcauntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Acaunts")
public class AcauntEndPoint {

    private final AcauntRepository acauntDAO;
    @Autowired
    public AcauntEndPoint(AcauntRepository acauntDAO){
        this.acauntDAO = acauntDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(acauntDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> listOne(@PathVariable("id") long id){
        verificaSeEstudanteExiste(id);
        Acaunt acaunt = acauntDAO.findById(id).get();
        return new ResponseEntity<>(acaunt, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Acaunt acaunt){
        return new ResponseEntity<>(acauntDAO.save(acaunt), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody long id){
        verificaSeEstudanteExiste(id);
        return new ResponseEntity<>(acauntDAO.existsById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> alter(@RequestBody Acaunt acaunt){
        verificaSeEstudanteExiste(acaunt.getId());
        return new ResponseEntity<>(acauntDAO.save(acaunt), HttpStatus.OK);
    }

    private void verificaSeEstudanteExiste(Long id){
        if (!acauntDAO.findById(id).isPresent()){
            throw new ResourceNotFoundException("Estudante não encontrado pelo id: " + id);
        }
    }
}
