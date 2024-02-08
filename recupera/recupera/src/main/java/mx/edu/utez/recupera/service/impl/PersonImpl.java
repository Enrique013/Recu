package mx.edu.utez.recupera.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.recupera.model.dao.PersonDao;
import mx.edu.utez.recupera.model.dto.PersonDto;
import mx.edu.utez.recupera.model.entity.PersonBean;
import mx.edu.utez.recupera.service.IPerson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class PersonImpl implements IPerson {

    private final PersonDao personDao;

    @Transactional
    @Override
    public PersonBean save(PersonDto personDto){
        if (isUsernameTaken(personDto.getUsername())) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }
        PersonBean person = PersonBean.builder()
                .id(personDto.getId())
                .username(personDto.getUsername())
                .password(genRandomPass())
                .activo(personDto.isActivo())
                .build();
        return personDao.save(person);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean isUsernameTaken(String username) {
        return personDao.findByUsername(username).isPresent();
    }


    @Transactional
    @Override
    public PersonBean findById(Integer id){
        return personDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(PersonBean personBean){
        personDao.delete(personBean);
    }

    @Transactional
    @Override
    public List<PersonBean> findAll(){
        return (List<PersonBean>) personDao.findAll();
    }

    private String genRandomPass() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * caracteres.length());
            password.append(caracteres.charAt(index));
        }
        return password.toString();
    }


}

