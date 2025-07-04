package br.com.rpganuncios.dtos.response;

import br.com.rpganuncios.entity.PlayerAd;
import br.com.rpganuncios.entity.TableAd;

import java.util.List;
import java.util.UUID;

public record UserAccountResponse(
        UUID id,
        String login,
        String email,
        String nickDiscord,
        List<TableAd> tableAds,
        List<PlayerAd> playerAds
) {
}
