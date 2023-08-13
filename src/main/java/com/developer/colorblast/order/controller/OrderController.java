package com.developer.colorblast.order.controller;

import com.developer.colorblast.order.entity.OderData;
import com.developer.colorblast.order.entity.OrderEntity;
import com.developer.colorblast.order.service.OrderService;
import com.developer.colorblast.panier.dto.PanierData;
import com.developer.colorblast.panier.entity.PanierEntity;
import com.developer.colorblast.product.entity.ProductEntity;
import com.developer.colorblast.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    private final ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        List<OrderEntity> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable Long id) {
        OrderEntity order = orderService.getOrderById(id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order) {
        OrderEntity createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long id, @RequestBody OrderEntity order) {
        OrderEntity updatedOrder = orderService.updateOrder(id, order);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/idKey/{idKey}")
    public ResponseEntity<OderData> getOrdersByIdKey(@PathVariable String idKey) {
        List<OrderEntity> orders = orderService.getOrdersByIdKey(idKey);

        if (!orders.isEmpty()) {
            OderData datas = new OderData();
            datas.setIdKey(idKey);
            datas.setIdClient(orders.get(0).getIdClient());

            List<ProductEntity> products = orders.stream()
                    .map(order -> productService.findById(order.getIdProduct()))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            datas.setProduct(products);

            return new ResponseEntity<>(datas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
