package org;

import org.view.HouseView;

/**
 * 【程序入口】
 * main 函数中创建 HouseView 对象
 * 并调用，显示主菜单
 */
public class HouseApp {

    public static void main(String[] args) {
        new HouseView().mainMenu();
    }
}
