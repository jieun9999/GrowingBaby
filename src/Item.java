public class Item {
    public String use;
    public String name;
    public int price;

    public int num;

    public Item(String name, int price, int num, String use) {
        this.name = name;
        this.price = price;
        this.num = num;
        this.use = use;
    }

    public void setNum(int num) { //1개씩 소비
        this.num += num;
    }

    public int getNum() {
        return num;
    }
}
