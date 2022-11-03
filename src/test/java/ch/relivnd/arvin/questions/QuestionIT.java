package ch.relivnd.arvin.questions;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionIT {

    @Autowired
    private QuestionRepository repository;


    @Test
    @Transactional
    public void givenQuestionEntityRepository_whenSaveandRetreiveEntity_theOK() {

        Question savedQuestion = repository.save(new Question());
        Question foundQuestion = repository.findById(savedQuestion.getId()).get();

        assertNotNull(foundQuestion);
        assertEquals(savedQuestion, foundQuestion);

    }
}
