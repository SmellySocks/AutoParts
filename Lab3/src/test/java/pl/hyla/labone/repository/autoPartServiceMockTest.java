package pl.hyla.labone.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.sql.*;
import pl.hyla.labone.DAO.DAO;
import pl.hyla.labone.DAO.autoPartDaoImpl;
import pl.hyla.labone.domain.autoPartTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class autoPartServiceMockTest {
    @Mock
    Connection connectionMock;
    @Mock
    PreparedStatement addPartStmt;
    @Mock
    PreparedStatement getAutoPartByID;
    @Mock
    PreparedStatement updateDateAutoPart;
    @Mock
    PreparedStatement getTimeFromAutoPart;

    private DAO dao;

    @Before
    public void setup() throws SQLException{
        when(connectionMock.prepareStatement("INSERT INTO AutoPart (name, price, createTime) VALUES (?, ?, now())")).thenReturn(addPartStmt);
        dao = new autoPartDaoImpl();
        dao.setConnection(connectionMock);
    }
    @Test
    public void checkGetting() throws SQLException{
        AbstractResultSet resultSet = mock(AbstractResultSet.class);
        when(resultSet.next()).thenCallRealMethod();
        when(resultSet.getInt(any())).thenCallRealMethod();
        when(resultSet.getString(any())).thenCallRealMethod();


        when(connectionMock.prepareStatement("SELECT * FROM AutoPart WHERE id = 1")).thenReturn(getAutoPartByID);
        when(getAutoPartByID.executeQuery()).thenReturn(resultSet);
        when(connectionMock.prepareStatement("UPDATE AutoPart SET readTime = now() WHERE id = 1")).thenReturn(updateDateAutoPart);


        dao.findPartById(1);

        verify(connectionMock).prepareStatement("SELECT * FROM AutoPart WHERE id = 1");
        verify(getAutoPartByID, times(1)).executeQuery();
        verify(connectionMock).prepareStatement("UPDATE AutoPart SET readTime = now() WHERE id = 1");

        verify(resultSet, times(1)).getInt("id");
        verify(resultSet, times(1)).getInt("price");
        verify(resultSet, times(1)).getString("name");
        verify(resultSet, times(1)).getDate("createTime");


    }

    @Test
    public void checkUpdate() throws SQLException{
        AbstractResultSet abstractResultSet = mock(AbstractResultSet.class);

        when(connectionMock.prepareStatement("UPDATE AutoPart SET name = updatedName WHERE id = 1")).thenReturn(updateDateAutoPart);
        when(updateDateAutoPart.executeQuery()).thenReturn(abstractResultSet);
        when(connectionMock.prepareStatement("UPDATE AutoPart SET modifyTime = now() WHERE id = 1")).thenReturn(updateDateAutoPart);

        dao.updatePartName(1, "updatedName");

        verify(connectionMock).prepareStatement("UPDATE AutoPart SET name = updatedName WHERE id = 1");
        verify(updateDateAutoPart, times(2)).executeQuery();

    }
    @Test
    public void checkAddNewRecord() throws SQLException{
        when(addPartStmt.executeUpdate()).thenReturn(1);
        autoPartTime autoPartTime = new autoPartTime("Defroster", 490);
        assertEquals(1, dao.addPart(autoPartTime));
        verify(addPartStmt, times(1)).setString(1,"Defroster");
        verify(addPartStmt, times(1)).setInt(2,490);
        verify(connectionMock).prepareStatement("INSERT INTO AutoPart (name, price, createTime) VALUES (?, ?, now())");
    }
    @Test
    public void getTimeOfCreateEditUpdate() throws SQLException{
        AbstractResultSet abstractResultSet = mock(AbstractResultSet.class);
        when(abstractResultSet.getDate(any())).thenCallRealMethod();
        autoPartTime autoPartTime = new autoPartTime("aaa", 123);
        autoPartTime.setId(1);

    when(connectionMock.prepareStatement("SELECT createTime FROM AutoPart WHERE id = 1")).thenReturn(getTimeFromAutoPart);
    when(getTimeFromAutoPart.executeQuery()).thenReturn(abstractResultSet);
    dao.checkDateInDatabase(autoPartTime, 1);
    verify(abstractResultSet, times(1)).getDate("creationDate");
    }

    abstract class AbstractResultSet implements ResultSet{
        int i = 0;

        @Override
        public int getInt(String s) throws SQLException {
            return 1;
        }

        @Override
        public String getString(String columnLabel) throws SQLException {
            return "nie wiem co robie";
    }

        @Override
        public Date getDate(String columnLabel) {
            return new Date(123456);
        }

        @Override
        public boolean next() throws SQLException {
            if (i == 1)
                return false;
            i++;
            return true;
        }
    }

}
