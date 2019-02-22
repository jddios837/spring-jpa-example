package websoft.gastospersonales.gastosPersonalesApi.repositories;

import org.springframework.data.repository.CrudRepository;
import websoft.gastospersonales.gastosPersonalesApi.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
