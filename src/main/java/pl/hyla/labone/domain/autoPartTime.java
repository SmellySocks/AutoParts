package pl.hyla.labone.domain;

import java.util.Date;

public class autoPartTime extends autoPart {

    Date createTime;
    Date readTime;
    Date modifyTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public autoPartTime(Long id, String name, int price){
        super(id, name, price);
    }

}
