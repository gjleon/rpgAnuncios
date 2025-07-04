package br.com.rpganuncios.dtos.mapper;

import br.com.rpganuncios.dtos.request.UsuarioRequest;
import br.com.rpganuncios.dtos.response.UsuarioResponse;
import br.com.rpganuncios.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    Usuario paraUsurio(final UsuarioRequest usuarioRequest);

    UsuarioResponse paraUsuarioResponse(final Usuario usuario);
}
