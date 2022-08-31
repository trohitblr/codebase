package TagManagement;

import java.util.List;
import java.util.Set;

public class TagManagementSystem {

    private static TagManagementSystem tgms =null;

    private static TagManager tgm;


    private TagManagementSystem(){

    }

    public static TagManagementSystem getInstance(){

        if(tgm == null ){
            tgms = new TagManagementSystem();
            tgm = new TagManager();
        }
        return tgms;
    }

    public void addTag(String tag, OrgApplications app,String url){
        tgm.addTag(tag,app,url);
    }

    public Set<String> getTags() {
        return tgm.getTags();
    }
    public Set<String> getTags(OrgApplications app) {
        return tgm.getTags(app);
    }

    public List<ApllicationMetaData> getAppLications(OrgApplications app, String tag) {
        return tgm.getApps(app,tag);
    }

    public List<ApllicationMetaData> getAppLications( String tag) {
        return tgm.getApps(OrgApplications.APPLICATION,tag);
    }


}
