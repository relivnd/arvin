package ch.relivnd.arvin.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepository repository;

    public Question save(Question question) {
        return repository.save(question);
    }

    public Question getById(Long id) {
        if (repository.findById(id).isPresent()) return repository.findById(id).get();
        return null;
    }

    public List<Question> getAll() {
        return repository.findAll().stream().toList();
    }


}
