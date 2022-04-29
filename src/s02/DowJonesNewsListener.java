package s02;

public class DowJonesNewsListener implements IFXNewsListener {
    @Override
    public String[] getAvailableNewsIds() {
        String[] arr = {"新闻1","新闻2","新闻3"};
        return arr;
    }

    @Override
    public FXNewsBean getNewsByPK(String newsId) {
        switch (newsId) {
            case "新闻1":
                return new FXNewsBean("2022/04/25","你");
            case "新闻2":
                return new FXNewsBean("2022/04/26","好");
            case "新闻3":
                return new FXNewsBean("2022/04/27","呀");
            default:
                return new FXNewsBean("2022/04/28","你好呀");
        }
    }

    @Override
    public void postProcessIsNecessary(String newsId) {
        System.out.println(newsId);
    }
}
