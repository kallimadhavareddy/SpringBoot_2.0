package tk.madhavareddy.digitaldiary.presentation.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ObjectMapperUtils {
    private final ModelMapper modelMapper;
    @Autowired
    public ObjectMapperUtils(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    @PostConstruct
    public void init(){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public <D,T> D map(final T entity, Class<D> outClass){
        return modelMapper.map(entity,outClass);
    }
    public <D,T> List<D> mapAll(final Collection<T> entityList, Class<D> outClass){
        return entityList.stream().map(entity->map(entity,outClass)).collect(Collectors.toList());
    }
}
