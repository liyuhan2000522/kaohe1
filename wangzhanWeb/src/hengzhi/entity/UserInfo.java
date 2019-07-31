package hengzhi.entity;

public class UserInfo {

    private int id;

    //账号
    private String username;

    //密码
    private String password;

    //头像
    private String image;

    //年龄
    private int age;

	//创建时间
    private String createTime;
    
    //用户状态	0-游客    1-待审核   2-管理员
    private int state;


    public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public UserInfo(String username, String password, String image, int age, String createTime) {
        this.username = username;
        this.password = password;
        this.image = image;
        this.age = age;
        this.createTime = createTime;
    }
    public UserInfo(String username, String password, String image, int age, String createTime, int state) {
        this.username = username;
        this.password = password;
        this.image = image;
        this.age = age;
        this.createTime = createTime;
        this.state = state;
    }

    public UserInfo() {
    }
}
