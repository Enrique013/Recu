package mx.edu.utez.recupera.service;

import mx.edu.utez.recupera.model.dto.ClienteDto;
import mx.edu.utez.recupera.model.dto.PersonDto;
import mx.edu.utez.recupera.model.entity.ClienteBean;
import mx.edu.utez.recupera.model.entity.PersonBean;

import java.util.List;

public interface ICliente {
    ClienteBean save(ClienteDto lienteDto);

    ClienteBean findById(Integer id);

    void delete(ClienteBean lienteBean);

    List<ClienteBean> findAll();
}
