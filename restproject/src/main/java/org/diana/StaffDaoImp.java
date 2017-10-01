package org.diana;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.model.Staff;

@Stateless
public class StaffDaoImp implements StaffDao {

	@Inject
	private EntityManager em;

	@Override
	public void createStaff(Staff staff) {

		em.persist(staff);
	}

	@Override
	public void removeStaff(Staff staff) {

		if (!em.contains(staff)) {
			System.out.println("There is no such a person!");
		} else
			em.remove(staff);

	}

	@Override
	public List<Staff> findStaffByName(String name) {

		return em.createQuery("from Staff s where s.name like: name", Staff.class)
				.setParameter("name", name).getResultList();
	}

	@Override
	public void updateStaff(Staff staff) {

		if (!em.contains(staff)) {
			System.out.println("There is no such a person!");
		}
		em.merge(staff);

	}

	@Override
	public List<Staff> getAllStaff(Staff staff) {
		return em.createQuery("from Staff s", Staff.class).getResultList();
	}

	@Override
	public Staff findStaffById(int id) {
		return em.find(Staff.class, id);
	}

}
