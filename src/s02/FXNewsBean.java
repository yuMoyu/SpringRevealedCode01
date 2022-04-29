package s02;

public class FXNewsBean {
    private String date;
    private String things;

    public FXNewsBean(String date,String things) {
        this.date = date;
        this.things = things;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things;
    }
}
