package tk.madhavareddy.digitaldiary.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="DIARY_EVENT")
@Setter
@Getter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private int id;
    @Column(name="EVENT_NAME")
    private String eventName;
    @Column(name="EVENT_CONTENT")
    private String eventContent;
    @Column(name="EVENT_TAGS")
    private String eventTags;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="DD_ID",nullable = false)
    private Diary diary;
}
