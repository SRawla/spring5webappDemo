package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring5webapp.domain.repositories.BookRepository;
import guru.springframework.spring5webapp.domain.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author srawla = new Author("Suleman", "Rawla");
        Book book = new Book("Spring-Boot", "1111");

        srawla.getBooks().add(book);
        book.getAuthors().add(srawla);

        authorRepository.save(srawla);
        bookRepository.save(book);

        Author rmistry = new Author("Rajan", "Mistry");
        Book react = new Book("React-JS", "2222");
        rmistry.getBooks().add(react);
        react.getAuthors().add(rmistry);

        authorRepository.save(rmistry);
        bookRepository.save(react);

        Publisher springer = new Publisher("Springer Publication","Address line 1", "City 1", "State 1", "zipcode 1");
        //Publisher oRilley =  new Publisher("ORilley Publication", "Address line 2", "City 2", "State 2", "Zip 2");
        springer.getBooks().add(book);
        springer.getBooks().add(react);

        book.setPublisher(springer);
        react.setPublisher(springer);
        publisherRepository.save(springer);

        bookRepository.save(book);bookRepository.save(react);

        System.out.println("Started in bootstrap");
        System.out.println(("Number of books count : "+bookRepository.count()));
        System.out.println(("Number of Author count : "+authorRepository.count()));
        System.out.println(("Number of Publisher count : "+publisherRepository.count()));



    }
}
