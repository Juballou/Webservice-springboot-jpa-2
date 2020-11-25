package com.fafram.webserviceexercicio.resources;

import com.fafram.webserviceexercicio.entities.Customer;
import com.fafram.webserviceexercicio.entities.Phone;
import com.fafram.webserviceexercicio.services.PhoneService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/phones") // caminho do recurso
public class PhoneResource {

        @Autowired
        private PhoneService service;


        @ApiOperation(value = "Retorna uma lista de telefones")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Retorna a lista de telefones"),
                @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Foi gerada uma exceção")
        })
        // endpoint
        @GetMapping // indica que o método responde a uma requisição GET HTTP
        public ResponseEntity<List<Phone>> findAll() {
                List<Phone> list = service.findAll();
                return ResponseEntity.ok().body(list);
        }

        @ApiOperation(value = "Retorna os dados do telefone do id selecionado")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Retorna os dados do telefone do id selecionado"),
                @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Foi gerada uma exceção")
        })
        // endpoint
        @GetMapping(value = "/{id}")
        public ResponseEntity<Phone> findById(@PathVariable Long id) {
        Phone obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
        }

        @ApiOperation(value = "Insere os dados de um Telefone")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Insere os dados do Telefone"),
                @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Foi gerada uma exceção")
        })
        // endpoint
        @PostMapping // indica que o método responde a uma requisição POST HTTP
        public ResponseEntity<Phone> insert(@RequestBody Phone phone){
                phone = service.insert(phone);
                return ResponseEntity.ok().body(phone);
        }

        @ApiOperation(value = "Deleta o cadastro de um Telefone")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Deleta o cadastro do Telefone"),
                @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Foi gerada uma exceção")
        })
        // endpoint
        @DeleteMapping(value = "/{id}") // indica que o método responde a uma requisição DELETE HTTP
        public ResponseEntity<Void> delete(@PathVariable Long id) {
                service.delete(id);
                return ResponseEntity.noContent().build();
        }

        @ApiOperation(value = "Altera os dados no cadastro de um Telefone")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Altera os dados no cadastro do Telefone"),
                @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
                @ApiResponse(code = 500, message = "Foi gerada uma exceção")
        })
        // endpoint
        @PutMapping(value = "/{id}") // indica que o método responde a uma requisição PUT HTTP
        public ResponseEntity<Phone> update(@PathVariable Long id, @RequestBody Phone phone){
                phone = service.update(id, phone);
                return ResponseEntity.ok().body(phone);
        }
}
