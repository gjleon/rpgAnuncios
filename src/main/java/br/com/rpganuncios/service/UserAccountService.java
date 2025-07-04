package br.com.rpganuncios.service;

import br.com.rpganuncios.dtos.mapper.UserAccountMapper;
import br.com.rpganuncios.dtos.request.UserAccountRequest;
import br.com.rpganuncios.dtos.response.UserAccountResponse;
import br.com.rpganuncios.entity.UserAccount;
import br.com.rpganuncios.repository.UserAccountRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    private final UserAccountMapper userAccountMapper;


    public UserAccountResponse save(@Valid UserAccountRequest userAccountRequest) {
        UserAccount userAccount = userAccountRepository.save(userAccountMapper.toUserAccount(userAccountRequest));
        return userAccountMapper.toUserAccountResponse(userAccount);
    }

    public List<UserAccountResponse> findAll() {
        return userAccountRepository.findAll().stream().map(userAccountMapper::toUserAccountResponse).toList();
    }


    public UserAccountResponse findById(UUID id) {
        return userAccountMapper.toUserAccountResponse(userAccountRepository.findById(id).get());
    }

    public UserAccountResponse updateUser(UserAccountRequest userAccountRequest, UUID id) {
        UserAccount user = userAccountRepository.findById(id).orElseThrow(() -> new  NoSuchElementException("O id: "+ id +" não existe"));
        user.setLogin(userAccountRequest.login());
        user.setNickDiscord(userAccountRequest.nickDiscord());
        user.setEmail(userAccountRequest.email());
        user.setTableAds(userAccountRequest.tableAds());
        user.setPlayerAds(userAccountRequest.playerAds());

        return userAccountMapper.toUserAccountResponse(userAccountRepository.save(user));
    }
}
