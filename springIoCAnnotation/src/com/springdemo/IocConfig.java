package com.springdemo;

import com.springdemo.Model.MsSQLCustomerDal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//config dosyasi oldugunu belirtmek icin:
@Configuration
@ComponentScan("com.springdemo") // paket ismi

//values.prop..vermek icin
@PropertySource("classpath:com/springdemo/values.properties")
// tum classlari arayacak - database gorene kadar
public class IocConfig {
    /**
     * her classin basina @Component("database") yazmak yerine config dosyasinda bean tanimlayarak daha duzgun bir yapi olusturmus oluruz.
     * cunku her defasinda veritabani dosyasini degisiminde o classin basina bu ifadeyi eklemek zorunda kaliriz.
     * Boylece tek bir yerden database classini degistiriyoruz.
     * AMAC : xml dosyasinda yazmak yerine java kodlariyla bu islemi yapmak
     */
    @Bean
    public ICustomerDal database() {
        return new MsSQLCustomerDal();
    }

    //tum bagimliliklari tek bir yerden yonetmis oluyoruz
    @Bean
    public ICustomerService service() {
        return new CustomerManager(database());
    }



}
