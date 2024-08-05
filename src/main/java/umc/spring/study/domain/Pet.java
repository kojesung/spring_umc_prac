package umc.spring.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.study.domain.common.BaseEntity;
import umc.spring.study.domain.enums.Gender;
import umc.spring.study.domain.enums.PetType;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Pet extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String species;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PetType petType;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = true, length = 255)
    private String profileImage;

    @Column(nullable = false)
    private double weight;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, length = 10)
    private Gender gender;

    @Column(nullable = true, length = 20)
    private String code;

    @Column(nullable = true)
    private Boolean neuter;
}