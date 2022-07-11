package CatCafe;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Table", schema = "public", catalog = "shorivar")
public class TableEntity {
    private int tableNum;
    private String hall;
    private CatCafeEntity catCafeByHall;

    @Id
    @Column(name = "table_num")
    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    @Basic
    @Column(name = "hall")
    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableEntity that = (TableEntity) o;
        return tableNum == that.tableNum && Objects.equals(hall, that.hall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableNum, hall);
    }

    @ManyToOne
    @JoinColumn(name = "hall", referencedColumnName = "venue", nullable = false)
    public CatCafeEntity getCatCafeByHall() {
        return catCafeByHall;
    }

    public void setCatCafeByHall(CatCafeEntity catCafeByHall) {
        this.catCafeByHall = catCafeByHall;
    }
}
