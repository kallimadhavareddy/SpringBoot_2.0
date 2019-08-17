package tk.madhavareddy.digitaldiary.persistence.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    //default fetch type is EAGER
    @OneToOne(fetch= FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "diary")
    Location location;
}
