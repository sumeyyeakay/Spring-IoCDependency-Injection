package com.springdemo.Model;

import com.springdemo.ICustomerDal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//database ile caliscam diyorum - sadece bi yerde olmasi gerekir.
//@Component("database")
public class MsSQLCustomerDal implements ICustomerDal {

    //degeri oku diyoruz (values.properties)
     @Value("${database.ConnectionString}")

    String connectionString;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public void add() {
        System.out.println("MsSql veritabani kullaniliyor.");
        System.out.println("ConnectionString: " + connectionString);
    }
}
