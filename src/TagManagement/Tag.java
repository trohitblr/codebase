package TagManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Tag {

    Set<String> getTags();
    void addTag(String tag, ApllicationMetaData app);
     List<ApllicationMetaData> getTaggedApplication(String tag);
     Map<String, List<ApllicationMetaData>> taggedApplication = new HashMap<>();

}
