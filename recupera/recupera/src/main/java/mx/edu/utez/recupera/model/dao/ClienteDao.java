package mx.edu.utez.recupera.model.dao;

import mx.edu.utez.recupera.model.entity.ClienteBean;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<ClienteBean, Integer> {
}
