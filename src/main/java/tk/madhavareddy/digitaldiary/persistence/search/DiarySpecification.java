package tk.madhavareddy.digitaldiary.persistence.search;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;

import static org.springframework.data.jpa.domain.Specification.where;
@Component
public class DiarySpecification  extends BaseSpecification<Diary, Search>{
    @Override
    public Specification<Diary> getFilter(Search request) {
        return (root, query, cb) -> {
            query.distinct(true);
            return where(diaryEvetContains(request.searchTerm))
                    .toPredicate(root, query, cb);
        };
    }
    private Specification<Diary> diaryEvetContains(String eventContent) {
        return userAttributeEqual("status", eventContent);
    }
    private Specification<Diary> userAttributeEqual(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }
            return cb.equal(
                    cb.lower(root.get(attribute)),
                    Integer.parseInt(value)
            );
        };
    }
    private Specification<Diary> userAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }
            return cb.like(
                    cb.lower(root.get(attribute)),
                    containsLowerCase(value)
            );
        };
    }


}


