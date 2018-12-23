package tk.madhavareddy.digitaldiary.presentation.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@ToString
public class Diary {
    @Min(0)
    @Max(0)
    int id;
    @NotNull
    private Set<Event> events;
    @DateTimeFormat
    private LocalDate contentDate;
    @NotNull
    private Location location;
}
