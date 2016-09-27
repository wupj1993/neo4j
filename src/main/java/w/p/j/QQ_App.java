package w.p.j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "w.p.j.domain")
public class QQ_App
{

    public static void main( String[] args )
    {
        new SpringApplication(QQ_App.class).run(args);
    }



}
