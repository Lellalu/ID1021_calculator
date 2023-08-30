package se.kth.id1021;

public class Item {
    private ItemType type;
    private int value = 0;

    public Item (ItemType type){
        this.type = type;
    }

    public Item (ItemType type, int value){
        this.type = type;
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public ItemType getType(){
        return type;
    }

    public enum ItemType {
        ADD,
        SUB,
        MUL,
        DIV,
        VALUE
    }
}

