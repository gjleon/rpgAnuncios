package br.com.rpganuncios.service;

import br.com.rpganuncios.dtos.mapper.UsuarioMapper;
import br.com.rpganuncios.dtos.request.UsuarioRequest;
import br.com.rpganuncios.dtos.response.UsuarioResponse;
import br.com.rpganuncios.entity.Usuario;
import br.com.rpganuncios.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;


    public UsuarioResponse salvar(@Valid UsuarioRequest usuarioRequest) {
        Usuario usuario= usuarioRepository.save(usuarioMapper.paraUsurio(usuarioRequest));
        return usuarioMapper.paraUsuarioResponse(usuario);
    }

    public List<UsuarioResponse> findAll() {
        return usuarioRepository.findAll().stream().map(usuarioMapper::paraUsuarioResponse).toList();
    }


    public UsuarioResponse findById(UUID id) {
        return usuarioMapper.paraUsuarioResponse(usuarioRepository.findById(id).get());
    }

    public UsuarioResponse updateUser(UsuarioRequest usuarioRequest,UUID id) {
        Usuario user = usuarioRepository.findById(id).orElseThrow(() -> new  NoSuchElementException("O id: "+ id +" não existe"));
        user.setNickName(usuarioRequest.nickName());
        user.setNickDiscord(usuarioRequest.nickDiscord());
        user.setEmail(usuarioRequest.email());
        user.setAnuncioMesas(usuarioRequest.anuncioMesas());
        user.setJogadorAnuncios(usuarioRequest.jogadorAnuncios());

        return usuarioMapper.paraUsuarioResponse(usuarioRepository.save(user));
    }
}
