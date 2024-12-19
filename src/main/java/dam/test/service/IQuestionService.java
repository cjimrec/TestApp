package dam.test.service;

import java.util.List;
import java.util.Map;

import dam.test.entity.Question;

public interface IQuestionService {
	List<Question> giveAllQuestions();
	Question getQuestionId(Long id);
	Map<Long, Boolean> checkAnswers(Map<Long, Boolean> userAnswers);
}
