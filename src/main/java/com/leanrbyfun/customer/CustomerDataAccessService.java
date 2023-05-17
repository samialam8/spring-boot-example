package com.leanrbyfun.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDataAccessService implements CustomerDao {

    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();

        Customer alex = new Customer(1,"ALex","alex@gmail.com",32);
        customers.add(alex);

        Customer jamila = new Customer(2,"Jamila","jamila@gmail.com",34);
        customers.add(jamila);
    }

   @Override
   public List<Customer> selectAllCustomers() {
       return customers;
   }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream().filter(c -> c.getId().equals(id))
                .findFirst();

    }

}
