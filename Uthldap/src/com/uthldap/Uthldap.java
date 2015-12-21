package com.uthldap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Hashtable;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class Uthldap {
    
    private  Hashtable env;
    private  Attributes atr;
    private  boolean auth;
    private  boolean error;
    private DirContext ctx;
    
    /**
     * Initiate and authenticate
     * @param username
     * @param password 
     */
    public Uthldap(String username, String password){
        try {
            // Set up ldap environment
            env = new Hashtable(11);
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://ldap.uth.gr:389/");
            env.put(Context.SECURITY_PRINCIPAL, "uid=" + username + ", ou=People, dc=uth,dc=gr");
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_CREDENTIALS, password);
            
            ctx = new InitialDirContext(env);
            
            atr = ctx.getAttributes("uid=" + username + ", ou=People, dc=uth, dc=gr");
            
            ctx.close();
            auth = true;

        } catch (AuthenticationException ex) {
              auth = false;
        }catch (NamingException ex) {
             auth=false;
        }
        

    }

    /**
     * Returns if user authentication succeeded
     * @return 
     */
    public boolean auth(){
        return auth;
    }
    
    /**
     * Returns users mail
     * @return 
     */
    public String getMail(){
        if(auth)
            return atr.get("mail").toString().replace("mail: ", "");
        return "Not authenticated";
    }
    
        
    /**
     * Returns users Name
     * @return 
     */
    public String getName(){
        if(auth)
            return atr.get("cn").toString().replace("cn: ", "");
        return "Not authenticated";
    }
     
        
    /**
     * Returns get user affiliation e.g: Student, Faculty
     * @return 
     */
    public String getAffiliation(){
        if(auth)
            return atr.get("eduPersonAffiliation").toString().replace("eduPersonAffiliation: ", "");
        return "Not authenticated";
    }
    
        
    /**
     * Returns users Department identifier, e.g: inf
     * @return 
     */
    public String getDept(){
        if(auth)
            return atr.get("eduPersonOrgUnitDN").toString().replace("eduPersonOrgUnitDN: ", "").replace("ou=","").replace(",dc=uth,dc=gr","");
        return "Not authenticated";
    }
    
        
    /**
     * Returns users Birth year
     * @return 
     */
    public String getBirthYear(){
        if(auth)
            return atr.get("schacDateOfBirth").toString().replace("schacDateOfBirth: ", "").substring(0, 4).replace(" ","");
        return "Not authenticated";
    }
    
     /**
     * Returns users Alternative e-mail
     * @return 
     */
    public String getAlternateMail(){
        if(auth)
            return atr.get("mailAlternateAddress").toString().replace("mailAlternateAddress: ", "");
        return "Not authenticated";
    }
    
     /**
     * Returns all LDAP attributes
     * @return 
     */
    public String getAllAttributes(){
        return atr.toString();
    }
    
     /**
     * Returns attribute asked for if exists
     * @return 
     */
    public String getAttribute(String attribute){
         if(auth && atr.get(attribute)!=null)
            return atr.get(attribute).toString().replace(attribute + ": ", "");
         else if(atr.get(attribute)==null)
             return "attribute doesnt exist";
         
        return "Not authenticated";
    }
}