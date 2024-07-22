package umc.spring.study.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.converter.MemberConverter;
import umc.spring.study.converter.MemberPreferConverter;
import umc.spring.study.domain.FoodCategory;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.mapping.MemberPrefer;
import umc.spring.study.repository.FoodCategoryRepository;
import umc.spring.study.repository.MemberRepository;
import umc.spring.study.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{
    //MemberCommandService인터페이스를 구현하는 클래스임을 명시
    //이제 MemberCommandServiceImpl은 인터페이스의 모든 메서드를 구현해야 함!!!!!
    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;
    //생성자를 통해 주입받은 모습

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {//joinMember의 타입인 Member는 먼소린지 몰게씀

        Member newMember = MemberConverter.toMember(request);//DTO를 엔티티로 바꿔줌
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }


}
