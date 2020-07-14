package springIoC.Model;

import springIoC.ICustomerDal;

public class OracleCustomerDal implements ICustomerDal {

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    //veriye ulasirken kullanacagiz, her sql de baglanti farklidir.
    private String connectionString;

    public void add(){

        System.out.println("ConnectionString: " + connectionString);

        System.out.println("Oracle veritabanina eklendi.");
    }
}
