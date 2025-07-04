package br.com.rpganuncios.dtos.mapper;

import br.com.rpganuncios.dtos.request.UserAccountRequest;
import br.com.rpganuncios.dtos.response.UserAccountResponse;
import br.com.rpganuncios.entity.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

    @Mapping(target = "id", ignore = true)
    UserAccount toUserAccount(final UserAccountRequest userAccountRequest);

    UserAccountResponse toUserAccountResponse(final UserAccount userAccount);
}
