package TagManagement;

import java.util.*;


public class OrgSystem implements Tag
{

    @Override
    public Set<String> getTags() {
       // System.out.println("Application tag :- "+ taggedApplication);
        return taggedApplication.keySet();
    }

    @Override
    public void addTag(String tag, ApllicationMetaData app) {
       List<ApllicationMetaData> applications =  taggedApplication.getOrDefault(tag,new ArrayList<ApllicationMetaData>());
        applications.add(app);
        taggedApplication.put(tag,applications);
        //System.out.println("Application tag :- "+ taggedApplication);
    }

    @Override
    public List<ApllicationMetaData> getTaggedApplication(String tag) {
        return taggedApplication.getOrDefault(tag, Collections.EMPTY_LIST);
    }
}
