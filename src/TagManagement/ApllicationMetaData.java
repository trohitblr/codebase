package TagManagement;

public class ApllicationMetaData {

    public String url;

    @Override
    public String toString() {
        return "ApllicationMetaData{" +
                "url='" + url + '\'' +
                ", app=" + app +
                '}';
    }

    public OrgApplications app;

    public ApllicationMetaData(OrgApplications app,String url){
        this.app = app;
        this.url= url;
    }

}
