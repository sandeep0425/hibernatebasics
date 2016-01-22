import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jpa.criteria.compile.CriteriaInterpretation;

public class Imp 
{
	static 
	Criterion cr;
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
	SessionFactory s= 	cfg.buildSessionFactory();
	Session session = s.openSession();
	Transaction ts = session.beginTransaction();
	Login login = new Login();
//org.hibernate.Query q = session.createQuery("select l from Login as l");
	Criteria q = session.createCriteria(Login.class);
	cr = Restrictions.eq("id", 1);
	q.add(cr);
	Login l = (Login)q.uniqueResult();
	System.out.println(l.getName()+l.getPassword());
/*List l=q.list();//execute hql query
//process the list object and display the results
for(int i=0;i<l.size();i++)
{
	Login e=(Login)l.get(i);
	System.out.println(e.getId() +e.getName()+e.getPassword());
	//System.out.println(e.getLname()+"\t"+e.getEmail());
}*/
	}
}
