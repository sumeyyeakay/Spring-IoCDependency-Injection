package springIoC.Model;

import springIoC.ICustomerDal;

public class MySqlCustomerDal implements ICustomerDal {


    //veriye ulasirken kullanacagiz, her sql de baglanti farklidir.
    private String connectionString;

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
