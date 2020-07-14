package com.springdemo;

/**
 * CustomerManager _> injectiona ihtiyac duyuyor
 */
public class CustomerManager implements ICustomerService {
    /**
     * CustomerManager ICustomerDal istiyor ve onun addini calistiriyor
     */
    private ICustomerDal customerDal;

    //constructor injection ->  Service aktarimi yapiyor (Daha cok tercig ediliyor.)
    public CustomerManager(ICustomerDal customerDal) {
       this.customerDal = customerDal;
    }

    public void add(){
        //is kurallari
        customerDal.add();
    }

}
