package in.hrms.core.entity.configuration;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "band_daily_expense")
public class BandDailyExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "band_id")
    private Bands band;

    @NotNull
    private Double travel;

    @NotNull
    private Double food;

    @NotNull
    private Double accommodation;

    @NotNull
    private Double convenience;

    @NotNull
    private Double other;

}
