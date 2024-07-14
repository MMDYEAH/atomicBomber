package model;

import java.util.ArrayList;

public class User {
    private int level=1;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    static private User logedInUser;
    private boolean loginStatus;
    private static String username;
    private  String password;
    public static ArrayList<User> users = new ArrayList();
    public static int kill = 0;

     public int clusters = 2;
     public int atom = 1;
    public static ArrayList<User> getUsers() {
        return users;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public static User getUserByUsername(String username){
        for(User user:User.getUsers()){
            if(user.getUsername().equals(username))
                return  user;
        }
        return null;
    }
    public static void setLoggedInUser(User logedInUser) {
        User.logedInUser = logedInUser;
    }

    public static User getLogedInUser() {
        return logedInUser;
    }

    public User(String username, String password,boolean loginStatus) {
        this.username = username;
        this.password = password;
        this.loginStatus = false;
        User.getUsers().add(this);
    }
    public static void removeUser(User user){
        users.remove(user);
    }
//    public boolean showLoginStatus(User user){
//        return user.loginStatus;
//    }
//    public void changeLoginStatus(User user){
//        if (user.loginStatus){
//            user.loginStatus = false;
//        }else {
//            user.loginStatus= true;
//        }
//    }
}
