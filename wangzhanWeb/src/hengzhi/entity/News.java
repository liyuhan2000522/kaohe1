package hengzhi.entity;

public class News {

    private int id;

    //标题
    private String title;

    //作者
    private String author;

    //内容
    private String content;

    //类别id 	1-新闻   2-公告
    private int sortId;

    //创建时间
    private String writeTime;

    //修改时间
    private String alterTime;
    
 /*   //文章类型	1-新闻   2-公告
    private String type;

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}*/

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public String getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(String writeTime) {
        this.writeTime = writeTime;
    }

    public String getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(String alterTime) {
        this.alterTime = alterTime;
    }
}
