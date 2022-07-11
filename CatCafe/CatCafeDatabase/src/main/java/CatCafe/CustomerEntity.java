package CatCafe;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "Customer", schema = "public", catalog = "shorivar")
public class CustomerEntity {
    private int number;
    private Time order;
    private int table;

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "order")
    public Time getOrder() {
        return order;
    }

    public void setOrder(Time order) {
        this.order = order;
    }

    @Basic
    @Column(name = "table")
    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return number == that.number && table == that.table && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, order, table);
    }
}
