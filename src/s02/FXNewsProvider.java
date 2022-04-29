package s02;

import com.sun.deploy.util.ArrayUtil;

public class FXNewsProvider {
    private IFXNewsListener newsListener;
    private IFXNewsPersister newsPersister;
    //构造方法注入（如果是set方法注入请注释）
    public FXNewsProvider(IFXNewsListener newsListener,IFXNewsPersister newsPersister){
        this.newsListener = newsListener;
        this.newsPersister = newsPersister;
    }
    public void getAndPersistNews() {
        //抓取新闻
        String[] newIds = newsListener.getAvailableNewsIds();
        if (ArrayUtils.isEmpty(newIds)) {
            return;
        }
        for (String newsId : newIds) {
            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newsPersister.persistNews(newsBean);
            newsListener.postProcessIsNecessary(newsId);
        }
    }
    //set方法注入，构造方法注入时可屏蔽可不屏蔽
//    public void setNewsListener(IFXNewsListener newsListener) {
//        this.newsListener = newsListener;
//    }
//
//    public void setNewsPersister(IFXNewsPersister newsPersister) {
//        this.newsPersister = newsPersister;
//    }
}
