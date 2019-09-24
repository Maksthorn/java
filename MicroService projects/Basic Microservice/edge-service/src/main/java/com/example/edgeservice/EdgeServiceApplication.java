package com.example.edgeservice;


import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class EdgeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdgeServiceApplication.class, args);
    }
}

@Data
class Item {
    private String name;

	public String getName() {
		return name;
	}
}

@FeignClient("item-catalog-service")
interface ItemClient {

    @GetMapping("/items")
    Resources<Item> readItems();
}

@RestController
class GoodItemApiAdapterRestController {

    private final ItemClient itemClient;

    public GoodItemApiAdapterRestController(ItemClient itemClient) {
        this.itemClient = itemClient;
    }

    @GetMapping("/good-item")
    public Collection<Item> gooditems() {
        return itemClient.readItems()
                .getContent()
                .stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    private boolean isGreat(Item item) {
        return !item.getName().equals("name 1");
    }
}