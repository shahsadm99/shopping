package com.shahsad.inventoryservice;

import com.shahsad.inventoryservice.model.Inventory;
import com.shahsad.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {SpringApplication.run(InventoryServiceApplication.class, args);}
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("Test3");
			inventory.setQuantity(10);
			inventoryRepository.save(inventory);


			Inventory inventory1 = new Inventory();
			inventory.setSkuCode("Test2");
			inventory.setQuantity(10);

			inventoryRepository.save(inventory1);
		};

	}

}
