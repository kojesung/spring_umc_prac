package umc.spring.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.mapping.MemberQuestion;

import java.util.List;
import java.util.Optional;

public interface MemberQuestionRepository extends JpaRepository<MemberQuestion, Long> {
    Optional<MemberQuestion> findTopByMemberIdOrderByCreatedAtDesc(Long memberId);
    //Optional을 통해 메서드에 특정 키워드를 포함함으로써 적절한 쿼리 만들어줌(쿼리메서드라 함)
    //findTopBy : 가장 상위 결과
    //MemberId : 이거로 찾는다
    //OrderByCreatedAtDesc : CreatedAt속성을 기준으로 내림차순 정렬
    //Optional이 붙으면 Null을 반환하지 않음
    Optional<MemberQuestion> findByQuestionIdAndMemberId(Long questionId, Long memberId);

    Page<MemberQuestion> findByMemberIdOrderByQuestionIdAsc(Long memberId, Pageable pageable); // QuestionId 기준으로 오름차순 정렬 및 페이징 처리
    boolean existsByQuestionIdAndMemberId(Long questionId, Long memberId);

}
