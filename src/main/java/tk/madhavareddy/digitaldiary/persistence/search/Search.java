package tk.madhavareddy.digitaldiary.persistence.search;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Search {
    String searchTerm;
    String order;
    String orderByField;
}
