package tn.taha.ms_inventory_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsInventoryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInventoryManagementApplication.class, args);
	}

}
