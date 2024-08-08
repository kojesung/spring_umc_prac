package umc.spring.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.study.domain.common.BaseEntity;
import umc.spring.study.domain.enums.Gender;
import umc.spring.study.domain.enums.MemberStatus;
import umc.spring.study.domain.enums.SocialType;
import umc.spring.study.domain.mapping.MemberAgree;
import umc.spring.study.domain.mapping.MemberPrefer;
import umc.spring.study.domain.mapping.MemberQuestion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor//이 어노테이션이 없으면 @Builder에 에러가 뜨는데 왜일까?
//전체 생성자 만들어주는 에노테이션, 얘가 없으면 생성자가 없게 되니까 Builder를 쓸 수 없게 됨
@DynamicInsert
@DynamicUpdate
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;//LocalDate import 해줘야 함

    //@Column(nullable = false, length = 50)
    private String email;

    //List<>는 <>안에 값들로 List를 만든다는 뜻이고 = new ArrayList<>()를 해주는 이유는 이걸 안해주면 초기화가 안돼있어서 나중에 오류 생길 수 있어서
    @Setter
    @ColumnDefault("0")
    private Integer point;

    @ColumnDefault("1")
    private Integer questionCount;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Pet pet;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberQuestion> memberQuestionsList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)//양방향 매핑을 위한 OneToMany
    private List<MemberAgree> memberAgreeList = new ArrayList<>();//리스트 형식으로 저장하기 위한 코드
//@OneToMany는 1에 해당하는 엔티티가 N에 해당하는 엔티티와 관계가 있음을 알려줌
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    public void incrementQuestionCount() {
        this.questionCount++;
    }
}
