package org.example;

import entity.CustomerEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.JPAConfig;
import repository.CustomerRepository;

import java.time.LocalDate;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static CustomerRepository customerRepository = (CustomerRepository) context.getBean("customerRepository");

    public static void main(String[] args) {
//        createNewUser();
//        showCustomer();
//        findCustomer();
//        findById(2);
//        findByName("Long");
//        findByPhoneOrEmail("0587107407","daudinhvuotkeo03@gmail.com");
        findByBirthdateBetween(20,17);
    }
    private static void createNewUser(){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName("Chinh");
        customerEntity.setBirthdate(LocalDate.parse("2003-07-25"));
        customerEntity.setSex("Nam");
        customerEntity.setEmail("daudinhvuotkeo03@gmail.com");
        customerEntity.setAddress("Nguyen Duc Trung");
        customerEntity.setPhone("0587107407");
        CustomerEntity result = customerRepository.save(customerEntity);
        if(result != null){
            System.out.println("A new customer save successfully, Customer Id = " + customerEntity.getId());
        }
    }
    private static void showCustomer(){
        ArrayList<CustomerEntity> customerEntities = new ArrayList<>();
        customerEntities = (ArrayList<CustomerEntity>) customerRepository.findAll();
        System.out.println("Found: " + customerEntities.size() + "customer(s) in the table customers ");
        for (int i = 0; i <customerEntities.size() ; i++) {
            System.out.println(customerEntities.get(i).toString());
        }
    }
    private  static  void findCustomer(){
        CustomerEntity customerEntity = customerRepository.findById(2).get();
        System.out.println("The customer you find is: " + customerEntity.toString());
    }
    private static void findById(int id){
        CustomerEntity customerEntity = customerRepository.findById(id).get();
        System.out.println("Customer: " + customerEntity.toString());
    }
    private  static void findByName(String name){
        ArrayList<CustomerEntity> customerEntities = customerRepository.findByName(name);
        for(int i = 0;i < customerEntities.size(); i++){
            System.out.println("Name of customer you find: " + customerEntities.get(i).toString());
            }
        }
        private static void findByPhoneOrEmail(String phone, String email){
            ArrayList<CustomerEntity> customerEntities = customerRepository.findByPhoneOrEmail(phone, email);
            for (int i = 0; i < customerEntities.size(); i++) {
                System.out.println("Phone and Email the customer you find: " + customerEntities.get(i).toString());
            }
        }
        private static void findByBirthdateBetween(int start, int end){
            LocalDate now = LocalDate.now();
            LocalDate startDate = now.minusYears(start);
            LocalDate endDate = now.minusYears(end);
            ArrayList<CustomerEntity> customerEntities = customerRepository.findByBirthdateBetween(startDate,endDate);
            for (int i = 0; i < customerEntities.size() ; i++) {
                System.out.println(customerEntities.toString());
            }
        }
    }
