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
public enum Societies implements Serializable{
    
    Home("Your Home island", 0),
    Privateer("Island of the Privateers", 1),
    Barbarian("Island of the Barbarians", 2),
    Aztec("Island of the Aztec", 3),
    Buchaneers("Island of the Buchaneers", 4),
    Carousers("Island of the Carousers", 5),
    Corsairs("Island of the Corsairs", 6),
    Turks("Island of the Turks", 7);

    
    private final String description;
    private final int islandNum;
    
    Societies(String description, int islandNum){
        this.description = description;
        this.islandNum = islandNum;
    }
    
    
    private String PositiveApproach;
    private String NeutralApproach;
    private String NegativeApproach;
    private int LeaderTrustLevel;
    private int LeaderTrustLevelTarget;
    private String LeaderTrustStatus;
    

    public String getdescription() {
        return description;
    }

//    public String getPositiveApproach() {
//        return PositiveApproach;
//    }
//
//    public void setPositiveApproach(String PositiveApproach) {
//        this.PositiveApproach = PositiveApproach;
//    }
//
//    public String getNeutralApproach() {
//        return NeutralApproach;
//    }
//
//    public void setNeutralApproach(String NeutralApproach) {
//        this.NeutralApproach = NeutralApproach;
//    }
//
//    public String getNegativeApproach() {
//        return NegativeApproach;
//    }
//
//    public void setNegativeApproach(String NegativeApproach) {
//        this.NegativeApproach = NegativeApproach;
//    }
//
//        public int getLeaderTrustLevel() {
//        return LeaderTrustLevel;
//    }
//
//    public void setLeaderTrustLevel(int LeaderTrustLevel) {
//        this.LeaderTrustLevel = LeaderTrustLevel;
//    }
//
//    public int getLeaderTrustLevelTarget() {
//        return LeaderTrustLevelTarget;
//    }
//
//    public void setLeaderTrustLevelTarget(int LeaderTrustLevelTarget) {
//        this.LeaderTrustLevelTarget = LeaderTrustLevelTarget;
//    }
//
//    public void setLeaderTrustStatus(String LeaderTrustStatus) {
//        this.LeaderTrustStatus = LeaderTrustStatus;
//    }
//    
//    @Override
//    public String toString() {
//        return "Societies{" + ", PositiveApproach=" + PositiveApproach + ", NeutralApproach=" + NeutralApproach + ", NegativeApproach=" + NegativeApproach + '}';
//    }

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 17 * hash + Objects.hashCode(this.PositiveApproach);
//        hash = 17 * hash + Objects.hashCode(this.NeutralApproach);
//        hash = 17 * hash + Objects.hashCode(this.NegativeApproach);
//        hash = 17 * hash + this.LeaderTrustLevel;
//        hash = 17 * hash + this.LeaderTrustLevelTarget;
//        hash = 17 * hash + Objects.hashCode(this.LeaderTrustStatus);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Societies other = (Societies) obj;
//        if (!Objects.equals(this.PositiveApproach, other.PositiveApproach)) {
//            return false;
//        }
//        if (!Objects.equals(this.NeutralApproach, other.NeutralApproach)) {
//            return false;
//        }
//        if (!Objects.equals(this.NegativeApproach, other.NegativeApproach)) {
//            return false;
//        }
//        if (this.LeaderTrustLevel != other.LeaderTrustLevel) {
//            return false;
//        }
//        if (this.LeaderTrustLevelTarget != other.LeaderTrustLevelTarget) {
//            return false;
//        }
//        if (!Objects.equals(this.LeaderTrustStatus, other.LeaderTrustStatus)) {
//            return false;
//        }
//        return true;
//    }
//    
    
}
