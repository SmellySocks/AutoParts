package pl.hyla.labone.DAO;
import pl.hyla.labone.domain.autoPart;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PartDao implements DAO<autoPart> {

    protected Map<Long, autoPart> parts;

    @Override
    public Optional<autoPart> get(Long id) throws IllegalArgumentException{
        if (!parts.containsKey(id))
            throw new IllegalArgumentException("Key doesn't exist");

        return Optional.ofNullable(parts.get(id));
    }
    @Override
    public List<autoPart> getAll(){
        return parts.entrySet().stream().map(x->x.getValue()).collect(Collectors.toList());
    }
    @Override
    public void delete(Long id) throws IllegalArgumentException{
        if(!parts.containsKey(id))
            throw new IllegalArgumentException("Key doesn't exist");
        parts.remove(id);
    }
    @Override
    public void update(autoPart o) throws IllegalArgumentException{

        if(!parts.containsKey(o.getId()))
            throw new IllegalArgumentException("Key doesn't exist");
        parts.put(o.getId(), o);
    }
}
