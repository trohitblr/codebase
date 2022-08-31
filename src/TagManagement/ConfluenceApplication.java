package TagManagement;

import java.util.*;

public class ConfluenceApplication extends OrgSystem{

    Map<String, List<ApllicationMetaData>> taggedConfluence = new HashMap<>();

    @Override
    public void addTag(String tag, ApllicationMetaData app) {
        super.addTag(tag,app);
        List<ApllicationMetaData> apps = taggedConfluence.getOrDefault(tag,new ArrayList<>());
        apps.add(app);
        taggedConfluence.put(tag,apps);
    }

    @Override
    public List<ApllicationMetaData> getTaggedApplication(String tag) {
        return taggedConfluence.getOrDefault(tag, Collections.EMPTY_LIST);
    }

   /* @Override
    public Set<String> getTags() {
        return taggedConfluence.keySet();
    }
    */

}
