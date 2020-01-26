package pl.hyla.labone.repository;

import pl.hyla.labone.domain.autoPart;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface AutoPartRepository {
    void  setConnection(Connection connection) throws SQLException;
    Connection getConnection();
    List<autoPart> getAll() throws SQLException;
    autoPart getByID(int id) throws SQLException;
    autoPart getByName(String name) throws SQLException;
    void addAutoPart(autoPart autoPart);
    void deleteAutoPart(autoPart autoPart) throws SQLException;
    void updateAutoPart(int id, autoPart newAutoPart) throws SQLException;
    void dropDataTable() throws SQLException;
}
