package lt.swedbank.itacademy.domain;

import java.util.Date;

public class HouseLoan extends RealEstateLoan {
    private Date constructionDate;
    private int floorCount;

    public Date getConstructionDate() {
        return constructionDate;
    }

    public void setConstructionDate(Date constructionDate) {
        this.constructionDate = constructionDate;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }
}
