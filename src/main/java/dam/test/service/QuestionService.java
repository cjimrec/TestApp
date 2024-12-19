package dam.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.test.entity.Question;
import dam.test.repository.IQuestionRepository;

@Service
public class QuestionService implements IQuestionService{
	@Autowired
	private IQuestionRepository questionRepository;
	
	@Override
	public List<Question> giveAllQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public Question getQuestionId(Long id) {
		return questionRepository.findById(id).get();
	}

	@Override
	public Map<Long, Boolean> checkAnswers(Map<Long, Boolean> userAnswers) {
	    Map<Long, Boolean> results = new HashMap<>();
	    List<Question> questions = questionRepository.findAll();

	    for (Question question : questions) {
	        Boolean userAnswer = userAnswers.get(question.getId());

	        if (userAnswer != null) {
	            results.put(question.getId(), userAnswer.equals(question.isAnswer()));
	        } else {
	            results.put(question.getId(), false); 
	        }
	    }

	    return results;
	}

}
