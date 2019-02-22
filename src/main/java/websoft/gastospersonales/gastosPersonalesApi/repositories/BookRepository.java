package websoft.gastospersonales.gastosPersonalesApi.repositories;

import org.springframework.data.repository.CrudRepository;
import websoft.gastospersonales.gastosPersonalesApi.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
