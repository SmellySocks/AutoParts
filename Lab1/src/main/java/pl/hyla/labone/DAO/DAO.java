package pl.hyla.labone.DAO;
import pl.hyla.labone.domain.autoPart;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    public Optional get (Long id) throws IllegalArgumentException;
    public List<T> getAll();
    public void delete(Long id) throws IllegalArgumentException;
    public void update(T o) throws IllegalArgumentException;

}
