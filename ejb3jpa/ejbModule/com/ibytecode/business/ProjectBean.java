package com.ibytecode.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ibytecode.entities.Project;

/**
 * Session Bean implementation class ProjectBean
 */
@Stateless(mappedName = "Project")
public class ProjectBean implements ProjectBeanRemote {

	@PersistenceContext(unitName = "JPADB")
    private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public ProjectBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void saveProject(Project project) {
        entityManager.persist(project);
    }
 
    @Override
    public Project findProject(Project project) {
        Project p = entityManager.find(Project.class, project.getPnumber());
        return p;
    }
 
    @Override
    public List<Project> retrieveAllProjects() {
         
        String q = "SELECT p from " + Project.class.getName() + " p";
        Query query = entityManager.createQuery(q);
        List<Project> projects = query.getResultList();
        return projects;
    }

}
