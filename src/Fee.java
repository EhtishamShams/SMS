/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.Date;

/**
 *
 * @author HumnaGul
 */
public class Fee {
    private double amount;
    private Date datePaid;
    private Date dueDate; 
    private Student student;
    private Semester semester;

    public Fee(double amount, Date datePaid, Date dueDate, Student st, Semester sem) {
        this.amount = amount;
        this.datePaid = datePaid;
        this.dueDate = dueDate;
        this.student = st;
        this.semester = sem;
    }

    public double getAmount() {
        return amount;
    }

    public boolean setAmount(double amount) {
        boolean set=false;
        if(amount>-1)
        {
            this.amount = amount;
            set=true;
        }
        return set;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public boolean setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
        return true;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public boolean setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return true;
        
    }
    
    
}