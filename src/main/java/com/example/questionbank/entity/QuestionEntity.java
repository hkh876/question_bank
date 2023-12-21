package com.example.questionbank.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(name = "question_type", nullable = false)
    private String type;

    @Column(nullable = false)
    private String title;

    private int answer;

    @Column(columnDefinition = "tinyint(1)")
    @ColumnDefault(value = "false")
    private boolean saved;

    @Column(columnDefinition = "tinyint(1)")
    @ColumnDefault(value = "false")
    private boolean hasPassage;
    private String passageUrl;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ChoiceEntity> choices = new ArrayList<>();

    @Builder
    public QuestionEntity(String type, String title, int answer) {
        this.type = type;
        this.title = title;
        this.answer = answer;
    }

    public void update(boolean saved) {
        this.saved = saved;
    }
}
