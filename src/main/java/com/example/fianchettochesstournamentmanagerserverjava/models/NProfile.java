package com.example.fianchettochesstournamentmanagerserverjava.models;

import javax.persistence.*;

@Entity
@Table(name = "players_new")
public class NProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private NUser user;

    public NProfile() {

    }

    public NProfile(Integer id, String name) {
        this.id = id;

    }


}
