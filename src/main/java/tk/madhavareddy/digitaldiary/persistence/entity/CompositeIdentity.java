package tk.madhavareddy.digitaldiary.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;


@Embeddable
public class CompositeIdentity implements Serializable {
    @Column(name="COL_1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idOne;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COL_2")
    int idTwo;
}
