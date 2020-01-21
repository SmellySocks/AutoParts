package pl.hyla.labone.domain;

public class autoPart {
    public Long id;
    public String partName;
    public int price;

    public autoPart(){

    }

    public autoPart(Long id, String name, int price) {
        this.id=id;
        this.partName=name;
        this.price=price;

    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
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
