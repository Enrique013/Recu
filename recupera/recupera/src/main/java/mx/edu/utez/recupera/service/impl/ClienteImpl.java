package mx.edu.utez.recupera.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.recupera.model.dao.ClienteDao;
import mx.edu.utez.recupera.model.dao.PersonDao;
import mx.edu.utez.recupera.model.dto.ClienteDto;
import mx.edu.utez.recupera.model.dto.PersonDto;
import mx.edu.utez.recupera.model.entity.ClienteBean;
import mx.edu.utez.recupera.model.entity.PersonBean;
import mx.edu.utez.recupera.service.ICliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ClienteImpl implements ICliente {
    private final ClienteDao clienteDao;

    @Transactional
    @Override
    public ClienteBean save(ClienteDto clienteDto){
        ClienteBean cliente = ClienteBean.builder()
                .id(clienteDto.getId())
                .nombre(clienteDto.getNombre())
                .apellido_paterno(clienteDto.getApellido_paterno())
                .apellido_materno(clienteDto.getApellido_materno())
                .direccion(clienteDto.getDireccion())
                .build();
        return clienteDao.save(cliente);
    }

    @Transactional
    @Override
    public ClienteBean findById(Integer id){
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(ClienteBean clienteBean){
        clienteDao.delete(clienteBean);
    }

    @Transactional
    @Override
    public List<ClienteBean> findAll(){
        return (List<ClienteBean>) clienteDao.findAll();
    }
}
