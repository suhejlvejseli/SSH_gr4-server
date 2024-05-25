package com.sshproject.bookstore.Repository;

import com.sshproject.bookstore.Entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testFindIdByNameAndNationalityAndBirthDate() {
        Author author = new Author("Author Name", "Nationality", LocalDate.of(1980, 1, 1));
        authorRepository.save(author);
        Optional<Integer> foundId = authorRepository.findIdByNameAndNationalityAndBirthDate("Author Name", "Nationality", LocalDate.of(1980, 1, 1));
        assertThat(foundId).isPresent();
        assertThat(foundId.get()).isEqualTo(author.getId());
    }

    @Test
    public void testFindByNameAndNationalityAndBirthDate() {
        Author author = new Author("Author Name", "Nationality", LocalDate.of(1980, 1, 1));
        authorRepository.save(author);
        Optional<Author> foundAuthor = authorRepository.findByNameAndNationalityAndBirthDate("Author Name", "Nationality", LocalDate.of(1980, 1, 1));
        assertThat(foundAuthor).isPresent();
        assertThat(foundAuthor.get().getId()).isEqualTo(author.getId());
    }
}
