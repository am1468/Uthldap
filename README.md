# Uthldap
Used to authenticate on the University of thessaly LDAP server, created for World Wide Web Technologies Course

# Library installation

- Download Uthldap.jar and import it to your NetBeans project
- 'import com.uthldap.' in the class you want to use the ldap with 

# Library usage example
			
			Uthldap ldap = new Uthldap(user,pass);
            
            if(ldap.auth()){
                out.println("<html><body>Autheticated Youre name is:" + ldap.getName() +"</body></html>");
                
            }
            else{
                out.println("<html><body>Authetication failed</body></html>");
            }
    