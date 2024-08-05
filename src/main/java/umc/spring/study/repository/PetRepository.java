package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findByMemberId(Long memberId);
    //쿼리 메서드의 일종, memberId필드값으로 Pet엔티티 조회
}
