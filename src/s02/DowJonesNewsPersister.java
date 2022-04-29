package s02;

public class DowJonesNewsPersister implements IFXNewsPersister{
    @Override
    public void persistNews(FXNewsBean newsBean) {
        System.out.println(newsBean.getThings());
    }
}
