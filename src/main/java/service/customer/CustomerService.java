package service.customer;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {

    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "1", "1@gmail.com", "Ha Noi"));
        customers.put(2, new Customer(2, "2", "2@gmail.com", "London"));
        customers.put(3, new Customer(3, "3", "3@gmail.com", "Ho Chi Minh"));
        customers.put(4, new Customer(4, "4", "4@gmail.com", "New York"));
        customers.put(5, new Customer(5, "5", "5@gmail.com", "Dubai"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }

}
