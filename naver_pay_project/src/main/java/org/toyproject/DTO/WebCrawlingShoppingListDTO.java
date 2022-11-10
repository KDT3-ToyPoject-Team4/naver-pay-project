package org.toyproject.DTO;

import org.toyproject.entity.WebCrawlingShoppingListEntity;

import java.util.List;

public class WebCrawlingShoppingListDTO {

    private static WebCrawlingShoppingListDTO webCrawlingShoppingListDTO = null;
    private String userId;
    private String userPassword;
    private List<WebCrawlingShoppingListEntity> entitiesList;

    public static WebCrawlingShoppingListDTO getInstance() {
        if (webCrawlingShoppingListDTO == null) {
            webCrawlingShoppingListDTO = new WebCrawlingShoppingListDTO();
        }

        return webCrawlingShoppingListDTO;
    }


    public WebCrawlingShoppingListDTO(String userId, String userPassword, List<WebCrawlingShoppingListEntity> entitiesList) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.entitiesList = entitiesList;
    }

    public WebCrawlingShoppingListDTO(){}


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<WebCrawlingShoppingListEntity> getEntitiesList() {
        return entitiesList;
    }

    public void setEntitiesList(List<WebCrawlingShoppingListEntity> entitiesList) {
        this.entitiesList = entitiesList;
    }
}
