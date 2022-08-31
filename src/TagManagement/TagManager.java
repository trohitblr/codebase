package TagManagement;

import java.util.List;
import java.util.Set;

public class TagManager {

    Tag tag ;
    JiraApplication jira;
    ConfluenceApplication conf;
    public TagManager(){
          tag = new OrgSystem();
          jira  = new JiraApplication();
          conf = new ConfluenceApplication();
     }


     private Tag getInstance(OrgApplications app){
         switch (app) {
             case JIRA:
                 return jira;
             case CONFLUENCE:
                 return conf;
             default :
                 return tag;
         }
     }


    public void addTag(String tag, OrgApplications app,String url) {
        getInstance(app).addTag(tag, new ApllicationMetaData(app, url));
    }

    public Set<String> getTags(OrgApplications app) {
        return getInstance(app).getTags();
    }

    public Set<String> getTags() {
        return tag.getTags();
    }

    public List<ApllicationMetaData> getApps(OrgApplications app, String tag) {
        return getInstance(app).getTaggedApplication(tag);
    }
}
