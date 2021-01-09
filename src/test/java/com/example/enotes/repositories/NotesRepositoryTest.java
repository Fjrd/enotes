package com.example.enotes.repositories;

import com.example.enotes.domain.Note;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
class NotesRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private NotesRepository notesRepository;

    @Test
    public void findByMessageShouldReturnNote(){
        Note note = new Note("mes", "tag");
        testEntityManager.persist(note);
        testEntityManager.flush();

        //when
        Note found = notesRepository.findByMessage(note.getMessage());

        //then
        assertThat(found.getMessage()).isEqualTo(note.getMessage());
    }

}