package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
