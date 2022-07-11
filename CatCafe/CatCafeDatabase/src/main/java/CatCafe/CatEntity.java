package CatCafe;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Cat", schema = "public", catalog = "shorivar")
public class CatEntity {
    private int catId;
    private String name;
    private int tray;
    private int bowl;
    private int whoCare;
    private String whereLive;

    @Basic
    @Column(name = "cat_id")
    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "tray")
    public int getTray() {
        return tray;
    }

    public void setTray(int tray) {
        this.tray = tray;
    }

    @Basic
    @Column(name = "bowl")
    public int getBowl() {
        return bowl;
    }

    public void setBowl(int bowl) {
        this.bowl = bowl;
    }

    @Basic
    @Column(name = "who_care")
    public int getWhoCare() {
        return whoCare;
    }

    public void setWhoCare(int whoCare) {
        this.whoCare = whoCare;
    }

    @Basic
    @Column(name = "where_live")
    public String getWhereLive() {
        return whereLive;
    }

    public void setWhereLive(String whereLive) {
        this.whereLive = whereLive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatEntity catEntity = (CatEntity) o;
        return catId == catEntity.catId && tray == catEntity.tray && bowl == catEntity.bowl && whoCare == catEntity.whoCare && Objects.equals(name, catEntity.name) && Objects.equals(whereLive, catEntity.whereLive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catId, name, tray, bowl, whoCare, whereLive);
    }
}
