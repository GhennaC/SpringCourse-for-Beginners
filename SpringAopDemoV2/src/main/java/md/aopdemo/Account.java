package md.aopdemo;

public class Account {

    private String name;
    private String level;


    public  Account() {

    }

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        System.out.println(getClass() + "getter Name");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + "setter Name");
        this.name = name;
    }

    public String getLevel() {
        System.out.println(getClass() + "getter level");
        return level;
    }

    public void setLevel(String level) {
        System.out.println(getClass() + "getter level");
        this.level = level;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
