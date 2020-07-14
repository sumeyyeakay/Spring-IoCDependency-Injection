package com.springdemo.Model;


import com.springdemo.ICustomerDal;
import org.springframework.beans.factory.annotation.Value;

public class MySqlCustomerDal implements ICustomerDal {

    //degeri oku diyoruz (values.properties)
     @Value("${database.ConnectionString}")
    //veriye ulasirken kullanacagiz, her sql de baglanti farklidir.
    String connectionString;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public void add() {
        System.out.println("ConnectionString: " + connectionString);
        System.out.println("Mysql veritabanina eklendi.");
    }
}
