package desafiosefaz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	public static EntityManagerFactory factory = null;
	
	static {
		init();
	}
	
	private static void init(){
		
		try {
			
			if (factory == null){
				factory = Persistence.createEntityManagerFactory("desafio-sefaz");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
	public static EntityManager geEntityManager(){
		return factory.createEntityManager(); /*Prover a parte de persistencia*/
	}
	
	public static Object getPrimaryKey(Object entity){ // Retorna a primary key
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}

}

