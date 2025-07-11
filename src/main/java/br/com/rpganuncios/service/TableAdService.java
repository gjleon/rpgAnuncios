package br.com.rpganuncios.service;

import br.com.rpganuncios.dtos.mapper.TableAdMapper;
import br.com.rpganuncios.dtos.request.TableAdRequest;
import br.com.rpganuncios.dtos.response.TableAdResponse;
import br.com.rpganuncios.entity.TableAd;
import br.com.rpganuncios.entity.UserAccount;
import br.com.rpganuncios.repository.TableAdRepository;
import br.com.rpganuncios.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class TableAdService {

    private final TableAdRepository tableAdRepository;
    private final TableAdMapper tableAdMapper;
    private final UserAccountRepository userAccountRepository;

    public TableAdResponse save(TableAdRequest tableAdRequest) {
        UserAccount userAccount =  userAccountRepository.findById(tableAdRequest.userAccountId()).orElseThrow(() -> new NoSuchElementException("O id: "+ tableAdRequest.userAccountId() +" não existe"));
         TableAd tableAd = tableAdMapper.toTableAd(tableAdRequest,userAccount);
        return tableAdMapper.toTableAdResponse(tableAdRepository.save(tableAd));
    }
}
