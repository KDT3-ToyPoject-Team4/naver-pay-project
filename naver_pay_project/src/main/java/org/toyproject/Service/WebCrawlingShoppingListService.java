package org.toyproject.Service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.toyproject.Entity.WebCrawlingShoppingListEntity;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WebCrawlingShoppingListService {

    public static void main(String[] args) throws AWTException, ParseException {
        getShoppingListFromWeb("724thomas","chl63B61op09#");
    }
    public static List<WebCrawlingShoppingListEntity> getShoppingListFromWeb(String naverId, String naverPassword) throws AWTException, ParseException {
        List<WebCrawlingShoppingListEntity> WebCrawlingShoppingListEntities = new ArrayList<>();

        WebDriver driver = null;
        WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.get("https://nid.naver.com/nidlogin.login?url=http://pay.naver.com");

        String loginUserId = naverId;
        String loginUserPassword = naverPassword;

        /*아이디 입력*/
        WebElement id = driver.findElement(By.cssSelector("#id"));
        id.click();
        copyAndPaste(loginUserId);

        /*비밀번호 입력*/
        WebElement pw = driver.findElement(By.cssSelector("#pw"));
        pw.click();
        copyAndPaste(loginUserPassword);

        /*로그인*/
        WebElement login_btn = driver.findElement(By.cssSelector("#log\\.login"));
        login_btn.click();


        /*임의 값*/
        String userAddress = "강남구 역삼동 비왕빌딩 10층";
        String userPw = randomPassword();
        String userName = randomName();
        String userTel = randomTel();
        String paymentMethod = randomPaymentMethod();

        /*주문내역 페이지 크롤링*/
        Document doc = Jsoup.parse(driver.getPageSource());
        Elements elements;
        elements = doc.select("p.name");
        int numOfOrders = elements.size();

        elements = doc.select("span.user_id");
        String userId = elements.text(); //유저 아이디

        elements = doc.select("div.member_sc");
        String userPoint =elements.text().split(" 포인트 ")[1].replace("원",""); //현재 유저 포인트

        Elements productNameList = doc.select("p.name");
        String productName; //제품명

        Elements orderTotalMoneyAndDateList = doc.select("ul.info");
        long orderTotalMoney; //총 제품가격
        Date orderDate; //주문 날짜

        Elements sellerList = doc.select("span.seller");
        String companyName; //판매자

        Elements sellerTelList = doc.select("span.tel");
        String companyPhone; //판매자 대표번호


        Elements urlLinks = doc.select("a.goods"); //주문제품들의 url들
        ArrayList<String> realLinks = new ArrayList<>();
        ArrayList<String> realproductNames = new ArrayList<>();
        ArrayList<String> realOrderDate = new ArrayList<>();
        ArrayList<String> realCompanyName = new ArrayList<>();
        ArrayList<String> realCompanyPhone = new ArrayList<>();


        for (int i=0; i<numOfOrders; i++){
            if(!realLinks.contains(getRealUrl(urlLinks.get(i).attr("href")))){
                realLinks.add(getRealUrl(urlLinks.get(i).attr("href"))); //url
                realproductNames.add(productNameList.get(i).text()); //제품명
                realOrderDate.add(orderTotalMoneyAndDateList.get(i).text().split(" 상품구매날짜 ")[1].replace(".","-")); //주문날짜
                realCompanyName.add(sellerList.get(i).text()); //회사명
                realCompanyPhone.add(sellerTelList.get(i).text()); //회사 대표번호
            }else{
                realproductNames.set(realproductNames.size()-1,productNameList.get(i).text());
            }
        }


        for (int i=0; i<realLinks.size(); i++){
//        for (int i=0; i<4; i++){

            productName = realproductNames.get(i); //제품명
            String tempDate=realOrderDate.get(i); //주문 날짜
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            orderDate = formatter.parse(tempDate);
            companyName=realCompanyName.get(i); //판매자
            companyPhone=realCompanyPhone.get(i); //판매자 대표번호
            long businessNumber = randomBusinessNumber(); //사업자 번호

            /*상세페이지 페이지 크롤링*/
//            String productUrl=getRealUrl(urlLinks.get(i).attr("href"));
            String productUrl=realLinks.get(i);
            driver.get(productUrl);
            doc = Jsoup.parse(driver.getPageSource());

            elements = doc.select("dd.pdb");
            if (!elements.text().equals("")){
                userName = elements.text().split(" ")[0]; //userName
                userTel =elements.text().split(" ")[1]; //userTel
            };

            elements = doc.select("a.seller_inquiry");
            String companyStore; //companyStore
            if (elements.attr("href").equals("#")){
                companyStore = "No store url";
            }else{
                companyStore = elements.attr("href");
            }

            elements = doc.select("span.p_color_green");
            int supplyPoint = Integer.parseInt(elements.text().split(" ")[1].replaceAll("[,원]","")); //supplyPoint

            elements = doc.select("strong.pointcol");
            String orderId=elements.text(); //orderId

            elements = doc.select("td.money");
            int orderQuantity =Integer.parseInt(elements.text().split(" ")[1].replaceAll("[()개]","")); //orderQuantity

            elements = doc.select("em.thm");
            long orderMoney=Long.parseLong(elements.text().split(" ")[elements.text().split(" ").length-1].replace(",",""));
            int usedPoint;
            if (elements.text().split(" ")[elements.text().split(" ").length-2].equals(elements.text().split(" ")[elements.text().split(" ").length-1])){
                usedPoint=0;
            }else{
                usedPoint=Integer.parseInt(elements.text().split(" ")[elements.text().split(" ").length-2].replace(",",""));
            }
            orderTotalMoney=Long.parseLong(elements.text().split(" ")[elements.text().split(" ").length-3].replace(",",""));


            long productPrice = orderTotalMoney/ orderQuantity;


            System.out.println("로그인아이디:"+userId);
            System.out.println("비밀번호:"+userPw);
            System.out.println("이름:"+userName);
            System.out.println("연락처:"+userTel);
            System.out.println("주소:"+userAddress);
            System.out.println("포인트잔액:"+userPoint);

            System.out.println("회사명:"+companyName);
            System.out.println("회사번호:"+companyPhone);
            System.out.println("회사URL:"+companyStore);
            System.out.println("사업자번호:"+businessNumber);

            System.out.println("제품명:"+productName);
            System.out.println("제공포인트:"+supplyPoint);
            System.out.println("제품가격:"+productPrice);

            System.out.println("결제방법:"+paymentMethod);

            System.out.println("주문번호:"+orderId);
            System.out.println("주문 날짜:"+orderDate);
            System.out.println("주문수량:"+orderQuantity);
            System.out.println("사용포인트:"+usedPoint);
            System.out.println("결제금액:"+orderMoney);
            System.out.println("총 결제금액:"+orderTotalMoney);
            System.out.println("------------------------------------------------");

            WebCrawlingShoppingListEntity temp = new WebCrawlingShoppingListEntity(
                    userId,userPw,userName,userTel,userAddress,userPoint,
                    companyName,companyPhone,companyStore,businessNumber,
                    productName,productPrice,supplyPoint,
                    paymentMethod,
                    orderId,orderDate,orderQuantity,usedPoint,orderTotalMoney
            );
            WebCrawlingShoppingListEntities.add(temp);
        }
        driver.quit();
        return WebCrawlingShoppingListEntities;
    }

    public static void copyAndPaste(String str) throws AWTException {
        StringSelection stringSelection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static String getRealUrl(String str){
        if (str.substring(1,12).equals("orderStatus")){
            return ("https://order.pay.naver.com" + str);
        }else{
            return str;
        }
    }

    public static String randomPassword(){
        return String.valueOf( Math.round(Math.random()*10000));
    }
    public static String randomName(){
        return "4조"+ Math.round(Math.random()*100);
    }
    public static String randomTel(){
        return "010-" + Math.round(Math.random()*10000) + "-" + Math.round(Math.random()*10000);
    }
    public static long randomBusinessNumber(){
        return Math.round(Math.random()*10000000000L);
    }
    public static String randomPaymentMethod(){
        switch ((int)Math.round(Math.random()*3)){
            case 0: return "신용카드";
            case 1: return "체크카드";
            case 2: return "계좌이체";
            case 3: return "비자카드";
            default : return "";
        }
    }
}
