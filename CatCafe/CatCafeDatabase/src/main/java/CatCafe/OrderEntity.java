package CatCafe;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "Order", schema = "public", catalog = "shorivar")
public class OrderEntity {
    private Time time;
    private int cost;
    private int table;
    private String typeOfFood;
    private int workerWhoDo;
    private WorkerEntity workerByWorkerWhoDo;

    @Id
    @Column(name = "time")
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Basic
    @Column(name = "cost")
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "table")
    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    @Basic
    @Column(name = "type_of_food")
    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    @Basic
    @Column(name = "worker_who_do")
    public int getWorkerWhoDo() {
        return workerWhoDo;
    }

    public void setWorkerWhoDo(int workerWhoDo) {
        this.workerWhoDo = workerWhoDo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return cost == that.cost && table == that.table && workerWhoDo == that.workerWhoDo && Objects.equals(time, that.time) && Objects.equals(typeOfFood, that.typeOfFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, cost, table, typeOfFood, workerWhoDo);
    }

    @ManyToOne
    @JoinColumn(name = "worker_who_do", referencedColumnName = "id", nullable = false)
    public WorkerEntity getWorkerByWorkerWhoDo() {
        return workerByWorkerWhoDo;
    }

    public void setWorkerByWorkerWhoDo(WorkerEntity workerByWorkerWhoDo) {
        this.workerByWorkerWhoDo = workerByWorkerWhoDo;
    }
}
