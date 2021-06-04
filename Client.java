/**
 * This class represents a human bank client and his personal and account information.
 * @author Joseph Diaa
 * @since 17.4.2021
 */

public class Client {
    protected String name;
    protected String nationalID;
    protected String address;
    protected String phone;
    protected Account account;

    /**
     * default constructor
     */
    public Client() {
    }

    /**
     * parameters constructor set name,nationalID,address,phone and account.
     * @param name
     * @param nationalID
     * @param address
     * @param phone
     * @param account
     */
    public Client(String name,String nationalID,String address,String phone ,Account account) {
        this.name= name;
        this.nationalID= nationalID;
        this.address=address;
        this.phone=phone;
        this.account=account;
    }

    /**
     *
     * this function gets the name of client
     * @return The name of the client
     */
    public String getName() {
        return name;
    }

    /**
     * this function takes name of client and set it
     * @param name the new name to be set to client
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * this is function displays National ID of client
     * @return The national ID of the client
     */
    public String getNationalID() {
        return nationalID;
    }

    /**
     * this function takes National ID of client and set it
     * @param nationalID the new national ID to be set to the client
     */
    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    /**
     * this function displays Address of client
     * @return the address of the client
     */
    public String getAddress() {
        return address;
    }

    /**
     * this function takes address of client and set it
     * @param address the new address to be set to the client
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * this function displays phone of client
     * @return the phone of the client
     */
    public String getPhone() {

        return phone;
    }

    /**
     * this function takes phone of client and set it
     * @param phone the new address to be set to the client
     */
    public void setPhone(String phone) {

        this.phone = phone;
    }

    /**
     * this function displays account of client
     * @return the account of the client
     */
    public Account getAccount() {
        return account;
    }

    /**
     * this function takes account of client and set it
     * @param account the new address to be set to the client
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    /**
     * this is override for function toString to display all information of client
     */
    public String toString() {
        return String.format("Client type is: not commercial\nClient name is: %s\nClient National ID is :%s\nClient Address is: %s \nClient Phone is: %s\n%s\n ",name,nationalID,address,phone,account);
    }
}
