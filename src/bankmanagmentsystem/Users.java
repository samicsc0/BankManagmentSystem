package bankmanagmentsystem;

public class Users {

    usrNode root = null;
    int totalUsrs = 0;

    class usrNode {

        int usrType; // 1 for the admin and 2 for the staffs or front desk
        String usrName;
        private String usrPass;
        usrNode next;

        usrNode(int usrType, String usrName, String usrPass) {
            this.usrType = usrType;
            this.usrName = usrName;
            this.usrPass = usrPass;
        }

        public String getUsrPass() {
            return usrPass;
        }

        public void setUsrPass(String usrPass) {
            this.usrPass = usrPass;
        }
    }

    usrNode createUser(int usrType, String usrName, String usrPass) {
        totalUsrs++;
        return new usrNode(usrType, usrName, usrPass);
    }

    void displayAll() {
        usrNode now = root;
        if (root == null) {
            System.out.println("Empty!");
        }
        System.out.println("UserName    Type( 1 - For Administrators & 2 - For Front Desk )");
        while (now != null) {
            System.out.println(now.usrName + "         " + now.usrType);
            now = now.next;
        }
    }

    void addUser(int usrType, String usrName, String usrPass) {
        usrNode newNode = createUser(usrType, usrName, usrPass);
        if (root == null) {
            root = newNode;
        } else {
            usrNode temp;
            temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void deleteUser(String n) {
        usrNode temp = root, prev = null;
        if (temp != null && temp.usrName.equals(n)) {
            root = temp.next;
            return;
        }
        while (temp != null && !temp.usrName.equals(n)) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        prev.next = temp.next;
    }

    void showInfo(usrNode b) {
        String type;
        if (b.usrType == 1) {
            type = "Administrator";
        } else {
            type = "Front-Desk";
        }
        System.out.println("User Name: " + b.usrName + " User Type: " + type);
    }

    usrNode search(String usr) {
        usrNode now = root;
        if (root == null) {
            return null;
        }
        while (now != null) {
            if (now.usrName.equals(usr)) {
                return now;
            }
            now = now.next;
        }
        return null;
    }

    void update(String nm, String nnm, String ps) {
        usrNode x = root;
        while (x != null) {
            if (x.usrName.equals(nm)) {
                x.usrName = nnm;
                x.usrPass = ps;
            } else {
                x = x.next;
            }
        }
    }

}
