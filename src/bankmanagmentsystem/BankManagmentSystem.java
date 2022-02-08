package bankmanagmentsystem;

import bankmanagmentsystem.Account.accNode;
import java.util.Scanner;
/*
    This is a simple bank managment system. There are 3 types of users the admin, staff/ front desk workers and the customer.
    The default name & password for the admin is admin and admin respectively. 
    To use the system the admin have to login first with the default user name and password. and then he have to create an account
    for the stuff. The stuff can create new bank account and manage it.
    The customer iteraction with this system is through the atm interface.

    Department - Computer Science
    Section - RCD2012F
    Members
        1. Aschalew Adbaru
        2. Dawit Mekonnen
        3. Daniel Mengistu
        4. Hiwot Molalign
        5. Samuel Zewde
        6. Yohannes Mulugeta
*/
public class BankManagmentSystem {

    public static void main(String[] args) throws Exception {
        Users userList = new Users();
        Account AccountList = new Account();
        Scanner sc = new Scanner(System.in);
        int sel = -1;
        userList.addUser(1, "admin", "admin");
        /*  Welcome Screen*/
        System.out.println("\t\t WELCOME TO DASHEN BANK");
        while (sel != 4) {

            System.out.println("\n 1 - For Administrator \n 2 - For Front Desk \n 3 - ATM \n 4 - Exit");
            System.out.print(": ");
            sel = sc.nextInt();

            if (sel == 1) {
                String usrnm;
                String adpass;
                Users.usrNode a;
                System.out.print("User Name: ");
                usrnm = sc.next();
                System.out.print("\nPassWord: ");
                adpass = sc.next();
                a = userList.search(usrnm);
                if (a != null) {
                    if (a.getUsrPass().equals(adpass) && a.usrType == 1) {
                        int adminsel = -1;
                        System.out.println("Logged Successfully!");
                        while (adminsel != 6) {
                            System.out.println("\n 1 - Add User \n 2 - Delete User \n 3 - Display UserInfo \n 4 - Display All \n 5 - Update Usr Info \n 6 - Log out");
                            System.out.print(": ");
                            adminsel = sc.nextInt();
                            if (adminsel == 1) {
                                System.out.print("\nUser Type / 1 - admin 2 - staff: ");
                                int usrty = sc.nextInt();
                                System.out.print("\nUser Name: ");
                                String usrn = sc.next();
                                System.out.print("\nUser Password: ");
                                String userps = sc.next();
                                userList.addUser(usrty, usrn, userps);
                                System.out.println("Successfully Added!");
                            } else if (adminsel == 2) {
                                System.out.print("Enter the user name: ");
                                String deu = sc.next();
                                userList.deleteUser(deu);
                                System.out.println("Deleted!");
                            } else if (adminsel == 3) {
                                Users.usrNode b;
                                String upval;
                                System.out.print("\nEnter User Name: ");
                                upval = sc.next();
                                b = userList.search(upval);
                                if (b != null) {
                                    userList.showInfo(b);
                                } else {
                                    System.out.println("No User Found by the name " + upval);
                                }
                            } else if (adminsel == 4) {
                                userList.displayAll();
                            } else if (adminsel == 5) {
                                String upn, upnn, upp;
                                System.out.print("\nEnter the user name: ");
                                upn = sc.next();
                                if (userList.search(upn) != null) {
                                    System.out.print("\nNew User Name: ");
                                    upnn = sc.next();
                                    System.out.print("\nNew Password: ");
                                    upp = sc.next();
                                    userList.update(upn, upnn, upp);
                                    System.out.println("Updated!");
                                } else {
                                    System.out.println("User name not found!");
                                }

                            }
                        }

                    } else {
                        System.out.println("Wrong Password Or User Type is not correct, Please try again!");
                    }
                } else {
                    System.out.println("Account Not Found!");
                }
            } else if (sel == 2) {
                String usrnm;
                String adpass;
                Users.usrNode a;
                System.out.print("User Name: ");
                usrnm = sc.next();
                System.out.print("\nPassWord: ");
                adpass = sc.next();
                a = userList.search(usrnm);
                if (a != null) {
                    if (a.getUsrPass().equals(adpass) && a.usrType == 2) {
                        int adminsel = -1;
                        System.out.println("Logged Successfully!");
                        while (adminsel != 9) {
                            System.out.println("\n 1 - Add Account  \n 2 - Deposit \n 3 - Withdraw \n 4 - Transfer \n 5 - Show Customer Info \n 6 - Update Cust. Info \n 7 - Delete Customer \n 8 - List All Customers \n 9 - Log out ");
                            System.out.print(": ");
                            adminsel = sc.nextInt();
                            if (adminsel == 1) {
                                accNode b;
                                String un, acn, pss, addr;
                                int pin;
                                double amnt;
                                System.out.print("\n Account Number: ");
                                acn = sc.next();
                                b = AccountList.searchAcc(acn);
                                if (b == null) {
                                    System.out.print("\n Full Name: ");
                                    un = sc.next();
                                    System.out.print("\n Address: ");
                                    addr = sc.next();
                                    System.out.print("\n Amount: ");
                                    amnt = sc.nextDouble();
                                    System.out.print("\n Pin: ");
                                    pin = sc.nextInt();
                                    AccountList.addAccount(un, acn, addr, pin, amnt);
                                    System.out.println("Account created successfully!");
                                } else {
                                    System.out.println("Account Number already exist, try another!");
                                }
                            }
                            if (adminsel == 2) {
                                String iacno;
                                accNode b;
                                System.out.print("\nEnter the account number: ");
                                iacno = sc.next();
                                b = AccountList.searchAcc(iacno);
                                if (b != null) {
                                    double amnt;
                                    System.out.print("\nEnter the amount to deposit: ");
                                    amnt = sc.nextDouble();
                                    AccountList.deposit(iacno, amnt);
                                    System.out.println("Done!");
                                } else {
                                    System.out.println("Account number does't exist, please try again!");
                                }
                            } else if (adminsel == 3) {
                                String iacno;
                                accNode b;
                                System.out.print("\nEnter the account number: ");
                                iacno = sc.next();
                                b = AccountList.searchAcc(iacno);
                                if (b != null) {
                                    double amnt;
                                    System.out.print("\nEnter the amount to withdraw: ");
                                    amnt = sc.nextDouble();
                                    AccountList.withdraw(iacno, amnt);
                                } else {
                                    System.out.println("Account number does't exist, please try again!");
                                }
                            } else if (adminsel == 4) {
                                accNode s, r;
                                String sn, rr;
                                double amnt;
                                System.out.print("\nEnter the sender account: ");
                                sn = sc.next();
                                System.out.print("\nEnter the reciever account: ");
                                rr = sc.next();
                                s = AccountList.searchAcc(sn);
                                r = AccountList.searchAcc(rr);
                                if (s != null && s != null) {
                                    System.out.print("Enter the amount to transfer: ");
                                    amnt = sc.nextDouble();
                                    AccountList.transfer(sn, rr, amnt);
                                } else {
                                    System.out.println("Either one or both accounts doesn't exist, please try again!");
                                }
                            } else if (adminsel == 5) {
                                String acin;
                                System.out.print("Enter account number: ");
                                acin = sc.next();
                                AccountList.accInfo(acin);
                            } else if (adminsel == 6) {
                                String acn, fn, ad;
                                int up;
                                System.out.print("Enter account number: ");
                                acn = sc.next();
                                if (AccountList.searchAcc(acn) != null) {
                                    System.out.print("\nEnter new name: ");
                                    fn = sc.next();
                                    System.out.print("\nEnter new Address: ");
                                    ad = sc.next();
                                    System.out.print("\nEnter the new pin: ");
                                    up = sc.nextInt();
                                    AccountList.update(acn, fn, ad, up);
                                    System.out.println("Account Updated Successfuly!");
                                } else {
                                    System.out.println("Account Not found!");
                                }

                            } else if (adminsel == 7) {
                                String acno;
                                System.out.print("Enter account number: ");
                                acno = sc.next();
                                if (AccountList.searchAcc(acno) != null) {
                                    AccountList.deleteAccount(acno);
                                    System.out.println("Account Deleted!");
                                } else {
                                    System.out.println("Account doesn't exist!");
                                }
                            } else if (adminsel == 8) {
                                AccountList.displayAll();
                            }
                        }
                    } else {
                        System.out.println("Wrong Password Or User Type is not correct, Please try again!");
                    }
                } else {
                    System.out.println("User Account Not Found");
                }

            } else if (sel == 3) {
                String accNo;
                int pin;
                double amn;
                System.out.print("Enter Your account: ");
                accNo = sc.next();
                accNode t = AccountList.searchAcc(accNo);
                if (t != null) {
                    System.out.print("\nEnter your pin: ");
                    pin = sc.nextInt();
                    if (t.getPin() == pin) {
                        System.out.print("Enter amount: ");
                        amn = sc.nextInt();
                        AccountList.withdraw(accNo, amn);
                    }
                } else {
                    System.out.println("Account doesnt exist!");
                }
            }
        }
    }
}
