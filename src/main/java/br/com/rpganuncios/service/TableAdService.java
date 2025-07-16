package br.com.rpganuncios.service;

import br.com.rpganuncios.dtos.mapper.TableAdMapper;
import br.com.rpganuncios.dtos.request.TableAdRequest;
import br.com.rpganuncios.dtos.response.TableAdResponse;
import br.com.rpganuncios.entity.TableAd;
import br.com.rpganuncios.entity.UserAccount;
import br.com.rpganuncios.repository.TableAdRepository;
import br.com.rpganuncios.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class TableAdService  {

    private final TableAdRepository tableAdRepository;
    private final TableAdMapper tableAdMapper;
    private final UserAccountRepository userAccountRepository;

    public TableAdResponse save(TableAdRequest tableAdRequest) {
        UserAccount userAccount =  userAccountRepository.findById(tableAdRequest.userAccountId()).orElseThrow(() -> new NoSuchElementException("O id: "+ tableAdRequest.userAccountId() +" não existe"));
         TableAd tableAd = tableAdMapper.toTableAd(tableAdRequest,userAccount);
        return tableAdMapper.toTableAdResponse(tableAdRepository.save(tableAd));
    }

    public List<TableAdResponse> findAll() {
        return tableAdRepository.findAll().stream().map(tableAdMapper:: toTableAdResponse).toList();
    }

    public TableAdResponse findById(Long id) {
        TableAd tableAd = tableAdRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Table Ad not found"));
        return tableAdMapper.toTableAdResponse(tableAd);
    }

    public TableAdResponse update(Long id, TableAdRequest tableAdRequest) {
        TableAd tableAd = tableAdRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Table Ad not found"));
        tableAd.setCampaignName(tableAdRequest.campaignName());
        tableAd.setSystemName(tableAdRequest.systemName());
        tableAd.setTableGenres(tableAdRequest.tableGenres());
        tableAd.setScheduledDateTime(tableAdRequest.scheduledDateTime());
        tableAd.setSynopsis(tableAdRequest.synopsis());
        tableAd.setMaxSlots(tableAdRequest.maxSlots());
        tableAd.setFilledSlots(tableAdRequest.filledSlots());
        tableAd.setPaidTable(tableAdRequest.isPaidTable());
        tableAd.setTableRules(tableAdRequest.tableRules());
        tableAd.setTablePrice(tableAdRequest.tablePrice());
        tableAd.setPlatform(tableAdRequest.platform());
        tableAd.setFormLink(tableAdRequest.formLink());
        tableAd.setMediaUrl(tableAdRequest.mediaUrl());
        tableAd.setAdditionalInfo(tableAdRequest.additionalInfo());
        return tableAdMapper.toTableAdResponse(tableAdRepository.save(tableAd));
    }

    public void delete(Long id) {
        TableAd tableAd = tableAdRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Table Ad not found"));
        tableAdRepository.delete(tableAd);
    }
}
