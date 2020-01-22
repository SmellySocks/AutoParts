package pl.hyla.labone.DAO;
import pl.hyla.labone.domain.autoPart;
import pl.hyla.labone.domain.autoPartTime;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DAO {
    Connection getConnection();

    void setConnection(Connection connection) throws SQLException;

    autoPartTime findPartById(int id) throws SQLException;

    void updateDateInSql(int partId, int typeUpdate) throws SQLException;

    Date checkDateInDatabase(autoPartTime partTime, int dateVariant) throws SQLException;

    Date currentDate();

    int addPart(autoPartTime autoPartTime);
    int updatePartName(int partId, String nameToUpdate) throws SQLException;

    List<autoPartTime> getAllParts();

}
