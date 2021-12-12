package com.ledger.geektrust;

import com.ledger.geektrust.entity.Loan;

import java.util.*;

public class ComapratorDemo {

    public static void main(String args[]) throws Exception
    {
        List<Loan> list = new ArrayList<>();
        Loan loan1 = Loan.builder()
                .borrowerName("A")
                .bankName("A")
                //.amountPaid(100f)
                .build();
        Loan loan2 = Loan.builder()
                .borrowerName("C")
                .bankName("C")
                //.amountPaid(200f)
                .build();
        Loan loan3 = Loan.builder()
                .borrowerName("B")
                .bankName("B")
                //.amountPaid(300f)
                .build();

        list.add(loan1);
        list.add(loan2);
        list.add(loan3);

        //list.forEach(loan -> System.out.println(loan.getAmountPaid()));
        System.out.println(list.indexOf(loan1));
        System.out.println(list.indexOf(loan2));
        System.out.println(list.indexOf(loan3));
    }
}

class Employee  {
    String name;
    String dept;
    String ssn;
    Employee(String name, String dept, String ssn) {
        this.name = name;
        this.dept = dept;
        this.ssn = ssn;
    }


    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        Employee geek = (Employee) obj;

        return (geek.name == this.name && geek.dept == this.dept);
    }

    @Override
    public int hashCode()
    {
        return (this.name + this.dept).hashCode();
    }
}