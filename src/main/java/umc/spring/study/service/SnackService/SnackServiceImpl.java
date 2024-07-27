package umc.spring.study.service.SnackService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.converter.SnackConverter;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Snack;
import umc.spring.study.domain.SnackOrder;
import umc.spring.study.repository.MemberRepository;
import umc.spring.study.repository.SnackOrderRepository;
import umc.spring.study.repository.SnackRepository;
import umc.spring.study.web.dto.OrderListResponseDTO;
import umc.spring.study.web.dto.SnackResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static umc.spring.study.converter.SnackConverter.toOrderListDTO;

@Service
@RequiredArgsConstructor
public class SnackServiceImpl implements SnackService{
    private final SnackRepository snackRepository;
    private final MemberRepository memberRepository;
    private final SnackOrderRepository snackOrderRepository;

    @Override
    public List<SnackResponseDTO.SnackDTO> getAllSnacks() {
        List<SnackResponseDTO.SnackDTO> snacks = snackRepository.findAll().stream()
                .map(snack -> {
                    return SnackConverter.toSnackDTO(snack);
                })
                .collect(Collectors.toList());
        return snacks;
    }

    @Override
    public void OrderSnack(SnackResponseDTO.SnackOderRequestDTO request){

        Member member=memberRepository.findById(request.getMemberId())
                .orElseThrow(()->new IllegalArgumentException("Member not found"));
        Snack snack=snackRepository.findById(request.getSnackId())
                .orElseThrow(()->new IllegalArgumentException("Snack not found"));
        if (member.getPoint() == 1000) {
            // 멤버의 포인트가 1000일 때
            member.setPoint(0);
            memberRepository.save(member);
        } else {
            // 멤버의 포인트가 1000이 아닐 때 예외 발생
            throw new IllegalArgumentException("구매할 수 없습니다. 필요한 포인트: 1000");
        }
        SnackOrder snackOrder=SnackConverter.toSnackOrder(member,snack);

        snackOrderRepository.save(snackOrder);

    }


    @Override
    public List<OrderListResponseDTO.OrderListDTO> getOrderList(Long userId) {
        List<SnackOrder> orders = snackOrderRepository.findByMemberId(userId);
        return orders.stream()
                .map(SnackConverter-> {
                    return toOrderListDTO(SnackConverter);
                })
                .collect(Collectors.toList());
    }


}
