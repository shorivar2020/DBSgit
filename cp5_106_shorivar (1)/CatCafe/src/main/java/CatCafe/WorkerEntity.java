package CatCafe;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Worker", schema = "public", catalog = "shorivar")
public class WorkerEntity {
    private int id;
    private int salary;
    private String infoAboutPerson;
    private String workplace;
    private Collection<OrderEntity> ordersById;
    private CatCafeEntity catCafeByWorkplace;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "info_about_person")
    public String getInfoAboutPerson() {
        return infoAboutPerson;
    }

    public void setInfoAboutPerson(String infoAboutPerson) {
        this.infoAboutPerson = infoAboutPerson;
    }

    @Basic
    @Column(name = "workplace")
    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerEntity that = (WorkerEntity) o;
        return id == that.id && salary == that.salary && Objects.equals(infoAboutPerson, that.infoAboutPerson) && Objects.equals(workplace, that.workplace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary, infoAboutPerson, workplace);
    }

    @OneToMany(mappedBy = "workerByWorkerWhoDo")
    public Collection<OrderEntity> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<OrderEntity> ordersById) {
        this.ordersById = ordersById;
    }

    @ManyToOne
    @JoinColumn(name = "workplace", referencedColumnName = "venue", nullable = false)
    public CatCafeEntity getCatCafeByWorkplace() {
        return catCafeByWorkplace;
    }

    public void setCatCafeByWorkplace(CatCafeEntity catCafeByWorkplace) {
        this.catCafeByWorkplace = catCafeByWorkplace;
    }
}
