package ch.relivnd.arvin.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepository repository;

    public Question save(Question question) {
        return repository.save(question);
    }

    public Question getById(long id) {
        return repository.findById(id).get();
    }


}
