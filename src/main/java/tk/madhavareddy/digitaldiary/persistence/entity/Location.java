package tk.madhavareddy.digitaldiary.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="DIG_LOCATION")
@Setter
@Getter
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue
    int id;
    @Column(name="LONGITUDE")
    String longitude;
    @Column(name="LATITUDE")
    String latitude;
    @Column(name="LOCATION")
    String userLocation;
    @Column(name="COUNTRY")
    String country;
    /*
    From the JPA 2.0 spec, the defaults are like so:

OneToMany: LAZY
ManyToOne: EAGER
ManyToMany: LAZY
OneToOne: EAGER
@MapsId
     */
    @OneToOne(fetch=FetchType.EAGER,optional=false)//by default fetch type is eager in JPA
    @JoinColumn(name="DD_ID",nullable=false)
    Diary diary;
}
