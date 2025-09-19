package com.vivekt.kt.serice;

import com.vivekt.ktpp.datamodel.Order;

import java.util.List;

public interface DataProvider {
    List<Order> getOrders();
}
