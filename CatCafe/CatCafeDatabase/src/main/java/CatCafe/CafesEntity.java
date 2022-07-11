package CatCafe;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Cafes", schema = "public", catalog = "shorivar")
public class CafesEntity {
    private String locationOfCafe;
    private CatCafeEntity catCafeByLocationOfCafe;

    @Id
    @Column(name = "location_of_cafe")
    public String getLocationOfCafe() {
        return locationOfCafe;
    }

    public void setLocationOfCafe(String locationOfCafe) {
        this.locationOfCafe = locationOfCafe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CafesEntity that = (CafesEntity) o;
        return Objects.equals(locationOfCafe, that.locationOfCafe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationOfCafe);
    }

    @OneToOne(mappedBy = "cafesByVenue")
    public CatCafeEntity getCatCafeByLocationOfCafe() {
        return catCafeByLocationOfCafe;
    }

    public void setCatCafeByLocationOfCafe(CatCafeEntity catCafeByLocationOfCafe) {
        this.catCafeByLocationOfCafe = catCafeByLocationOfCafe;
    }
}
