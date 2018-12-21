package tk.madhavareddy.digitaldiary.persistence.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="DIGITAL_DIARY")
@Data
public class Diary {
    @Id
    @GeneratedValue
    @Column(name="DD_ID")
    int id;
    @Column(name="CONTENT")
    String content;
    @Column(name="CONTENT_DATE")
    LocalDate contentDate;
    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "diary")
    Location location;
}
