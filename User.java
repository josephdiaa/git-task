package pro;

import java.io.*;
import java.util.Scanner;

public class User {
    protected String name;
    protected String email;
    protected String password;
    protected String nationalId;
    protected String phone;
    protected String defaultLocation;
    protected String role;

    //-----------------------------
    public User(String n, String e, String pass, String nId, String ph, String dfLo, String ro) throws IOException {
        boolean check = false;
        name = n;
        email = e;
        password = pass;
        nationalId = nId;
        phone = ph;
        defaultLocation = dfLo;
        role = ro;
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                check = true;
            }
        } catch (IOException e1) {
            System.out.println("An error occurred.");
            e1.printStackTrace();
        }
        FileWriter writer = new FileWriter("filename.txt", check);
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.write(name);
        buffer.write(' ');
        buffer.write(email);
        buffer.write(' ');
        buffer.write(password);
        buffer.write(' ');
        buffer.write(nationalId);
        buffer.write(' ');
        buffer.write(phone);
        buffer.write(' ');
        buffer.write(defaultLocation);
        buffer.write(' ');
        buffer.write(role);
        buffer.newLine();
        buffer.close();
        writer.close();
    }

    public User() {

    }

    public void Register(String n, String e, String pass, String nId, String ph, String dfLo, String ro) throws IOException {
        while (true) {
            email = e;
            Scanner sc = new Scanner(System.in);
            boolean userNameCheck = false;
            FileReader fr = new FileReader("filename.txt");
            BufferedReader br = new BufferedReader(fr);
            String[] words = null;
            String s;
            while ((s = br.readLine()) != null) {
                words = s.split(" ");
                for (String word : words) {
                    if (word.equals(n))   //Search for the given word
                    {
                        userNameCheck = true;
                    }
                    if (userNameCheck) {
                        System.out.println("This User Name is Used");
                        System.out.println("Please Enter new User Name");
                        n = sc.nextLine();
                        userNameCheck=false;
                    }
                }
            }

            if(ro.equalsIgnoreCase("Administrator")){
                if(checkAdministrator(n, pass)!=true){
                    System.out.println("This role is Not Available for you");
                    System.out.println("Enter Another Role");
                    ro=sc.nextLine();
                }
            }
            User user = new User(n, e, pass, nId, ph, dfLo, ro);
            break;
        }
    }
    public boolean login(String e, String pass) throws IOException {
        boolean Checker = false;
        boolean passCheck = false;
        boolean emailCheck = false;
        FileReader fr = new FileReader("filename.txt");
        BufferedReader br = new BufferedReader(fr);
        String[] words = null;
        String s;
        while ((s = br.readLine()) != null) {
            words = s.split(" ");
            for (String word : words) {
                if (word.equals(e))   //Search for the given word
                {
                    emailCheck = true;    //If Present increase the count by one
                }
                if (word.equals(pass)) {
                    passCheck = true;
                }
            }
            if (emailCheck == true && passCheck == true) {
                Checker = true;
                break;
            }
        }
        if (Checker == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAdministrator(String n , String pas) {
        int sizePass = pas.length();
        int sizeName = n.length();
        boolean pasChecker = false;
        boolean nameChecker = false;
        char pas1=pas.charAt(0);
        char pas1f=pas.charAt(sizePass - 2);
        char pas2f=pas.charAt(sizePass - 1);
        char n1=n.charAt(sizeName - 2);
        char n2=n.charAt(sizeName - 1);
        if (pas.charAt(0) == 'A' && Character.isDigit(pas.charAt(1)) && pas.charAt(sizePass - 2) == 'a' && pas.charAt(sizePass - 1) == 'd') {
            pasChecker = true;
        }
        if (n.charAt(sizeName - 2) == 'A' && n.charAt(sizeName - 1) == 'D') {
            nameChecker = true;
        }
        if (pasChecker && nameChecker) {
            return true;
        } else {
            return false;
        }
    }
}
