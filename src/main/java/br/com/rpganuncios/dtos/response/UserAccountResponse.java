package br.com.rpganuncios.dtos.response;

import br.com.rpganuncios.entity.PlayerAd;

import java.util.List;

public record UserAccountResponse(
        Long id,
        String login,
        String email,
        String nickDiscord,
        List<TableAdToUserAccountResponse> tableAds,
        List<PlayerAd> playerAds
) {
}
