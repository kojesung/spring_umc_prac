package umc.spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.SnackOrder;
import umc.spring.study.web.dto.OrderListResponseDTO;

import java.util.List;

public interface SnackOrderListRepository extends JpaRepository<SnackOrder, List> {
}
