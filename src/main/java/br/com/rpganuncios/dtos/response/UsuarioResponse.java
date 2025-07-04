package br.com.rpganuncios.dtos.response;

import br.com.rpganuncios.entity.AnuncioMesa;

import java.util.List;
import java.util.UUID;

public record UsuarioResponse(
        UUID id,
        String nickName,
        String email,
        String nickDiscord,
        List<AnuncioMesa> anuncioMesas,
        List<AnuncioMesa> jogadorAnuncios
) {
}
