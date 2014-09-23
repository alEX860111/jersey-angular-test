package ngdemo.domain;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

}