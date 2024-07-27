package umc.spring.study.converter;

import umc.spring.study.domain.Member;
import umc.spring.study.domain.enums.Gender;
import umc.spring.study.web.dto.MemberRequestDTO;
import umc.spring.study.web.dto.MemberResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }
        LocalDate birth = LocalDate.of(request.getBirthYear(), request.getBirthMonth(), request.getBirthDay());

        return Member.builder()
                .name(request.getName())//
                //에러 났을 때 어떤 필드가 누락되었다는 에러가 나면 DTO Converter쪽 봐주면 됨
                .gender(gender)
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}