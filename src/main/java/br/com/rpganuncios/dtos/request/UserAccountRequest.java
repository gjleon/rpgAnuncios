package br.com.rpganuncios.dtos.request;

import br.com.rpganuncios.entity.PlayerAd;
import br.com.rpganuncios.entity.TableAd;

import java.util.List;

public record UserAccountRequest(
        String login,
        String email,
        String password,
        String nickDiscord,
        List<TableAd> tableAds,
        List<PlayerAd> playerAds
) {
}
