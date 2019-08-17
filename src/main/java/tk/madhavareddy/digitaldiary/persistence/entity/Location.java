package tk.madhavareddy.digitaldiary.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


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
    @OneToOne(fetch= FetchType.LAZY,optional=false)
    @JoinColumn(name="DD_ID",nullable=false)
    @JsonIgnore
    Diary diary;
}
