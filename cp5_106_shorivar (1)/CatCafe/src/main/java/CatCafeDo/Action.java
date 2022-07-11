package CatCafeDo;

import CatCafe.CatEntity;
import CatCafe.CustomerEntity;
import CatCafe.OrderEntity;
import CatCafe.WorkerEntity;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

public class Action {
    EntityManagerFactory factory;
    EntityManager manager;
    public Action() {
        factory = Persistence.createEntityManagerFactory("default");
        manager = factory.createEntityManager();
    }
    public void close() {
        manager.close();
        factory.close();
    }

    public OrderEntity addOrder(Time time, int cost, int table, String food, WorkerEntity worker){
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        if (!transaction.isActive())transaction.begin();
        OrderEntity o = new OrderEntity();
        o.setTime(time);
        o.setCost(cost);
        o.setTable(table);
        o.setTypeOfFood(food);
        o.setWorkerByWorkerWhoDo(worker);
        manager.persist(o);
        transaction.commit();
        return o;
    }

    public WorkerEntity addNewWorker(int id, int salary, String infoAboutPerson, String workplace){
        manager.getTransaction().begin();
        EntityTransaction t = manager.getTransaction();
        if (!t.isActive())t.begin();
        WorkerEntity w = new WorkerEntity();
        w.setId(id);
        w.setSalary(salary);
        w.setInfoAboutPerson(infoAboutPerson);
        w.setWorkplace(workplace);
        manager.persist(w);
        t.commit();
        return w;
    }

    public void removeOrder(OrderEntity order){
        EntityTransaction t = manager.getTransaction();
        t.begin();
        manager.remove(order);
        manager.flush();
        t.commit();
    }

    public void myOrder(){
        TypedQuery<OrderEntity> q = manager.createQuery("SELECT o FROM OrderEntity AS o", OrderEntity.class);
        List<OrderEntity> l = q.getResultList();
        System.out.println("Order:");
        for (OrderEntity o : l) {
            System.out.println(o);
        }
    }

    public void myCustomer(){
        TypedQuery<CustomerEntity> q = manager.createQuery("SELECT c FROM CustomerEntity AS c ", CustomerEntity.class);
        List<CustomerEntity> l = q.getResultList();
        System.out.println("Customer:");
        for (CustomerEntity c : l) {
            System.out.println(c);
        }
    }

    public void myCat(){
        TypedQuery<CatEntity> q = manager.createQuery("SELECT c FROM CatEntity AS c", CatEntity.class);
        List<CatEntity> l = q.getResultList();
        System.out.println("Cats:");
        for (CatEntity c : l) {
            System.out.println(c);
        }
    }

    public void CustomerOrder(){
        TypedQuery<CustomerEntity> q = manager.createQuery("SELECT c FROM CustomerEntity AS c WHERE c.order= :order", CustomerEntity.class);
        List<CustomerEntity> l = q.getResultList();
        System.out.println("Order of Customer:");
        for (CustomerEntity c : l) {
            System.out.println(c);
        }


    }
}
