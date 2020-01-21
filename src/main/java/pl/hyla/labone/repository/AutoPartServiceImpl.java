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
    public void renameAutoPart(Long id, String name){
        for(autoPartTime part : partList){
            if(part.id == id){
                part.partName = name;
                part.setModifyTime(new Date());
            }
        }
    }
    public autoPartTime getByID (Long id){
        try{
            for(autoPartTime s : partList){
                if(s.id == id){
                    s.setReadTime(this.setCurrentDate());
                    return s;
                }
            }

        } catch(IllegalArgumentException e){

        }
        throw new IllegalArgumentException("not found");
    }

    public Date setCurrentDate(){
        return new Date();
    }

}
