package ch.relivnd.arvin.questions;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionIT {

    @Autowired
    private QuestionService questionService;


    @Test
    @Transactional
    public void givenQuestionEntityRepository_whenSaveAndRetreiveEntity_theOK() {
        //when
        Question savedQuestion = questionService.save(new Question());
        Question foundQuestion = questionService.getById(savedQuestion.getId());

        //then
        assertNotNull(foundQuestion);
        assertEquals(savedQuestion, foundQuestion);

    }

    @Test
    public void givenListOfQuestions_whenSaveAndCountQuestions_thenOK() {
        //given
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            questions.add(new Question());
        }

        //when
        for (Question question : questions) {
            questionService.save(question);
        }

        List<Question> questions1 = questionService.getAll();

        //then
        assertEquals(questions.size(), questions1.size());

    }
}
