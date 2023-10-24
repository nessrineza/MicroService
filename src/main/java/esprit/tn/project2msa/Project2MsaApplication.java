package esprit.tn.project2msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Project2MsaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Project2MsaApplication.class, args);
    }

}
