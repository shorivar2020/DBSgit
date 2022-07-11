package CatCafeDo;

import CatCafe.OrderEntity;
import CatCafe.WorkerEntity;

import java.sql.Time;
public class Main {
    public static void main(String[] args) {
        Action a = new Action();
        WorkerEntity w = a.addNewWorker(10, 30, "John White", "RedStreet 22");
        OrderEntity o = a.addOrder(Time.valueOf("12:00"), 20, 1, "Salad, tea", w);
        a.removeOrder(o);
        OrderEntity o2 = a.addOrder(Time.valueOf("13:00"), 20, 1, "Salad, tea", w);
        a.myCustomer();
        a.myOrder();
        a.myCat();
        a.close();
    }
}
