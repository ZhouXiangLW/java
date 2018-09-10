package com.cultivation.javaBasicExtended.posMachine;

import com.cultivation.javaBasic.util.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.binding.ObjectExpression;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings({"WeakerAccess", "unused", "RedundantThrows"})
public class PosMachine {

    public static final String LINE_SEPORATER = "------------------------------------------------------------";
    public static final String LONG_SPACE = "                       ";
    public static final String SHORT_SPACE = "          ";
    private List<Product> products = new ArrayList<>();

    public void readDataSource(Reader reader) throws IOException {
        // TODO: please implement the following method to pass the test
        // <--start
        ObjectMapper mapper = new ObjectMapper();
        List<Object> objects = mapper.readValue(reader, List.class);
        for (Object object : objects) {
            Product product = mapper.readValue(mapper.writeValueAsString(object), Product.class);
            products.add(product);
        }
        // --end-->
    }

    public String printReceipt(String barcodeContent) throws IOException {
        // TODO: please implement the following method to pass the test
        // <--start
        List<String> codes = getBarCode(barcodeContent);
        List<Product> bought = new ArrayList<>();
        codes.forEach(code -> {
            for (Product p : products) {
                if (p.getId().equals(code)) {
                    bought.add(p);
                }
            }
        });
        return createReceiptString(bought);
        // --end-->
    }

    private String createReceiptString(List<Product> bought) {
        String line = System.lineSeparator();
        StringBuilder builder = new StringBuilder();
        int price = bought.stream().mapToInt(item -> item.getPrice()).sum();
        String header = "Receipts" + line + LINE_SEPORATER + line;
        String tail = LINE_SEPORATER + line + "Price: " + price + line;
        builder.append(header);
        Map<Product, Integer> groupedProducts = getGroupedProduct(bought);
        groupedProducts.forEach((product, quantity) -> {
            builder.append(product.getName() + LONG_SPACE + product.getPrice() + SHORT_SPACE + quantity + line);
        });
        builder.append(tail);
        return builder.toString();
    }

    private List<String> getBarCode(String content) throws IOException {
        List<String> res = new ArrayList<>();
        if (content == null) {
            return res;
        }
        ObjectMapper mapper = new ObjectMapper();
        List<Object> objects = mapper.readValue(content, List.class);
        for (Object object : objects) {
            res.add(mapper.readValue(mapper.writeValueAsString(object), String.class));
        }
        return res;
    }

    private Map<Product, Integer> getGroupedProduct(List<Product> products) {
        Map<String, List<Product>> map = products.stream().collect(Collectors.groupingBy(Product::getId));
        Map<Product, Integer> res = new HashMap<>();
        map.forEach((k, v) -> res.put(v.get(0), v.size()));
        return res;
    }
}

@SuppressWarnings("unused")
class Product {
    private String id;
    private String name;
    private Integer price;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;

        Product other = (Product) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}