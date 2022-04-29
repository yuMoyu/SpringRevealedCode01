package s02;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class MainTest {
    public static void main(String[] args) {
       DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
       //书架
       BeanFactory container = (BeanFactory)bindViaCode(beanRegistry);
        //取书
        FXNewsProvider newsProvider =
                (FXNewsProvider) container.getBean("djNewsProvider");
        //看某一页
        newsProvider.getAndPersistNews();

    }
    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {
        //把散落的资料（FXNewsProvider的相关信息）放在一本一个文件夹（newsProvider）里
        AbstractBeanDefinition newsProvider =
                new RootBeanDefinition(FXNewsProvider.class);
        AbstractBeanDefinition newsListener =
                new RootBeanDefinition(DowJonesNewsListener.class);
        AbstractBeanDefinition newsPersister =
                new RootBeanDefinition(DowJonesNewsPersister.class);
        //把这个文件夹（newsProvider）放在书架上（registry），并标注（djNewsProvider）
        //将bean定义注册到容器中
        registry.registerBeanDefinition("djNewsProvider",newsProvider);
        registry.registerBeanDefinition("djListener",newsListener);
        registry.registerBeanDefinition("djPersister",newsPersister);
        //因为newsProvider书里面涉及了newsListener书和newsPersister书的概况，所以需要绑定起来，方便及时查阅。
        //通过构造方法注入
        ConstructorArgumentValues argValues =
                new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0,newsListener);
        argValues.addIndexedArgumentValue(1,newsPersister);
        newsProvider.setConstructorArgumentValues(argValues);
          //set方法注入
//        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("newsListener",newsListener));
//        propertyValues.addPropertyValue(new PropertyValue("newsPersister",newsPersister));
//        newsProvider.setPropertyValues(propertyValues);
        return (BeanFactory) registry;
    }
}
