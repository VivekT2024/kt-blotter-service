package com.vivekt.kt.serice.impl;

import com.vivekt.kt.serice.DataProvider;
import com.vivekt.ktpp.datamodel.Order;
import org.springframework.stereotype.Service;

import java.util.List;


public class DataProviderHardCodedImpl implements DataProvider {
    @Override
    public List<Order> getOrders() {

        return List.of(Order.builder().orderId("1").symbol("UBS").Quantity(20).Side("Buy or Sell").build(),
                Order.builder().orderId("2").symbol("Google").Quantity(20).Side("Buy or Sell").build(),
                Order.builder().orderId("3").symbol("ALphabet").Quantity(20).Side("Buy or Sell").build(),
                Order.builder().orderId("4").symbol("Apple").Quantity(20).Side("Buy or Sell").build(),
                Order.builder().orderId("5").symbol("Microsoft").Quantity(20).Side("Buy or Sell").build());
    }
}
