package pl.hyla.labone.repository;

import pl.hyla.labone.domain.autoPartTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutoPartServiceImpl {
    public List<autoPartTime> partList = new ArrayList<>();

    public void addPart(autoPartTime part){
        partList.add(part);
        part.setCreateTime(new Date());
    }

}
