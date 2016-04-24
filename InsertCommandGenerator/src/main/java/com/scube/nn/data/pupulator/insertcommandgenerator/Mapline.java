package com.scube.nn.data.pupulator.insertcommandgenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Mapline {

    public static void main(String[] args) {
        String header[] = new String[]{"product_id", "model", "upc", "quantity", "stock_status_id", "image", "manufacturer_id", "price", "weight", "weight_class_id", "viewed", "name", "description", "tag", "meta_title", "meta_description", "meta_keyword", "category_id", "sku", "ean", "jan", "isbn", "mpn", "location", "points", "tax_class_id", "date_available", "length", "width", "height", "length_class_id", "subtract", "minimum", "sort_order", "status", "date_added", "date_modified", "language_id", "store_id", "layout_id", "shipping"};
        String values[] = new String[]{"50", "Gorcery", "SO001", "1", "6", "catalog/SO001-img1.jpg", "0", "50.0000", "0.50000000", "1", "12", "Turmeric 500 gm", "&lt;p&gt;Turmeric&lt;br&gt;&lt;/p&gt;", "grocery", "herb", "Turmeric", "Turmeric", "59", "", "", "", "", "", "", "0", "0", "2016-04-14", "0.00000000", "0.00000000", "0.00000000", "1", "0", "1", "1", "1", "2016-04-14 03:17:07", "2016-04-14 03:38:38", "1", "0", "0", "1"};

        List<String> headerList;// = Arrays.asList(header);
        List<String> valuesList;// = Arrays.asList(values);
        List<String> list = new ArrayList();
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb;

        if (header.length == values.length) {
            headerList = Arrays.asList(header);
            valuesList = Arrays.asList(values);
            list = new ArrayList();
            sb = new StringBuilder();
            IntStream.range(
                    0, header.length)
                    .mapToObj(i -> "\"" + headerList.get(i) + "\":\"" + valuesList.get(i) + "\",")
                    .forEach(sb::append);
            String productJSON = getProductJson();
            
            try {
                File singleProduct = new File("C:\\Kash\\Scube\\Nannel\\SiteAdministration\\DataPopulation\\SingleProduct.json");
                File multiProduct = new File("C:\\Kash\\Scube\\Nannel\\SiteAdministration\\DataPopulation\\ProductsSample.json");
                Product product = mapper.readValue(singleProduct, Product.class);
                List<Product> products = mapper.readValue(multiProduct, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
                System.out.println(product);
                System.out.println(products);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Header and values lingth not equal");
        }
//        System.out.println(Stream.of(header, values).collect(Collectors.toList()));
    }

    public static String getProductJson() {
        String productJSON = "{\n"
                + "    \"product_id\": \"50\",\n"
                + "    \"model\": \"Gorcery\",\n"
                + "    \"upc\": \"SO001\",\n"
                + "    \"quantity\": \"1\",\n"
                + "    \"stock_status_id\": \"6\",\n"
                + "    \"image\": \"catalog/SO001-img1.jpg\",\n"
                + "    \"manufacturer_id\": \"0\",\n"
                + "    \"price\": \"50.0000\",\n"
                + "    \"weight\": \"0.50000000\",\n"
                + "    \"weight_class_id\": \"1\",\n"
                + "    \"viewed\": \"12\",\n"
                + "    \"name\": \"Turmeric 500 gm\",\n"
                + "    \"description\": \"&lt;p&gt;Turmeric&lt;br&gt;&lt;/p&gt;\",\n"
                + "    \"tag\": \"grocery\",\n"
                + "    \"meta_title\": \"herb\",\n"
                + "    \"meta_description\": \"Turmeric\",\n"
                + "    \"meta_keyword\": \"Turmeric\",\n"
                + "    \"category_id\": \"59\",\n"
                + "    \"sku\": \"\",\n"
                + "    \"ean\": \"\",\n"
                + "    \"jan\": \"\",\n"
                + "    \"isbn\": \"\",\n"
                + "    \"mpn\": \"\",\n"
                + "    \"location\": \"\",\n"
                + "    \"points\": \"0\",\n"
                + "    \"tax_class_id\": \"0\",\n"
                + "    \"date_available\": \"2016-04-14\",\n"
                + "    \"length\": \"0.00000000\",\n"
                + "    \"width\": \"0.00000000\",\n"
                + "    \"height\": \"0.00000000\",\n"
                + "    \"length_class_id\": \"1\",\n"
                + "    \"subtract\": \"0\",\n"
                + "    \"minimum\": \"1\",\n"
                + "    \"sort_order\": \"1\",\n"
                + "    \"status\": \"1\",\n"
                + "    \"date_added\": \"2016-04-14 03:17:07\",\n"
                + "    \"date_modified\": \"2016-04-14 03:38:38\",\n"
                + "    \"language_id\": \"1\",\n"
                + "    \"store_id\": \"0\",\n"
                + "    \"layout_id\": \"0\",\n"
                + "    \"shipping\": \"1\"\n"
                + "  }";
        return productJSON;
    }
}
