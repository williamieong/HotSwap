package com.teamcaffeine.hotswap.login;

import com.stfalcon.chatkit.commons.models.IUser;
import com.teamcaffeine.hotswap.swap.ActiveTransactionInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class User implements IUser {
    // Force empty initialization of default table fields
    private String Uid = "";
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String memberSince = "";
    private String phoneNumber = "";
    private String avatar = "";
    private boolean online = false;
    private List<String> addresses = new ArrayList<>();
    private List<String> payments = new ArrayList<>();

    // The list of item ids this user owns
    private List<String> owned = new ArrayList<>();

    // The users current renting or pending items
    private HashMap<String, ActiveTransactionInfo> renting = new HashMap<>();
    private HashMap<String, ActiveTransactionInfo> pending = new HashMap<>();

    User() {
    }

    public User(String Uid, String email) {
        this.Uid = Uid;
        this.email = email;
    }

    public User(User user) {
        this.Uid = user.getUid();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.memberSince = user.getMemberSince();
        this.phoneNumber = user.getPhoneNumber();
        this.avatar = user.getAvatar();
        this.online = user.getOnline();
        this.addresses = user.getAddresses();
        this.payments = user.getPayments();
        this.owned = user.getOwned();
        this.renting = user.getRenting();
        this.pending = user.getPending();
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Uid", Uid);
        result.put("firstName", firstName);
        result.put("lastName", lastName);
        result.put("email", email);
        result.put("memberSince", memberSince);
        result.put("phoneNumber", phoneNumber);
        result.put("avatar", avatar);
        result.put("online", online);
        result.put("addresses", addresses);
        result.put("payments", payments);
        result.put("owned", owned);
        result.put("renting", renting);
        result.put("pending", pending);
        return result;
    }

    public void setUid(String uid) {
        this.Uid = uid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getUid() {
        return Uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public boolean getOnline() {
        return online;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public boolean removeAddress(String s) {
        return addresses.remove(s);
    }

    public boolean addAddress(String s) {
        if (!addresses.contains(s)) {
            addresses.add(s);
            return true;
        } else {
            return false;
        }
    }

    public List<String> getOwned() {
        return owned;
    }

    public void addOwnedItem(String itemID) {
        if (!owned.contains(itemID)) {
            owned.add(itemID);
        }
    }

    public void setOwned(List<String> owned) {
        this.owned = owned;
    }

    public HashMap<String, ActiveTransactionInfo> getRenting() {
        return renting;
    }

    public void setRenting(HashMap<String, ActiveTransactionInfo> renting) {
        this.renting = renting;
    }

    public HashMap<String, ActiveTransactionInfo> getPending() {
        return pending;
    }

    public void setPending(HashMap<String, ActiveTransactionInfo> pending) {
        this.pending = pending;
    }

    // Methods that need to be implemented for the IUser class for chatkit
    @Override
    public String getId() {
        return email;
    }

    @Override
    public String getName() {
        return firstName + " " + lastName;
    }

    public void setId(String newEmail) {
        this.email = newEmail;
    }


    public List<String> getPayments() {
        return payments;
    }

    public boolean removePayment(String p) {
        return payments.remove(p);
    }

    public boolean addPayment(String p) {
        if (!payments.contains(p)) {
            payments.add(p);
            return true;
        } else {
            return false;
        }
    }
}
