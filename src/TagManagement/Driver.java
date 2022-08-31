package TagManagement;

public class Driver {

    public static void main(String[] args) {

        TagManagementSystem tgm = TagManagementSystem.getInstance();

        tgm.addTag("3.12",OrgApplications.APPLICATION,"ABC.com");
        tgm.addTag("3.11",OrgApplications.JIRA,"ABCD.com");
        tgm.addTag("3.10",OrgApplications.CONFLUENCE,"BCD.com");

        System.out.println(tgm.getTags());

        System.out.println(tgm.getAppLications("3.12"));

        System.out.println(tgm.getAppLications("3.10"));
        System.out.println(tgm.getAppLications("3.11"));


        System.out.println(tgm.getAppLications(OrgApplications.JIRA,"3.11"));

        System.out.println(tgm.getAppLications(OrgApplications.JIRA,"3.12"));

        //System.out.println(tgm.getTags(OrgApplications.JIRA));

       // System.out.println(tgm.getTags(OrgApplications.CONFLUENCE));
    }
}
