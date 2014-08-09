package ejbClient;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.ibytecode.entities.Project;

public class TestEJB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try{
			
			Project prj = new Project();
			prj.setDeptNo(234);
			prj.setPlocation("Plocation");
			prj.setPname("name");
			prj.setPnumber(123);
			
	      Properties p=new Properties();
	      p.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
	      p.put(Context.PROVIDER_URL,"t3://localhost:7001");
	      InitialContext ctx=new InitialContext(p);
	      com.ibytecode.business.ProjectBeanRemote helo = (com.ibytecode.business.ProjectBeanRemote)ctx.lookup("Project#com.ibytecode.business.ProjectBeanRemote");
	      //helo.saveProject(prj);
	      List<Project> prjs = helo.retrieveAllProjects();
	      for(Project pr : prjs){
	    	  System.out.println("DeptNO:" + pr.getDeptNo() + ", Plocation:" + pr.getPlocation() + ", Pname:" + pr.getPname() + ", Pnumber:" + pr.getPnumber());
	      }
	      //System.out.println(helo.getMessage());
	      //System.out.println(helo.getPassword());
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	}
}
