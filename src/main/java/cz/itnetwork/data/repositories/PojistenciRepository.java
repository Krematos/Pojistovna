package cz.itnetwork.data.repositories;

import cz.itnetwork.data.entities.Pojistenci;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PojistenciRepository extends CrudRepository<Pojistenci, Long> {
     List<Pojistenci> getAllByIsDeleted(boolean isDeleted);
}
