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
    @OneToOne(fetch=FetchType.EAGER,optional=false)
    @JoinColumn(name="DD_ID",nullable=false)
    Diary diary;
}
