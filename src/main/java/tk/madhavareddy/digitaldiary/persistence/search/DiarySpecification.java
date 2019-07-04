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
        return diaryAttributeEqual("status", eventContent);
    }
    private Specification<Diary> diaryAttributeEqual(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }
            return cb.equal(
                    cb.lower(root.get(attribute)),Integer.parseInt(value)
            );
        };
    }
    /*
    Note: Date Search should be equal.
    Since one to many could not able to do string search.
    Consider below example for string search incase you added any string value in the Diary Class.

    private Specification<Diary> diaryAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }
            return cb.like(
                    cb.lower(root.get(attribute)),
                    containsLowerCase(value)
            );
        };
    }*/


}


