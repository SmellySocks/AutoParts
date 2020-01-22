package pl.hyla.labone.repository;

import pl.hyla.labone.domain.autoPartTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutoPartServiceImpl {

    public List<autoPartTime> partList = new ArrayList<>();

    public void addPart(autoPartTime part){
        partList.add(part);
        part.setCreateTime(new Date());
    }
    public autoPartTime addAutoPartDate(autoPartTime part){
        partList.add(part);
        part.setCreateTime(new Date());
        return part;
    }
    public void removeAutoPart(autoPartTime autoPart){
        partList.remove(autoPart);
    }

    public void renameAutoPart(int id, String name){
        for(autoPartTime part : partList){
            if(part.id == id){
                part.partName = name;
                part.setModifyTime(new Date());
            }
        }
    }
    public autoPartTime getByID (int id){
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
    public List<autoPartTime> getPartList(){
        return partList;
    }
    public Date dateConverterFromString(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        return sdf.parse(dateString);
    }
    public autoPartTime autoPartTimeWitReadDate(String autoPartName){
        autoPartTime autoPartTimeToReturn = null;
        for (autoPartTime autoPartTime : partList){
            if(autoPartTime.getPartName().equals(autoPartName)){
                autoPartTime.setReadTime(new Date());
                autoPartTimeToReturn = autoPartTime;
            }
        }
        return autoPartTimeToReturn;
    }
    public autoPartTime updatePartName(String currentName, String newName){
        autoPartTime partTimeToReturn = null;
        for(autoPartTime autoPartTime : partList){
            if(autoPartTime.getPartName().equals(currentName)){
                autoPartTime.setPartName(newName);
                autoPartTime.setModifyTime(new Date());
                partTimeToReturn = autoPartTime;
            }
        }
        return partTimeToReturn;
    }
    public autoPartTime multiDateUpdate(autoPartTime partTime, boolean createDate, Date createDateInfo, boolean readDate, Date readDateInfo, boolean modifyDate, Date modifyDateInfo){
        if (createDate)
            partTime.setCreateTime(createDateInfo);
        if (readDate)
            partTime.setReadTime(readDateInfo);
        if (modifyDate)
            partTime.setModifyTime(modifyDateInfo);
        return partTime;
    }

}
