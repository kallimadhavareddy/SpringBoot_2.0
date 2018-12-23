package tk.madhavareddy.digitaldiary.persistence.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="DIGITAL_DIARY")
@Data
public class Diary {
    @Id
    @GeneratedValue
    @Column(name="DD_ID")
    int id;
    @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL, mappedBy = "diary")
    Set<Event> events;
    @Column(name="CONTENT_DATE")
    LocalDate contentDate;
    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "diary")
    Location location;
}
