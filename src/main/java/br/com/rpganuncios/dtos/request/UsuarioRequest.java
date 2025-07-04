package br.com.rpganuncios.dtos.request;

import br.com.rpganuncios.entity.AnuncioMesa;
import br.com.rpganuncios.entity.JogadorAnuncio;

import java.util.ArrayList;
import java.util.List;

public record UsuarioRequest(
        String nickName,
        String email,
        String senha,
        String nickDiscord,
        List<AnuncioMesa> anuncioMesas ,
        List<JogadorAnuncio> jogadorAnuncios
) {
}
