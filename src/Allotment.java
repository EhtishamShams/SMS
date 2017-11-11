/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HumnaGul
 */
public class Allotment {
    Office allotedOffice;
    Staff allotedTo;

    public Allotment(Office allotedOffice, Staff allotedTo) {
        this.allotedOffice = allotedOffice;
        this.allotedTo = allotedTo;
    }

    public Office getAllotedOffice() {
        return allotedOffice;
    }

    public boolean setAllotedOffice(Office allotedOffice) {
       boolean alloted=false;
        if(allotedOffice != null)
       {
           this.allotedOffice = allotedOffice;
           alloted=true;
       }
        return alloted;
    }

    public Staff getAllotedTo() {
        return allotedTo;
    }

    public boolean setAllotedTo(Staff allotedTo) {
       boolean set=false;
        if(allotedTo!=null)
       {
           this.allotedTo = allotedTo;
           set=true;
       }
        return set;
    }

}
