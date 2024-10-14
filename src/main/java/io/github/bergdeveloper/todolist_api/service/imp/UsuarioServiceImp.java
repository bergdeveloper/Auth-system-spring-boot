package io.github.bergdeveloper.todolist_api.service.imp;
import io.github.bergdeveloper.todolist_api.dto.UsuarioDTO;
import io.github.bergdeveloper.todolist_api.entity.Usuario;
import io.github.bergdeveloper.todolist_api.enums.Role;
import io.github.bergdeveloper.todolist_api.repository.UsuarioRepository;
import io.github.bergdeveloper.todolist_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        if(usuarioRepository.findByCpf(usuarioDTO.cpf()) != null){
            throw new RuntimeException("Usuário já casatrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.nome());
        usuario.setCpf(usuarioDTO.cpf());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.senha()));
        usuario.setRole(Role.USER);


        usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario.getNome(), usuario.getCpf(), usuario.getSenha());
    }
}