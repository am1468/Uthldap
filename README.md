# Uthldap
Used to authenticate on the University of thessaly LDAP server, created for World Wide Web Technologies Course


# Library installation

- Download Uthldap.jar and import it to your NetBeans project.
- 'import com.uthldap.' in the class you want to use the ldap with.


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