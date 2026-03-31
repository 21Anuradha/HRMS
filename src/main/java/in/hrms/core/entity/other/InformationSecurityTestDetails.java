package in.hrms.core.entity.other;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import in.hrms.core.entity.configuration.InformationSecurityAnswers;
import in.hrms.core.entity.configuration.InformationSecurityQuestions;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "information_security_test_details")
public class InformationSecurityTestDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Information_security_test")
    private InformationSecurityTests informationSecurityTest;

    @ManyToOne
    @JoinColumn(name = "info_sec_qst_id")
    @NotNull(message = "Question should not be null")
    private InformationSecurityQuestions isQuestion;

    @ManyToOne
    @JoinColumn(name = "info_sec_ans_id")
    @NotNull(message = "Answer should not be null")
    private InformationSecurityAnswers isAnswer;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

}
