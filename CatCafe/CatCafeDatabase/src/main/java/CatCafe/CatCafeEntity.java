package CatCafe;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CatCafe", schema = "public", catalog = "shorivar")
public class CatCafeEntity {
    private String venue;
    private String menu;
    private int money;
    private CafesEntity cafesByVenue;
    private Collection<TableEntity> tablesByVenue;
    private Collection<WorkerEntity> workersByVenue;

    @Id
    @Column(name = "venue")
    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Basic
    @Column(name = "menu")
    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Basic
    @Column(name = "money")
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatCafeEntity that = (CatCafeEntity) o;
        return money == that.money && Objects.equals(venue, that.venue) && Objects.equals(menu, that.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venue, menu, money);
    }

    @OneToOne
    @JoinColumn(name = "venue", referencedColumnName = "location_of_cafe", nullable = false)
    public CafesEntity getCafesByVenue() {
        return cafesByVenue;
    }

    public void setCafesByVenue(CafesEntity cafesByVenue) {
        this.cafesByVenue = cafesByVenue;
    }

    @OneToMany(mappedBy = "catCafeByHall")
    public Collection<TableEntity> getTablesByVenue() {
        return tablesByVenue;
    }

    public void setTablesByVenue(Collection<TableEntity> tablesByVenue) {
        this.tablesByVenue = tablesByVenue;
    }

    @OneToMany(mappedBy = "catCafeByWorkplace")
    public Collection<WorkerEntity> getWorkersByVenue() {
        return workersByVenue;
    }

    public void setWorkersByVenue(Collection<WorkerEntity> workersByVenue) {
        this.workersByVenue = workersByVenue;
    }
}
