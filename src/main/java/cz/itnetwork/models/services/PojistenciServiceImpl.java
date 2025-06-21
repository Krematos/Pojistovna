package cz.itnetwork.models.services;


import cz.itnetwork.data.entities.Pojistenci;
import cz.itnetwork.data.repositories.PojistenciRepository;
import cz.itnetwork.models.dto.PojistenciDTO;
import cz.itnetwork.models.dto.mapper.PojistenciMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cz.itnetwork.models.exceptions.PojistenecNotFoundException;

import java.util.List;

@Service
public class PojistenciServiceImpl implements PojistenciService {

    @Autowired
    private PojistenciRepository pojistenciRepository;

    @Autowired
    private PojistenciMapper pojistenciMapper;

    @Override
    public void create(PojistenciDTO pojistenecDTO){       // vytvoření nového pojištěnce
        Pojistenci newPojistenec = pojistenciMapper.toEntity(pojistenecDTO);
        pojistenciRepository.save(newPojistenec);
    }

    @Override
    public List<PojistenciDTO> getAll(){
        return pojistenciRepository.getAllByIsDeleted(false).stream()
                .map(i -> pojistenciMapper.toDTO(i)).toList();
    }

    @Override
    public PojistenciDTO getById(long pojistenci_id){
        Pojistenci selectedPojistenci = getPojistenciOrThrow(pojistenci_id);
        return pojistenciMapper.toDTO(selectedPojistenci);
    }

    @Override
    public void edit(PojistenciDTO pojistenec){
        Pojistenci selectedPojistenci = getPojistenciOrThrow(pojistenec.getPojistenci_id());
        pojistenciMapper.updatePojistenci(pojistenec, selectedPojistenci);
        pojistenciRepository.save(selectedPojistenci);
    }

    @Override
    public void remove(long pojistenci_id){
        Pojistenci selectedPojistenci = getPojistenciOrThrow(pojistenci_id);
        selectedPojistenci.setDeleted(true);
        pojistenciRepository.save(selectedPojistenci);
    }

    public Pojistenci getPojistenciOrThrow(long pojistenci_id){
        return pojistenciRepository
                .findById(pojistenci_id).orElseThrow(PojistenecNotFoundException::new);
    }

    public Pojistenci getPojistenecOrThrow(long pojistenci_id){
        return pojistenciRepository.findById(pojistenci_id)
                .orElseThrow(PojistenecNotFoundException::new);
    }

}
