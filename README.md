# Uthldap
Used to authenticate on the University of thessaly LDAP server, created for World Wide Web Technologies Course

#Important Notice
The University of Thessaly LDAP server requires a VPN connection in order to operate.

# Library installation

- Download Uthldap.jar and import it to your NetBeans project.
- 'import com.uthldap.Uthldap' in the class you want to use the ldap with.

![alt tag](http://i.imgur.com/rO8lK9r.png)

![alt tag](http://i.imgur.com/0YhVSmD.png)

![alt tag](http://i.imgur.com/eNtY6s7.png)

# Library usage example
			
			Uthldap ldap = new Uthldap(user,pass);
            
            if(ldap.auth()){
                out.println("<html><body>Autheticated Youre name is:" + ldap.getName() +"</body></html>");
                
            }
            else{
                out.println("<html><body>Authetication failed</body></html>");
            }
    

# Library Methods
- auth(): returns true if Authentication was Successful, false if not (wrong username/password)
- getName(): returns users full name.
- getDept(): returns users department identifier, e.g for Electrical and computer engineering returns 'inf'
- getMail(): returns users e-mail address
- getAlternativeMail(): returns users alternative e-mail address (other than university mail)
- getAffiliation(): returns users affiliation, eg 'Student' for students, 'Faculty' for professors
- getBirthYear(): returns users birth year e.g "1992"


## Advanced Library Methods
- getAllAtributes(): returns all attributes available
- getAttribute(String): returns the attribute asked for