package temp.I_HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * hashMap
 */
@SuppressWarnings("unchecked")
public class Test15 {

    static HashMap phoneBook    = new HashMap();

    public static void main(String[] args) {
        addPhoneNo("친구", "홍길동", "010-1234-1234");
        addPhoneNo("친구", "김나비", "010-2345-2686");
        addPhoneNo("회사", "이공룡", "010-3456-7454");
        addPhoneNo("회사", "김갑자", "010-6545-5673");
        addPhoneNo("회사", "장순자", "010-7465-2654");
        addPhoneNo("회사", "홍나비", "010-3142-5674");
        addPhoneNo("회사", "김순이", "010-6475-5856");
        addPhoneNo("회사", "박수진", "010-6456-6245");
        addPhoneNo("기타", "이웃집", "010-8967-4563");
        addPhoneNo("기타", "세탁실", "010-8563-2352");
        addPhoneNo("기타", "집주인", "010-3458-3454");

        printList();
    }

    static void addPhoneNo(String groupName, String name, String tel) {
        addGroup(groupName);

        HashMap group   = (HashMap) phoneBook.get(groupName);
        group.put(tel, name);
    }

    static void addGroup(String groupName) {
        if(!phoneBook.containsKey(groupName)) {
            phoneBook.put(groupName, new HashMap());
        }
    }

    static void addPhoneNo(String name, String tel) {
        addPhoneNo("기타", name, tel);
    }

    static void printList() {
        Iterator iterator   = phoneBook.entrySet().iterator();

        while(iterator.hasNext()) {
            Map.Entry e     = (Map.Entry) iterator.next();
            Set subSet      = ((HashMap) e.getValue()).entrySet();
            Iterator subIt  = subSet.iterator();

            System.out.println(" * " + e.getKey() + " [ " + subSet.size() + " ]");

            while(subIt.hasNext()) {
                Map.Entry subE  = (Map.Entry) subIt.next();
                String telNo    = (String) subE.getKey();
                String name     = (String) subE.getValue();
                System.out.println(name + " " + telNo);
            }
        }
    }
}
