package pl.hyla.labone.DAO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import pl.hyla.labone.domain.autoPart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(BlockJUnit4ClassRunner.class)
public class AutoPartDaoTest {

    PartDao dao;
    PartDao daoTest;

    @Before
    public void initData(){
        autoPart p1 = new autoPart();
        autoPart p2 = new autoPart();

        p1.setId(1L);
        p1.setPartName("Clutch");
        p1.setPrice(280);

        p2.setId(2L);
        p2.setPartName("brake pad");
        p2.setPrice(110);

        dao = new PartDao();
        daoTest = new PartDao();

        dao.parts = new HashMap<>();
        daoTest.parts = new HashMap<>();

        dao.parts.put(1L,p1);
        dao.parts.put(2L,p2);

        daoTest.parts.put(1L,p1);
        daoTest.parts.put(2L,p2);
    }
    @Test
    public void createDaoCheck(){
        assertNotNull(dao);
    }

    @Test(expected = IllegalArgumentException.class)
    public void redDaoExceptionCheck(){
        dao.get(20L);
    }
    @Test
    public void readDaoCheck(){
        Optional <autoPart> autoPart = dao.get(1L);
        assertThat(autoPart.get().getPartName(), is("Clutch"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void updateDaoExceptionTest(){
        autoPart part = new autoPart();
        part.setId(11L);
        part.setPartName("rim");
        part.setPrice(1200);
        dao.update(part);
    }
    @Test
    public void updateDaoCheck(){
        autoPart p1 = new autoPart();
        p1.setId(1L);
        p1.setPartName("tyre");
        p1.setPrice(290);

        daoTest.parts.put(1L,p1);
        System.out.println(dao.parts.values().toString());

        Collection<autoPart> expected = daoTest.parts.values();

        System.out.println(expected.toString());
        dao.update(p1);

        Collection<autoPart> real = dao.parts.values();
        System.out.println(real.toString());
        assertArrayEquals(expected.toArray(),real.toArray());

    }
    @Test
    public void deleteDaoCheck(){
        autoPart p1 = new autoPart();
        p1.setId(1L);
        p1.setPartName("Clutch");
        p1.setPrice(120);

        daoTest.parts.remove(1L);
        Collection<autoPart> expected = daoTest.parts.values();
        dao.delete(1L);
        Collection<autoPart> real = dao.parts.values();
        assertArrayEquals(expected.toArray(), real.toArray());
    }

    @Test
    public void readAllCheck(){
        Collection<autoPart> test = dao.parts.values();
        assertArrayEquals(test.toArray(), dao.getAll().toArray());
    }


}
