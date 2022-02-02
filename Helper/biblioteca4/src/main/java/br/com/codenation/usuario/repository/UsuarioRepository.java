package br.com.codenation.usuario.repository;

import br.com.codenation.usuario.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

    Usuario findByLogin(String login);

}
