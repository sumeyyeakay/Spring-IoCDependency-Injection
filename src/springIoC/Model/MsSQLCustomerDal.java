package springIoC.Model;

import springIoC.ICustomerDal;

public class MsSQLCustomerDal implements ICustomerDal {

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
        System.out.println("MsSql veritabani kullaniliyor.");
        System.out.println("ConnectionString: " + connectionString);
    }
}
