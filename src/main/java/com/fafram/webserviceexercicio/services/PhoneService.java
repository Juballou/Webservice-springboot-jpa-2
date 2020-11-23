package com.fafram.webserviceexercicio.services;

import com.fafram.webserviceexercicio.entities.Phone;
import com.fafram.webserviceexercicio.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repository; // injeção de dependência

    public List<Phone> findAll(){
        return repository.findAll();
    }

    public Phone findById(Long id) {
        Optional<Phone> obj = repository.findById(id);
        return obj.get();
    }

    public Phone insert(Phone phone){

        return repository.save(phone); //o método save retorna o usuário salvo
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Phone update(Long id, Phone phone){
        Phone entity = repository.getOne(id);
        updateData(entity,phone);
        return repository.save(entity);
    }

    public void updateData(Phone entity, Phone phone){
        entity.setType(phone.getType());
        entity.setNumber(phone.getNumber());
    }
}
