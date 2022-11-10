package org.toyproject.DAO;

import org.toyproject.DB.ConnectionPoolMgr;
import org.toyproject.DTO.UserDTO;
import org.toyproject.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {
    private static UserDAO userDAO = null;
    private ConnectionPoolMgr connectionPoolMgr;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    //유저의 모든 정보 삽입
    private static final String USER_INSERT_ALL = "INSERT INTO user_info(user_id, user_pw, user_name, user_ph, user_addr, user_point) VALUES(?, ?, ?, ?, ?, ?)";
    //유저 필수 정보만 삽입
    private static final String USER_INSERT = "INSERT INTO user_info(user_id, user_pw, user_name) VALUES(?,?,?)";
    //전체 데이터 조회 query (디버깅용)
    private static final String USER_SELECT_ALL = "SELECT * FROM user_info";
    //특정 유저 조회 (로그인 및 회원 가입 용)
    private static final String USER_SELECT = "SELECT * FROM user_info WHERE user_id = ? AND user_pw = ?";
    //유저 이름 수정
    private static final String USER_UPDATE_NAME = "UPDATE user_info SET user_name = ? WHERE user_serial_num = ?";
    //유저 주소 수정
    private static final String USER_UPDATE_ADDRESS = "UPDATE user_info SET user_addr = ? WHERE user_serial_num = ?";
    //유저 폰 번호 수정
    private static final String USER_UPDATE_PHONENUMBER = "UPDATE user_info SET user_ph = ? WHERE user_serial_num = ?";

    public UserDAO(){
        if(connectionPoolMgr == null){
            connectionPoolMgr = ConnectionPoolMgr.getInstance();
        }
    }

    public static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    /**
     * 디버깅용 전체 리스트 조회 하기
     * @return user 테이블에 있는 모든 값
     */
    public List<UserDTO> searchUserALL(){
        List<UserDTO> userList = new LinkedList<>();
        try{
            conn = connectionPoolMgr.getConnection();
            pstmt = conn.prepareStatement(USER_SELECT_ALL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Long uSerial = Long.parseLong(rs.getString("user_serial_num"));
                String uId = rs.getString("user_id");
                String uPw = rs.getString("user_pw");
                String uName = rs.getString("user_name");
                String uPh = rs.getString("user_ph");
                String uAddr = rs.getString("user_addr");
                int uPoint = Integer.parseInt(rs.getString("user_point"));

                userList.add(new UserDTO(uSerial,uId,uPw,uName,uPh,uAddr,uPoint));
            }
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPoolMgr.freeConnection(conn, pstmt, rs);
        }

        return userList;
    }

    /**
     * 아이디와 비밀번호 입력 받아서 유저 정보 찾기
     * @param userId : 사용자에게 입력 받은 아이디
     * @param userPassword : 사용자에게 입력 받은 비밀 번호
     * @return UserDTO 객체 반환, 없으면 null
     */
    public UserDTO searchUser(String userId, String userPassword){
        UserDTO userList = null;
        try{
            conn = connectionPoolMgr.getConnection();
            pstmt = conn.prepareStatement(USER_SELECT);
            pstmt.setString(1,userId);
            pstmt.setString(2,userPassword);

            rs = pstmt.executeQuery();
            while(rs.next()){
                Long uSerial = Long.parseLong(rs.getString("user_serial_num"));
                String uId = rs.getString("user_id");
                String uPw = rs.getString("user_pw");
                String uName = rs.getString("user_name");
                String uPh = rs.getString("user_ph");
                String uAddr = rs.getString("user_addr");
                int uPoint = Integer.parseInt(rs.getString("user_point"));

                userList = new UserDTO(uSerial,uId,uPw,uName,uPh,uAddr,uPoint);
            }
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPoolMgr.freeConnection(conn, pstmt, rs);
        }

        return userList;
    }

    /**
     * 필수 사용자 정보만 저장
     * @param userEntity : user DTO 객체
     * @return DB에 삽입한 데이터 개수 반환 ( 1: 정상, 그 외 나머지 : error)
     */
    public int insertUser(UserEntity userEntity){
        int result = 0;
        try{
            conn = connectionPoolMgr.getConnection();
            pstmt = conn.prepareStatement(USER_INSERT_ALL);
            pstmt.setString(1,userEntity.getUserID());
            pstmt.setString(2,userEntity.getUserPassword());
            pstmt.setString(3,userEntity.getUserName());
            pstmt.setString(4,userEntity.getUserPhoneNumber());
            pstmt.setString(5,userEntity.getUserAddress());
            pstmt.setString(6,userEntity.getUserPoint());

            result = pstmt.executeUpdate();
            conn.commit();
            System.out.println("DAO");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPoolMgr.freeConnection(conn,pstmt);
        }
        return result;
    }

    /**
     * 필수 정보 외의 다른 모든 정보 입력시
     * @return DB에 삽입한 데이터 개수 반환 ( 1: 정상, 그 외 나머지 : error)
     */
    public int insertAllUserInfo(UserDTO userDTO){
        int result = 0;
        try{
            conn = connectionPoolMgr.getConnection();
            pstmt = conn.prepareStatement(USER_INSERT_ALL);
            pstmt.setString(1,userDTO.getUserId());
            pstmt.setString(2,userDTO.getUserPassword());
            pstmt.setString(3,userDTO.getUserName());
            pstmt.setString(4,userDTO.getUserPhoneNumber());
            pstmt.setString(5,userDTO.getUserAddress());
            result = pstmt.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPoolMgr.freeConnection(conn,pstmt);
        }
        return result;
    }

    //원래 필수 정보 외의 정보(폰번호,주소) 둘중에 하나만 받는 경우도 넣어야 하는데 시간 관계상 생략함

    /**
     * 사용자 이름 변경
     * @param userDTO : 사용자 객체
     * @return 수정 완료한 데이터 개수 ( 1 : 정상, 그 외 나머지 : error)
     */
    public int updateUserName(UserDTO userDTO){
        int result = 0;
        try{
            conn = connectionPoolMgr.getConnection();
            pstmt = conn.prepareStatement(USER_UPDATE_NAME);
            pstmt.setString(1,userDTO.getUserName());
            pstmt.setString(2,String.valueOf(userDTO.getUserSerialNum()));
            result = pstmt.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPoolMgr.freeConnection(conn,pstmt);
        }
        return result;
    }

    public UserEntity select(String userId, String userPassword) {
        UserEntity user = null;
        try {
            conn = connectionPoolMgr.getConnection();
            pstmt = conn.prepareStatement(USER_SELECT);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPassword);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                String uId = rs.getString("USER_ID");
                String uPw = rs.getString("USER_PW");
                String uName = rs.getString("USER_NAME");
                String uPhoneNumber = rs.getString("USER_PH");
                String uAddress = rs.getString("USER_ADDR");
                String uPoint = rs.getString("USER_POINT");
                user = new UserEntity(uId, uPw, uName, uPhoneNumber, uAddress, uPoint);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionPoolMgr.freeConnection(conn,pstmt, rs);
        }
        return user;
    }
}