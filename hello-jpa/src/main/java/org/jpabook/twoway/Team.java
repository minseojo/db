package org.jpabook.twoway;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    // Team team 을 사용하는 곳이 주인, 즉 Team.getTeam()은 가능, Team.setTeam() 불가
    // Member.setTeam(), Member.getTeam() 가능
    // 외래 키가 있는 곳이 주인
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }
}

 */