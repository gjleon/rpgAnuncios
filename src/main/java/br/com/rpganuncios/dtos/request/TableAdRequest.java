package br.com.rpganuncios.dtos.request;


import java.util.UUID;

public record TableAdRequest(
        String campaignName,
        String systemName,
        String tableGenres,
        String scheduledDateTime,
        String synopsis,
        int maxSlots,
        int filledSlots,
        boolean isPaidTable,
        String tableRules,
        String tablePrice,
        String platform,
        String formLink,
        String mediaUrl,
        String additionalInfo,
        Long userAccountId
) {
}
