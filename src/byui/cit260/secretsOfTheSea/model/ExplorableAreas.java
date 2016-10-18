/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author SDababneh
 */
public class ExplorableAreas implements Serializable{
    private String Description;
    private int HasStatue; 
    private String Resource1;
    private String Resource2;
    private int Resource1Quantity;
    private int Resource2Quantity;
    private int TravelDistance;

    public ExplorableAreas() {
    }
    
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getHasStatue() {
        return HasStatue;
    }

    public void setHasStatue(int HasStatue) {
        this.HasStatue = HasStatue;
    }

    public String getResource1() {
        return Resource1;
    }

    public void setResource1(String Resource1) {
        this.Resource1 = Resource1;
    }

    public String getResource2() {
        return Resource2;
    }

    public void setResource2(String Resource2) {
        this.Resource2 = Resource2;
    }

    public int getResource1Quantity() {
        return Resource1Quantity;
    }

    public void setResource1Quantity(int Resource1Quantity) {
        this.Resource1Quantity = Resource1Quantity;
    }

    public int getResource2Quantity() {
        return Resource2Quantity;
    }

    public void setResource2Quantity(int Resource2Quantity) {
        this.Resource2Quantity = Resource2Quantity;
    }

    public int getTravelDistance() {
        return TravelDistance;
    }

    public void setTravelDistance(int TravelDistance) {
        this.TravelDistance = TravelDistance;
    }

    @Override
    public String toString() {
        return "ExplorableAreas{" + "Description=" + Description + ", HasStatue=" + HasStatue + ", Resource1=" + Resource1 + ", Resource2=" + Resource2 + ", Resource1Quantity=" + Resource1Quantity + ", Resource2Quantity=" + Resource2Quantity + ", TravelDistance=" + TravelDistance + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.Description);
        hash = 59 * hash + this.HasStatue;
        hash = 59 * hash + Objects.hashCode(this.Resource1);
        hash = 59 * hash + Objects.hashCode(this.Resource2);
        hash = 59 * hash + this.Resource1Quantity;
        hash = 59 * hash + this.Resource2Quantity;
        hash = 59 * hash + this.TravelDistance;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExplorableAreas other = (ExplorableAreas) obj;
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (this.HasStatue != other.HasStatue) {
            return false;
        }
        if (!Objects.equals(this.Resource1, other.Resource1)) {
            return false;
        }
        if (!Objects.equals(this.Resource2, other.Resource2)) {
            return false;
        }
        if (this.Resource1Quantity != other.Resource1Quantity) {
            return false;
        }
        if (this.Resource2Quantity != other.Resource2Quantity) {
            return false;
        }
        if (this.TravelDistance != other.TravelDistance) {
            return false;
        }
        return true;
    }
    
       
}
