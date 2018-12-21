package tk.madhavareddy.digitaldiary.presentation.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Setter
@Getter
@ToString
public class Diary {
    @Min(0)
    @Max(0)
    int id;
    @NotNull
    String content;
    @DateTimeFormat
    LocalDate contentDate;
    @NotNull
    Location location;
}
