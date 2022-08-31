package TagManagement;

import java.util.*;

public class JiraApplication extends OrgSystem{


    Map<String, List<ApllicationMetaData>> taggedJira = new HashMap<>();



    @Override
    public void addTag(String tag, ApllicationMetaData app) {
        super.addTag(tag,app);
        List<ApllicationMetaData> apps = taggedJira.getOrDefault(tag,new ArrayList<>());
        apps.add(app);
        taggedJira.put(tag,apps);
    }

    @Override
    public List<ApllicationMetaData> getTaggedApplication(String tag) {
        return taggedJira.getOrDefault(tag, Collections.EMPTY_LIST);
    }

    /*
    @Override
    public Set<String> getTags() {
        return taggedJira.keySet();
    }
     */
}
