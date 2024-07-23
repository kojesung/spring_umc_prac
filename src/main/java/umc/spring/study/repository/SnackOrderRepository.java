package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.SnackOrder;

public interface SnackOrderRepository extends JpaRepository<SnackOrder, Integer> {
}
