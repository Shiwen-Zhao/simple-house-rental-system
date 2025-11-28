package org.domain;

/**
 * 【实体层 domain/model 即数据层】
 * 一个 House 对象就是一个房屋信息
 */
public class House {
    private String name;
    private int phone;
    private String address;
    private double rent;
    private String state;

    public House(String name, int phone, String address, double rent, String state) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String isState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String toString() {
        return  name +
                "\t\t" + phone +
                "\t\t" + address +
                "\t\t" + rent +
                "\t\t" + state;
    }
}
