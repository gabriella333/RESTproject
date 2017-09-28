package org.diana;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.examples.model.Member;

@Stateful
public class MemberDaoImp implements MemberDao {

	@Inject
	private EntityManager em;

	@Override
	public void createMember(Member member) {

		em.persist(member);
	}

	@Override
	public void removeMember(Member member) {

		if (!em.contains(member)) {
			System.out.println("There is no such a person!");
		} else
			em.remove(member);

	}

	@Override
	public List<Member> findByFirstName(String firstname) {

		return em.createQuery("from Member m where m.firstname lik: firstname", Member.class)
				.setParameter("firstname", firstname).getResultList();
	}

	@Override
	public void updateMember(Member member) {

		if (!em.contains(member)) {
			System.out.println("There is no such a person!");
		}
		em.merge(member);

	}

	@Override
	public List<Member> getAll(Member member) {
		return em.createQuery("from Member m", Member.class).getResultList();
	}

	@Override
	public Member findById(int id) {
		return em.find(Member.class, id);

	}

}
