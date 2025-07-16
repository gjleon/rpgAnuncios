package br.com.rpganuncios.dtos.mapper;

import br.com.rpganuncios.dtos.request.TableAdRequest;
import br.com.rpganuncios.dtos.request.UserAccountRequest;
import br.com.rpganuncios.dtos.response.TableAdResponse;
import br.com.rpganuncios.dtos.response.UserAccountResponse;
import br.com.rpganuncios.entity.TableAd;
import br.com.rpganuncios.entity.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TableAdMapper {

    @Mapping(target = "id", ignore = true)
    TableAd toTableAd(final TableAdRequest tableAdRequest, UserAccount userAccount);

    @Mapping(target = "isPaidTable", source = "paidTable")
    @Mapping(target = "userAccountId", source = "tableAd.userAccount.id")
    TableAdResponse toTableAdResponse(final TableAd tableAd);
}
