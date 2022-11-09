package org.toyproject.DTO;

import org.toyproject.Entity.UserEntity;

public class UserDTO {
    private Long userSerialNum;
    private String userId;
    private String userPassword;
    private String userName;
    private String userPhoneNumber;
    private String userAddress;
    private int userPoint;

    public UserDTO(){

    }

    public UserDTO(Long userSerialNum, String userID, String userPassword, String userName){
        this.userSerialNum = userSerialNum;
        this.userId = userID;
        this.userPassword = userPassword;
        this.userName = userName;
    }

    public UserDTO(Long userSerialNum, String userID, String userPassword, String userName, String userPhoneNumber, String userAddress, int userPoint) {
        this.userSerialNum = userSerialNum;
        this.userId = userID;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userAddress = userAddress;
        this.userPoint = userPoint;
    }

    public UserEntity toEntity(){
        return new UserEntity(userSerialNum.toString(), userId, userPassword, userName, userPhoneNumber, userAddress, String.valueOf(userPoint));
    }

    public Long getUserSerialNum() {
        return userSerialNum;
    }

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

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userSerialNum=" + userSerialNum +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPoint=" + userPoint +
                '}';
    }
}
