package harsh.android.hellofirebase;

public class UserData {
    public String userid;
    public String name;
    public String regno;

    public UserData(){

    }

    public UserData(String userid, String name, String regno) {
        this.userid = userid;
        this.name = name;
        this.regno = regno;
    }

    public String getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getRegno() {
        return regno;
    }
}
