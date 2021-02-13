package com.example.fianchettochesstournamentmanagerserverjava.repository;

import com.example.fianchettochesstournamentmanagerserverjava.models.NTournament;
import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;
import org.springframework.data.repository.CrudRepository;

public interface NTournamentRepository extends CrudRepository<NTournament, Integer> {

}
