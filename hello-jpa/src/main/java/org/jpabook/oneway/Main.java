package org.jpabook.oneway;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // team_id (외래 키) 를 이용해 조인한 코드
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            // 조회
//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = em.find(Team.class, team.getId());

            /**
             * 멤버와 팀이 연관 관계가 없음 > 협력 관계를 만들 수 없다
             * 테이블은 외래 키로 조인을 사용하여 연관된 테이블을 찾는다.
             * 객체는 참조를 사용해서 연관된 객체를 찾는다.
             * 테이블과 객체 사이에는 이런 큰 간격이 있음.
             */

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());

            Team findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

            tx.commit();
        } catch (Exception e) {
            System.out.println("ERROR");
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
