package cz.itnetwork.models.services;


import cz.itnetwork.models.dto.PojistenciDTO;

import java.util.List;

public interface PojistenciService {


    List<PojistenciDTO> getAll();

    PojistenciDTO getById(long pojistenci_id);

    void edit(PojistenciDTO pojistenec);

    void remove(long pojistenci_id);

    void create(PojistenciDTO pojistenciDTO);
}
