package com.example.demo.services;

import com.example.demo.business.ServiceResult;
import com.example.demo.entities.Product;
import com.example.demo.webscrapings.AmericanasWebScraping;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AmericanasService extends BaseService {
    public ServiceResult<String> getTop3WebCamLoweredPrice() throws IOException {
        ServiceResult<String> result = new ServiceResult<String>();
        AmericanasWebScraping webScraping = null;
        try {
            webScraping = new AmericanasWebScraping();

            List<Product> products = webScraping.getProductsByCategoryAndSort("webcam", "lowerPrice");
            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            int index = 0;
    
            StringBuilder html = new StringBuilder();
            html.append("<html>\n");
            html.append("<body>\n");
            html.append("<h2>Segue abaixo o resultado de raspagem no site americanas.com, onde o sistema tentou localizar as 3 webcams com menor preço:</h2>\n");
            html.append("<br/>\n");

            while ((index < products.size()) && (index < 3)) {
                Product product = products.get(index);

                if (index > 0) {
                    html.append("<br/>\n");
                }

                html.append("<h3>"+ (index + 1) + "º - <a href=\"" + product.getUrl() + "\">" + product.getDescription() + "</a></h3>\n");
                html.append("<h2>R$ " + decimalFormat.format(product.getPrice()) + "</h2>\n");
    
                index++;
            }

            html.append("</body>\n");
            html.append("</html>\n");
                
            webScraping.quit();

            result.setSuccess(html.toString());
        } catch (Exception e) {
            result.setFail("Ocorreram erros na execução do serviço: getTop3WebCamLoweredPrice()", e);
        } finally {
            if (webScraping != null) {
                try {
                    webScraping.destroy();
                } catch (Exception ex) {}
            }
        }
        return result;
    }
}
