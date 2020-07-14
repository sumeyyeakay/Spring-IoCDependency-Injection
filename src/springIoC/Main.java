package springIoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Proje Tanimi:
 * *************************************************************************************************************************************************
 * DEPENDEnCY INJECTION
 * Normal sartlarda calistiginiz sirkette oracle verttabani kullaniliyordu. Siz ona gore bir sinif yazdiniz
 * ve uygulama sorunsuz olarak calisiyordu.
 *
 * Musteri 3 ay sonra biz artik Mysql ile calismak istiyoruz dedi. Eger yazdiginiz kod tasarim sablonlarina uygun sekilde yazilmamis olursa
 * sistem de bir cok yerde degisiklik yapmaniz gerekecekti.
 *
 * Bunun onune gecmek icin biz bir Interface olusturduk.
 * Interface: ICustomerDal adinda ;
 *      public interface ICustomerDal {
 *     void add();
 * } sadece icine add metodunu ekledik.
 *
 * boylece musteri  eklemek istedigi database isimlerini direk class seklinde yazarak bu sinifi implemente etmesi karmasikligi giderecektir.
 * Main sinifimizda ise bunu kullanmak icin tek yapmamiz gereken;
 *          CustomerManager manager = new CustomerManager(new OracleCustomerDal());
 *         //CustomerManager manager = new CustomerManager(new MySqlCustomerDal());
 *          hangi veritabanini kulllanmak istedigimizdir.
 *
 **************************************************************************************************************************************************
 * IoC INJECTION
 * UPDATE :  new CustomerManager(new OracleCustomerDal()); bu islemi bizim yerimize spring yapacak.
 * YANI new OracleCustomerDal() bu uretimi artik spring bizim yerimize yapacak.
 * Factory design patter ile bize nesneler uretecek.
 * Bunu yapmak icin:
 *      Projeye ekledigimiz applicationContext.xml dosyasini aciyoruz ve icine :
 *       <bean id="database" class="springIoC.OracleCustomerDal"> </bean> ekliyoruz.
 *       Bununla birlikte :
 *        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
 *        satirini maine yaziyoruz. burada dosya ismini veriyoruz.
 *
 *         Onceden CustomerManager manager = new CustomerManager(new MySqlCustomerDal()); olarak yazdigimiz satiri :
 *         new CustomerManager(context.getBean("database",ICustomerDal.class)); olarak degistiriyoruz.
 *         Boylece artik xml dosyasinda degistirdigimiz class ismi ile hangi veritabaninin calismasi gerektigine karar verebiliyoruz.
 *
 **************************************************************************************************************************************************
 *  CONSTRUCTOR arg ILE IC ICE BAGIMLILIK COZUMU
 *     bknz: CustomerManager.java (detayli bilgi mevcut)
 *
 *      applicationcontext icinde onceden olusturdugumuz gibi bean yapisi olusturuyoruz.
 *      ve bu sefer icine bir durum daha ekliyoruz.
 *      <bean id="services" class="springIoC.CustomerManager">
 *         <constructor-arg ref="database">
 *         </constructor-arg>
 *      </bean>
 *      yani const. arg ile database beansi icine referans olarak verioruz.
 *
 *      ICustomerService customerService = context.getBean("services",ICustomerService.class);
 *      artik mainde ki new olarak yazdigimiz kisimda ortadan kalkmis oldu.
 *
 * **************************************************************************************************************************************************
 * SETTER INJECTION
 *      Constructor arg ye bir alternatif yapidir. Bu sefer:
 *      CustomerManager.java icinde const. yapisini yorum satiri haline getiriyoruz ve ;
 *
 *          private ICustomerDal customerDal;
 *           //Setter Injection
 *          public void setCustomerDal(ICustomerDal customerDal) {
 *              this.customerDal = customerDal;
 *          }
 *
 *       customerDal yapisinin set metodunu tanimliyoruz.
 *       <!--Propertiyden biri customerdal ise (sete karsilik geliyor) database ver diyoruz -->
 *       bu yapi const alternatifidir.
 *          <property name="customerDal" ref="database"></property>
 *  Boylece uygulamamiz yine ayni sekilde calismaya devam ediyor.
 *
 *
 ***************************************************************************************************************************************************
 * METINSEL DEGERLERIN ENJEKSIYONU
 *
 *      Her sql'in metodlari farkldir. Insert-update vb.
 *      Bunun icin her classta metinsel ifade olabilir. Bunu kodumuza eklemek icin mesela;
 *      OracleCustomerDal.java icinde orivate String connectionString; ifadesi tanimliyoruz. Bu degerin getter and setter metodlarini ekliyoruz.
 *      add() metodu icinde artik bu degeri kullanabiliriz. sout ile yazabiliriz.
 *
 *      -Daha sonra applicationContext icinde ;
 *       <bean id="database" class="springIoC.Model.MsSQLCustomerDal">
 *              <property name="connectionString" value="Oracle String"></property> <!-- Bu tanimlama ile degeri gonderebiliyoruz -->
 *     </bean>
 *
 *
 *
 *
 *
 *
 */
public class Main {
    public static void main(String[] args) {

        //dosya ismi vercez applicationContext okuyacagimizi soyluyoruz
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

         ICustomerService customerService = context.getBean("services",ICustomerService.class);

        //customer dal imp ettigi icin bunun refereansini ekliyor
        // CustomerManager customerManager = new CustomerManager(context.getBean("database",ICustomerDal.class)); //arka planda bizim yerimize new yapiyor
        //CustomerManager manager = new CustomerManager(new MySqlCustomerDal());
        customerService.add();
    }
}
