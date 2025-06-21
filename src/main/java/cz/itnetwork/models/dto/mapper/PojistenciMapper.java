package cz.itnetwork.models.dto.mapper;

import cz.itnetwork.data.entities.Pojistenci;
import cz.itnetwork.models.dto.PojistenciDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
public interface PojistenciMapper {

    PojistenciDTO toDTO(Pojistenci source);

    Pojistenci toEntity(PojistenciDTO source);

    void updatePojistenciDTO(PojistenciDTO source, @MappingTarget PojistenciDTO target);

    void updatePojistenci(PojistenciDTO source, @MappingTarget Pojistenci target);
}
