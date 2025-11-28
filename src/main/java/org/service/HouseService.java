package org.service;

import org.domain.House;

import java.util.Scanner;

/**
 * 【业务层】
 * 1. 定义 House[] 数组，保存 House 对象
 * 2. 响应 HouseView 类的调用
 * 2. 完成对房屋信息的各种操作（CRUD）
 * 注：增（Create）删（Delete）改（Update）查（Read）
 */
public class HouseService {
    private House[] houses;
    private int houseNumbers = 0;

    public House find(int fID) {
        if (fID >= houseNumbers) {
            return null;
        }
        return houses[fID];
    }

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House("云在", 3680, "上海", 2000, "未出租");
        houses[1] = new House("云在1", 3681, "上海1", 2001, "未出租");
        houses[2] = new House("云在2", 3682, "上海2", 2002, "未出租");
        houses[3] = new House("云在3", 3683, "上海3", 2003, "未出租");
        houseNumbers = 4;
    }

    public boolean delete(int dID) {
        if (dID >= houseNumbers) {
            return false;
        }
        houses[dID] = null;

        int write = 0;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != null) {
                houses[write++] = houses[i];
            }
        }
        houseNumbers = write;
        while (write < houses.length) {
            houses[write++] = null;
        }

        return true;
    }

    public boolean add(House newHouse) {
        if (houseNumbers == houses.length) {
            return false;
        }
        houses[houseNumbers++] = newHouse;
        return true;
    }

    public House[] list() {
        return houses;
    }
}