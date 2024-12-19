package dam.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dam.test.entity.Question;

@Repository
public interface IQuestionRepository extends JpaRepository<Question, Long>{

}
