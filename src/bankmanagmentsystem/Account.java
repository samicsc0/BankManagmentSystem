package bankmanagmentsystem;

public class Account {

    int totalAccs = 0;
    accNode root = null;

    class accNode {

        String fullName, Address;
        private int pin;
        String accNo;
        double balance;
        accNode next;

        accNode(String fullName, String accNo, String Address, int pin, double balance) {
            this.fullName = fullName;
            this.accNo = accNo;
            this.Address = Address;
            this.pin = pin;
            this.balance = balance;
            this.next = null;
        }

        public int getPin() {
            return pin;
        }

        public void setPin(int pin) {
            this.pin = pin;
        }
    }

    accNode createNode(String fullName, String accno, String Address, int pin, double balance) {
        totalAccs++;
        return new accNode(fullName, accno, Address, pin, balance);
    }

    void addAccount(String fullName, String accno, String Address, int pin, double balance) {
        accNode newNode = createNode(fullName, accno, Address, pin, balance);
        if (root == null) {
            root = newNode;
        } else {
            accNode temp;
            temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void displayAll() {
        accNode now = root;
        if (root == null) {
            System.out.println("Empty!");
        }
        while (now != null) {
            System.out.println(now.accNo + " " + now.fullName + " " + now.Address + " " + now.balance);
            now = now.next;
        }
    }

    void deleteAccount(String aNo) {
        accNode temp = root, prev = null;
        if (temp != null && temp.accNo.equals(aNo)) {
            root = temp.next;
            return;
        }
        while (temp != null && !temp.accNo.equals(aNo)) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        prev.next = temp.next;
    }

    accNode searchAcc(String aNo) {
        int count = -1;
        accNode now = root;
        if (root == null) {
            return null;
        }
        while (now != null) {
            if (now.accNo.equals(aNo)) {
                return now;
            }
            now = now.next;
        }
        return null;
    }

    void withdraw(String aNo, double amount) {
        accNode x = root;
        if (amount > 0) {
            while (x != null) {
                if (x.accNo.equals(aNo)) {
                    if (amount > x.balance) {
                        System.out.println("Cann't withdraw. Your balance is : " + x.balance);
                    } else {
                        x.balance = x.balance - amount;
                        System.out.println("Done!");
                    }

                }
                x = x.next;
            }
        } else {
            System.out.println("Error!");
        }
    }

    void deposit(String aNo, double amount) {
        accNode x = root;
        while (x != null) {
            if (x.accNo.equals(aNo)) {
                x.balance = x.balance + amount;
            }
            x = x.next;
        }
    }

    void accInfo(String accNo) {
        accNode x = searchAcc(accNo);
        if (x != null) {
            System.out.println(x.accNo + " " + x.fullName + " " + x.Address + " " + x.balance);
        } else {
            System.out.println("Account doesn't exist!");
        }
    }

    void transfer(String saccn, String raccn, double amount) {
        accNode x = root;
        boolean stat = false;
        if (amount > 0) {
            while (x != null) {
                if (x.accNo.equals(saccn)) {
                    if (amount > x.balance) {
                        System.out.println("Cann't withdraw. Your balance is : " + x.balance);
                        stat = false;
                    } else {
                        if (x.accNo.equals(saccn)) {
                            x.balance = x.balance - amount;
                            stat = true;
                        }
                    }

                }
                x = x.next;
            }
            if (stat == true) {
                accNode y = root;
                while (y != null) {
                    if (y.accNo.equals(raccn)) {
                        y.balance = y.balance + amount;
                        System.out.println("Money Transferd Successfully!");
                    }
                    y = y.next;
                }
            }
        } else {
            System.out.println("Error!");
        }
    }

    void update(String accN, String nm, String ad, int pin) {
        accNode x = root;
        while (x != null) {
            if (x.accNo.equals(accN)) {
                x.fullName = nm;
                x.Address = ad;
                x.pin = pin;
            }
            x = x.next;
        }
    }
}
