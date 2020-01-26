package pl.hyla.labone.domain;

public class autoPart {
    public int id;
    public String partName;
    public int price;

    public autoPart(){

    }

    public autoPart(String name, int price) {
        this.partName=name;
        this.price=price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
