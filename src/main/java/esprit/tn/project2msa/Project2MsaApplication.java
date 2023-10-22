package esprit.tn.project2msa;

import esprit.tn.project2msa.Repositories.AppointementRepo;
import esprit.tn.project2msa.entites.AppointmentStatus;
import esprit.tn.project2msa.entites.appointement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Project2MsaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Project2MsaApplication.class, args);
    }

}
