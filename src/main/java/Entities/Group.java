package Entities;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

public class Group implements Serializable, ObjectMap {
    private User groupLeader;
    private static HashMap<Integer, String> groupIDMap; // maps groupID to the groupName
    private int groupID;
    private HashMap<Integer, User> groupMembers;
    //maps UserID to User object,
    private String courseCode;
    private String description;
    private String groupName;
    private HashMap<String, User> memberRequests;
    //maps UserID to User objects, dict of users who requested to join the group

    /**
     * Delete groupIDmap from static variable, assign the idmap read from saved file as attribute
     * when making new group
     */

    public Group(User groupLeader, String groupName, String description){
        //Random rand = new Random();
        //Integer id = rand.nextInt();
        //while (groupIDMap.containsValue(id)){
        //    id = rand.nextInt();
        //}
        //groupIDMap.put(id, groupName);
        this.groupName = groupName;
        this.groupID = 10;
        this.memberRequests = new HashMap<>();
        this.groupMembers = new HashMap<>();
        groupMembers.put(groupLeader.getID(), groupLeader);
        this.groupLeader = groupLeader;
        this.courseCode = "";
        this.description = description;

    }

    public Group(User groupLeader, String groupName){
        this(groupLeader, groupName, "");
    }

    public String getGroupName(){
        return this.groupName;
    }
    public String getCourseCode(){
        return this.courseCode;
    }
    public String getGroupDescription(){
        return this.description;
    }
    public int getGroupID(){
        return this.groupID;
    }

    public User getGroupLeader(){
        return this.groupLeader;
    }

    public HashMap getGroupMembers(){
        return this.groupMembers;
    }
    public HashMap getMemberRequests(){
        return this.memberRequests;
    }

    public boolean setGroupLeader(int userID){
        if (! groupMembers.containsKey(userID)){
            return false;
        }
        this.groupLeader = groupMembers.get(userID);
        return true;
    }

    public boolean setCourseCode(String courseCode){
        if (validateCourseCode(courseCode)){
            this.courseCode = courseCode;
            return true;
        }
        return false;
    }
    public void setGroupDescription(String description){
        this.description = description;
    }

    public boolean validateCourseCode(String courseCode){
        char[] letters = courseCode.substring(0,3).toCharArray();
        char[] numbers = courseCode.substring(3, 6).toCharArray();
        for (char c : letters){
            if (! Character.isLetter(c)){
                return false;
            }
        }
        for (char c : numbers){
            if (! Character.isDigit(c)){
                return false;
            }
        }
        return courseCode.length() == 6;
    }

    public void setGroupName(String name){
        this.groupName = name;
    }

}
