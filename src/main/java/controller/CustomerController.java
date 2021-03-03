package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.customer.CustomerService;
import service.customer.ICustomerService;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    //Show All
    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers",customers);
        return modelAndView;

    }

    //Create
    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("create", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCustomer(@ModelAttribute Customer customer) {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("create", new Customer());
        int id = customerService.findAll().size();
        customer.setId(id);
        customerService.save(customer);
        return modelAndView;
    }

    //Edit
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Customer customer = customerService.findById(id);
        modelAndView.addObject("edit", customer);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editCustomer(@PathVariable int id, Customer customer) {
        customer.setId(id);
        customerService.update(id, customer);
        return new ModelAndView("edit", "edit", customerService.findAll());
    }

    //Delete
    @GetMapping("/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable int id) {
        customerService.remove(id);
        return new ModelAndView("redirect:/customers");
    }

}
