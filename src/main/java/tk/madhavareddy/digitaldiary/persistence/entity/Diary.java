package tk.madhavareddy.digitaldiary.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name="DIGITAL_DIARY")
public class Diary {
    @Id
    @GeneratedValue
    int id;
    @Column(name="CONTENT")
    String content;
    @Column(name="CONTENT_DATE")
    LocalDate contentDate;
    @Column(name="LOCATION")
    String location;
}
