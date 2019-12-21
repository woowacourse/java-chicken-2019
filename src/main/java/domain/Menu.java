package domain;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final double price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getMenuNumber(){
        return this.number;
    }

    public double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public boolean isChicken(){
        if(this.category == Category.CHICKEN){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
