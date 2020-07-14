package springIoC;

/**
 * bir arayuzumuz var : Swing veya jsp(masaustu uygulama) olsun
 *ayrica  business ve data access katmanlari var ve  bunlarin aralarinda baglanti kuruyoruz.
 * Buna ek olarak service katmani da eklendigi zaman aradaki bagliligi yapmamiz gerekir.
 *  Yani bu classida soyutlicaz. Boyleikle arada baglanti olusturmus olcaz.
 */
public class CustomerManager implements ICustomerService {
    /**
     * CustomerManager ICustomerDal istiyor ve onun addini calistiriyor
     */
    private ICustomerDal customerDal;

    //Setter Injection
    public void setCustomerDal(ICustomerDal customerDal) {
        this.customerDal = customerDal;
    }


    //constructor injection ->  Service aktarimi yapiyor (Daha cok tercig ediliyor.)
    //public CustomerManager(ICustomerDal customerDal) {
      //  this.customerDal = customerDal;
    //}

    public void add(){
        //is kurallari
        customerDal.add();
    }

}
