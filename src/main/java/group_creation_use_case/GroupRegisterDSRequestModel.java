package group_creation_use_case;

import Entities.Group;

public class GroupRegisterDSRequestModel {

    private final Group group;

    private final String groupName;

    private final int id;


    public GroupRegisterDSRequestModel(Group group, String groupName, int id){
        this.group = group;
        this.groupName = groupName;
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }
    public String getGroupName() {
        return groupName;
    }
    public int getId() {
        return id;
    }

}
