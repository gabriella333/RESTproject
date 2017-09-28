package org.diana;

import java.util.List;

import javax.ejb.Local;

import org.jboss.tools.examples.model.Member;

@Local
public interface MemberDao {

	void createMember(Member member);

	void removeMember(Member member);

	void updateMember(Member member);

	List<Member> getAll(Member mem);

	Member findById(int id);

	List<Member> findByFirstName(String firstname);

}
