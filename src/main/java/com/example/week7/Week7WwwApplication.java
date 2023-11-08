package com.example.week7;

import com.example.week7.backend.enums.ProductStatus;
import com.example.week7.backend.models.Product;
import com.example.week7.backend.models.ProductImage;
import com.example.week7.backend.repositories.ProductImageRepository;
import com.example.week7.backend.repositories.ProductRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Week7WwwApplication {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductImageRepository productImageRepository;
	public static void main(String[] args) {
		SpringApplication.run(Week7WwwApplication.class, args);
	}

	@Bean
	public CommandLineRunner x () {
		return  new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Random random = new Random();
				Faker faker = new Faker();
				List<String> listImg = List.of("https://cdn.phuckhangmobile.com/image/iphone-12-pro-max-128gb-vang-quocte-phuckhangmobile-27951j.jpg",
						"https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:80/plain/https://cellphones.com.vn/media/catalog/product/s/a/samsung-galaxy-s23-ultra.png",
						"https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:80/plain/https://cellphones.com.vn/media/catalog/product/r/e/reno10_5g_-_combo_product_-_blue.png",
						"https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:80/plain/https://cellphones.com.vn/media/catalog/product/r/e/reno10_5g_-_combo_product_-_blue.png",
						"https://cdn.phuckhangmobile.com/image/iphone-12-pro-max-128gb-vang-quocte-phuckhangmobile-27951j.jpg",
						"https://cdn.phuckhangmobile.com/image/samsung-galaxy-s20-plus-den-900-19416j.jpg",
						"https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:80/plain/https://cellphones.com.vn/media/catalog/product/s/a/samsung-galaxy-s23-ultra.png",
						"https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:80/plain/https://cellphones.com.vn/media/catalog/product/n/o/nokia-215-4g-600jpg-600x600.jpg",
						"https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:80/plain/https://cellphones.com.vn/media/catalog/product/n/o/nokia-c32_3_.png",
						"https://cdn2.cellphones.com.vn/insecure/rs:fill:358:358/q:80/plain/https://cellphones.com.vn/media/catalog/product/1/_/1_365-doc-quyuen.jpg");

				for (int i = 0; i < 10; i++) {
					Product product = new Product(faker.device().modelName(),
							faker.device().platform(),
							faker.lorem().characters(10),
							faker.device().manufacturer(),
							ProductStatus.values()[random.nextInt(3)]);
					productRepository.save(product);
					ProductImage productImage = new ProductImage(listImg.get(i), "Img " + i, product);
					productImageRepository.save(productImage);
				}

//				for (int i = 0; i < 10; i++) {
//					ProductImage  productImage = new ProductImage("");
//					productImageRepository.save(productImage);
//				}
			}
		};

	}





}
