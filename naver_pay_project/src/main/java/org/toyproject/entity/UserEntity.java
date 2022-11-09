package org.toyproject.entity;

import org.toyproject.DTO.UserDTO;

public class UserEntity {
    private String userSerialNum;
    private String userId;
    private String userPassword;
    private String userName;
    private String userPhoneNumber;
    private String userAddress;
    private String userPoint;

    public UserEntity(){

    }

    public UserEntity(String userSerialNum, String userId, String userPw, String userName){
        this.userSerialNum = userSerialNum;
        this.userId = userId;
        this.userPassword = userPw;
        this.userName = userName;
    }

    public UserEntity(String userSerialNum, String userId, String userPassword, String userName, String userPhoneNumber, String userAddress, String userPoint) {
        this.userSerialNum = userSerialNum;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userAddress = userAddress;
        this.userPoint = userPoint;
    }

<<<<<<< HEAD
=======
    public UserEntity(String userId, String userPassword, String userAddress) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
    }

    public UserEntity(String uId, String uPassword, String uName, String uPhoneNumber, String uAddress, String uPoint) {
        this.userId = uId;
        this.userPassword = uPassword;
        this.userName = uName;
        this.userPhoneNumber = uPhoneNumber;
        this.userAddress = uAddress;
        this.userPoint = uPoint;
    }


>>>>>>> bda7fa04335a9f28205510d027e01a5d62152a29
    public UserDTO toUserDTO(){
        Long uSerialNum = Long.parseLong(userSerialNum);
        int uPoint = Integer.parseInt(userPoint);
        return new UserDTO(uSerialNum, userId, userPassword, userName, userPhoneNumber, userAddress, uPoint);
    }


    public String getUserSerialNum() {
        return userSerialNum;
    }

    public String getUserID() {
        return userId;
    }

    public void setUserID(String userID) {
        this.userId = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(String userPoint) {
        this.userPoint = userPoint;
    }
}

