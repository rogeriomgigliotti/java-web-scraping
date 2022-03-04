package com.example.demo.webscrapings;

import com.example.demo.entities.Product;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AmericanasWebScraping extends BaseWebScraping {
    private static final String urlBase = "https://www.americanas.com.br";

    public AmericanasWebScraping() {
    }

    public List<Product> getProductsByCategoryAndSort(String category, String sort) {
        this.webDriver.get(urlBase + "/busca/" + category + "?sortBy=" + sort);
        List<WebElement> elements = this.webDriver.findElements(By.className("iRvjrG"));
        List<Product> result = new ArrayList<>();

        for (WebElement element: elements) {
            Product product = new Product();
            product.setCategory("webcam");
            product.setDescription(this.getTextByClassName(element, "gUjFDF"));
            product.setPrice(this.getDoubleByClassName(element, "liXDNM"));
            product.setUrl(urlBase + this.getDomAttributeByTagName(element, "a", "href"));

            this.addSortered(result, product);
        }

        return result;
    }

    private void addSortered(List<Product> list, Product item) {
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getPrice() > item.getPrice()) {
                list.add(index, item);
                return;
            }
        }
        
        list.add(item);
    }
}
