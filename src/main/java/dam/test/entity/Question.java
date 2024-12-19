package dam.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Question{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String question;
	private boolean answer;
	
	public Question(Long id, String question, boolean answer) {
		this.id = id;
		this.question = question;
		this.answer = answer;
	}
	
	public Question() {
	}

	public Long getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public boolean isAnswer() {
		return answer;
	}
	
	
	
}
