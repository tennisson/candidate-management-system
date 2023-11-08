package com.example.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.WrongData;
import com.example.demo.model.Candidatebean;
import com.example.demo.repository.candidaterepo;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class Candidatedao {
	@Autowired
	private candidaterepo emprepo;
	

	
	@GetMapping("/candidate")

	public List<Candidatebean> getAllCandidate(){
		return emprepo.findAll();
		
	}
	@PostMapping("/candidate")
	public Candidatebean createCandidate(@RequestBody Candidatebean candidate) {
		return emprepo.save(candidate);
	}
	// get employee by id rest api
		@GetMapping("/candidate/{id}")
		public ResponseEntity<Candidatebean> getCandidateById(@PathVariable Long id) {
			Candidatebean candidate = emprepo.findById(id)
					.orElseThrow(() -> new WrongData("Employee not exist with id :" + id));
			return ResponseEntity.ok(candidate);
		}

		// update employee rest api
		
		@PutMapping("/candidate/{id}")
		public ResponseEntity<Candidatebean> updateCandidate(@PathVariable Long id, @RequestBody Candidatebean candidateDetails){
			Candidatebean candidate = emprepo.findById(id)
					.orElseThrow(() -> new WrongData("Employee not exist with id :" + id));
			
			candidate.setName(candidateDetails.getName());
			candidate.setM1(candidateDetails.getM1());
			candidate.setM2(candidateDetails.getM2());
			candidate.setM3(candidateDetails.getM3());
			candidate.setGrade(candidateDetails.getGrade());
			candidate.setResult(candidateDetails.getResult());
			Candidatebean updatedCandidate = emprepo.save(candidate);
			return ResponseEntity.ok(updatedCandidate);
		}
		
		// delete employee rest api
		@DeleteMapping("/candidate/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteCandidate(@PathVariable Long id){
			Candidatebean candidate = emprepo.findById(id)
					.orElseThrow(() -> new WrongData("Employee not exist with id :" + id));
			
			emprepo.delete(candidate);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	


}
