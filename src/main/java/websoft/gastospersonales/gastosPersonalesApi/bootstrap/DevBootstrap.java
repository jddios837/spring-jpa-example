package websoft.gastospersonales.gastosPersonalesApi.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sun.applet.AppletEvent;
import websoft.gastospersonales.gastosPersonalesApi.model.Author;
import websoft.gastospersonales.gastosPersonalesApi.model.Book;
import websoft.gastospersonales.gastosPersonalesApi.model.Publisher;
import websoft.gastospersonales.gastosPersonalesApi.repositories.AuthorRepository;
import websoft.gastospersonales.gastosPersonalesApi.repositories.BookRepository;
import websoft.gastospersonales.gastosPersonalesApi.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDate();
    }

    private void initDate() {

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisher.setAddress("12th Street, LA");
        publisherRepository.save(publisher);

        // Juan
        Author juan = new Author("Juam", "Gomez");
        Book ddd = new Book("Libro 1", "1234", publisher);
        juan.getBooks().add(ddd);
        ddd.getAuthors().add(juan);

        authorRepository.save(juan);
        bookRepository.save(ddd);

    }
}
