package pl.hyla.labone.domain;

import org.junit.Before;
import org.junit.Test;
import pl.hyla.labone.repository.AutoPartServiceImpl;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class mockTest {
    AutoPartServiceImpl part = new AutoPartServiceImpl();

    @Before
    public void before(){
        autoPartTime p1 = new autoPartTime("Clutch", 280);
        autoPartTime p2 = new autoPartTime("Gear Selector", 390);
        p1.setCreateTime(new Date());
        part.partList.add(p1);
        part.partList.add(p2);

        try{
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        p2.setCreateTime(new Date());
    }

    @Test
    public void doesPartListExist(){
        assertNotNull(part);
    }
    @Test
    public void checkIfDateExists(){
        assertNotNull(part.getByID(1).getCreateTime());
    }
    @Test
    public void checkCreateDates(){
        assertNotEquals(part.getByID(1).getCreateTime(), part.getByID(2).getCreateTime());
    }
    @Test
    public void getByID(){
        assertNotNull(part.getByID(1));
    }
    @Test
    public void countEntities(){
        assertEquals(2,part.partList.size());
    }
    @Test
    public void renameEntity(){
        part.renameAutoPart(1, "New Name");
        assertEquals("New Name", part.getByID(1).partName);
    }
    @Test
    public void checkReadDate(){
        assertNotNull(part.getByID(1).getReadTime());
    }
    @Test
    public void checkModifyDate(){
        part.renameAutoPart(1, "new name");
        assertNotNull((part.getByID(1).getModifyTime()));
    }



}
