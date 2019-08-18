package tk.madhavareddy.digitaldiary.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@Setter
@Getter
public class CompositeIdentity implements Serializable {
    @Column(name="COL_1")
    int idOne;
    @Column(name="COL_2")
    int idTwo;
}
