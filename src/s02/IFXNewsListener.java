package s02;

public interface IFXNewsListener {
    String[] getAvailableNewsIds();
    FXNewsBean getNewsByPK(String newsId);

    void postProcessIsNecessary(String newsId);
}
