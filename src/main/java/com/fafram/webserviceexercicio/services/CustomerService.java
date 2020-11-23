package com.fafram.webserviceexercicio.services;

import com.fafram.webserviceexercicio.repositories.CustomerRepository;
import com.fafram.webserviceexercicio.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepository repository; // injeção de dependência

    public List<com.fafram.webserviceexercicio.entities.Customer> findAll(){

        return repository.findAll();
    }

    public Customer findById(Long id) {
        Optional<Customer> obj = repository.findById(id);
        return obj.get();
    }

    public Customer insert(Customer customer){

        return repository.save(customer); //o método save retorna o usuário salvo
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Customer update(Long id, Customer customer){
        Customer entity = repository.getOne(id);
        updateData(entity,customer);
        return repository.save(entity);
    }

    public void updateData(Customer entity, Customer customer){
        entity.setName(customer.getName());
        entity.setEmail(customer.getEmail());
        entity.setCpf(customer.getCpf());
    }
}
