package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Question;
import umc.spring.study.domain.mapping.MemberQuestion;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
