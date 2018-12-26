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
    private int id;
    @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL, mappedBy = "diary")
    private Set<Event> events;
    @Column(name="CONTENT_DATE")
    private LocalDate contentDate;
    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "diary")
    private Location location;
    @Column(name="STATUS")
    private int status;



}
