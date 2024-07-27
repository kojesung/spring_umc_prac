package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.SnackOrder;

import java.util.List;

public interface SnackOrderRepository extends JpaRepository<SnackOrder, Long> {

    List<SnackOrder> findByMemberId(Long memberId);
}
