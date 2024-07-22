package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Snack;

public interface SnackRepository extends JpaRepository<Snack, Long> {
}
