package com.billing.billingservice;

import com.billing.billingservice.entities.Bill;
import com.billing.billingservice.entities.ProductItem;
import com.billing.billingservice.enums.BillStatus;
import com.billing.billingservice.feignclients.CustomerRestClient;
import com.billing.billingservice.feignclients.ProductItemRestClient;
import com.billing.billingservice.models.Customer;
import com.billing.billingservice.models.Product;
import com.billing.billingservice.repositories.BillRepository;
import com.billing.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BillRepository billRepository,
							ProductItemRepository productItemRepository,
							CustomerRestClient customerRestClient,
							ProductItemRestClient productItemRestClient ){
		return  args -> {
			Customer customer=customerRestClient.findCustomerById(3L);
			PagedModel<Product> products=productItemRestClient.findAllProducts();

			Bill bill= billRepository.save(new Bill(null,new Date(), BillStatus.PENDING,null,customer.getId(),customer));
			products.forEach(product -> {
				ProductItem productItem=new ProductItem();
				productItem.setProductName(product.getName());
				productItem.setPrice(product.getPrice());
				productItem.setProductID(product.getId());
				productItem.setQuantity(1 + new Random().nextInt(100));
				productItem.setBill(bill);
				productItemRepository.save(productItem);
			});

			billRepository.save(new Bill(null,new Date(),BillStatus.PAID,null,customer.getId(),customer));


		};
	}
}