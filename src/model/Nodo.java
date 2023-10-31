package model;

public class Nodo {
    public String name;
    public Integer money;
    public String country;
    public Integer employees;
    public Nodo sig;

    public Nodo (String name,Integer money,String country,Integer employees){
        this.name = name;
        this.money = money;
        this.country = country;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "model.Nodo{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", country='" + country + '\'' +
                ", employees=" + employees +
                ", sig=" + sig +
                '}';
    }
}
