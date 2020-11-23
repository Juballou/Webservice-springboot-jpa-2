package com.fafram.webserviceexercicio.resources;

import com.fafram.webserviceexercicio.entities.Customer;
import com.fafram.webserviceexercicio.services.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers") // caminho do recurso
public class CustomerResource {

    @Autowired
    private CustomerService service;

    @ApiOperation(value = "Retorna uma lista de usuários")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de usuários"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    // endpoint
    @GetMapping // indica que o método responde a uma requisição GET HTTP
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        Customer user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping // indica que o método responde a uma requisição POST HTTP
    public ResponseEntity<Customer> insert(@RequestBody Customer customer){
        customer = service.insert(customer);
        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping(value = "/{id}") // indica que o método responde a uma requisição DELETE HTTP
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}") // indica que o método responde a uma requisição PUT HTTP
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer){
        customer = service.update(id, customer);
        return ResponseEntity.ok().body(customer);
    }
}
