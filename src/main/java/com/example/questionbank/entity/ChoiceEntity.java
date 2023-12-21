package com.example.questionbank.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "choice_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChoiceEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choice_id")
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "tinyint(1)")
    @ColumnDefault(value = "false")
    private boolean hasTip;

    @Column(length = 1000)
    private String tip;

    @Column(columnDefinition = "tinyint(1)")
    @ColumnDefault(value = "false")
    private boolean capturedTip;

    private String tipUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionEntity question;

    @Builder
    public ChoiceEntity(String content, QuestionEntity question) {
        this.content = content;
        this.question = question;
    }
}
