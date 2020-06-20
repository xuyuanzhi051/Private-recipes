package net.xyz.entrys;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于保存客户端用户的信息
 */
public class UserInfomation implements Serializable {
    private String userTel;//用户账号
    private String userName;//用户昵称
    private String userImg;//用户头像
    private String userSex;//用户性别
    private List<String> hobbys =new ArrayList<>();//用户爱好

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public List<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    @Override
    public String toString() {
        return "UserInfomation{" +
                "userTel='" + userTel + '\'' +
                ", userName='" + userName + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userSex='" + userSex + '\'' +
                ", hobbys=" + hobbys +
                '}';
    }
}
