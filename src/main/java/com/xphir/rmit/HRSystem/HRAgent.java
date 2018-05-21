package com.xphir.rmit.HRSystem;

/**
 * Login Metholds + Libary by Ian Gallagher <igallagher@securityinnovation.com>
 *
 * This code utilizes jBCrypt, which you need installed to use.
 * jBCrypt: http://www.mindrot.org/projects/jBCrypt/
 */


import org.mindrot.jbcrypt.*;

public class HRAgent {
    long ID;
    private String firstName;
    private String lastName;
    private String agentType;
    private String accessArea;
    private String email;
    private String passwordHash;

    private static int workload = 12;

    public HRAgent(long ID, String firstName, String lastName, String agentType, String accessArea, String email, String passwordHash) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.agentType = agentType;
        this.accessArea = accessArea;
        this.email = email;
        this.passwordHash = hashPassword(passwordHash);
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAgentType() {
        return agentType;
    }

    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }

    public String getAccessArea() {
        return accessArea;
    }

    public void setAccessArea(String accessArea) {
        this.accessArea = accessArea;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = hashPassword(passwordHash);
    }

    /**
     * This method can be used to generate a string representing an account password
     * suitable for storing in a database. It will be an OpenBSD-style crypt(3) formatted
     * hash string of length=60
     * The bcrypt workload is specified in the above static variable, a value from 10 to 31.
     * A workload of 12 is a very reasonable safe default as of 2013.
     * This automatically handles secure 128-bit salt generation and storage within the hash.
     * @param password_plaintext The account's plaintext password as provided during account creation,
     *			     or when changing an account's password.
     * @return String - a string of length 60 that is the bcrypt hashed password in crypt(3) format.
     */

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return(hashed_password);
    }

    /**
     * This method can be used to verify a computed hash from a plaintext (e.g. during a login
     * request) with that of a stored hash from a database. The password hash from the database
     * must be passed as the second variable.
     * @param password_plaintext The account's plaintext password, as provided during a login request
     * @param stored_hash The account's stored password hash, retrieved from the authorization database
     * @return boolean - true if the password matches the password of the stored hash, false otherwise
     */
    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;

        if(null == stored_hash || !stored_hash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

        return(password_verified);
    }

    public boolean verifyPassword(String password_plaintext) {
        boolean password_verified = false;

        if(null == this.getPasswordHash() || !this.getPasswordHash().startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = BCrypt.checkpw(password_plaintext, this.getPasswordHash());

        return(password_verified);
    }

}
