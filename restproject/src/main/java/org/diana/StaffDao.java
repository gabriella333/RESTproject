package org.diana;

import java.util.List;

import javax.ejb.Local;

import org.jboss.tools.examples.model.Staff;

@Local
public interface StaffDao {

	void createStaff(Staff staff);

	void removeStaff(Staff staff);

	void updateStaff(Staff staff);

	List<Staff> getAllStaff(Staff staff);

	Staff findStaffById(int id);

	List<Staff> findStaffByName(String name);

}
