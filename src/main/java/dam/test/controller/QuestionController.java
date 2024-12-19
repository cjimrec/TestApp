package dam.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dam.test.entity.Question;
import dam.test.service.IQuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private IQuestionService questionService;
	
	@GetMapping("/all")
	public String giveAllQuestion(Model model) {
		model.addAttribute("list", questionService.giveAllQuestions());
		return "question-view";
	}
	
	@PostMapping("/check")
	public String checkAnswers(@RequestParam Map<Long, Boolean> answers, Model model) {
	    System.out.println("User Answers: " + answers);

	    Map<Long, Boolean> results = questionService.checkAnswers(answers);

	    System.out.println("Results: " + results);

	    model.addAttribute("results", results);
	    model.addAttribute("list", questionService.giveAllQuestions());
	    return "question-view";
	}

}
