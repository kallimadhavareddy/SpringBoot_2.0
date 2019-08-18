package tk.madhavareddy.digitaldiary.persistence.entity;

import lombok.Data;
import tk.madhavareddy.digitaldiary.persistence.model.Status;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="DIGITAL_DIARY")
@Data
public class Diary {
    @EmbeddedId
    CompositeIdentity compositeIdentity;
    @Column(name="CONTENT")
    String content;
    @Column(name="CONTENT_DATE")
    LocalDate contentDate;
    @Enumerated
    @Column(name="STATUS")

@OneToOne
    Status status;
}
