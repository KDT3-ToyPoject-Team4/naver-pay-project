package crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//제품명, 가격, 판매자, 판매자URL 가져옵니다.
public class ProductCrawling {

    private static String[] url;

    public static void main(String[] args) {
        url = new String[]{
                "https://search.shopping.naver.com/search/all?query=%ED%82%A4%EB%B3%B4%EB%93%9C&frm=NVSHATC&prevQuery=%ED%82%A4%EB%B3%B4%EB%93%9C"
        };

        for(String url:url){
            System.out.println(getProductDataFromUrl(url));
        }
    }



    public static Map getProductDataFromUrl(String URL) {
        Document doc;
        Elements el;
        Map<String,String> productInfo = new HashMap<>();
        try{
            doc = Jsoup.connect(URL).get();

            //제품명
            el = doc.getElementsByAttributeValue("class", "basicList_title__VfX3c");
            String productName=el.get(0).text();
            //가격
            el = doc.getElementsByAttributeValue("class", "price_num__S2p_v");
            String price=el.get(0).text();
            //첫번째 판매자
            el = doc.getElementsByAttributeValue("class", "basicList_mall_name__XQlSa");
            String seller=el.get(0).text();
            //판매자 URL
            el = doc.getElementsByAttributeValue("class", "basicList_link__JLQJf");
            String sellerURL=el.get(0).toString().split("href=")[1].split("\"")[1];

            productInfo.put("제품명",productName);
            productInfo.put("가격",price);
            productInfo.put("판매자",seller);
            productInfo.put("판매자 URL",sellerURL);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return productInfo;

    }
}
