package org.view;

import org.domain.House;
import org.service.HouseService;

import java.util.Scanner;

/**
 * 【界面层】
 * 1. 显示界面
 * 2. 接收用户的输入
 * 3. 调用 HouseService 完成对房屋信息的各种操作
 */
public class HouseView {
    private boolean loop = true; // 控制显示菜单
    private String key; // 接收用户选择
    private Scanner scanner = new Scanner(System.in);
    private HouseService houseService = new HouseService(5);

    public void updateHouse() {
        System.out.println("【系统】正在进入...4 修 改 房 屋 信 息......");
        listHouses();
        System.out.print("【提示】请输入要修改的房屋的编号（-1返回主界面）：");

        int updateId = scanner.nextInt();

        if (updateId == -1) {
            back();
            return;
        }
        if (updateId < -1 || updateId == 0) {
            System.out.println("【错误】输入不合法！");
            back();
            return;
        }
        int uID = updateId - 1;

        House house = houseService.find(uID);

        if (house == null) {
            System.out.println("【错误】输入编号有误！");
            back();
            return;
        }

        System.out.print("【提示】姓名（" + house.getName() + "）：");
        String updateName = scanner.next();
        house.setState(updateName);
        System.out.print("【提示】电话（" + house.getPhone() + "）：");
        int updatePhone = scanner.nextInt();
        house.setPhone(updatePhone);
        System.out.print("【提示】地址（" + house.getAddress() + "）：");
        String updateAddress = scanner.next();
        house.setAddress(updateAddress);
        System.out.print("【提示】租金（" + house.getRent() + "）：");
        double updateRent = scanner.nextDouble();
        house.setRent(updateRent);
        System.out.print("【提示】状态（" + house.isState() + "）：");
        String updateState = scanner.next();
        house.setState(updateState);

        System.out.println("【系统】正在修改......");
        house.toString();
        System.out.println("【系统】修改完成！");
        back();
    }

    public void findHouse() {
        System.out.println("【系统】正在进入...2 查 找 房 屋......");
        listHouses();
        System.out.print("【提示】请输入要查找的房屋的编号（-1返回主界面）：");

        int findId = scanner.nextInt();

        if (findId == -1) {
            back();
            return;
        }
        if (findId < -1 || findId == 0) {
            System.out.println("【错误】输入不合法！");
            back();
            return;
        }
        int fID = findId - 1;

        House house = houseService.find(fID);

        if (house == null) {
            System.out.println("【错误】输入编号有误！");
            back();
            return;
        }
        System.out.println("【系统】找到如下信息：\n" + house.toString());
        back();
    }

    public void deleteHouse() {
        System.out.println("【系统】正在进入...3 删 除 房 屋......");
        listHouses();
        System.out.print("【提示】请输入删除房屋编号（-1返回主界面）：");

        int deleteId = scanner.nextInt();

        if (deleteId == -1) {
            back();
            return;
        }
        if (deleteId < -1 || deleteId == 0) {
            System.out.println("【错误】输入不合法！");
            back();
            return;
        }

        int dID = deleteId - 1;

        if (!isY()){
            back();
            return;
        }
        System.out.println("\n【系统】正在删除 " + deleteId + " 号房屋......");
        if (!houseService.delete(dID)) {
            System.out.println("【错误】输入编号有误！");
            System.out.println("【系统】删除失败！");
            back();
        }
        System.out.println("【系统】删除成功！");
        back();
    }

    public void addHouse() {
        System.out.println("【系统】正在进入...1 新 增 房 屋......");

        // 输入 house 信息
        // 输入姓名
        System.out.print("【提示】姓名：");
        String name = scanner.next();
        // 输入电话
        System.out.print("【提示】电话：");
        int phone = scanner.nextInt();
        // 输入地址
        System.out.print("【提示】地址：");
        String address = scanner.next();
        // 输入月租
        System.out.print("【提示】月租：");
        double rent = scanner.nextDouble();
        // 输入状态
        System.out.print("【提示】状态（未出租/已出租）：");
        String state = scanner.next();

        House newHouse = new House(name, phone, address, rent, state);

        System.out.println("【系统】正在添加......");
        if (!houseService.add(newHouse)) {
            System.out.println("【错误】存储空间已满！");
            System.out.println("【系统】添加失败！");
            back();
            return;
        }
        System.out.println("【系统】添加成功！");
        back();
    }

    public void listHouses() {
        System.out.println("----------------------- 房屋列表 -----------------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(i + 1 + "\t\t" + houses[i].toString());
        }
        System.out.println("------ end -------------- end -------------- end ------");
    }

    public boolean exit() {
        if (!isY()) {
            back();
            return true;
        }
        System.out.println("【系统】正在退出......");
        return false;
    }

    public void mainMenu() {
        do {
            // 打印菜单
            System.out.println("\n【系统】欢迎使用房屋出租系统！正在加载......");
            System.out.println("=========== 房  屋  出  租  系  统 =================================");
            System.out.println("\t\t\t1 新 增 房 屋");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退 出");

            // 交互输入
            System.out.print("【提示】请选择（1-6）：");
            key = scanner.next();

            // switch 分支进入不同界面
            switch (key) {
                case "1": // done
                    addHouse();
                    break;
                case "2": // done
                    findHouse();
                    break;
                case "3": // done
                    listHouses();
                    deleteHouse();
                    break;
                case "4":
                    updateHouse();
                    break;
                case "5": // done
                    System.out.println("【系统】正在进入...5 房 屋 列 表......");
                    listHouses();
                    back();
                    break;
                case "6": // done
                    loop = exit();
                    break;
            }
        } while (loop);
        System.out.println("【系统】已退出！欢迎下次使用。");
    }

    private boolean isY() {
        String choice = "";

        do {
            System.out.print("【提示】您确定吗？y/n：");
            choice = scanner.next();
        } while (!"y".equals(choice) && !"n".equals(choice));

        return "y".equals(choice);
    }

    private void back() {
        System.out.println("【系统】正在返回主界面......\n");
    }
}
