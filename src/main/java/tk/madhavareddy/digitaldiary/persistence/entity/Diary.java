package tk.madhavareddy.digitaldiary.persistence.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tk.madhavareddy.digitaldiary.persistence.model.Status;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="DIGITAL_DIARY")
@Getter
@Setter
@NoArgsConstructor
public class Diary {
    @Id
    @GeneratedValue
    int id;
    @Column(name="CONTENT")
    String content;
    @Column(name="CONTENT_DATE")
    LocalDate contentDate;
    @Enumerated
    @Column(name="STATUS")
    Status status;
}
